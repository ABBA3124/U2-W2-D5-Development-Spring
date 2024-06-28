package davideabbadessa.U2_W2_D5_Development_Spring.controllers;


import davideabbadessa.U2_W2_D5_Development_Spring.entities.Dipendente;
import davideabbadessa.U2_W2_D5_Development_Spring.payloads.DipendenteDTO;
import davideabbadessa.U2_W2_D5_Development_Spring.services.DipendenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/dipendente")
public class DipendenteController {

    @Autowired
    private DipendenteService dipendenteService;

    @GetMapping
    public List<Dipendente> getAllDipendenti() {
        return dipendenteService.getAllDipendenti();
    }

    @GetMapping("/{id}")
    public Dipendente getDipendenteById(@PathVariable UUID id) {
        return dipendenteService.getDipendenteById(id);
    }

    @PostMapping
    public Dipendente createDipendente(@Validated @RequestBody DipendenteDTO dipendenteDTO) {
        return dipendenteService.saveDipendente(dipendenteDTO);
    }

    @PutMapping("/{id}")
    public Dipendente updateDipendente(@PathVariable UUID id, @Validated @RequestBody DipendenteDTO dipendenteDTO) {
        return dipendenteService.updateDipendente(id, dipendenteDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDipendente(@PathVariable UUID id) {
        dipendenteService.deleteDipendente(id);
        return ResponseEntity.noContent().build();
    }
}


