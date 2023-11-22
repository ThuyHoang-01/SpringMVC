package vn.edu.iuh.fit.frontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import vn.edu.iuh.fit.backend.models.Order;
import vn.edu.iuh.fit.backend.models.Product;
import vn.edu.iuh.fit.backend.services.EmployeeService;
import vn.edu.iuh.fit.backend.services.OrderService;
import vn.edu.iuh.fit.backend.services.ProductService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Controller
public class OrderController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private OrderService orderService;

    @GetMapping("/order")
    public String getProduct(Model model) {
        List<Order> order =  orderService.getAllOrder();
        model.addAttribute("orders", order);
        return "order/list-order";
    }

    @GetMapping("/order/add")
    public String formProduct(Model model) {
            Order order = new Order();
            order.setOrderDate(java.time.LocalDateTime.now());
            order.setEmployee(employeeService.getAllEmployee().get(0));
            orderService.saveOrder(order);
//        model.addAttribute("ord", new Order());
//        return "order/add-order";

        return "redirect:/order";
    }

    @GetMapping("/order/update/{id}")
    public String formUpdateProduct(Model model, @PathVariable("id") long id) {
        Optional<Order> order = orderService.findOrderById(id);
        model.addAttribute("ord", order.get());
        return "order/add-order";
    }

    @PostMapping("/order/save")
    public String saveProduct(@ModelAttribute("order") Order order) {
        orderService.saveOrder(order);
        return "redirect:/order";
    }

    @GetMapping("/order/delete/{id}")
    public String saveProduct(@PathVariable("id") long id) {
        orderService.deleteOrder(id);
        return "redirect:/order";
    }

    @GetMapping("/order/report")
    public String reportProduct(Model model) {
        List<Order> order =  orderService.findOrderByDate(LocalDateTime.now().minusDays(7), LocalDateTime.now());
        model.addAttribute("orders", order);
        model.addAttribute("dateS", LocalDateTime.now().minusDays(7));
        model.addAttribute("dateE", LocalDateTime.now());
        return "order/report-order";
    }
}
