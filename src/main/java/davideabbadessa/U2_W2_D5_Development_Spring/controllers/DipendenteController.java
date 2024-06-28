package davideabbadessa.U2_W2_D5_Development_Spring.controllers;


import davideabbadessa.U2_W2_D5_Development_Spring.entities.Dipendente;
import davideabbadessa.U2_W2_D5_Development_Spring.services.DipendenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/dipendenti")
public class DipendenteController {

    @Autowired
    private DipendenteService dipendenteService;

    @GetMapping
    public List<Dipendente> getAllDipendenti() {
        return dipendenteService.getAllDipendenti();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dipendente> getDipendenteById(@PathVariable UUID id) {
        Optional<Dipendente> dipendente = dipendenteService.getDipendenteById(id);
        return dipendente.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Dipendente createDipendente(@RequestBody Dipendente dipendente) {
        return dipendenteService.saveDipendente(dipendente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Dipendente> updateDipendente(@PathVariable UUID id, @RequestBody Dipendente dipendenteUpdate) {
        return dipendenteService.updateDipendente(id, dipendenteUpdate);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDipendente(@PathVariable UUID id) {
        dipendenteService.deleteDipendente(id);
        return ResponseEntity.noContent().build();
    }
}


