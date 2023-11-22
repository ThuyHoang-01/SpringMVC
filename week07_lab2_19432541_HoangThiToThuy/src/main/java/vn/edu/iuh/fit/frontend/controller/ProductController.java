package vn.edu.iuh.fit.frontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import vn.edu.iuh.fit.backend.models.Employee;
import vn.edu.iuh.fit.backend.models.Product;
import vn.edu.iuh.fit.backend.services.EmployeeService;
import vn.edu.iuh.fit.backend.services.ProductService;

import java.util.List;
import java.util.Optional;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/product")
    public String getProduct(Model model) {
        List<Product> pro =  productService.getAllProduct();
        model.addAttribute("products", pro);
        return "product/list-product";
    }

    @GetMapping("/product/add")
    public String formProduct(Model model) {
        model.addAttribute("prod", new Product());
        return "product/add-product";
    }

    @GetMapping("/product/update/{id}")
    public String formUpdateProduct(Model model, @PathVariable("id") long id) {
        Optional<Product> prod = productService.findProductById(id);
        model.addAttribute("prod", prod.get());
        return "product/add-product";
    }

    @PostMapping("/product/save")
    public String saveProduct(@ModelAttribute("product") Product product) {
        productService.saveProduct(product);
        return "redirect:/product";
    }

    @GetMapping("/product/delete/{id}")
    public String saveProduct(@PathVariable("id") long id) {
        productService.deleteProduct(id);
        return "redirect:/product";
    }
}
