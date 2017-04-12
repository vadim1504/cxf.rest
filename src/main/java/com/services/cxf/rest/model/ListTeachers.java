package com.services.cxf.rest.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

@XmlRootElement
@XmlType(propOrder = {"teacher"},name = "listTeachers")
@XmlAccessorType(XmlAccessType.FIELD)
public class ListTeachers {

    private List<Teacher> teacher;

    public ListTeachers(){

    }

    public ListTeachers(List<Teacher> teacher){
        this.teacher=teacher;
    }

    public List<Teacher> getTeacher() {
        return teacher;
    }

    public void setTeacher(List<Teacher> teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "ListTeachers{" +
                "teacher=" + teacher +
                '}';
    }
}
