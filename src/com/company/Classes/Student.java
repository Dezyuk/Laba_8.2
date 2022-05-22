package com.company.Classes;

import java.io.Serializable;

public class Student implements Serializable {
    private String surname;
    private Speciality speciality;
    private int admission;
    private int gradePhysics;
    private int gradeMath;
    private int gradeInformatics;

    public Student(final String surname, final Speciality speciality, final int admission, final int gradePhysics, final int gradeMath, final int gradeInformatics) {
        this.setSurname(surname);
        this.speciality = speciality;
        this.setAdmission(admission);
        this.setGradePhysics(gradePhysics);
        this.setGradeMath(gradeMath);
        this.setGradeInformatics(gradeInformatics);
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(final String surname) {
        this.surname = Utilities.correctingSurname(surname);
    }

    public Speciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(final Speciality speciality) {
        this.speciality = speciality;
    }

    public int getAdmission() {
        return admission;
    }

    public void setAdmission(final int admission) {
        this.admission = Utilities.correctingAdmission(admission);
    }

    public int getGradePhysics() {
        return gradePhysics;
    }

    public void setGradePhysics(final int gradePhysics) {
        this.gradePhysics = Utilities.correctingGrade(gradePhysics);
    }

    public int getGradeMath() {
        return gradeMath;
    }

    public void setGradeMath(final int gradeMath) {
        this.gradeMath = Utilities.correctingGrade(gradeMath);
    }

    public int getGradeInformatics() {
        return gradeInformatics;
    }

    public void setGradeInformatics(final int gradeInformatics) {
        this.gradeInformatics = Utilities.correctingGrade(gradeInformatics);
    }

    public String toString() {
        return "Student[" +
                "Surname=" + surname +
                ", speciality=" + speciality +
                ", admission=" + admission +
                ", grade Physics=" + gradePhysics +
                ", grade Math=" + gradeMath +
                ", grade Informatics=" + gradeInformatics +
                "]";
    }
}
