package com.example.ecomerce.repository;

import com.example.ecomerce.model.Pedido;
import com.example.ecomerce.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {

}


