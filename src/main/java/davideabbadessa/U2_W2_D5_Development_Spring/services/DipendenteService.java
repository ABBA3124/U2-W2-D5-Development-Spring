package davideabbadessa.U2_W2_D5_Development_Spring.services;


import davideabbadessa.U2_W2_D5_Development_Spring.entities.Dipendente;
import davideabbadessa.U2_W2_D5_Development_Spring.repositories.DipendenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DipendenteService {

    @Autowired
    private DipendenteRepository dipendenteRepository;

    public List<Dipendente> getAllDipendenti() {
        return dipendenteRepository.findAll();
    }


    public Optional<Dipendente> getDipendenteById(UUID id) {
        return dipendenteRepository.findById(id);
    }

    public Dipendente saveDipendente(Dipendente dipendente) {
        return dipendenteRepository.save(dipendente);
    }

    public void deleteDipendente(UUID id) {
        dipendenteRepository.deleteById(id);
    }

    public ResponseEntity<Dipendente> updateDipendente(UUID id, Dipendente dipendenteUpdate) {
        Optional<Dipendente> dipendenteOptional = this.getDipendenteById(id);
        if (dipendenteOptional.isPresent()) {
            Dipendente dipendente = dipendenteOptional.get();
            dipendente.setUsername(dipendenteUpdate.getUsername());
            dipendente.setNome(dipendenteUpdate.getNome());
            dipendente.setCognome(dipendenteUpdate.getCognome());
            dipendente.setEmail(dipendenteUpdate.getEmail());
            return ResponseEntity.ok(this.saveDipendente(dipendente));
        } else {
            return ResponseEntity.notFound().build();
        }

    }


}
