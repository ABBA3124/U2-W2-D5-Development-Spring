package davideabbadessa.U2_W2_D5_Development_Spring.controllers;

import davideabbadessa.U2_W2_D5_Development_Spring.entities.Dispositivi;
import davideabbadessa.U2_W2_D5_Development_Spring.payloads.DispositivoDTO;
import davideabbadessa.U2_W2_D5_Development_Spring.services.DispositivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/dispositivo")
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
    public Dispositivi createDispositivo(@Validated @RequestBody DispositivoDTO dispositivoDTO) {
        return dispositivoService.saveDispositivo(dispositivoDTO);
    }

    @PutMapping("/{id}")
    public Dispositivi updateDispositivo(@PathVariable UUID id, @Validated @RequestBody DispositivoDTO dispositivoDTO) {
        return dispositivoService.updateDispositivo(id, dispositivoDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDispositivo(@PathVariable UUID id) {
        dispositivoService.deleteDispositivo(id);
        return ResponseEntity.noContent().build();
    }
}
