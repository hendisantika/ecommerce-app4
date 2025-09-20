package id.my.hendisantika.ecommerceapp4.controller;

import id.my.hendisantika.ecommerceapp4.repository.CategoryRepository;
import id.my.hendisantika.ecommerceapp4.repository.ProductRepository;
import id.my.hendisantika.ecommerceapp4.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
