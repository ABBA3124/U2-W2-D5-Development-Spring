package davideabbadessa.U2_W2_D5_Development_Spring.exceptions;


import java.util.UUID;


public class NotFoundException extends RuntimeException {
    public NotFoundException(UUID id) {
        super("ID: --> " + id + " non trovato!");
    }


}
