package com.suchi.erp.api.common;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Error implements Serializable {

	private static final long serialVersionUID = 1L;

	private transient Object detailMessage;

	private String errorCode;

	private String message;

	private String moreInfo;
	private String field;

}