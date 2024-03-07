package org.example.backofficeeshop.service;


import org.example.backofficeeshop.model.Gamme;
import org.example.backofficeeshop.repository.GammeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GammeService {

    @Autowired
    private GammeRepository gammeRepository;


    public void save(Gamme gamme) {
        gammeRepository.save(gamme);
    }


    public List<Gamme> listAll() {
        return this.gammeRepository.findAll();
    }


    public void deleteGamme(long id) {
       gammeRepository.deleteById(id);
    }

    public Gamme getGammeByID(long gammeId) {
        return this.gammeRepository.findById(gammeId).get();
    }
}
