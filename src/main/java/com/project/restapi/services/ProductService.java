package com.project.restapi.services;

import com.project.restapi.entities.Product;
import com.project.restapi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public Product saveProduct(Product product) {
        return repository.save(product);
    }

    public java.util.List<Product> saveProducts(List<Product> products) {
        return repository.save(products);
    }

    public  List<Product> getProducts(){
        return repository.findAll();
    }

    public Product getProductById(Integer id) {
        return repository.getOne(id);
    }

    public Product updateProduct(Product product) {
        Product current = repository.getOne(product.getId());
        current.setName(product.getName());
        current.setPrice(product.getPrice());
        current.setQuantity(product.getQuantity());
        return repository.save(current);
    }

    public void deleteProduct(Integer id) {
        repository.delete(id);
    }

}
