package com.suchi.erp.api.user;

import java.util.List;

import lombok.Data;

@Data
public class RoleResponse {

	private int roleId;
	private String roleName;
	private List<Menus> menus;
	
	
	
}
