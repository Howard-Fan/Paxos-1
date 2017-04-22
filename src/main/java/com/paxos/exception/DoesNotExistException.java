package com.paxos.exception;

/**
 * Created by hyh608 on 4/21/17.
 */

/**
 * This is a custom exception to handle non-existent hash
 * The exception will return a 404 NOT FOUND
 */
public class DoesNotExistException extends Exception {
    public DoesNotExistException(String message) {
        super(message);
    }
}
