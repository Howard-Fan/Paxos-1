package com.paxos.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hyh608 on 4/21/17.
 */

/**
 * This is a global exception handler to handle all unhandled controller level exceptions
 */

@ControllerAdvice
@RestController
public class GlobalExceptionHandler {
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(value = DoesNotExistException.class)
    public Map<String, String> handleTerraformException() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("err_msg", "Message not found");
        return map;
    }
}
