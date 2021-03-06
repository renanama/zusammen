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

package com.amdocs.zusammen.datatypes.itemversion;

import java.util.ArrayList;
import java.util.List;

public class ItemVersionRevisions {
  List<Revision> itemVersionRevisions = new ArrayList<>();

  public List<Revision> getItemVersionRevisions() {
    return itemVersionRevisions;
  }

  public void setItemVersionRevisions(
      List<Revision> itemVersionRevisions) {
    this.itemVersionRevisions = itemVersionRevisions;
  }

  public void addChange(Revision revision){
    this.itemVersionRevisions.add(revision);
  }
}
