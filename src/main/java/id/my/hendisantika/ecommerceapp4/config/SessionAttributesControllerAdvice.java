package id.my.hendisantika.ecommerceapp4.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * Created by IntelliJ IDEA.
 * Project : ecommerce-app4
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 21/09/25
 * Time: 07.30
 * To change this template use File | Settings | File Templates.
 */
@ControllerAdvice
public class SessionAttributesControllerAdvice {

    @ModelAttribute
    public void addSessionAttributes(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            Object status = session.getAttribute("status");
            if (status != null) {
                // Add status to request attributes for Thymeleaf access
                request.setAttribute("sessionStatus", status);
                // Remove status from session after adding to request
                session.removeAttribute("status");
            }
        }
    }
}