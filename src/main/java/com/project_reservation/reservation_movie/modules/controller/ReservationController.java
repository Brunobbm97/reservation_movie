package com.project_reservation.reservation_movie.modules.controller;

import com.project_reservation.reservation_movie.modules.dto.ReservationRequestDTO;
import com.project_reservation.reservation_movie.modules.entity.Reservation;
import com.project_reservation.reservation_movie.modules.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reservations")
@RequiredArgsConstructor
public class ReservationController {

    private final ReservationService reservationService;

    /**
     * Rota para COMPRAR bilhetes (fazer uma reserva).
     * Método HTTP: POST
     * URL: http://localhost:8080/api/reservations
     */
    @PostMapping
    public ResponseEntity<Reservation> makeReservation(@RequestBody ReservationRequestDTO request) {
        // Recebemos o nosso "envelope" (DTO) e desempacotamos as variáveis para entregar ao Serviço
        Reservation confirmedReservation = reservationService.createReservation(
                request.getUserId(),
                request.getShowtimeId(),
                request.getSeatIds()
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(confirmedReservation);
    }
}
