package com.corporate.microservice.Item.serviceImpl;

import com.corporate.microservice.Item.Repo.ItemImageRepo;
import com.corporate.microservice.Item.Repo.ItemRepo;
import com.corporate.microservice.Item.model.Item;
import com.corporate.microservice.Item.model.ItemImage;
import com.corporate.microservice.Item.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.swing.text.AbstractDocument;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    private ItemImageRepo itemImageRepo;

    @Override
    public ResponseEntity<?> saveItem(Item item) {
        return new ResponseEntity<>(itemRepo.save(item), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getAllItems() {
        return new ResponseEntity<>(itemRepo.findAll(),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> saveAllItems(List<Item> items) {
        return new ResponseEntity<>(itemRepo.saveAll(items),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> saveItemImage(MultipartFile file,Long itemId) {

        try {
            ItemImage image = new ItemImage();
            image.setContent(file.getBytes());
            image.setItemId(itemId);
           return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(itemImageRepo.save(image).getContent());
//            return new ResponseEntity<>(itemImageRepo.save(image),HttpStatus.OK);
        }catch (IOException e)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
