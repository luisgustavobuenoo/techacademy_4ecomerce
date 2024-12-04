package com.example.ecomerce.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "item")
public class Item extends ProdutoBase {

    @Column(name = "Estoque")
    private BigDecimal estoque;

    // Getters e Setters
    public BigDecimal getEstoque() {
        return estoque;
    }

    public void setEstoque(BigDecimal estoque) {
        this.estoque = estoque;
    }
}
