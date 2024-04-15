package org.marcosbrindis.polymorphismstudentlist.models;

import java.util.ArrayList;

public class DataBase3 implements IStudentManager{
    private ArrayList<Student> studentList3;
    public DataBase3() {
        studentList3 = new ArrayList<>();
    }
    @Override
    public void save(Student student) {
        studentList3.add(student);
    }

    @Override
    public void update(Student student) {
        for(Student actual: studentList3){
            if (actual.getId()==student.getId()){
                studentList3.set(studentList3.indexOf(actual), student);
            }
        }
    }
    public ArrayList<Student> getStudentList3() {
        return studentList3;
    }
}
