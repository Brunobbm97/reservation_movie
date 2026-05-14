package com.project_reservation.reservation_movie.modules.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * Entidade que representa a exibição de um filme numa sala a uma determinada hora.
 */
@Entity
@Table(name = "showtimes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Showtime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Relacionamento: Muitos Showtimes (Sessões) podem passar o mesmo Movie (Filme)
    @ManyToOne
    @JoinColumn(name = "movie_id", nullable = false)
    private Movie movie;

    // Relacionamento: Muitos Showtimes (Sessões) podem acontecer na mesma Room (Sala)
    @ManyToOne
    @JoinColumn(name = "room_id", nullable = false)
    private Room room;

    @Column(nullable = false)
    private LocalDateTime startTime; // Data e hora exata em que o filme começa

    @Column(nullable = false)
    private Double ticketPrice; // Preço do bilhete para esta sessão específica
}