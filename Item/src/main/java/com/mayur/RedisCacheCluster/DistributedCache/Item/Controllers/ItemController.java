package com.mayur.RedisCacheCluster.DistributedCache.Item.Controllers;

import com.mayur.RedisCacheCluster.DistributedCache.Item.Entities.Item;
import com.mayur.RedisCacheCluster.DistributedCache.Item.Services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ItemController {
    @Autowired
    ItemService itemService;

    @PostMapping("/saveItem")
    public Item saveInvoice(@RequestBody Item item) {
        item.setItemId(null);
        return itemService.saveItem(item);
    }

    @GetMapping("/allItems")
    public ResponseEntity<List<Item>> getAllInvoices(){
        return ResponseEntity.ok(itemService.getAllItems());
    }

    @GetMapping("/getOne/{id}")
    public Item getOneInvoice(@PathVariable Integer id) {
        return itemService.getOneItem(id);
    }

    @PutMapping("/modify/{id}")
    public Item updateInvoice(@RequestBody Item item, @PathVariable Integer id) {
        return itemService.updateItem(item, id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteInvoice(@PathVariable Integer id) {
        itemService.deleteItem(id);
        return "Employee with id: "+id+ " Deleted !";
    }
}
