package com.project_reservation.reservation_movie.modules.service;

import com.project_reservation.reservation_movie.modules.entity.Movie;
import com.project_reservation.reservation_movie.modules.entity.Room;
import com.project_reservation.reservation_movie.modules.entity.Showtime;
import com.project_reservation.reservation_movie.modules.repository.MovieRepository;
import com.project_reservation.reservation_movie.modules.repository.RoomRepository;
import com.project_reservation.reservation_movie.modules.repository.ShowtimeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Serviço responsável por agendar as sessões (ligar Filmes a Salas num horário).
 */
@Service
@RequiredArgsConstructor
public class ShowtimeService {

    // Precisamos dos 3 repositórios para garantir que tudo existe antes de agendar
    private final ShowtimeRepository showtimeRepository;
    private final MovieRepository movieRepository;
    private final RoomRepository roomRepository;

    /**
     * Cria uma nova sessão.
     *
     * @param movieId O ID do filme que vai passar.
     * @param roomId O ID da sala onde o filme vai passar.
     * @param startTime O horário do filme.
     * @param ticketPrice O preço do bilhete para esta sessão.
     * @return A sessão agendada.
     */
    public Showtime createShowtime(Long movieId, Long roomId, LocalDateTime startTime, Double ticketPrice) {

        // Passo 1: Verificar se o Filme existe
        Movie movie = movieRepository.findById(movieId)
                .orElseThrow(() -> new RuntimeException("Erro: Filme não encontrado no sistema."));

        // Passo 2: Verificar se a Sala existe
        Room room = roomRepository.findById(roomId)
                .orElseThrow(() -> new RuntimeException("Erro: Sala não encontrada no sistema."));

        // Passo 3: Montar o objeto Showtime com as peças encontradas
        Showtime showtime = new Showtime();
        showtime.setMovie(movie);
        showtime.setRoom(room);
        showtime.setStartTime(startTime);
        showtime.setTicketPrice(ticketPrice);

        // Passo 4: Guardar na base de dados
        return showtimeRepository.save(showtime);
    }

    /**
     * Lista todas as sessões disponíveis para um determinado filme.
     * Usa aquele método personalizado que criámos no ShowtimeRepository!
     */
    public List<Showtime> getShowtimesForMovie(Long movieId) {
        return showtimeRepository.findByMovieId(movieId);
    }
}