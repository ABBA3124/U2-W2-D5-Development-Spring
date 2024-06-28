package davideabbadessa.U2_W2_D5_Development_Spring.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.UUID;

@Entity
@Data
@ToString
@NoArgsConstructor
public class Dipendente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;


    @NotEmpty(message = "Username è richiesto!")
    private String username;

    @NotEmpty(message = "Nome è richiesto!")
    private String nome;

    @NotEmpty(message = "Cognome è richiesto!")
    private String cognome;

    @Email(message = "Email non è valida!")
    @NotEmpty(message = "Email è richiesta!")
    private String email;


}
