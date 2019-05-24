package com.stage.safezone.handler;

import com.stage.safezone.exception.ValidationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice(annotations = RestController.class)
public class ApiResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<Object> handleException(final WebRequest req, final Exception e) {
        return this.handleExceptionInternal(e, new ExceptionDto(e.getMessage()), new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, req);
    }

    @ExceptionHandler(value = ValidationException.class)
    public ResponseEntity<Object> handleValidationException(final WebRequest req, final Exception e) {
        return this.handleExceptionInternal(e, new ExceptionDto(e.getMessage()), new HttpHeaders(), HttpStatus.UNPROCESSABLE_ENTITY, req);
    }

}
