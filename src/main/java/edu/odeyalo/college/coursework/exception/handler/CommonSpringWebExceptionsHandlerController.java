package edu.odeyalo.college.coursework.exception.handler;

import edu.odeyalo.college.coursework.dto.ApiExceptionMessage;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * A simple controller that used to handle the web exceptions thrown by Spring framework
 */
@RestControllerAdvice
public class CommonSpringWebExceptionsHandlerController {
    public static final String INVALID_ARGUMENT_EXCEPTION_TYPE = "invalid_body";

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiExceptionMessage> handleMethodArgumentNotValidException(MethodArgumentNotValidException e,
                                                                                     HttpServletRequest webRequest) {
        Map<String, Object> details = new LinkedHashMap<>();
        e.getAllErrors().forEach((error) -> {
            details.put(((FieldError) error).getField(), error.getDefaultMessage());
        });
        ApiExceptionMessage message = ApiExceptionMessage.of("Payload is invalid and should be updated", webRequest.getServletPath(),
                        INVALID_ARGUMENT_EXCEPTION_TYPE, details);

        return ResponseEntity.badRequest().body(message);
    }
}
