package com.services.cxf.rest.model;

import com.services.cxf.rest.exception.TeacherNotFoundException;

import java.util.*;
import java.util.stream.Collectors;

public class TeacherUtil {

    private Map<Integer,Teacher> teachers = new HashMap<Integer,Teacher>();

    public TeacherUtil(){
        teachers.put(0,new Teacher(0,"Teacher1",1000, new ListLessons(Arrays.asList(new Lesson(0,"Lesson1",1), new Lesson(1,"Lesson2",2)))));
        teachers.put(1,new Teacher(1,"Teacher2",1500, new ListLessons(Arrays.asList(new Lesson(0,"Lesson1",3), new Lesson(1,"Lesson2",4)))));
        teachers.put(2,new Teacher(2,"Teacher3",1700, new ListLessons(Arrays.asList(new Lesson(0,"Lesson1",5), new Lesson(1,"Lesson2",6)))));
        teachers.put(3,new Teacher(3,"Teacher4",1800, new ListLessons(Arrays.asList(new Lesson(0,"Lesson1",6), new Lesson(1,"Lesson2",7)))));
        teachers.put(4,new Teacher(4,"Teacher5",1900, new ListLessons(Arrays.asList(new Lesson(0,"Lesson1",7), new Lesson(1,"Lesson2",6)))));
    }

    public Teacher getTeacher(Integer id) throws TeacherNotFoundException {
        Teacher teacher = teachers.get(id);
        if(teacher==null){
            throw new TeacherNotFoundException("Teacher with id " + id + " not found");
        }
        return teachers.get(id);
    }

    public List<Teacher> getAllTeacher() throws TeacherNotFoundException {
        if(teachers.values().isEmpty()){
            throw new TeacherNotFoundException("Teacher list not found");
        }
        return new ArrayList<>(teachers.values());
    }

    public void createTeacher(Teacher teacher){
        teachers.put(teacher.getId(),teacher);
    }

    public void updateTeacher(Teacher teacher,Integer id){
        teachers.put(id,teacher);
    }

    public void deleteTeacher(Integer id){
        teachers.remove(id);
    }

    public List<Teacher> getBusiestTeacher(){
        //addict
        int max = teachers.values().stream().mapToInt((s1)->s1.getLessons().getLesson().stream().mapToInt(Lesson::getDuration).sum()).max().getAsInt();
        return teachers.values().stream().filter((s)->s.getLessons().getLesson().stream().mapToInt(Lesson::getDuration).sum()==max).collect(Collectors.toList());
    }

}
