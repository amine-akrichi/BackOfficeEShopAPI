package org.example.backofficeeshop.controller;


import org.example.backofficeeshop.model.Produit;
import org.example.backofficeeshop.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/produit")
public class ProduitController {

    @Autowired
    private ProduitService produitService;


    @PostMapping(value = "/save")
    private long saveproduct(@RequestBody Produit produits) {
        produitService.save(produits);
        return produits.getCodeProduit();
    }


    @GetMapping(value = "/getAll")
    private Iterable<Produit> getProduits() {
        return produitService.listAll();
    }

    @PutMapping(value = "/edit/{id}")
    private Produit update(@RequestBody Produit produit,@PathVariable(name="id")Long id) {
        produit.setCodeProduit(id);
        produitService.save(produit);
        return produit;
    }

    @DeleteMapping("/delete/{id}")
    private void deleteProduit(@PathVariable("id")long id){
        produitService.deleteproduit(id);

    }

    @RequestMapping("/produit/{id}")
    private Produit getProduit(@PathVariable(name="id")long produit_id){
        return produitService.getProduitByID(produit_id);

    }
}
