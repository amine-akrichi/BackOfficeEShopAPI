package org.example.backofficeeshop.service;


import org.example.backofficeeshop.model.Marque;
import org.example.backofficeeshop.model.Produit;
import org.example.backofficeeshop.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProduitService {

    @Autowired
    private ProduitRepository produitrepos;
    public void save(Produit produits) {
        produitrepos.save(produits);
    }

    public Iterable<Produit> listAll() {
        return this.produitrepos.findAll();
    }

    public void deleteproduit(long id) {
        produitrepos.deleteById(id);
    }


    public Produit getProduitByID(long produitId) {
        return produitrepos.findById(produitId).get();
    }
}
