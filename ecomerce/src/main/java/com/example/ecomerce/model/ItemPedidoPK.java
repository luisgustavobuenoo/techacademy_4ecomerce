package com.example.ecomerce.model;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ItemPedidoPK implements Serializable {

    private int pedidoId;
    private int itemId;

    // Construtores
    public ItemPedidoPK() {}

    public ItemPedidoPK(int pedidoId, int itemId) {
        this.pedidoId = pedidoId;
        this.itemId = itemId;
    }

    // Getters e Setters
    public int getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(int pedidoId) {
        this.pedidoId = pedidoId;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    // hashCode e equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemPedidoPK that = (ItemPedidoPK) o;
        return pedidoId == that.pedidoId && itemId == that.itemId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(pedidoId, itemId);
    }
}
