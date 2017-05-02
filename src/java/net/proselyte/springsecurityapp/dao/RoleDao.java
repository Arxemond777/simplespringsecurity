package net.proselyte.springsecurityapp.dao;

import net.proselyte.springsecurityapp.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author arxemond777
 * @version 1.0
 */
public interface RoleDao extends JpaRepository<Role, Long>
{
}
