package com.example.demo.exception;

import com.example.demo.model.EbizResponse;
import com.example.demo.model.Status;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<EbizResponse> productNotFoundException(ProductNotFoundException ex){
        String message = ex.getMessage();

        return new ResponseEntity<EbizResponse>(new EbizResponse(Status.FAILURE, message), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CartItemNotFoundException.class)
    public ResponseEntity<EbizResponse> cartNotFoundException(CartItemNotFoundException ex){
        String message = ex.getMessage();

        return new ResponseEntity<EbizResponse>(new EbizResponse(Status.FAILURE, message), HttpStatus.NOT_FOUND);
    }


}
