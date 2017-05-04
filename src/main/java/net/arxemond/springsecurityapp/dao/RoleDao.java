package net.arxemond.springsecurityapp.dao;

import net.arxemond.springsecurityapp.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author arxemond777
 * @version 1.0
 */
public interface RoleDao extends JpaRepository<Role, Long>
{
}
