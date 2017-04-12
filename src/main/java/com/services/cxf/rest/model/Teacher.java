package com.services.cxf.rest.model;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "teacher")
@XmlType(propOrder = {"id","name","birthday","lessons"},name = "teacher")
@XmlAccessorType(XmlAccessType.FIELD)
public class Teacher {

    @XmlElement(required = true)
    private int id;
    private String name;
    private int birthday;
    private ListLessons lessons;

    public Teacher(){

    }

    public Teacher(int id, String name, int birthday, ListLessons lessons) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.lessons = lessons;
    }

    public Teacher(String name, int birthday, ListLessons lessons) {
        this.name = name;
        this.birthday = birthday;
        this.lessons = lessons;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ListLessons getLessons() {
        return lessons;
    }

    public void setLessons(ListLessons lessons) {
        this.lessons = lessons;
    }

    public int getBirthday() {
        return birthday;
    }

    public void setBirthday(int birthday) {
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                ", lessons=" + lessons +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Teacher teacher = (Teacher) o;

        if (id != teacher.id) return false;
        if (birthday != teacher.birthday) return false;
        if (name != null ? !name.equals(teacher.name) : teacher.name != null) return false;
        return lessons != null ? lessons.equals(teacher.lessons) : teacher.lessons == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + birthday;
        result = 31 * result + (lessons != null ? lessons.hashCode() : 0);
        return result;
    }
}
