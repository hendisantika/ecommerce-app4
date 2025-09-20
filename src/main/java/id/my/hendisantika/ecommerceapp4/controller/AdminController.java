package id.my.hendisantika.ecommerceapp4.controller;

import id.my.hendisantika.ecommerceapp4.entity.Category;
import id.my.hendisantika.ecommerceapp4.entity.Product;
import id.my.hendisantika.ecommerceapp4.entity.User;
import id.my.hendisantika.ecommerceapp4.repository.CategoryRepository;
import id.my.hendisantika.ecommerceapp4.repository.ProductRepository;
import id.my.hendisantika.ecommerceapp4.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : ecommerce-app4
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 21/09/25
 * Time: 06.28
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    private final UserRepository userRepo;

    private final ProductRepository productRepo;

    private final CategoryRepository categoryRepo;

    @GetMapping(value = {"/", "/home"})
    public String home(Model m, Principal principal) {
        User user = this.userRepo.loadUserByUserName(principal.getName());

        List<User> users = this.userRepo.getUsers();
        List<Category> categories = this.categoryRepo.getCategories();
        List<Product> products = this.productRepo.getProducts();

        m.addAttribute("title", "Admin | StoreWala");
        m.addAttribute("user", user);
        m.addAttribute("users", users);
        m.addAttribute("products", products);
        m.addAttribute("categories", categories);
        m.addAttribute("category", new Category());

        return "admin/index";
    }
}
