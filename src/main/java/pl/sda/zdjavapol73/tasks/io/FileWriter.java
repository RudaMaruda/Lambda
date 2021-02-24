package pl.sda.zdjavapol73.tasks.io;

import pl.sda.zdjavapol73.api.Task;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

public class FileWriter implements Task {
    private static final String FILE_NAME = "file_out.txt";

    @Override
    public void run() {
//        fileOutputStream();
//        fileWriter();
        printWriter();
    }

    private void fileOutputStream() {
        try (final FileOutputStream fos = new FileOutputStream(FILE_NAME);) {
            fos.write("Cześć from FOS!".getBytes(StandardCharsets.UTF_8));
            System.out.println("File written!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void fileWriter() {
        try (final java.io.FileWriter fw = new java.io.FileWriter(FILE_NAME)) {
            fw.write("Cześć from FileWriter!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void printWriter() {
        try (final PrintWriter pw = new PrintWriter(FILE_NAME);) {
            pw.println("Cześć from PrintWriter!");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
