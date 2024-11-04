package eccomerce.tp.exceptions;

public class ProductNotFoundException extends RuntimeException{

    public ProductNotFoundException(String errorMessage){
        super(errorMessage);
    }

}
