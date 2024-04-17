package org.marcosbrindis.polymorphismstudentlist.models;

public class School {
    private DataBase1 dataBase;
    private DataBase2 dataBase2;
    private DataBase3 dataBase3;
    public School() {
      dataBase=new DataBase1();
      dataBase2=new DataBase2();
      dataBase3=new DataBase3();
    }
    public void addStudent(Student student) {
        dataBase.save(student);
        dataBase2.save(student);
        dataBase3.save(student);
    }
    public void updateStudent(Student student) {
        dataBase.update(student);
        dataBase2.update(student);
        dataBase3.update(student);
    }

    public DataBase1 getDataBase() {
        return dataBase;
    }
    public DataBase2 getDataBase2() {
        return dataBase2;
    }

    public DataBase3 getDataBase3() {
        return dataBase3;
    }
}
