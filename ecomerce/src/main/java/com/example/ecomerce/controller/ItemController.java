
package com.example.ecomerce.controller;

import com.example.ecomerce.dto.ItemRequestDTO;
import com.example.ecomerce.model.Item;
import com.example.ecomerce.service.ItemService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Item")
public class ItemController {

    @Autowired
    private ItemService service;

    @GetMapping
    public ResponseEntity<List<Item>> getAllItems() {
        return ResponseEntity.ok(service.getAllItems());
    }

    @PostMapping
    public ResponseEntity<Item> save(@Valid @RequestBody ItemRequestDTO dto) {
        Item item = new Item();
        item.setNome(dto.getNome());
        item.setDescricao(dto.getDescricao());
        item.setPreco(dto.getPreco());
        item.setEstoque(dto.getEstoque());
        return ResponseEntity.ok(service.saveItem(item));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.deleteItem(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Item> update(@PathVariable Integer id, @Valid @RequestBody ItemRequestDTO dto) {
        Item item = new Item();
        item.setNome(dto.getNome());
        item.setDescricao(dto.getDescricao());
        item.setPreco(dto.getPreco());
        item.setEstoque(dto.getEstoque());
        return ResponseEntity.ok(service.updateItem(id, item));
    }
}
