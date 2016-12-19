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

package org.amdocs.tsuzammen.adaptor.inbound.impl.item;

import org.amdocs.tsuzammen.adaptor.inbound.api.item.ItemVersionContentAdaptor;
import org.amdocs.tsuzammen.commons.datatypes.SessionContext;
import org.amdocs.tsuzammen.commons.datatypes.item.ItemVersionData;
import org.amdocs.tsuzammen.core.api.item.ItemVersionContentManager;
import org.amdocs.tsuzammen.core.api.item.ItemVersionContentManagerFactory;

public class ItemVersionContentAdaptorImpl implements ItemVersionContentAdaptor {
  @Override
  public void save(SessionContext context, String itemId, String versionId,
                   ItemVersionData versionData, String message) {
    getItemVersionContentManager(context)
        .save(context, itemId, versionId, versionData, null, null, message);
  }

  private ItemVersionContentManager getItemVersionContentManager(SessionContext context) {
    return ItemVersionContentManagerFactory.getInstance().createInterface(context);
  }
}