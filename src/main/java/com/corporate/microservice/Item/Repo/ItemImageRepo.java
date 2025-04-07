package com.corporate.microservice.Item.Repo;

import com.corporate.microservice.Item.model.ItemImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemImageRepo extends JpaRepository<ItemImage,Long> {
}
