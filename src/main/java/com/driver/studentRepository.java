package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

@Repository
public class studentRepository {

    HashMap<String ,Student> studentMap = new HashMap<>();
    HashMap<String,Teacher> teacherMap = new HashMap<>();
    HashMap<String,List<String >> teastuMap = new HashMap<>();

    public studentRepository(HashMap<String, Student> studentMap, HashMap<String, Teacher> teacherMap, HashMap<String, List<String>> teastuMap) {
        this.studentMap = studentMap;
        this.teacherMap = teacherMap;
        this.teastuMap = teastuMap;
    }

    public void addStudent(Student student) {
        studentMap.put(student.getName(),student);
    }

    public void addTeacher(Teacher teacher) {
        teacherMap.put(teacher.getName(),teacher);
    }

    public String addStudent_Teacher_Pair(String student, String teacher) {

        if(studentMap.containsKey(student) == false || teacherMap.containsKey(teacher) == false)
        {
            return "Student or Teacher Data Not FOund";
        }
        else
        {
            if(teastuMap.containsKey(teacher))
            {
                teastuMap.get(teacher).add(student);
            }
            else {
                List<String> l = new ArrayList<>();
                l.add(student);
                teastuMap.put(teacher,l);
            }
        }

        return "DOne and Successful";

    }

    public Student getStudent_by_name(String name) {
        if(studentMap.containsKey(name) == false) return null;
        return studentMap.get(name);
    }

    public Teacher getTeacher_by_name(String name) {
        if(teacherMap.containsKey(name) == false) return null;
        return teacherMap.get(name);
    }

    public List<String> getstudentslistbyteacher(String teacher) {
        List<String> l = new ArrayList<>();

        if(teastuMap.containsKey(teacher))
        {
            l = teastuMap.get(teacher);
        }

        return l;
    }

    public List<String> getallStudents() {
//        List<String> l = new ArrayList<>();
//        for(String s : studentMap.keySet())
//        {
//            l.add(s);
//        }
//        return l;

        return new ArrayList<>(studentMap.keySet());
    }

    public void deleteTeacher(String teacher) {
        List<String> l = new ArrayList<>();
        if(teastuMap.containsKey(teacher))
        {
            l = teastuMap.get(teacher);
            for(String s : l)
            {
                if(studentMap.containsKey(s))
                {
                    studentMap.remove(s);
                }
            }
        }


        if(teacherMap.containsKey(teacher))
        {
            teacherMap.remove(teacher);
        }
        if(teastuMap.containsKey(teacher))
        {
            teastuMap.remove(teacher);
        }

    }

    public void deleteallteachersandtheirstudents() {
        HashSet<String> set = new HashSet<>();

        for(String s:teastuMap.keySet())
        {
            for(String str : teastuMap.get(s))
            {
                set.add(str);
            }
        }

        for(String s : set)
        {
            if(studentMap.containsKey(s))
            {
                studentMap.remove(s);
            }
        }

        teastuMap.clear();
        teacherMap.clear();

    }
}
