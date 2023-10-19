package lk.ijse.database.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lk.ijse.database.entity.Item;
import lk.ijse.database.service.ItemService;

//@CrossOrigin(origins = "*")
@RestController
//@RequestMapping("/items")

public class ItemController {
    private ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService){
        this.itemService=itemService;
    }

    @GetMapping("/items")
    public ResponseEntity<List<Item>> getAllItems(){
        List<Item> items = itemService.getAllItems();
        return ResponseEntity.status(HttpStatus.OK).body(items);
        
    }

    @GetMapping("/items/{id}")
    public ResponseEntity<Item> getItemById(@PathVariable Long id){
        try {
            Item item = itemService.getItemById(id);
            return ResponseEntity.status(HttpStatus.OK).body(item);
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null); 
        }
    }

    @PostMapping("/items")
    public ResponseEntity<Item> createItem(@RequestBody Item item){
        try {
            Item createdItem = itemService.createItem(item);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdItem);
        } catch (Exception e) {
              return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null); 
        }
    }

    @GetMapping("/categories/{categoryId}/items")
    public ResponseEntity<List<Item>> getItemsByCategoryId(@PathVariable Long categoryId) {
        return ResponseEntity.status(HttpStatus.OK).body(itemService.getItemsByCategoryId(categoryId));
    }

}
