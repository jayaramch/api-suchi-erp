package com.suchi.erp.api.user;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleMenusRepository extends JpaRepository<RoleMenus, Integer> {

	List<RoleMenus> findByRole(Role role);
}
