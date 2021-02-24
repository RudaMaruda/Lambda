package pl.sda.zdjavapol73.tasks;

import pl.sda.zdjavapol73.api.Task;

import java.time.*;
import java.util.Arrays;

public class DateAndTime implements Task {
    @Override
    public void run() {
        System.out.println("Hello from DateAndTime Task!");

        long currentTime = System.currentTimeMillis();
        System.out.println("Current time in ms: " + currentTime);
        System.out.println("Current time in ages: " + (currentTime / 1000 / 60 / 60 / 24 / 365.25));

        // Set default time zone for LocalDate... classes
        //         TimeZone.setDefault(TimeZone.getTimeZone(ZoneOffset.ofTotalSeconds(0)));
        final LocalDate localDate = LocalDate.now();
        System.out.println("Local date: " + localDate);

        final LocalTime localTime = LocalTime.now();
        System.out.println("Local time: " + localTime);

        final LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("Local date and time: " + localDateTime);

        // zone aware classes
        final ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println("Zoned date time now: " + zonedDateTime);

        // convert from UTC to user time zone
        final ZonedDateTime timeInUTC = ZonedDateTime.of(LocalDateTime.of(2021, 1, 12, 15, 35), ZoneId.of("UTC"));
        System.out.println("Time in UTC: " + timeInUTC);

        // get available time zones in JAVA
         System.out.println(Arrays.toString(ZoneId.getAvailableZoneIds().toArray()));

        final ZoneId chileZone = ZoneId.of("Chile/Continental");
        final ZonedDateTime timeInChile = timeInUTC.withZoneSameInstant(chileZone);
        System.out.println("timeInChile - instant: " + timeInChile);

        // convert from user time zone to UTC
        final ZonedDateTime timeInUTCFromChile = timeInChile.withZoneSameInstant(ZoneId.of("UTC"));
        System.out.println("Time in UTC from user in chile: " + timeInUTCFromChile);

        // changing time winter/summer
        final ZonedDateTime oneMonthLater = zonedDateTime.plusMonths(1);
        System.out.println("One month later: " + oneMonthLater);

        final ZonedDateTime threeMonthLater = zonedDateTime.plusMonths(3);
        System.out.println("Three month later: " + threeMonthLater);
    }
}
