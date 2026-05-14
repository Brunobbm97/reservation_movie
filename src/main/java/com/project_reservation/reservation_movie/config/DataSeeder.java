package com.project_reservation.reservation_movie.config;

import com.project_reservation.reservation_movie.modules.entity.Role;
import com.project_reservation.reservation_movie.modules.entity.Room;
import com.project_reservation.reservation_movie.modules.entity.Seat;
import com.project_reservation.reservation_movie.modules.entity.User;
import com.project_reservation.reservation_movie.modules.repository.RoomRepository;
import com.project_reservation.reservation_movie.modules.repository.SeatRepository;
import com.project_reservation.reservation_movie.modules.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DataSeeder implements CommandLineRunner {

    private final UserRepository userRepository;
    private final RoomRepository roomRepository;
    private final SeatRepository seatRepository;

    @Override
    public void run(String... args) throws Exception {
        if (userRepository.count() == 0) {

            User admin = new User(null, "Admin", "admin@cinema.com", "123456", Role.ADMIN);
            User cliente = new User(null, "Cliente Teste", "cliente@cinema.com", "123456", Role.USER);
            userRepository.saveAll(List.of(admin, cliente));

            Room room = new Room(null, "Sala 1 - Principal", 50);
            roomRepository.save(room);

            Seat seat1 = new Seat(null, room, "A", 1);
            Seat seat2 = new Seat(null, room, "A", 2);
            Seat seat3 = new Seat(null, room, "A", 3);
            seatRepository.saveAll(List.of(seat1, seat2, seat3));

        }
    }
}
