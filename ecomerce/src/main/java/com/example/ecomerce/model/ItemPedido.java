package com.example.ecomerce.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table
public class ItemPedido {
    @EmbeddedId
    private ItemPedidoPK id;

    @ManyToOne
    @MapsId("Pedidoid")
    @JoinColumn(name = "Pedido_ID", referencedColumnName = "Pedido_ID")
    private Pedido pedido;

    @ManyToOne
    @MapsId("item_id")
    @JoinColumn(name = "Item_ID", referencedColumnName = "Item_ID")
    private Item item;

    @Column(name = "Quantidade")
    private BigDecimal quantidade;

    @Column(name = "Preco_Total")
    private BigDecimal precoTotal;

    public ItemPedidoPK getId() {
        return id;
    }

    public void setId(ItemPedidoPK id) {
        this.id = id;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(BigDecimal precoTotal) {
        this.precoTotal = precoTotal;
    }
}
