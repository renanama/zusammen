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

package org.amdocs.tsuzammen.core.api.workspace;


import org.amdocs.tsuzammen.datatypes.Id;
import org.amdocs.tsuzammen.datatypes.ItemVersionKey;
import org.amdocs.tsuzammen.datatypes.SessionContext;
import org.amdocs.tsuzammen.datatypes.item.Info;
import org.amdocs.tsuzammen.datatypes.workspace.WorkspaceInfo;

import java.util.Collection;

public interface WorkspaceManager {

  Id create(SessionContext context, Info workspaceInfo);

  void save(SessionContext context, Id workspaceId, Info workspaceInfo);

  void delete(SessionContext context, Id workspaceId);

  Collection<WorkspaceInfo> list(SessionContext context);

  void addItem(SessionContext context, Id workspaceId, Id itemId, Id versionId);

  void removeItem(SessionContext context, Id workspaceId, Id itemId, Id versionId);

  Collection<ItemVersionKey> listItems(SessionContext context, Id workspaceId);
}
