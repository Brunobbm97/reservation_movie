package com.project_reservation.reservation_movie.modules.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entidade que representa um lugar específico (Fila e Número) dentro de uma Sala.
 */
@Entity
@Table(name = "seats")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Relacionamento: Vários Assentos pertencem a Uma Sala
    @ManyToOne
    @JoinColumn(name = "room_id", nullable = false)
    private Room room;

    @Column(nullable = false)
    private String rowName; // Exemplo: "A", "B", "C"

    @Column(nullable = false)
    private Integer seatNumber; // Exemplo: 1, 2, 3
}