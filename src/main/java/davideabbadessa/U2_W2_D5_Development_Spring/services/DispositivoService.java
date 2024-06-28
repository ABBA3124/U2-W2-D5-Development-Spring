package davideabbadessa.U2_W2_D5_Development_Spring.services;


import davideabbadessa.U2_W2_D5_Development_Spring.entities.Dispositivi;
import davideabbadessa.U2_W2_D5_Development_Spring.repositories.DispositivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DispositivoService {

    @Autowired
    private DispositivoRepository dispositivoRepository;

    public List<Dispositivi> getAllDispositivi() {
        return dispositivoRepository.findAll();
    }

    public Optional<Dispositivi> getDispositivoById(UUID id) {
        return dispositivoRepository.findById(id);
    }

    public Dispositivi saveDispositivo(Dispositivi dispositivo) {
        return dispositivoRepository.save(dispositivo);
    }


    public ResponseEntity<Dispositivi> updateDispositivo(UUID id, Dispositivi dispositivoDetails) {
        Optional<Dispositivi> dispositivoOptional = this.getDispositivoById(id);
        if (dispositivoOptional.isPresent()) {
            Dispositivi dispositivo = dispositivoOptional.get();
            dispositivo.setTipo(dispositivoDetails.getTipo());
            dispositivo.setStato(dispositivoDetails.getStato());
            return ResponseEntity.ok(this.saveDispositivo(dispositivo));
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    public void deleteDispositivo(UUID id) {
        dispositivoRepository.deleteById(id);
    }
}
