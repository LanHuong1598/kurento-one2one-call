package org.kurento.tutorial.one2onecall.auth;

import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.http.HttpStatus;
import vn.com.itechcorp.base.exception.APIAuthenticationException;
import vn.com.itechcorp.base.exception.APIException;
import vn.com.itechcorp.base.exception.IllegalPropertyException;
import vn.com.itechcorp.base.exception.ObjectNotFoundException;

public class FeignErrorDecoder implements ErrorDecoder {
    @Override
    public Exception decode(String methodKey, Response response) {
        if (response.status() == HttpStatus.FORBIDDEN.value())
            return new APIAuthenticationException("Access is denied");
        else if (response.status() == HttpStatus.NOT_FOUND.value())
            return new ObjectNotFoundException("Object is not found");
        else if(response.status() ==HttpStatus.BAD_REQUEST.value())
            return new IllegalPropertyException("Invalid request properties");

        return new APIException("Exception: " + response.reason());
    }
}