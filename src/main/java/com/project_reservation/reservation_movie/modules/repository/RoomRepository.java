package com.project_reservation.reservation_movie.modules.repository;

import com.project_reservation.reservation_movie.modules.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
}