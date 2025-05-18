package com.akhi.microservices.order;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.akhi.microservices.order.Esception.IllegalArgumentExceptionaks;

@ControllerAdvice
public class ExceptionHandlers {

  @ExceptionHandler(IllegalArgumentExceptionaks.class)
  public ResponseEntity<String> IllegalArgumentExceptionhandler() {
    return new ResponseEntity<>("already existing item", HttpStatus.NOT_ACCEPTABLE);
  }

}
