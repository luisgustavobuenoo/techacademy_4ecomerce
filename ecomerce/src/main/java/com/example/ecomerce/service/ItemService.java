
package com.example.ecomerce.service;

import com.example.ecomerce.model.Item;
import com.example.ecomerce.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    private ItemRepository repository;

    public List<Item> getAllItems() {
        return repository.findAll();
    }

    public Item saveItem(Item item) {
        return repository.save(item);
    }

    public void deleteItem(Integer id) {
        Item item = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item não encontrado"));
        repository.delete(item);
    }

    public Item updateItem(Integer id, Item newItem) {
        Item item = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item não encontrado"));

        item.setNome(newItem.getNome());
        item.setDescricao(newItem.getDescricao());
        item.setPreco(newItem.getPreco());
        item.setEstoque(newItem.getEstoque());
        return repository.save(item);
    }
}
