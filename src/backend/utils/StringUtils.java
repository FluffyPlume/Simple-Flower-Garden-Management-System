package src.backend.utils;

public class StringUtils {

    //Checks if a string is null or empty (after trimming spaces).
    public static boolean isNullOrEmpty(String s) {
        return s == null || s.trim().isEmpty();
    }
}