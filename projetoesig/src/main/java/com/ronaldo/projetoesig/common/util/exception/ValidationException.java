package com.ronaldo.projetoesig.common.util.exception;

import com.ronaldo.projetoesig.common.util.view.GenericView;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseStatus;

import static com.ronaldo.projetoesig.enums.ResultType.VALIDATION_ERROR;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ValidationException extends GenericException{

    public ValidationException(String message) {
        super(message);
    }

    @Override
    public ResponseEntity<GenericView<?>> asResponse() {
        return ResponseEntity.badRequest().body(GenericView.fail(VALIDATION_ERROR, getMessage()));
    }

}