package sg.nus.iss.apiDarryl.apiDarryl.service;

import java.util.List;

import sg.nus.iss.apiDarryl.apiDarryl.Model.Item;



public interface ItemService {
    Item saveItem(Item item);

    List<Item> getItemList();

    Item updateItem(Item item, Long itemId);

    void deleteItemById(Long itemId);
}
