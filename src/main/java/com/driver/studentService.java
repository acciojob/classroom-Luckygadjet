package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class studentService {

    @Autowired
    studentRepository repository;
    public void addstudent(Student student) {

        repository.addStudent(student);
    }

    public void addteacher(Teacher teacher) {
       repository.addTeacher(teacher);
    }

    public void  addstudentteacherpair(String student, String teacher) {
        repository.addStudent_Teacher_Pair(student,teacher);

    }

    public Student getstudentbyname(String name) {
        Student s = repository.getStudent_by_name(name);
        return s;
    }

    public Teacher getteacherbyname(String name) {
        Teacher t = repository.getTeacher_by_name(name);
        return t;
    }

    public List<String> getstudentsbyteachername(String teacher) {
        return repository.getstudentslistbyteacher(teacher);
    }

    public List<String> getallstudents() {
        return repository.getallStudents();
    }

    public void deleteteacherbyname(String teacher) {
        repository.deleteTeacher(teacher);
    }

    public void allteachers() {
        repository.deleteallteachersandtheirstudents();
    }
}
