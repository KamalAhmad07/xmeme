package com.crio.starter.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler   extends ResponseEntityExceptionHandler{
    

    @ExceptionHandler(DataNotFoundException.class)
    public ResponseEntity<ErrorDetails> dtaNotFoundException(DataNotFoundException message, WebRequest request){
        
        ErrorDetails errorDetails = new ErrorDetails(HttpStatus.NOT_FOUND, message.getMessage(), request.getDescription(false));
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorDetails);

    }
   
   
    @ExceptionHandler(DataMatchedEception.class)
    public ResponseEntity<ErrorDetails> dataMatchedException(DataMatchedEception message, WebRequest request){
        
        ErrorDetails errorDetails = new ErrorDetails(HttpStatus.CONFLICT, message.getMessage(), request.getDescription(false));
        return ResponseEntity.status(HttpStatus.CONFLICT).body(errorDetails);

    }

}
