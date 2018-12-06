package com.clientui.exceptions;

import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.http.HttpStatus;

public class CustomeErrorDecoder implements ErrorDecoder {

    private final ErrorDecoder defaultErrorDecoder = new Default() ;

    @Override
    public Exception decode(String s, Response response) {
        if ( response.status() == HttpStatus.BAD_REQUEST.value() ) {
            return new ProductBadRequestException(response.body().toString());
        } else if ( response.status() == HttpStatus.NOT_FOUND.value() ) {
            return new ProductNotFoundException(response.body().toString());
        }
        return defaultErrorDecoder.decode(s, response);
    }
}
