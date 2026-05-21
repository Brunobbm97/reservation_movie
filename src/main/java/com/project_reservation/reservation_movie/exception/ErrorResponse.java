package com.project_reservation.reservation_movie.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * Classe que define o formato padrão para as mensagens de erro da nossa API.
 */
@Data
@AllArgsConstructor
public class ErrorResponse {

    private LocalDateTime timestamp; // Data e hora em que o erro aconteceu
    private int status;              // O código do erro (ex: 400)
    private String error;            // O título do erro
    private String message;          // A mensagem amigável que escrevemos no nosso Serviço
}
