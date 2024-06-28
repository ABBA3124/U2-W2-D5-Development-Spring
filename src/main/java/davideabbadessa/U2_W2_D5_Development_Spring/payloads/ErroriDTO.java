package davideabbadessa.U2_W2_D5_Development_Spring.payloads;


import java.time.LocalDateTime;

public record ErroriDTO(String message, LocalDateTime time) {
}
