package com.services.cxf.rest.services;

import com.services.cxf.rest.model.Teacher;
import org.springframework.stereotype.Service;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Service
@Path("/teacher")
public interface TeacherService {

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_XML)
    Response getEntity(@PathParam("id") int id);

    @GET
    @Produces(MediaType.APPLICATION_XML)
    Response getAllEntity();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    Response create(Teacher teacher);

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    Response update(Teacher teacher,@PathParam("id") int id);

    @DELETE
    @Path("/{id}")
    Response delete(@PathParam("id") int id);

}