package com.suchi.erp.api.user;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<UserRole, Integer> {

	List<UserRole> findByUser(User user);
}
