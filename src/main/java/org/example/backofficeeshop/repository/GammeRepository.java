package org.example.backofficeeshop.repository;

import org.example.backofficeeshop.model.Gamme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GammeRepository extends JpaRepository<Gamme, Long> {
}
