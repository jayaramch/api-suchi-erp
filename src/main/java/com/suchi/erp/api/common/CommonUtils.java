package com.suchi.erp.api.common;

import org.slf4j.MDC;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;

public class CommonUtils {

	public static <T> ReturnResponse<T> getHttpStatusResponse(String message, HttpStatus status, T res,
			String errorCode) {
		ReturnResponse<T> returnResponse = new ReturnResponse<>();
		returnResponse.setStatusCode(String.valueOf(status.value()));
		returnResponse.setStatusText(status.getReasonPhrase());
		String requestId = MDC.get(CommonConstants.REQUEST_ID);
		if (StringUtils.isEmpty(requestId))
			requestId = java.util.UUID.randomUUID().toString();
		returnResponse.setRequestId(requestId);
		if (errorCode != null) {
			Error error = new Error();
			error.setErrorCode(errorCode);
			error.setMessage(message);
			error.setDetailMessage(res);
			returnResponse.setError(error);
		} else {
			returnResponse.setData(res);
			returnResponse.setStatusMessage(message);

		}
		return returnResponse;
	}

}
