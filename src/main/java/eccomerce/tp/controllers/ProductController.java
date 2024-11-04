package eccomerce.tp.controllers;

import eccomerce.tp.entities.Product;
import eccomerce.tp.services.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService productService;

    @PostMapping("/products")
    public Product newProduct(@RequestBody Product product) {

        logger.info("Creando producto nuevo:" + productService.saveProduct(product));
        return productService.saveProduct(product);

    }

    @GetMapping("/products")
    public List<Product> getAllProducts(){

        return productService.getAllProducts();
    }

    @GetMapping("/products/{productId}")
    public Product getProductById(@PathVariable(name = "productId")Long productId) {
        return productService.getProductById(productId);

    }

    @DeleteMapping("/products/{productId}")

    public void deleteProductById(@PathVariable(name = "productId")Long productId){
        productService.getProductById(productId);
        productService.deleteById(productId);

    }

    @PutMapping("/products/{productId}")
    public Product putProductById(@PathVariable(name =  "productId") Long productId, @RequestBody Product updateProduct) {
        Product currentProduct = productService.getProductById(productId);
        currentProduct.setName(updateProduct.getName());
        currentProduct.setDescription(updateProduct.getDescription());
        currentProduct.setPrice(updateProduct.getPrice());
        currentProduct.setImage(updateProduct.getImage());
        return productService.saveProduct(currentProduct);
    }



}
