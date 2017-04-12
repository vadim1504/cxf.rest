package com.services.cxf.rest.services;

import com.services.cxf.rest.exception.TeacherNotFoundException;
import com.services.cxf.rest.model.ListTeachers;
import com.services.cxf.rest.model.Teacher;
import com.services.cxf.rest.model.TeacherUtil;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.core.Response;
import java.util.List;

public class TeachersServiceImpl implements TeacherService, BusiestService {

    @Autowired
    private TeacherUtil teacherUtil;

    public Response getEntity(int id) {
        Teacher teacher = null;
        try {
            teacher = teacherUtil.getTeacher(id);
        } catch (TeacherNotFoundException e) {

        }
        if(teacher!=null)
            return Response.accepted(teacher).status(Response.Status.OK).build();
        else
            return Response.status(Response.Status.NOT_FOUND).build();
    }

    public Response getAllEntity() {
        List<Teacher> teacher = null;
        try {
            teacher = teacherUtil.getAllTeacher();
        } catch (TeacherNotFoundException e) {
            e.printStackTrace();
        }
        if(teacher!=null)
            return Response.accepted(new ListTeachers(teacher)).status(Response.Status.OK).build();
        else
            return Response.status(Response.Status.NOT_FOUND).build();
    }

    public Response create(Teacher teacher) {
        teacherUtil.createTeacher(teacher);
        return Response.status(Response.Status.CREATED).build();
    }

    public Response update(Teacher teacher, int id) {
        Teacher t = (Teacher) getEntity(id).getEntity();
        if (t.equals(teacher))
            return Response.status(Response.Status.NOT_MODIFIED).build();
        else {
            teacherUtil.updateTeacher(teacher, id);
            return Response.status(Response.Status.OK).build();
        }
    }

    public Response delete(int id) {
        getEntity(id);
        teacherUtil.deleteTeacher(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    public Response getBusiestTeacher() {
        List<Teacher> teacher = teacherUtil.getBusiestTeacher();
        if(teacher!=null)
            return Response.accepted(new ListTeachers(teacherUtil.getBusiestTeacher())).status(Response.Status.OK).build();
        else
            return Response.status(Response.Status.NOT_FOUND).build();
    }
}
