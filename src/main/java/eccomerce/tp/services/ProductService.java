package eccomerce.tp.services;


import eccomerce.tp.entities.Product;

import java.util.List;

public interface ProductService {

    Product saveProduct(Product product);

    List<Product> getAllProducts();

    Product getProductById(Long id);

    void deleteById(Long productId);

}
