package com.richjames.brickordering.exception;

/**
 * Created by sysdevan on 05/08/2016.
 */

import lombok.AllArgsConstructor;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ApplicationExceptionMapper implements ExceptionMapper<ApplicationException> {

    @Context
    private HttpHeaders headers;

    @Override
    public Response toResponse(ApplicationException e) {
        Integer returnCode = e.getReturnCode();
        String errorMessage = e.getMessage();

        ApiErrorResponse errorResponse = new ApiErrorResponse(errorMessage, returnCode);

        Response.ResponseBuilder responseBuilder = Response
                .status(returnCode)
                .entity(errorResponse)
                .type(headers.getMediaType());

        return responseBuilder.build();
    }
}

@AllArgsConstructor
class ApiErrorResponse {

    private String message;
    private int returnCode;
}