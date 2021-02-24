package pl.sda.zdjavapol73.tasks.io;

import pl.sda.zdjavapol73.api.Task;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class FileReader implements Task {
    @Override
    public void run() {
        System.out.println("File content:");
        //        fileInputStream();
//        bufferedReader();
        scanner();
        //        bufferedInputStream();
    }

    private void fileInputStream() {
        try (final FileInputStream fis = new FileInputStream("/home/arek/git/sda/java_zaawansowana/fileName.txt")) {
            System.out.println("File was opened!");
            final byte[] fileContent = fis.readAllBytes();
            final String textFromFile = new String(fileContent, StandardCharsets.UTF_8);
            System.out.println(textFromFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void fileReader() {
        try (final java.io.FileReader fr = new java.io.FileReader(
                "/home/arek/git/sda/java_zaawansowana/fileName.txt")) {
            final char[] chars = new char[21];
            fr.read(chars);
            System.out.println(chars);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void bufferedReader() {
        try (final BufferedReader br = new BufferedReader(
                new java.io.FileReader("/home/arek/git/sda/java_zaawansowana/fileName.txt"))) {
            String line = br.readLine();
            while (line != null) {
                System.out.println(line);
                line = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void scanner() {
        try (final Scanner scanner = new Scanner(new File("/home/arek/git/sda/java_zaawansowana/fileName.txt"));) {
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void bufferedInputStream() {
        try (final BufferedInputStream bis = new BufferedInputStream(
                new FileInputStream("/home/arek/Documents/gdrive_backup/drive-download-2021_02_10.zip"))) {
            int nextByte = bis.read();
            while (nextByte != -1) {
                System.out.print(nextByte);
                nextByte = bis.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
