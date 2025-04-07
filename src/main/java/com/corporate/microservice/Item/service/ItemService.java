package com.corporate.microservice.Item.service;

import com.corporate.microservice.Item.model.Item;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public interface ItemService {
    ResponseEntity<?> saveItem(Item item);

    ResponseEntity<?> getAllItems();

    ResponseEntity<?> saveAllItems(List<Item> items);

    ResponseEntity<?> saveItemImage(MultipartFile file,Long itemId);
}
