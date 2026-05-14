package com.project_reservation.reservation_movie.modules.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entidade que representa os Utilizadores (Clientes e Admins) no banco de dados.
 */
@Entity
@Table(name = "users") // Chamamos "users" no plural porque "user" é uma palavra reservada no PostgreSQL
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true) // O email não pode repetir
    private String email;

    @Column(nullable = false)
    private String password; // Mais tarde, no Passo de Autenticação, vamos encriptar esta senha!

    @Enumerated(EnumType.STRING) // Grava no banco a palavra "ADMIN" ou "USER" em vez de números (0 ou 1)
    @Column(nullable = false)
    private Role role;
}