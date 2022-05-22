package com.company.Classes;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HexFormat;
import java.util.Objects;

public class WorkerDatabase {
    public static void Save(Workers workers) throws IOException {
        HexFormat hex = HexFormat.of();
        byte[]bytes=Utilities.convertObjectToBytes(workers);
        try {
            FileOutputStream fileOut = new FileOutputStream("./src/DatabaseW/" + LocalDate.now() + "-" + LocalDateTime.now().getHour() + "-" + LocalDateTime.now().getMinute() + "-" + LocalDateTime.now().getSecond() + ".hex");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(hex.formatHex(bytes));
            out.close();
            fileOut.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public static Workers Load() throws IOException, ClassNotFoundException {
        HexFormat hex = HexFormat.of();
        FileInputStream fileInputStream = new FileInputStream(Objects.requireNonNull(new File("./src/DatabaseW").listFiles())[Objects.requireNonNull(new File("./src/DatabaseW").listFiles()).length - 1]);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        byte[] bytes = hex.parseHex((String)objectInputStream.readObject());
        objectInputStream.close();
        fileInputStream.close();
        return Utilities.convertBytesToWorkers(bytes);
    }

}
