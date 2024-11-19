package com.example.ecomerce.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "pagamento")
public class Pagamento {

    @EmbeddedId
    private PagamentoPK id;

    @ManyToOne
    @MapsId("Pedidoid")
    @JoinColumn(name = "Pedido_ID", referencedColumnName = "Pedido_ID")
    @JsonIgnoreProperties("forma_pgto_id")
    private Pedido pedido;

    @ManyToOne
    @MapsId("forma_pgto_id")
    @JoinColumn(name = "Forma_PGTO_ID", referencedColumnName = "Forma_PGTO_ID")
    private FormaPgto formaPgto;

    @Column(name = "Data_Pagamento")
    private LocalDate data_pagamento;


    public PagamentoPK getId() {
        return id;
    }

    public void setId(PagamentoPK id) {
        this.id = id;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public FormaPgto getFormaPgto() {
        return formaPgto;
    }

    public void setFormaPgto(FormaPgto formaPgto) {
        this.formaPgto = formaPgto;
    }

    public LocalDate getData_pagamento() {
        return data_pagamento;
    }

    public void setData_pagamento(LocalDate data_pagamento) {
        this.data_pagamento = data_pagamento;
    }
}

