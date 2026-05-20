package com.project_reservation.reservation_movie.modules.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

/**
 * Entidade User. Agora implementa UserDetails para se integrar com o Spring Security.
 */
@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    // =======================================================================
    // MÉTODOS OBRIGATÓRIOS DA INTERFACE UserDetails (Spring Security)
    // =======================================================================

    /**
     * Diz ao Spring quais são as permissões (Roles) deste utilizador.
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Se for ADMIN, ele tem a permissão ROLE_ADMIN. Se for USER, tem ROLE_USER.
        if (this.role == Role.ADMIN) {
            return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_USER"));
        } else {
            return List.of(new SimpleGrantedAuthority("ROLE_USER"));
        }
    }

    /**
     * Diz ao Spring qual campo é o "nome de utilizador" no nosso sistema (nós usamos o email).
     */
    @Override
    public String getUsername() {
        return this.email;
    }

    // Os métodos abaixo servem para bloquear contas. Por enquanto, vamos deixar todos como "true" (ativos).

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}