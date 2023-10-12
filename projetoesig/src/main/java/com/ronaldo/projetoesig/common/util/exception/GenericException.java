package com.ronaldo.projetoesig.common.util.exception;

import com.ronaldo.projetoesig.common.util.view.GenericView;
import com.ronaldo.projetoesig.enums.ResultType;
import org.springframework.http.ResponseEntity;

public abstract class GenericException extends RuntimeException {

    protected ResultType resultType;

    protected GenericException(String message) {
        super(message);
    }

    protected GenericException(ResultType resultType) {
        super(resultType.getMessage());
        this.resultType = resultType;
    }

    protected GenericException(ResultType resultType, Exception e) {
        super(e.getMessage(), e);
        this.resultType = resultType;
    }

    public abstract ResponseEntity<GenericView<?>> asResponse();

}
