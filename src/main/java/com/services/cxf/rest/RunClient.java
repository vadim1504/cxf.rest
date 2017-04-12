package com.services.cxf.rest;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.services.cxf.rest.client.Request;
import com.services.cxf.rest.model.Lesson;
import com.services.cxf.rest.model.ListLessons;
import com.services.cxf.rest.model.ListTeachers;
import com.services.cxf.rest.model.Teacher;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.util.Arrays;

public class RunClient {

    public static void main(String[] args) throws JAXBException, JsonProcessingException {
        Request req = new Request();

        // GET entity
        JAXBContext jaxbContext = JAXBContext.newInstance(Teacher.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

        Teacher teacher = (Teacher) jaxbUnmarshaller.unmarshal(req.GET("http://localhost:8080/services/teacher/2"));
        System.out.println(teacher.toString());

        // GET all entity
        jaxbContext = JAXBContext.newInstance(ListTeachers.class);
        jaxbUnmarshaller = jaxbContext.createUnmarshaller();

        ListTeachers teachers = (ListTeachers) jaxbUnmarshaller.unmarshal(req.GET("http://localhost:8080/services/teacher"));
        System.out.println(teachers.toString());

        // DELETE entity
        req.DELETE("http://localhost:8080/services/teacher/2");

        // POST create entity
        teacher = new Teacher(22,"CreateTeacher",2222,new ListLessons(Arrays.asList(new Lesson(2,"22",222))));
        ObjectMapper objectMapper = new ObjectMapper();
        String input = objectMapper.writeValueAsString(teacher);

        req.POST("http://localhost:8080/services/teacher",input);

        //PUT update entity
        teacher = new Teacher(33,"UpdateTeacher",1111,new ListLessons(Arrays.asList(new Lesson(3,"33",333))));
        input = objectMapper.writeValueAsString(teacher);

        req.PUT("http://localhost:8080/services/teacher/1",input);

        //GET busiestTeacher
        teachers = (ListTeachers) jaxbUnmarshaller.unmarshal(req.GET("http://localhost:8080/services/teacher/busiest"));
        System.out.println(teachers.toString());

    }
}
