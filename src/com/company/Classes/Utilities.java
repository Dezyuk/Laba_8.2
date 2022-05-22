package com.company.Classes;

import java.io.*;

public class Utilities {

    public static final int YEAR_NOW = 2022;

    static String correctingSurname(String str) {
        String result = "";
        str = str.strip();
        char[] ch = str.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            if (i != 0) {
                if (Character.isAlphabetic(ch[i]) && Character.isLowerCase(ch[i])) {
                    result += ch[i];
                } else {
                    result = "Unknown";
                    break;
                }
            }

            else {
                if (Character.isAlphabetic(ch[i]) && Character.isUpperCase(ch[i])) {
                    result += ch[i];
                } else {
                    result = "Unknown";
                    break;
                }
            }
        }
        return result;
    }
    static int correctingAdmission(int admission){
        if(YEAR_NOW - admission < 0 || YEAR_NOW - admission > 7){
            return -1;
        }
        else return admission;
    }

    static int correctingGrade(int grade){
        if(grade<0||grade>100){
            return -1;
        }
        else return grade;
    }

    static int correctingIncome(int income){
        if(income>20000&&income<500000){
            return income;
        }
        else return -1;
    }

    // Convert object to byte[]
    public static byte[] convertObjectToBytes(Students students) throws IOException {
        ByteArrayOutputStream boas = new ByteArrayOutputStream();
        try (ObjectOutputStream ois = new ObjectOutputStream(boas)) {
            ois.writeObject(students);
            return boas.toByteArray();
        }

    }
    public static byte[] convertObjectToBytes(Workers workers) throws IOException {
        ByteArrayOutputStream boas = new ByteArrayOutputStream();
        try (ObjectOutputStream ois = new ObjectOutputStream(boas)) {
            ois.writeObject(workers);
            return boas.toByteArray();
        }

    }

    // Convert byte[] to object
    public static Students convertBytesToStudents(byte[] bytes) throws IOException, ClassNotFoundException {
        InputStream is = new ByteArrayInputStream(bytes);
        try (ObjectInputStream ois = new ObjectInputStream(is)) {
            return (Students) ois.readObject();
        }
    }
    public static Workers convertBytesToWorkers(byte[] bytes) throws IOException, ClassNotFoundException {
        InputStream is = new ByteArrayInputStream(bytes);
        try (ObjectInputStream ois = new ObjectInputStream(is)) {
            return (Workers) ois.readObject();
        }
    }
}
