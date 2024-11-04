package eccomerce.tp.exceptions;

public class CartNotFoundException extends RuntimeException{

    public CartNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
