package net.proselyte.springsecurityapp.service;

/**
 * Отвечает за безопасность приложений
 *
 * Service for Security
 *
 * @author arxemond777
 * @version 1.0
 */

public interface SecurityService
{
    String findLoggedInUsername(); // Ищем уже залогиненных

    void autoLogin(String username, String password);
}
