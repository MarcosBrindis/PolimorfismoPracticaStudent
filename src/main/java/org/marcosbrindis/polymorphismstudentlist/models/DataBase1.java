package org.marcosbrindis.polymorphismstudentlist.models;

import java.util.ArrayList;

public class DataBase1 implements IStudentManager{
    private ArrayList <Student> studentList1;
    public DataBase1() {
        studentList1 = new ArrayList<>();
    }

    @Override
    public void save(Student student) {
        studentList1.add(student);
    }

    @Override
    public void update(Student student) {
        for(Student actual: studentList1){
            if (actual.getId()==student.getId()){
                studentList1.set(studentList1.indexOf(actual), student);
            }
        }
    }

    public ArrayList<Student> getStudentList1() {
        return studentList1;
    }
}
