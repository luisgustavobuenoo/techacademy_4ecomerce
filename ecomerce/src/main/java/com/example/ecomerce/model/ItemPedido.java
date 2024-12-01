package com.example.ecomerce.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
public class ItemPedido {

    @EmbeddedId
    private ItemPedidoPK id;

    @ManyToOne
    @MapsId("pedidoId")
    @JoinColumn(name = "Pedido_ID")
    private Pedido pedido;

    @ManyToOne
    @MapsId("itemId")
    @JoinColumn(name = "Item_ID")
    private Item item;

    private BigDecimal quantidade;  // Alterado para BigDecimal

    @Column(name = "Preco_Total")
    private BigDecimal precoTotal;

    // Getter e Setter para precoTotal
    public BigDecimal getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(BigDecimal precoTotal) {
        this.precoTotal = precoTotal;
    }

    // Método para calcular precoTotal corretamente
    public void calcularPrecoTotal() {
        if (item != null && item.getPreco() != null) {
            // Multiplica o preco unitario do item pela quantidade
            this.precoTotal = item.getPreco().multiply(quantidade); // Alterado para BigDecimal
        }
    }

    // Getters e Setters para outros campos
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
}
