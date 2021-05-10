package com.suchi.erp.api.common;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReturnResponse<T> implements Serializable {

	private static final long serialVersionUID = 1L;

	private T data;

	private Error error;

	private String requestId;
	private String statusCode;
	private String statusText;
	private String statusMessage;

}
