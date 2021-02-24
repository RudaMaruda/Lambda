package pl.sda.zdjavapol73.tasks.individual;

import pl.sda.zdjavapol73.api.Task;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class DateTimeIndividual implements Task {
    // user1 (create post) - Asia/Aden
    // user2 (read post) - America/Noronha
    // server - UTC

    @Override
    public void run() {
        // create ZonedDateTime 15.12.2015 21:47 in zone Asia/Aden
        final ZonedDateTime timeInAsiaAden =
                ZonedDateTime.of(LocalDateTime.of(2015, 12, 15, 21, 47), ZoneId.of("Asia/Aden"));
        System.out.println("Time in Asia/Aden:  " + timeInAsiaAden);
        // convert this time to UTC
        final ZonedDateTime timeInUtc = timeInAsiaAden.withZoneSameInstant(ZoneId.of("UTC"));
        System.out.println("Time in Asia/Aden in convertion to UTC:  " + timeInUtc);
        // UTC convert to zone America/Noronha
        final ZonedDateTime timeInAmericaNoronha = timeInUtc.withZoneSameInstant(ZoneId.of("America/Noronha"));
        System.out.println("Time from UTC to America/Noronha:  " + timeInAmericaNoronha);
        if (timeInAsiaAden.isEqual(timeInUtc) && timeInAmericaNoronha.isEqual(timeInUtc) &&
                timeInAmericaNoronha.isEqual(timeInAsiaAden)) {
            System.out.println("Success!!!");
        } else {
            System.out.println("Try again...");
        }
    }
}
