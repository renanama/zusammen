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

package org.amdocs.tsuzammen.core.impl.item;


import org.amdocs.tsuzammen.adaptor.outbound.api.CollaborationAdaptor;
import org.amdocs.tsuzammen.adaptor.outbound.api.CollaborationAdaptorFactory;
import org.amdocs.tsuzammen.adaptor.outbound.api.item.ItemStateAdaptor;
import org.amdocs.tsuzammen.adaptor.outbound.api.item.ItemStateAdaptorFactory;
import org.amdocs.tsuzammen.datatypes.Id;
import org.amdocs.tsuzammen.datatypes.SessionContext;
import org.amdocs.tsuzammen.datatypes.item.Info;
import org.amdocs.tsuzammen.datatypes.item.Item;
import org.amdocs.tsuzammen.core.api.item.ItemManager;
import org.amdocs.tsuzammen.core.impl.Messages;

import java.util.Collection;
import java.util.UUID;

public class ItemManagerImpl implements ItemManager {


  @Override
  public Collection<Item> list(SessionContext context) {
    return getStateAdaptor(context).listItems(context);
  }

  @Override
  public Item get(SessionContext context, Id itemId) {
    validateItemExistence(context, itemId);
    return getStateAdaptor(context).getItem(context, itemId);
  }

  @Override
  public Id create(SessionContext context, Info itemInfo) {
    Id itemId = new Id(UUID.randomUUID());
    getCollaborationAdaptor(context).createItem(context, itemId, itemInfo);
    getStateAdaptor(context).createItem(context, itemId, itemInfo);
    return itemId;
  }

  @Override
  public void save(SessionContext context, Id itemId, Info itemInfo) {
    validateItemExistence(context, itemId);
    getCollaborationAdaptor(context).saveItem(context, itemId, itemInfo);
    getStateAdaptor(context).saveItem(context, itemId, itemInfo);
  }

  @Override
  public void delete(SessionContext context, Id itemId) {
    validateItemExistence(context, itemId);
    getCollaborationAdaptor(context).deleteItem(context, itemId);
    getStateAdaptor(context).deleteItem(context, itemId);
  }

  private void validateItemExistence(SessionContext context, Id itemId) {
    if (!getStateAdaptor(context).isItemExist(context, itemId)) {
      throw new RuntimeException(String.format(Messages.ITEM_NOT_EXIST, itemId));
    }
  }

  private CollaborationAdaptor getCollaborationAdaptor(SessionContext context) {
    return CollaborationAdaptorFactory.getInstance().createInterface(context);
  }

  private ItemStateAdaptor getStateAdaptor(SessionContext context) {
    return ItemStateAdaptorFactory.getInstance().createInterface(context);
  }
}
