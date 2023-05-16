package edu.odeyalo.college.coursework.exception.handler;

import edu.odeyalo.college.coursework.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.LinkedHashMap;
import java.util.Map;

@RestControllerAdvice
public class NotFoundExceptionsHandlerController  {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> handleCommonNotFoundException(NotFoundException e) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("message", e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
    }
}
