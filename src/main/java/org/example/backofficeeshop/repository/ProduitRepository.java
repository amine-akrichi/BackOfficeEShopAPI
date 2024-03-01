package org.example.backofficeeshop.repository;

import org.example.backofficeeshop.model.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduitRepository extends JpaRepository<Produit, Long> {
}
