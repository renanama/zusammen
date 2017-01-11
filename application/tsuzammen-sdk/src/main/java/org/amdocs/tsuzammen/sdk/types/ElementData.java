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

package org.amdocs.tsuzammen.sdk.types;

import org.amdocs.tsuzammen.datatypes.Id;
import org.amdocs.tsuzammen.datatypes.Namespace;
import org.amdocs.tsuzammen.datatypes.Space;
import org.amdocs.tsuzammen.datatypes.item.ElementInfo;
import org.amdocs.tsuzammen.datatypes.item.Info;
import org.amdocs.tsuzammen.datatypes.item.Relation;
import org.amdocs.tsuzammen.datatypes.searchindex.SearchableData;
import org.amdocs.tsuzammen.utils.fileutils.FileUtils;

import java.io.InputStream;
import java.util.Collection;
import java.util.Map;

public class ElementData {
  private Id id;
  private Id itemId;
  private Id versionId;
  private Namespace namespace;
  private Space space;
  private Id parentId;
  private Info info;
  private Collection<Relation> relations;
  private Class elementImplClass;
  private byte[] data;
  private SearchableData searchableData;
  private byte[] visualization;
  private Map<Id, Class> subElements;

  public ElementData(Id itemId,Id versionId,Namespace namespace,Class elementImplClass){
    this.itemId = itemId;
    this.versionId = versionId;
    this.namespace = namespace;
    this.elementImplClass = elementImplClass;
  }


  public Id getItemId() {
    return itemId;
  }

  public Id getVersionId() {
    return versionId;
  }

  public Namespace getNamespace() {
    return namespace;
  }

  public Space getSpace() {
    return space;
  }

  public void setSpace(Space space){
    this.space = space;
  }

  public Id getId() {
    return id;
  }

  public void setId(Id id) {
    this.id = id;
  }

  public Id getParentId() {
    return parentId;
  }

  public void setParentId(Id parentId) {
    this.parentId = parentId;
  }

  public Info getInfo() {
    return info;
  }

  public void setInfo(Info info) {
    this.info = info;
  }

  public Collection<Relation> getRelations() {
    return relations;
  }

  public void setRelations(Collection<Relation> relations) {
    this.relations = relations;
  }

  public Class getElementImplClass() {
    return elementImplClass;
  }

  /*public void setElementImplClass(Class elementImplClass) {
    this.elementImplClass = elementImplClass;
  }*/

  public InputStream getData() {
    return FileUtils.toInputStream(data);
  }

  public void setData(InputStream data) {
    this.data = FileUtils.toByteArray(data);
  }

  public SearchableData getSearchableData() {
    return searchableData;
  }

  public void setSearchableData(SearchableData searchableData) {
    this.searchableData = searchableData;
  }

  public InputStream getVisualization() {
    return FileUtils.toInputStream(visualization);
  }

  public void setVisualization(InputStream visualization) {
    this.visualization = FileUtils.toByteArray(visualization);
  }

  public Map<Id, Class> getSubElements() {
    return subElements;
  }

  public void setSubElements(Map<Id, Class> subElements) {
    this.subElements = subElements;
  }

  public void putSubElement(Id key,Class type){
    this.subElements.put(key,type);
  }
}
