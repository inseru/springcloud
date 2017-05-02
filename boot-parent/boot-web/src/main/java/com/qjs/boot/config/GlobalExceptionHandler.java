package com.qjs.boot.config;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qjs.boot.dto.Response;

@ControllerAdvice
public class GlobalExceptionHandler {
	private Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	@ResponseBody
	public Response<Map> jsonErrorHandler(HttpServletRequest req, MethodArgumentNotValidException e) throws Exception {
		BindingResult result = e.getBindingResult();
		Map<String, String> map = new HashMap<String, String>();
		if (result.hasErrors()) {
			List<FieldError> errorList = result.getFieldErrors();
			for (FieldError f : errorList) {
				log.debug("er_" + f.getField() + ":" + f.getDefaultMessage());
				map.put(f.getField(), f.getDefaultMessage());
			}
		}
		Response<Map> r = new Response<Map>(200, map, "");
		return r;
	}
}
