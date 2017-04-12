package com.services.cxf.rest.providers;

import com.services.cxf.rest.exception.TeacherNotFoundException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class TeacherNotFoundExceptionHandler implements ExceptionMapper<TeacherNotFoundException> {

    public Response toResponse(TeacherNotFoundException e) {
        return Response.status(Response.Status.NOT_FOUND).header("exception",e.getMessage()).build();
    }
}
