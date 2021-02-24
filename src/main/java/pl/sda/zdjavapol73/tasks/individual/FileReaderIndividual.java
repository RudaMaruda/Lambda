package pl.sda.zdjavapol73.tasks.individual;

import pl.sda.zdjavapol73.api.Task;

import java.io.*;
import java.util.Scanner;

public class FileReaderIndividual implements Task {
    @Override
    public void run() {
        bufferedInputStream();
        scanner();
    }

    private void bufferedInputStream() {
        try (final BufferedInputStream bis = new BufferedInputStream(getClass().getResourceAsStream("/about_me.txt"));) {
            // TODO: read byte by byte and print on system out
            System.out.println(bis.read());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void scanner() {
        try (final Scanner scanner = new Scanner(getClass().getResourceAsStream("/about_me.txt"));) {
            // TODO: read all lines of file and print on system out
            System.out.println(scanner.nextLine());
        }
    }
}
