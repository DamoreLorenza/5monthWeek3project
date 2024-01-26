package lorenza.week3project.exceptions;

import java.util.UUID;

public class NotFoundException extends RuntimeException {
    public NotFoundException(UUID uuid) {
        super("UUID " + uuid + " non trovato");
    }
    public NotFoundException(String message) {
        super(message);
    }
}