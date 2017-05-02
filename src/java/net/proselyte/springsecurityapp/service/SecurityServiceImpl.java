package net.proselyte.springsecurityapp.service;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;

/**
 * Implementation {@link SecurityService} implementation.
 *
 * @author arxemond777 <1arxemond1@gmail.com>
 * @version 1.0
 */

@Service
public class SecurityServiceImpl implements SecurityService
{
    private static final Logger logger = LoggerFactory.getLogger(SecurityServiceImpl.class);// Добавим щипоточку логгирования ;)

    @Autowired
    private AuthenticationManager authenticationManager; // менеджер Аутентификации

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    public String findLoggedInUsername() {
        Object userDeatil = // Содержит инфу по пользователю
                SecurityContextHolder
                    .getContext()
                    .getAuthentication() // Получаем Аунтетификацию
                    .getDetails(); // и детали нашей аунтетификации для данного юзвера

        if (userDeatil instanceof UserDetails) { // Получаем имя залогиненного юзвера
            return ((UserDetails) userDeatil).getUsername();
        }

        return null;
    }

    @Override
    public void autoLogin(String username, String password) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);

        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities());

        authenticationManager.authenticate(authenticationToken); // Авторизуем

        if (authenticationToken.isAuthenticated()) { // Если удалось авторизовать
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);

            logger.debug(String.format("Successfully %s auto logged in.", username));
        }
    }
}
