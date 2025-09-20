package id.my.hendisantika.ecommerceapp4.controller;

import id.my.hendisantika.ecommerceapp4.entity.Category;
import id.my.hendisantika.ecommerceapp4.entity.Product;
import id.my.hendisantika.ecommerceapp4.repository.CategoryRepository;
import id.my.hendisantika.ecommerceapp4.repository.CommentRepository;
import id.my.hendisantika.ecommerceapp4.repository.ProductRepository;
import id.my.hendisantika.ecommerceapp4.repository.UnbanRequestRepository;
import id.my.hendisantika.ecommerceapp4.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
 * Time: 06.31
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequiredArgsConstructor
public class MainController {

    private final UserRepository userRepo;

    private final CategoryRepository categoryRepo;

    private final ProductRepository productRepo;

    private final UnbanRequestRepository unbanRequestRepo;

    private final CommentRepository commentRepo;

    private final BCryptPasswordEncoder passwordEncoder;

    /* ==================== */
    // home page view.

    @GetMapping(value = {"/", "/home"})
    public String firstHomeView(Model m, Principal principal) {
        if (principal != null) {
            m.addAttribute("user", this.userRepo.loadUserByUserName(principal.getName()));
        }

        List<Product> products = this.productRepo.getProducts();
        List<Category> categories = this.categoryRepo.getCategories();

        m.addAttribute("title", "StoreWala | Start Shopping Now!");
        m.addAttribute("categories", categories);
        m.addAttribute("products", products);
        return "index.html";
    }
}
