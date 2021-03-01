package pl.sda.zdjavapol73;

import pl.sda.zdjavapol73.api.Task;
import pl.sda.zdjavapol73.tasks.DateAndTime;
import pl.sda.zdjavapol73.tasks.functional.FunctionalIndividual;
import pl.sda.zdjavapol73.tasks.functional.FunctionalTask;
import pl.sda.zdjavapol73.tasks.individual.DateTimeIndividual;
import pl.sda.zdjavapol73.tasks.individual.FileReaderIndividual;
import pl.sda.zdjavapol73.tasks.io.FileReader;
import pl.sda.zdjavapol73.tasks.io.FileWriter;
import pl.sda.zdjavapol73.tasks.io.ReadWrite;
import pl.sda.zdjavapol73.tasks.regularexpression.RegularExpressions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Collection<Task> tasks = new ArrayList<>();
        tasks.add(new DateAndTime());
        tasks.add(new RegularExpressions());
        tasks.add(new DateTimeIndividual());
        tasks.add(new RegularExpressions());
        tasks.add(new FileReader());
        tasks.add(new FileReaderIndividual());
        tasks.add(new FileWriter());
        tasks.add(new ReadWrite());
        tasks.add(new FunctionalIndividual());

        for (Task task : tasks) {
            task.run();
        }


        System.out.println(new Random().nextInt(18) + 1);

        final String[] strings = {"To", "jest", "przykład"};

        /*for (String string : strings) {
            System.out.println(string);
        }*/

    }


}
