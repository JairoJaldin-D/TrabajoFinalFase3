package eccomerce.tp.exceptions;

public class CategoryNotFoundException extends RuntimeException {

    public CategoryNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
