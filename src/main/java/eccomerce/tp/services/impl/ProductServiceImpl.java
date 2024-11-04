package eccomerce.tp.services.impl;

import eccomerce.tp.entities.Product;
import eccomerce.tp.exceptions.ProductNotFoundException;
import eccomerce.tp.repositories.ProductRepository;
import eccomerce.tp.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElseThrow(()-> new ProductNotFoundException("Producto no encontrado"));
    }

    @Override
    public void deleteById(Long productId) {
        productRepository.deleteById(productId);

    }


}
