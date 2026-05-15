package com.project_reservation.reservation_movie.modules.repository;

import com.project_reservation.reservation_movie.modules.entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Long> {

    // Método personalizado: Traz todos os assentos (Fila e Número) de uma sala específica
    List<Seat> findByRoomId(Long roomId);
}