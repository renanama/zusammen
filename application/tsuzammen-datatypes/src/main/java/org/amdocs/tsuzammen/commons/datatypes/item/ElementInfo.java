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

package org.amdocs.tsuzammen.commons.datatypes.item;

import org.amdocs.tsuzammen.commons.datatypes.Id;

import java.util.Collection;
import java.util.Map;

public class ElementInfo {
  private Id id;
  private Id parentId; //core uses for save
  private Info info;
  private Collection<Relation> relations;
  private Map<Id, ElementInfo> subElementIds; //core uses for get

  public Id getId() {
    return id;
  }

  public void setId(Id id) {
    this.id = id;
  }

  public Info getInfo() {
    return info;
  }

  public void setInfo(Info info) {
    this.info = info;
  }

  public Id getParentId() {
    return parentId;
  }

  public void setParentId(Id parentId) {
    this.parentId = parentId;
  }

  public Collection<Relation> getRelations() {
    return relations;
  }

  public void setRelations(Collection<Relation> relations) {
    this.relations = relations;
  }

  public Map<Id, ElementInfo> getSubElementIds() {
    return subElementIds;
  }

  public void setSubElementIds(Map<Id, ElementInfo> subElementIds) {
    this.subElementIds = subElementIds;
  }
}