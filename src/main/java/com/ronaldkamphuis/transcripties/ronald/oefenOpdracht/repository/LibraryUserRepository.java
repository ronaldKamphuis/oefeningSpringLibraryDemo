package com.ronaldkamphuis.transcripties.ronald.oefenOpdracht.repository;

import com.ronaldkamphuis.transcripties.ronald.oefenOpdracht.model.LibraryUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LibraryUserRepository extends JpaRepository<LibraryUser, Integer> {
    Optional<LibraryUser> findByUsername(String username);
}
