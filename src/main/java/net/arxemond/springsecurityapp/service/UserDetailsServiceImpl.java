package net.arxemond.springsecurityapp.service;

import net.arxemond.springsecurityapp.dao.UserDao;
import net.arxemond.springsecurityapp.model.Role;
import net.arxemond.springsecurityapp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

/**
 * Implementation of {@link org.springframework.security.core.userdetails.UserDetailsService} interface.
 *
 * @author arxemond777
 * @version 1.0
 */

public class UserDetailsServiceImpl implements UserDetailsService
{
    @Autowired
    private UserDao userDao;

    @Override
    @Transactional(readOnly = true) // import org.springframework.transaction.annotation.Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.findByUsername(username); // Которого ищем

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();

        /**
         * Добавляем пользователю все разрешения, которые хранятся у него в БД
         */
        for (Role role: user.getRoles()) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
        }

        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                grantedAuthorities // Все его роли, соответственно
        );
    }
}
