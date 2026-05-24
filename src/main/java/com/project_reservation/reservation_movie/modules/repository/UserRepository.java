package com.project_reservation.reservation_movie.modules.repository;

import com.project_reservation.reservation_movie.modules.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repositório para a entidade User (Utilizador).
 * O JpaRepository precisa de dois tipos: <A Classe da Entidade, O tipo da Chave Primária (ID)>
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // Método personalizado: O Spring entende o nome do método e cria o SQL automaticamente!
    // Vai ser muito útil no momento do Login para procurar o utilizador pelo email.
    Optional<User> findByEmail(String email);
}