package com.corporate.microservice.Item.Repo;

import com.corporate.microservice.Item.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepo extends JpaRepository<Item,Long> {

}
