package com.example.ecomerce.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "usuario")


public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String Nome;

    @Column
    private String Email;

    @Column
    private String Senha;


    @ManyToOne
    @JoinColumn(name = "Usuario_ID", referencedColumnName = "id")
    @JsonIgnoreProperties("usuario")
    private  Pedido pedido;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(id, usuario.id) && Objects.equals(Nome, usuario.Nome) && Objects.equals(Email, usuario.Email) && Objects.equals(Senha, usuario.Senha) && Objects.equals(pedido, usuario.pedido);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, Nome, Email, Senha, pedido);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String senha) {
        Senha = senha;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
}
