/*
 * Add Copyright © 2016-2017 European Support Limited
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

package com.amdocs.zusammen.adaptor.inbound.api.types.item;

import com.amdocs.zusammen.datatypes.Id;
import com.amdocs.zusammen.datatypes.item.Info;
import com.amdocs.zusammen.datatypes.item.Relation;

import java.util.ArrayList;
import java.util.Collection;

public class ElementInfo {
  private Id id;
  private Info info;
  private Collection<Relation> relations;
  private Collection<ElementInfo> subElements = new ArrayList<>();

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

  public Collection<Relation> getRelations() {
    return relations;
  }

  public void setRelations(Collection<Relation> relations) {
    this.relations = relations;
  }

  public Collection<ElementInfo> getSubElements() {
    return subElements;
  }

  public void setSubElements(Collection<ElementInfo> subElements) {
    this.subElements = subElements;
  }
}
