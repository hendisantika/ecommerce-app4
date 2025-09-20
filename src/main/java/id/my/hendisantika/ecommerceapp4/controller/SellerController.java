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
import java.util.UUID;

/**
 * Created by IntelliJ IDEA.
 * Project : ecommerce-app4
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 21/09/25
 * Time: 06.42
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/seller")
@RequiredArgsConstructor
public class SellerController {
    static String usingRandomUUID() {
        UUID randomUUID = UUID.randomUUID();
        return randomUUID.toString().replaceAll("_", "");
    }

    private final ProductRepository productRepo;

    private final CategoryRepository categoryRepo;

    private final UserRepository userRepo;

    @GetMapping(value = {"/home", "/"})
    public String sellerHome(Model m, Principal principal) {
        User user = this.userRepo.loadUserByUserName(principal.getName());
        List<Product> sellerProducts = this.productRepo.getSellerAllProducts(user.getId());

        List<Category> categories = this.categoryRepo.getCategories();

        m.addAttribute("title", "Seller Panel | StoreWala");
        m.addAttribute("product", new Product());
        m.addAttribute("categories", categories);
        m.addAttribute("user", user);
        m.addAttribute("products", sellerProducts);
        return "seller/index";
    }
}
