package name.javalex.springboot.controller;

import name.javalex.springboot.exception.RangeNotSatisfiableException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ResponseStatus(value = HttpStatus.REQUESTED_RANGE_NOT_SATISFIABLE, reason = "Incorrect amount requested")
    @ExceptionHandler(RangeNotSatisfiableException.class)
    public void handleRangeNotSatisfiableException() {
        logger.info("RangeNotSatisfiableException handler executed. Returning 416 error code");
    }
}
