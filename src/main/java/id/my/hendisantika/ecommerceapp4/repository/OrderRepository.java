package id.my.hendisantika.ecommerceapp4.repository;

import id.my.hendisantika.ecommerceapp4.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by IntelliJ IDEA.
 * Project : ecommerce-app4
 * User: hendisantika
 * Link: s.id/hendisantika
 * Email: hendisantika@yahoo.co.id
 * Telegram : @hendisantika34
 * Date: 21/09/25
 * Time: 06.20
 * To change this template use File | Settings | File Templates.
 */
@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

    @Query(value = "SELECT * FROM orders WHERE product_id = :id", nativeQuery = true)
    Order findByProductId(@Param("id") Integer id);
}
