package org.arshiya.fsd.cr.api.exception;

import org.arshiya.fsd.cr.api.Common;
import org.arshiya.fsd.cr.api.dto.FoodBoxError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ResponseBody
	@ExceptionHandler(FoodBoxServiceException.class)
	public ResponseEntity<FoodBoxError> handleException(FoodBoxServiceException e) {
		String code = Common.DB_ERROR_CODE;
		HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

		if (e.getCode() != null && !e.getCode().isEmpty()) {
			code = e.getCode();
			status = HttpStatus.BAD_REQUEST;
		}

		return ResponseEntity.status(status).body(new FoodBoxError(code, e.getMessage()));
	}

	@ResponseBody
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<FoodBoxError> handleException(MethodArgumentNotValidException e) {
		String defaultMessage = e.getMessage();

		for (ObjectError o : e.getBindingResult().getAllErrors()) {
			defaultMessage = o.getDefaultMessage();
			break;
		}

		return ResponseEntity.badRequest().body(new FoodBoxError(Common.SB_VALIDATION_FAIL, defaultMessage));
	}

}
