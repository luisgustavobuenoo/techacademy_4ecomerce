package com.example.ecomerce.dto;

import java.math.BigDecimal;

public class PagamentoRequestDTO {
    private Integer formaPgtoId; // ID da Forma de Pagamento
    private BigDecimal valor;   // Valor do pagamento

    // Getter e Setter para formaPgtoId
    public Integer getFormaPgtoId() {
        return formaPgtoId;
    }

    public void setFormaPgtoId(Integer formaPgtoId) {
        this.formaPgtoId = formaPgtoId;
    }

    // Getter e Setter para valor
    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
}
