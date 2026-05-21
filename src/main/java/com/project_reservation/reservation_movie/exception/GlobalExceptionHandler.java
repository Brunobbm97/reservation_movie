package com.project_reservation.reservation_movie.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

/**
 * A nossa "rede de segurança" global. Interceta exceções lançadas em qualquer lugar
 * da aplicação e formata a resposta antes de enviar ao cliente.
 */
@RestControllerAdvice // Diz ao Spring que esta classe vai tratar os erros de todos os Controllers
public class GlobalExceptionHandler {

    /**
     * Este método é ativado automaticamente sempre que uma RuntimeException for lançada.
     */
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorResponse> handleRuntimeException(RuntimeException ex) {

        // Montamos o nosso objeto de erro bonitinho usando a mensagem que veio da exceção
        ErrorResponse errorResponse = new ErrorResponse(
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST.value(), // Devolve 400 em vez de 500
                "Regra de Negócio Violada",
                ex.getMessage() // Aqui entra o nosso "Erro: O assento já está ocupado!"
        );

        // Devolvemos o erro para a internet (Insomnia/Angular)
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }
}