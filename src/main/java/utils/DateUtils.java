package utils;

import lombok.experimental.UtilityClass;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

@UtilityClass
public class DateUtils {

    public static LocalTime convertMatchStartTimeToUtc(String timeZone, int hour, int minute) {
        ZoneId zoneId = ZoneId.of(timeZone);
        LocalDateTime localDateTime = LocalDateTime.of(LocalDate.now(), LocalTime.of(hour, minute));
        ZonedDateTime zonedDateTime = localDateTime.atZone(zoneId);
        ZonedDateTime utcDateTime = zonedDateTime.withZoneSameInstant(ZoneOffset.UTC);
        return utcDateTime.toLocalTime();
    }

    public static LocalTime parseStringToLocalTime(String time) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        return LocalTime.parse(time, formatter);
    }

    public static Duration adjustingExpectedTime(String timezone) {
        ZoneId defaultZone = ZoneId.of(timezone);
        ZoneOffset defaultOffset = defaultZone.getRules().getOffset(LocalDateTime.now());
        Instant defaultInstant = LocalDateTime.now().atZone(defaultZone).toInstant();
        Instant targetInstant = defaultInstant.plus(defaultOffset.getRules().getOffset(defaultInstant).getTotalSeconds(), ChronoUnit.SECONDS);
        return Duration.between(defaultInstant, targetInstant);
    }
}
