package com.example.ecomerce.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "pedido")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Pedido_ID")
    private Integer pedidoId;

    @ManyToOne
    @JoinColumn(name = "Usuario_ID", referencedColumnName = "Usuario_ID")
    @JsonIgnoreProperties("pedidos")
    private Usuario usuario;


    @Column(name = "Data_Pedido")
    private LocalDateTime dataPedido = LocalDateTime.now();

    @Column(name = "Status")
    private String status;

    // Getters e Setters


    public Integer getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(Integer pedidoId) {
        this.pedidoId = pedidoId;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public LocalDateTime getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(LocalDateTime dataPedido) {
        this.dataPedido = dataPedido;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
