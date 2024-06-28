package davideabbadessa.U2_W2_D5_Development_Spring.payloads;

import davideabbadessa.U2_W2_D5_Development_Spring.enums.StatoDispositivo;
import davideabbadessa.U2_W2_D5_Development_Spring.enums.TipoDispositivo;
import jakarta.validation.constraints.NotEmpty;

import java.util.UUID;

public record DispositivoDTO(

        @NotEmpty(message = "Tipo dispositivo è richiesto!")
        TipoDispositivo tipo,

        @NotEmpty(message = "Stato dispositivo è richiesto!")
        StatoDispositivo stato,

        UUID dipendenteId
) {
}
