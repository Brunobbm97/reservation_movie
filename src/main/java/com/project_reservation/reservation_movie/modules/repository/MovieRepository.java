package com.project_reservation.reservation_movie.modules.repository;

import com.project_reservation.reservation_movie.modules.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
}