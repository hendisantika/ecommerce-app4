package id.my.hendisantika.ecommerceapp4.repository;

import id.my.hendisantika.ecommerceapp4.entity.UnbanRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
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
 * Time: 06.23
 * To change this template use File | Settings | File Templates.
 */
@Repository
public interface UnbanRequestRepository extends JpaRepository<UnbanRequest, Integer> {

    @Query(value = "SELECT * FROM unban_requests", nativeQuery = true)
    List<UnbanRequest> getAllRequest();
}
