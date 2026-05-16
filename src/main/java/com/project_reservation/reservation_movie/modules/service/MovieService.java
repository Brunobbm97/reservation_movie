package com.project_reservation.reservation_movie.modules.service;

import com.project_reservation.reservation_movie.modules.entity.Movie;
import com.project_reservation.reservation_movie.modules.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Serviço responsável pela gestão de Filmes.
 */
@Service // Indica ao Spring que esta é uma classe de serviço (lógica de negócio)
@RequiredArgsConstructor // Lombok: Injeta o repositório automaticamente
public class MovieService {

    private final MovieRepository movieRepository;

    /**
     * Guarda um novo filme no banco de dados.
     *
     * @param movie O objeto filme recebido (ex: do frontend ou do Postman).
     * @return O filme guardado, agora com um ID gerado pelo PostgreSQL.
     */
    public Movie saveMovie(Movie movie) {
        // O método .save() já vem pronto do JpaRepository. Não precisamos escrever SQL!
        return movieRepository.save(movie);
    }

    /**
     * Busca todos os filmes registados.
     *
     * @return Uma lista com todos os filmes.
     */
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    /**
     * Busca um filme específico pelo seu ID.
     */
    public Movie getMovieById(Long id) {
        return movieRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Filme com ID " + id + " não encontrado."));
    }
}