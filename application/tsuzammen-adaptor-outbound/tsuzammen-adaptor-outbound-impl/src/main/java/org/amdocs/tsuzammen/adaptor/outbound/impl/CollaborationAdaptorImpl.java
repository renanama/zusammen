/*
 * Copyright © 2016 Amdocs Software Systems Limited
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.amdocs.tsuzammen.adaptor.outbound.impl;


import org.amdocs.tsuzammen.adaptor.outbound.api.CollaborationAdaptor;
import org.amdocs.tsuzammen.datatypes.CollaborationNamespace;
import org.amdocs.tsuzammen.datatypes.Id;
import org.amdocs.tsuzammen.datatypes.Namespace;
import org.amdocs.tsuzammen.datatypes.SessionContext;
import org.amdocs.tsuzammen.datatypes.item.ElementContext;
import org.amdocs.tsuzammen.datatypes.item.Info;
import org.amdocs.tsuzammen.core.api.types.CoreElement;
import org.amdocs.tsuzammen.sdk.CollaborationStore;
import org.amdocs.tsuzammen.sdk.CollaborationStoreFactory;
import org.amdocs.tsuzammen.sdk.types.ElementData;

import java.util.Collection;

public class CollaborationAdaptorImpl implements CollaborationAdaptor {

  @Override
  public void createItem(SessionContext context, Id itemId,
                         Info itemInfo) {
    getCollaborationStore(context).createItem(context, itemId, itemInfo);
  }

  @Override
  public void saveItem(SessionContext context, Id itemId, Info itemInfo) {
    //getCollaborationStore(context).saveItem(context, itemId, itemInfo);
  }

  @Override
  public void deleteItem(SessionContext context, Id itemId) {
    getCollaborationStore(context).deleteItem(context, itemId);
  }

  @Override
  public void createItemVersion(SessionContext context, Id itemId, Id baseVersionId,
                                Id versionId, Info info) {
    getCollaborationStore(context)
        .createItemVersion(context, itemId, baseVersionId, versionId, info);
  }

  @Override
  public void saveItemVersion(SessionContext context, Id itemId, Id versionId,
                              Info versionInfo) {
    getCollaborationStore(context).saveItemVersion(context, itemId, versionId, versionInfo);
  }

  /*@Override
  public void saveItemVersion(SessionContext context, Id itemId, Id versionId,
                              ItemVersion itemVersion, String message) {
    getCollaborationStore(context)
        .saveItemVersion(context, itemId, versionId, itemVersion, message);
  }*/

  @Override
  public void deleteItemVersion(SessionContext context, Id itemId, Id versionId) {
    getCollaborationStore(context).deleteItemVersion(context, itemId, versionId);
  }

  @Override
  public void publishItemVersion(SessionContext context, Id itemId, Id versionId, String message) {
    getCollaborationStore(context).publishItemVersion(context, itemId, versionId, message);
  }

  @Override
  public void syncItemVersion(SessionContext context, Id itemId, Id versionId) {
    getCollaborationStore(context).syncItemVersion(context, itemId, versionId);
  }

  @Override
  public void revertItemVersion(SessionContext context, Id itemId, Id versionId,
                                String targetRevisionId) {

  }

  @Override
  public Collection listItemVersionRevisions(SessionContext context, Id itemId, Id versionId) {
    return null;
  }

  @Override
  public Collection listItemVersionMissingRevisions(SessionContext context, Id itemId,
                                                    Id versionId) {
    return null;
  }

  @Override
  public Collection listItemVersionOverRevisions(SessionContext context, Id itemId, Id versionId) {
    return null;
  }

  @Override
  public CoreElement getElement(SessionContext context, ElementContext elementContext,
                                CollaborationNamespace namespace, Id elementId) {
    return getCoreElement(
        getCollaborationStore(context).getElement(context, elementContext, namespace, elementId));
  }

  @Override
  public CollaborationNamespace createElement(SessionContext context, ElementContext elementContext,
                                              Namespace parentNamespace, CoreElement element) {
    return getCollaborationStore(context)
        .createElement(context, elementContext, parentNamespace, getElementData(element));
  }

  @Override
  public void saveElement(SessionContext context, ElementContext elementContext,
                          CollaborationNamespace collaborationNamespace, CoreElement element) {
    getCollaborationStore(context)
        .saveElement(context, elementContext, collaborationNamespace, getElementData(element));
  }

  @Override
  public void deleteElement(SessionContext context, ElementContext elementContext,
                            CollaborationNamespace collaborationNamespace, Id elementId) {
    getCollaborationStore(context)
        .deleteElement(context, elementContext, collaborationNamespace, elementId);
  }

  @Override
  public void commitEntities(SessionContext context, ElementContext elementContext,
                             String message) {
    //getCollaborationStore(context).commitEntities(context, elementContext, message);
  }

  private ElementData getElementData(CoreElement coreElement) {
    ElementData elementData = new ElementData();
    elementData.setElementImplClass(coreElement.getElementImplClass());
    elementData.setId(coreElement.getElementId());
    elementData.setInfo(coreElement.getInfo());
    elementData.setRelations(coreElement.getRelations());

    elementData.setData(coreElement.getData());
    elementData.setSearchData(coreElement.getSearchData());
    elementData.setVisualization(coreElement.getVisualization());
    return elementData;
  }

  private CoreElement getCoreElement(ElementData elementData) {
    CoreElement coreElement = new CoreElement();
    coreElement.setElementImplClass(elementData.getElementImplClass());
    coreElement.setElementId(elementData.getId());
    coreElement.setInfo(elementData.getInfo());
    coreElement.setRelations(elementData.getRelations());

    coreElement.setData(elementData.getData());
    coreElement.setSearchData(elementData.getSearchData());
    coreElement.setVisualization(elementData.getVisualization());
    return coreElement;
  }

  private CollaborationStore getCollaborationStore(SessionContext context) {
    return CollaborationStoreFactory.getInstance().createInterface(context);
  }
}
