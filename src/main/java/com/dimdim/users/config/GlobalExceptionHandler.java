package com.dimdim.users.config;
import org.springframework.http.*; import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*; import java.util.*;
@ControllerAdvice
public class GlobalExceptionHandler {
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<?> handleValidation(MethodArgumentNotValidException ex){
    Map<String,String> errors=new HashMap<>();
    ex.getBindingResult().getFieldErrors().forEach(err->errors.put(err.getField(),err.getDefaultMessage()));
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
  }
}
