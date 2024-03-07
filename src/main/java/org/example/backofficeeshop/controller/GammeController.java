package org.example.backofficeeshop.controller;


import org.example.backofficeeshop.model.Gamme;
import org.example.backofficeeshop.model.Marque;
import org.example.backofficeeshop.service.GammeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/gamme")
public class GammeController {

    @Autowired
    private GammeService gammeService;

    @PostMapping(value = "/save")
    private long savegamme(@RequestBody Gamme gamme) {
        gammeService.save(gamme);
        return gamme.getCodeGamme();
    }


    @GetMapping(value = "/getAll")
    private Iterable<Gamme> getGammes() {
        return gammeService.listAll();
    }

    @PutMapping(value = "/edit/{id}")
    private Gamme update(@RequestBody Gamme gamme,@PathVariable(name="id")Long id) {
       gamme.setCodeGamme(id);
       gammeService.save(gamme);
        return gamme;
    }

    @DeleteMapping("/delete/{id}")
    private void deleteGamme(@PathVariable("id")long id){
        gammeService.deleteGamme(id);

    }

    @RequestMapping("/{id}")
    private Gamme getGamme(@PathVariable(name="id")long gamme_id){
        return gammeService.getGammeByID(gamme_id);

    }



}
