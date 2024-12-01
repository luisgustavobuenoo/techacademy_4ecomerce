package com.example.ecomerce.dto;

import java.math.BigDecimal;

public class PagamentoRequestDTO {
    private Integer formaPgtoId; // ID da Forma de Pagamento

    // Getter e Setter para formaPgtoId
    public Integer getFormaPgtoId() {
        return formaPgtoId;
    }

    public void setFormaPgtoId(Integer formaPgtoId) {
        this.formaPgtoId = formaPgtoId;
    }

}
