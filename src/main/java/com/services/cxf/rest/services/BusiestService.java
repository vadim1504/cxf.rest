package com.services.cxf.rest.services;


import org.springframework.stereotype.Service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Service
public interface BusiestService {

    @GET
    @Path("/busiest")
    @Produces(MediaType.APPLICATION_XML)
    Response getBusiestTeacher();
}
