package com.suchi.erp.api.user;

import com.suchi.erp.api.common.CommonConstants;
import com.suchi.erp.api.common.CommonUtils;
import com.suchi.erp.api.security.JwtUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticateController {

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private AuthenticationManager authenticationManager;

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody AuthRequest authRequest) throws Exception {
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword()));
		} catch (Exception ex) {

			return new ResponseEntity<>(
					CommonUtils.getHttpStatusResponse(HttpStatus.BAD_REQUEST.getReasonPhrase(), HttpStatus.BAD_REQUEST,
							"inavalid username/password", String.valueOf(HttpStatus.BAD_REQUEST.value())),
					HttpStatus.BAD_REQUEST);
		}

		String token = jwtUtil.generateToken(authRequest.getUserName());
		AuthenticateResponse response = new AuthenticateResponse();
		response.setToken(token);
		return new ResponseEntity<>(
				CommonUtils.getHttpStatusResponse(CommonConstants.SUCCESS, HttpStatus.OK, response, null),
				HttpStatus.OK);
	}
}
