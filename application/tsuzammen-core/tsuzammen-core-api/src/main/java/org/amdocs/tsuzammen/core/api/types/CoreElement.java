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

package org.amdocs.tsuzammen.core.api.types;

import org.amdocs.tsuzammen.commons.datatypes.Id;
import org.amdocs.tsuzammen.commons.datatypes.item.Info;
import org.amdocs.tsuzammen.commons.datatypes.item.Relation;
import org.amdocs.tsuzammen.utils.fileutils.FileUtils;

import java.io.InputStream;
import java.util.Collection;
import java.util.Map;

public class CoreElement {
  private Class elementImplClass;
  private Id id;
  private Info info;
  private Collection<Relation> relations;
  private byte[] data;
  private byte[] searchData;
  private byte[] visualization;
  private Map<Id, CoreElement> subElements;

  public Class getElementImplClass() {
    return elementImplClass;
  }

  public void setElementImplClass(Class elementImplClass) {
    this.elementImplClass = elementImplClass;
  }

  public Id getElementId() {
    return id;
  }

  public void setElementId(Id elementId) {
    id = elementId;
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

  public InputStream getData() {
    return FileUtils.toInputStream(data);
  }

  public void setData(InputStream data) {
    this.data = FileUtils.toByteArray(data);
  }

  public InputStream getSearchData() {
    return FileUtils.toInputStream(searchData);
  }

  public void setSearchData(InputStream searchData) {
    this.searchData = FileUtils.toByteArray(searchData);
  }

  public InputStream getVisualization() {
    return FileUtils.toInputStream(visualization);
  }

  public void setVisualization(InputStream visualization) {
    this.visualization = FileUtils.toByteArray(visualization);
  }

  public Map<Id, CoreElement> getSubElements() {
    return subElements;
  }

  public void setSubElements(Map<Id, CoreElement> subElements) {
    this.subElements = subElements;
  }
}