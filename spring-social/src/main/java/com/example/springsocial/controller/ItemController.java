package com.example.springsocial.controller;

import com.example.springsocial.model.Item;
import com.example.springsocial.repository.ItemRepository;
import com.example.springsocial.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
@RestController
public class ItemController {
    @Autowired
    private ItemRepository itemRepository;

    /**
     * <p>Get all items for non authenticated users</p>
     * @return
     */
    @GetMapping("/items")
    public ResponseEntity<List<Item>> getAllItems(Pageable pageable){
        Page<Item> page =  itemRepository.findAll(
                PageRequest.of(
                    pageable.getPageNumber(),
                    pageable.getPageSize(),
                    pageable.getSortOr(Sort.by(Sort.Direction.DESC, "id"))));

        return ResponseEntity.ok(page.getContent());
    }

}
