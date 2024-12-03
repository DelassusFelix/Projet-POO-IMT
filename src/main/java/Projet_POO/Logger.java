package Projet_POO;

import java.io.FileWriter;
import java.io.IOException;

public class Logger {
    private FileWriter writer;

    public Logger(String fileName) throws IOException {
        this.writer = new FileWriter(fileName, true);
    }

    public void log(String message) throws IOException {
        System.out.println(message);
        writer.write(message + "\n");
        writer.flush();
    }

    public void close() throws IOException {
        writer.close();
    }
}

