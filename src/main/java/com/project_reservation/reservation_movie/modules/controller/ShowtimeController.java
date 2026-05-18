package com.project_reservation.reservation_movie.modules.controller;

import com.project_reservation.reservation_movie.modules.entity.Showtime;
import com.project_reservation.reservation_movie.modules.service.ShowtimeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/showtimes")
@RequiredArgsConstructor
public class ShowtimeController {

    private final ShowtimeService showtimeService;

    /**
     * Rota para CRIAR uma nova sessão.
     * Exemplo de URL: http://localhost:8080/api/showtimes?movieId=1&roomId=1&price=15.50
     */
    @PostMapping
    public ResponseEntity<Showtime> createShowtime(
            @RequestParam Long movieId,
            @RequestParam Long roomId,
            @RequestParam String startTime, // Recebemos como texto e convertemos abaixo
            @RequestParam Double price) {

        LocalDateTime parsedTime = LocalDateTime.parse(startTime);
        Showtime newShowtime = showtimeService.createShowtime(movieId, roomId, parsedTime, price);

        return ResponseEntity.status(HttpStatus.CREATED).body(newShowtime);
    }

    /**
     * Rota para LISTAR as sessões de um filme específico.
     * O {movieId} na URL é uma variável.
     * Exemplo de URL: http://localhost:8080/api/showtimes/movie/5
     */
    @GetMapping("/movie/{movieId}")
    public ResponseEntity<List<Showtime>> getShowtimesByMovie(@PathVariable Long movieId) {
        // @PathVariable pega o número "5" da URL e coloca na variável movieId
        List<Showtime> showtimes = showtimeService.getShowtimesForMovie(movieId);
        return ResponseEntity.ok(showtimes);
    }
}