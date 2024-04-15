package org.marcosbrindis.polymorphismstudentlist.models;

import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

public class Student {
    private String name;
    private String id;
    private LocalDate birthdate;
    private int age;
    private String gender;

    private String email;
    private String curp;
    private Long phoneNumbre;
    private static int studentCount = 0;

    public Student(String name, LocalDate birthdate, String gender, String email, String curp, Long phoneNumbre) {
        this.name = name;
        this.id = generarId();
        this.birthdate = birthdate;
        this.age = calculateYears();
        this.gender = gender;
        this.email = email;
        this.curp = curp;
        this.phoneNumbre = phoneNumbre;
    }
    public Student(String id, String name, LocalDate birthdate, String gender, String email, String curp, Long phoneNumbre) {
        this.id = id;
        this.name = name;
        this.birthdate = birthdate;
        this.age = calculateYears();
        this.gender = gender;
        this.email = email;
        this.curp = curp;
        this.phoneNumbre = phoneNumbre;
    }
    public String generarId(){
        int fechaActual=LocalDate.now().getYear()%100;
        studentCount=studentCount+1;
        String sequentialId = String.format("%04d", studentCount);
        String yearPart = String.format("%02d", fechaActual);
        return yearPart + sequentialId;
    }
    public int calculateYears(){
        Period period= Period.between(birthdate,LocalDate.now());
        return period.getYears();
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public String getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }

    public String getCurp() {
        return curp;
    }

    public Long getPhoneNumbre() {
        return phoneNumbre;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return  id +" ----> "+ name;
    }
    public String imprimir() {
        String attributesString = "ID: " + id +
                " Name: " + name  +
                " Birthdate: " + birthdate +
                " Age: " + age  +
                " Gender: " + gender  +
                " Email: " + email  +
                " CURP: " + curp  +
                " Phone Number: " + phoneNumbre + "\n";
        return attributesString;
    }
}
