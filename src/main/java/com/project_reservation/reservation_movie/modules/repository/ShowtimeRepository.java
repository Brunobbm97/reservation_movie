package com.project_reservation.reservation_movie.modules.repository;

import com.project_reservation.reservation_movie.modules.entity.Showtime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ShowtimeRepository extends JpaRepository<Showtime, Long> {

    // Método personalizado: Busca todas as sessões de um filme específico
    List<Showtime> findByMovieId(Long movieId);

    // Método personalizado: Busca sessões que acontecem depois de uma determinada data/hora
    List<Showtime> findByStartTimeAfter(LocalDateTime time);
}