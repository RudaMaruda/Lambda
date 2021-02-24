package pl.sda.zdjavapol73.tasks.io;

import pl.sda.zdjavapol73.api.Task;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ReadWrite implements Task {
    @Override
    public void run() {
        boolean programRunning = true;
        while (programRunning) {
            printMenu();
            int userChoice = getUserChoice();
            switch (userChoice) {
                case 1:
                    programRunning = false;
                    break;
                case 2:
                    writer();
                    break;
            }
        }
    }

    private void printMenu() {
        System.out.println("MENU");
        System.out.println("1 - exit");
        System.out.println("2 - writer");
    }

    private int getUserChoice() {
        final Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int userChoice = scanner.nextInt();
            if (userChoice == 1 || userChoice == 2) {
                return userChoice;
            }
            System.out.println("Choose 1 or 2");
        }
        return 0;
    }

    private void writer() {
        System.out.println("Write something...");
        final Scanner scanner = new Scanner(System.in);
        final String line = scanner.nextLine();
        System.out.println("1 - file, 2 - console");
        int userChoice = getUserChoice();
        switch (userChoice) {
            case 1:
                try (final PrintWriter pw = new PrintWriter("output.txt")) {
                    write(pw, line);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                break;
            case 2:
                final PrintWriter pw = new PrintWriter(System.out);
                write(pw, line);
        }
    }

    private void write(PrintWriter pw, String line) {
        pw.println("User typed in following text:");
        pw.println(line);
        pw.println("#############################");
        pw.flush();
    }
}
