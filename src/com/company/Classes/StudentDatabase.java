package com.company.Classes;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HexFormat;
import java.util.Objects;

public class StudentDatabase {


    public static void Save(Students students) throws IOException {
        HexFormat hex = HexFormat.of();
        byte[]bytes=Utilities.convertObjectToBytes(students);
        try {
            FileOutputStream fileOut = new FileOutputStream("./src/DatabaseS/" + LocalDate.now() + "-" + LocalDateTime.now().getHour() + "-" + LocalDateTime.now().getMinute() + "-" + LocalDateTime.now().getSecond() + ".hex");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(hex.formatHex(bytes));
            out.close();
            fileOut.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public static Students Load() throws IOException, ClassNotFoundException {
        HexFormat hex = HexFormat.of();
        FileInputStream fileInputStream = new FileInputStream(Objects.requireNonNull(new File("./src/DatabaseS").listFiles())[Objects.requireNonNull(new File("./src/DatabaseS").listFiles()).length - 1]);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        byte[] bytes = hex.parseHex((String)objectInputStream.readObject());
        objectInputStream.close();
        fileInputStream.close();
        return Utilities.convertBytesToStudents(bytes);
    }

}
