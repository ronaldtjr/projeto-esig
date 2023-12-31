package com.ronaldo.projetoesig.common.util.exception;

import com.ronaldo.projetoesig.common.util.view.GenericView;
import com.ronaldo.projetoesig.enums.ResultType;
import lombok.extern.slf4j.Slf4j;
import org.jooq.tools.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(GenericException.class)
    public ResponseEntity<?> handleException(GenericException e) {
        log.error(e.getMessage(), e);
        return e.asResponse();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleValidationErrors(MethodArgumentNotValidException ex) {

        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return ResponseEntity.badRequest()
                .body(GenericView.fail(ResultType.VALIDATION_ERROR, JSONObject.toJSONString(errors)));
    }

}