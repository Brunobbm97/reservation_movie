package com.project_reservation.reservation_movie.modules.dto;

import lombok.Data;
import java.util.List;

/**
 * DTO (Data Transfer Object) para receber os dados de uma nova reserva.
 * Funciona como um "envelope" simples para transportar informações da internet para a nossa API.
 */
@Data // O Lombok cria os Getters e Setters por nós
public class ReservationRequestDTO {

    private Long userId;        // Quem está a comprar
    private Long showtimeId;    // Qual a sessão (filme + horário + sala)
    private List<Long> seatIds; // Quais os lugares (ex: IDs correspondentes a Fila A-1, A-2)
}