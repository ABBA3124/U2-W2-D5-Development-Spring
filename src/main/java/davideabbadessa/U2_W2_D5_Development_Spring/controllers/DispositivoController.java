package davideabbadessa.U2_W2_D5_Development_Spring.controllers;

import davideabbadessa.U2_W2_D5_Development_Spring.entities.Dispositivi;
import davideabbadessa.U2_W2_D5_Development_Spring.services.DispositivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/dispositivi")
public class DispositivoController {

    @Autowired
    private DispositivoService dispositivoService;

    @GetMapping
    public List<Dispositivi> getAllDispositivi() {
        return dispositivoService.getAllDispositivi();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dispositivi> getDispositivoById(@PathVariable UUID id) {
        Optional<Dispositivi> dispositivo = dispositivoService.getDispositivoById(id);
        return dispositivo.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Dispositivi createDispositivo(@RequestBody Dispositivi dispositivo) {
        return dispositivoService.saveDispositivo(dispositivo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Dispositivi> updateDispositivo(@PathVariable UUID id, @RequestBody Dispositivi dispositivoUpdate) {
        return dispositivoService.updateDispositivo(id, dispositivoUpdate);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDispositivo(@PathVariable UUID id) {
        dispositivoService.deleteDispositivo(id);
        return ResponseEntity.noContent().build();
    }
}
