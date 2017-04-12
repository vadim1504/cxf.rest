package com.services.cxf.rest.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

@XmlRootElement
@XmlType(propOrder = {"lesson"},name = "listLessons")
@XmlAccessorType(XmlAccessType.FIELD)
public class ListLessons {

    private List<Lesson> lesson;

    public ListLessons(){

    }

    public ListLessons(List<Lesson> lesson){
        this.lesson=lesson;
    }

    public List<Lesson> getLesson() {
        return lesson;
    }

    public void setLesson(List<Lesson> lesson) {
        this.lesson = lesson;
    }

    @Override
    public String toString() {
        return "ListLessons{" +
                "lesson=" + lesson +
                '}';
    }
}
