package com.ronaldkamphuis.transcripties.ronald.oefenOpdracht.repository;

import com.ronaldkamphuis.transcripties.ronald.oefenOpdracht.model.Partij;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PartijRepository extends JpaRepository<Partij, Integer> {
    Optional<Partij> findByTitel(String titel);
}
