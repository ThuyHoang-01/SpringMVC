package vn.edu.iuh.fit.backend.services;

import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.backend.models.Employee;
import vn.edu.iuh.fit.backend.models.Product;

import java.util.List;
import java.util.Optional;

@Service
public interface ProductService {
    public List<Product> getAllProduct();

    public Product saveProduct(Product product);

    public Optional<Product> findProductById(Long id);

    public void deleteProduct(Long id);
}
