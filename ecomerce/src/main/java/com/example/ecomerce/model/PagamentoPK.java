package com.example.ecomerce.model;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.util.Objects;

@Embeddable
public class PagamentoPK {
    @Column(name = "Pedido_ID")
    private Integer pedidoId;

    @Column(name = "Forma_PGTO_ID")
    private Integer formaPgtoId;

    public Integer getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(Integer pedidoId) {
        this.pedidoId = pedidoId;
    }

    public Integer getFormaPgtoId() {
        return formaPgtoId;
    }

    public void setFormaPgtoId(Integer formaPgtoId) {
        this.formaPgtoId = formaPgtoId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PagamentoPK that = (PagamentoPK) o;
        return Objects.equals(pedidoId, that.pedidoId) && Objects.equals(formaPgtoId, that.formaPgtoId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pedidoId, formaPgtoId);
    }
}
