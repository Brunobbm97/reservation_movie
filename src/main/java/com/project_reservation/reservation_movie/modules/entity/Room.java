package com.project_reservation.reservation_movie.modules.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entidade que representa uma Sala de Cinema.
 */
@Entity
@Table(name = "rooms")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true) // O nome da sala tem de ser único (não podem haver duas "Sala 1")
    private String name;

    @Column(nullable = false)
    private Integer totalCapacity; // Capacidade total da sala
}