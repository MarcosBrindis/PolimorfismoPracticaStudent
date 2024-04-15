package org.marcosbrindis.polymorphismstudentlist.models;

import java.util.ArrayList;

public class DataBase2 implements IStudentManager{
    private ArrayList<Student> studentList2;
    public DataBase2() {
        studentList2 = new ArrayList<>();
    }
    @Override
    public void save(Student student) {
        studentList2.add(student);
    }

    @Override
    public void update(Student student) {
        for(Student actual: studentList2){
            if (actual.getId()==student.getId()){
                studentList2.set(studentList2.indexOf(actual), student);
            }
        }
    }
    public ArrayList<Student> getStudentList2() {
        return studentList2;
    }
}
