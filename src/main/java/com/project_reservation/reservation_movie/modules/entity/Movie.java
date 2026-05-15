package com.project_reservation.reservation_movie.modules.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entidade que representa um Filme no banco de dados.
 */
@Entity // Indica que esta classe será uma tabela no PostgreSQL
@Table(name = "movies") // Opcional: Define o nome exato da tabela
@Data // Lombok: Cria Getters, Setters, toString, etc.
@NoArgsConstructor // Lombok: Construtor sem argumentos (exigido pelo JPA)
@AllArgsConstructor // Lombok: Construtor com todos os argumentos
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Chave primária gerada automaticamente (1, 2, 3...)

    @Column(nullable = false) // Indica que o título não pode ser nulo
    private String title;

    @Column(length = 1000) // Aumenta o tamanho da coluna no banco para textos longos
    private String description;

    private String genre;

    private String posterImageUrl; // Link para a imagem do cartaz
}
