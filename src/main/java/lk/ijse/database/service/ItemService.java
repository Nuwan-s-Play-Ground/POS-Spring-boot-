package lk.ijse.database.service;

import java.util.List;

import lk.ijse.database.entity.Item;

public interface ItemService {

    List<Item> getAllItems();
    Item getItemById(Long id);
    Item createItem(Item item);
    List<Item> getItemsByCategoryId(Long categoryId);
    
}
