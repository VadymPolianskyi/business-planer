package com.exec.business.protocol.exception;

/**
 * Author: Vadym Polyanski;
 * Date: 15.10.17;
 * Time: 12:41.
 */
public class ContactNotFoundException extends RuntimeException {
    public ContactNotFoundException(String message) {
        super(message);
    }
}
