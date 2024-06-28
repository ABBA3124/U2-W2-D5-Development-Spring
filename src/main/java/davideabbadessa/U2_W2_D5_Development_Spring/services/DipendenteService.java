package davideabbadessa.U2_W2_D5_Development_Spring.services;


import davideabbadessa.U2_W2_D5_Development_Spring.entities.Dipendente;
import davideabbadessa.U2_W2_D5_Development_Spring.exceptions.NotFoundException;
import davideabbadessa.U2_W2_D5_Development_Spring.payloads.DipendenteDTO;
import davideabbadessa.U2_W2_D5_Development_Spring.repositories.DipendenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DipendenteService {

    @Autowired
    private DipendenteRepository dipendenteRepository;

    public List<Dipendente> getAllDipendenti() {
        return dipendenteRepository.findAll();
    }


    public Dipendente getDipendenteById(UUID id) {
        return dipendenteRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
    }


    public Dipendente saveDipendente(DipendenteDTO dipendenteDTO) {
        Dipendente dipendente = new Dipendente();
        dipendente.setUsername(dipendenteDTO.username());
        dipendente.setNome(dipendenteDTO.nome());
        dipendente.setCognome(dipendenteDTO.cognome());
        dipendente.setEmail(dipendenteDTO.email());
        dipendente.setAvatar("https://ui-avatars.com/api/?name=" + dipendente.getNome() + "+" + dipendente.getCognome());
        return dipendenteRepository.save(dipendente);
    }


    public void deleteDipendente(UUID id) {
        dipendenteRepository.deleteById(id);
    }


    public Dipendente updateDipendente(UUID id, DipendenteDTO dipendenteDTO) {
        Dipendente dipendente = this.getDipendenteById(id);
        dipendente.setUsername(dipendenteDTO.username());
        dipendente.setNome(dipendenteDTO.nome());
        dipendente.setCognome(dipendenteDTO.cognome());
        dipendente.setEmail(dipendenteDTO.email());
        return dipendenteRepository.save(dipendente);
    }

}
