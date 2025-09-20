package id.my.hendisantika.ecommerceapp4.repository;

import id.my.hendisantika.ecommerceapp4.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

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
public interface CommentRepository extends JpaRepository<Comment, Integer> {

    @Query(value = "SELECT * FROM comments WHERE comment_related_to = ?", nativeQuery = true)
    List<Comment> getAllComments(@Param("id") Integer id);
}
