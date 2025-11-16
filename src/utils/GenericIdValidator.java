package utils;

import java.util.List;
import java.util.function.ToIntFunction;

public class GenericIdValidator {

    /**
     * 
     * @param id        the ID to validate
     * @param list      list of objects
     * @param getIdFunc function to extract ID from object
     * @param <T>       type of objects in list
     */
    public static <T> void validateId(int id, List<T> list, ToIntFunction<T> getIdFunc) {
        if (id <= 0) {
            throw new IllegalArgumentException("ID must be positive.");
        }

        boolean exists = list.stream().anyMatch(item -> getIdFunc.applyAsInt(item) == id);

        if (!exists) {
            throw new IllegalArgumentException("Object with ID " + id + " does not exist.");
        }
    }
}