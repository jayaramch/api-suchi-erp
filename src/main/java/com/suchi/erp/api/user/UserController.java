package com.suchi.erp.api.user;

import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.suchi.erp.api.common.CommonConstants;
import com.suchi.erp.api.common.CommonUtils;
import com.suchi.erp.api.security.JwtUtil;

@RestController
public class UserController {

	@Value("${jwt.header}")
	private String tokenHeader;

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserRoleRepository userRoleRepository;

	@Autowired
	private RoleMenusRepository roleMenusRepository;

	@GetMapping("/menus")
	public ResponseEntity<?> menus(HttpServletRequest request) throws Exception {
		try {

			String authToken = request.getHeader(tokenHeader);

			String userName = jwtUtil.getUsername(authToken);

			User user = userRepository.findByUserName(userName);

			List<UserRole> userRoles = userRoleRepository.findByUser(user);

			List<RoleResponse> roleResponses = userRoles.parallelStream().map((UserRole userRole) -> {
				List<RoleMenus> roleMenus = roleMenusRepository.findByRole(userRole.getRole());
				RoleResponse roleResponse = new RoleResponse();
				roleResponse.setRoleId(userRole.getRole().getRoleId());
				roleResponse.setRoleName(userRole.getRole().getRoleName());
				roleResponse.setMenus(roleMenus.parallelStream().map(RoleMenus::getMenus).collect(Collectors.toList()));

				return roleResponse;
			}).collect(Collectors.toList());

			return new ResponseEntity<>(
					CommonUtils.getHttpStatusResponse(CommonConstants.SUCCESS, HttpStatus.OK, roleResponses, null),
					HttpStatus.OK);
		} catch (Exception ex) {

			return new ResponseEntity<>(CommonUtils.getHttpStatusResponse(HttpStatus.BAD_REQUEST.getReasonPhrase(),
					HttpStatus.BAD_REQUEST, ex.getMessage(), String.valueOf(HttpStatus.BAD_REQUEST.value())),
					HttpStatus.BAD_REQUEST);
		}

	}
}
