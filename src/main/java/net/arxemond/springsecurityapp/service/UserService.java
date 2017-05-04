package net.arxemond.springsecurityapp.service;

import net.arxemond.springsecurityapp.model.User;

import java.util.List;

/**
 * Service class for {@link net.arxemond.springsecurityapp.model.User}
 *
 * @author arxemond777
 * @version 1.0
 */

public interface UserService
{
    void save(User user);

    User findByUsername(String username);

    List<User> findAll();
}
