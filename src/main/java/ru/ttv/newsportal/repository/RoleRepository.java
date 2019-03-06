package ru.ttv.newsportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ttv.newsportal.model.Role;

public interface RoleRepository extends JpaRepository<Role,Long> {

    Role findByName(String name);

}
