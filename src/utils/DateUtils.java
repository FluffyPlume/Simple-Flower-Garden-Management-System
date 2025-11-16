package backend.utils;

import java.time.LocalDate;

public class DateUtils {
    
    //Checks if the given date is in the future.
    public static boolean isFutureDate(LocalDate date) {
        return date != null && date.isAfter(LocalDate.now());
    }
}