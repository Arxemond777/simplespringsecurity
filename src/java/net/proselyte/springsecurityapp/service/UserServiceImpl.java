package net.proselyte.springsecurityapp.service;

import net.proselyte.springsecurityapp.dao.*;
import net.proselyte.springsecurityapp.model.Role;
import net.proselyte.springsecurityapp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.*;

/**
 * Implementation of {@link UserService} interface.
 *
 * @author arxemond777
 * @version 1.0
 */

@Service // Класс сервисов
public class UserServiceImpl implements UserService
{
    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(User user) {
        // Производим установку доп методов перед сохранением
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword())); // Кодируем в bCrypt

        Set<Role> roles = new HashSet<>();
        roles.add(roleDao.getOne(1L)); // Роль по умолчанию id = 1, т.е. роль по умолчанию Role_user (id = 1)
        user.setRoles(roles);

        userDao.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }
}
