package com.corporate.microservice.Item.controller;

import com.corporate.microservice.Item.model.Item;
import com.corporate.microservice.Item.service.ItemService;
import jdk.jfr.ContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping(value = "/item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping("/saveItem")
    public ResponseEntity<?> saveItem(@RequestBody Item item) {
        return  itemService.saveItem(item);
    }

    @GetMapping("/getItems")
    public ResponseEntity<?> getItems(){
        return itemService.getAllItems();
    }

    @PostMapping("/createItemsBulk")
    public ResponseEntity<?> saveBulkItems(@RequestBody List<Item> items){
        return itemService.saveAllItems(items);
    }

    @PostMapping(value = "/saveItemImage")
    public ResponseEntity<?> saveItemImage(@RequestPart("file")MultipartFile file, @RequestParam("itemId")Long itemId)
    {
        return itemService.saveItemImage(file,itemId);
    }
}
