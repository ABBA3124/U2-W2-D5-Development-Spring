package davideabbadessa.U2_W2_D5_Development_Spring.services;


import davideabbadessa.U2_W2_D5_Development_Spring.entities.Dipendente;
import davideabbadessa.U2_W2_D5_Development_Spring.entities.Dispositivi;
import davideabbadessa.U2_W2_D5_Development_Spring.exceptions.NotFoundException;
import davideabbadessa.U2_W2_D5_Development_Spring.payloads.DispositivoDTO;
import davideabbadessa.U2_W2_D5_Development_Spring.repositories.DipendenteRepository;
import davideabbadessa.U2_W2_D5_Development_Spring.repositories.DispositivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DispositivoService {

    @Autowired
    private DipendenteService dipendenteService;

    @Autowired
    private DispositivoRepository dispositivoRepository;

    @Autowired
    private DipendenteRepository dipendenteRepository;


    public List<Dispositivi> getAllDispositivi() {
        return dispositivoRepository.findAll();
    }

    public Optional<Dispositivi> getDispositivoById(UUID id) {
        return dispositivoRepository.findById(id);
    }

    public Dispositivi saveDispositivo(DispositivoDTO dispositivoDTO) {
        Dispositivi dispositivi = new Dispositivi();
        dispositivi.setTipo(dispositivoDTO.tipo());
        dispositivi.setStato(dispositivoDTO.stato());

        if (dispositivoDTO.dipendenteId() != null) {
            Dipendente dipendente = dipendenteRepository.findById(dispositivoDTO.dipendenteId())
                    .orElseThrow(() -> new NotFoundException(dispositivoDTO.dipendenteId()));
            dispositivi.setDipendente(dipendente);
        }

        return dispositivoRepository.save(dispositivi);
    }


    public Dispositivi updateDispositivo(UUID id, DispositivoDTO dispositivoDTO) {
        Dispositivi dispositivo = dispositivoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(id));

        dispositivo.setTipo(dispositivoDTO.tipo());
        dispositivo.setStato(dispositivoDTO.stato());

        if (dispositivoDTO.dipendenteId() != null) {
            Dipendente dipendente = dipendenteRepository.findById(dispositivoDTO.dipendenteId())
                    .orElseThrow(() -> new NotFoundException(dispositivoDTO.dipendenteId()));
            dispositivo.setDipendente(dipendente);
        } else {
            dispositivo.setDipendente(null);
        }

        return dispositivoRepository.save(dispositivo);
    }


    public void deleteDispositivo(UUID id) {
        dispositivoRepository.deleteById(id);
    }
}
