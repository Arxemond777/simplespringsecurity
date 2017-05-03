package net.proselyte.springsecurityapp.dao;

import net.proselyte.springsecurityapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author arxemond777
 * @version 1.0
 */

public interface UserDao extends JpaRepository<User, Long>
{
    User findByUsername(String username);

    List<User> findAll();
}
