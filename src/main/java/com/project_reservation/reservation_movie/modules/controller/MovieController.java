package com.project_reservation.reservation_movie.modules.controller;

import com.project_reservation.reservation_movie.modules.entity.Movie;
import com.project_reservation.reservation_movie.modules.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador para gerir as rotas (URLs) relacionadas com os Filmes.
 */
@RestController // Diz ao Spring que esta classe vai receber pedidos da internet e devolver JSON
@RequestMapping("/api/movies") // Define o endereço base para aceder a este controlador
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService; // Injetamos o serviço que criámos no passo anterior

    /**
     * Rota para ADICIONAR um novo filme.
     * Método HTTP: POST
     * URL: http://localhost:8080/api/movies
     */
    @PostMapping
    public ResponseEntity<Movie> addMovie(@RequestBody Movie movie) {
        // @RequestBody avisa o Spring para transformar o JSON recebido num objeto da classe Movie
        Movie savedMovie = movieService.saveMovie(movie);
        // Devolve o filme salvo com o status 201 (Created - Criado com sucesso)
        return ResponseEntity.status(HttpStatus.CREATED).body(savedMovie);
    }

    /**
     * Rota para LISTAR todos os filmes.
     * Método HTTP: GET
     * URL: http://localhost:8080/api/movies
     */
    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies() {
        List<Movie> movies = movieService.getAllMovies();
        // Devolve a lista de filmes com o status 200 (OK)
        return ResponseEntity.ok(movies);
    }
}