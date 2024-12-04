package com.example.ecomerce.controller;

import com.example.ecomerce.dto.ItemRequestDTO;
import com.example.ecomerce.model.Item;
import com.example.ecomerce.repository.ItemRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Item")
public class ItemController {

    @Autowired
    private ItemRepository repository;

    @GetMapping
    public ResponseEntity<List<Item>> getAllItems() {
        return ResponseEntity.ok(this.repository.findAll());
    }

    @PostMapping
    public ResponseEntity<Item> save(@Valid @RequestBody ItemRequestDTO dto) {
        Item item = new Item();
        item.setNome(dto.getNome());
        item.setDescricao(dto.getDescricao());
        item.setPreco(dto.getPreco());
        item.setEstoque(dto.getEstoque());
        this.repository.save(item);

        return ResponseEntity.ok(item);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        Item item = this.repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Item não encontrado"));
        this.repository.delete(item);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Item> update(@PathVariable Integer id, @Valid @RequestBody ItemRequestDTO dto) {
        Item item = this.repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Item não encontrado"));

        item.setNome(dto.getNome());
        item.setDescricao(dto.getDescricao());
        item.setPreco(dto.getPreco());
        item.setEstoque(dto.getEstoque());
        this.repository.save(item);

        return ResponseEntity.ok(item);
    }
}
