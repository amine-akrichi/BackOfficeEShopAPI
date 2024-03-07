package org.example.backofficeeshop.controller;

import org.example.backofficeeshop.model.Marque;
import org.example.backofficeeshop.model.Produit;
import org.example.backofficeeshop.service.MarqueService;
import org.example.backofficeeshop.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/marque")
public class MarqueControlleur {
    @Autowired
    private MarqueService marqueService;





    @PostMapping(value = "/save")
    private long savemarque(@RequestBody Marque marque) {
        marqueService.save(marque);
        return marque.getCodeMarque();
    }


    @GetMapping(value = "/getAll")
    private Iterable<Marque> getMarques() {
        return marqueService.listAll();
    }

    @PutMapping(value = "/edit/{id}")
    private Marque update(@RequestBody Marque marque,@PathVariable(name="id")Long id) {
        marque.setCodeMarque(id);
       marqueService.save(marque);
        return marque;
    }

    @DeleteMapping("/delete/{id}")
    private void deleteMarque(@PathVariable("id")long id){
       marqueService.deleteMarque(id);

    }

    @RequestMapping("/{id}")
    private Marque getMarque(@PathVariable(name="id")long marque_id){
        return marqueService.getMarqueByID(marque_id);

    }


}
