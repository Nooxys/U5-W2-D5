package CiroVitiello.U5W2D5.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(long id) {
        super("element with " + id + " not found");
    }
}