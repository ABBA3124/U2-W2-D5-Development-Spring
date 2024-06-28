package davideabbadessa.U2_W2_D5_Development_Spring.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

public record DipendenteDTO(
        @NotEmpty(message = "Username è richiesto!")
        String username,

        @NotEmpty(message = "Nome è richiesto!")
        String nome,

        @NotEmpty(message = "Cognome è richiesto!")
        String cognome,

        @Email(message = "Email non è valida!")
        @NotEmpty(message = "Email è richiesta!")
        String email
) {
}
