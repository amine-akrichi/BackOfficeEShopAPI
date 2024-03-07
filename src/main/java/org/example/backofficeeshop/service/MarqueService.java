package org.example.backofficeeshop.service;


import org.example.backofficeeshop.model.Marque;
import org.example.backofficeeshop.model.Produit;
import org.example.backofficeeshop.repository.MarqueRepository;
import org.example.backofficeeshop.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MarqueService {

    @Autowired
    private MarqueRepository marquerepos;

    public void save(Marque marque) {
        marquerepos.save(marque);
    }

    public Iterable<Marque> listAll() {
        return this.marquerepos.findAll();
    }

    public void deleteMarque(long id) {
        marquerepos.deleteById(id);
    }

    public Marque getMarqueByID(long marqueId) {
        return this.marquerepos.findById(marqueId).get();
    }
}
