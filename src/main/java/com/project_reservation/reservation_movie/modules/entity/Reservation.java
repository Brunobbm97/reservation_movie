package com.project_reservation.reservation_movie.modules.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Entidade que representa a compra/reserva de bilhetes.
 */
@Entity
@Table(name = "reservations")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Relacionamento: Várias Reservas podem pertencer a Um Utilizador
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    // Relacionamento: Várias Reservas podem ser feitas para a mesma Sessão
    @ManyToOne
    @JoinColumn(name = "showtime_id", nullable = false)
    private Showtime showtime;

    // Relacionamento: Uma Reserva pode ter Vários Assentos e um Assento pode estar em Várias Reservas (em sessões diferentes)
    // O JPA vai criar uma tabela intermédia para gerir isto automaticamente.
    @ManyToMany
    @JoinTable(
            name = "reservation_seats",
            joinColumns = @JoinColumn(name = "reservation_id"),
            inverseJoinColumns = @JoinColumn(name = "seat_id")
    )
    private List<Seat> seats;

    @Column(nullable = false)
    private LocalDateTime reservationTime; // Quando a compra foi feita

    @Column(nullable = false)
    private Double totalAmount; // O preço total (Quantidade de assentos X preço do bilhete da sessão)
}