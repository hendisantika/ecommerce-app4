package id.my.hendisantika.ecommerceapp4.repository;

import id.my.hendisantika.ecommerceapp4.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : ecommerce-app4
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 21/09/25
 * Time: 06.22
 * To change this template use File | Settings | File Templates.
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query(value = "SELECT * FROM products", nativeQuery = true)
    List<Product> getProducts();

    @Query(value = "SELECT * FROM products WHERE product_seller_id = ?", nativeQuery = true)
    List<Product> getSellerAllProducts(@Param("id") int id);
}
