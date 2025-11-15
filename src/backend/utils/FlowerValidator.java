package src.backend.utils;

import java.time.LocalDate;
import java.util.List;
import src.backend.models.Flower;

public class FlowerValidator {


    //Validates all fields of a new Flower.

    public static void validateFlower(Flower flower) {
        if (flower == null) {
            throw new IllegalArgumentException("Flower cannot be null.");
        }

        if (StringUtils.isNullOrEmpty(flower.getName())) {
            throw new IllegalArgumentException("Flower name cannot be empty.");
        }
        if (StringUtils.isNullOrEmpty(flower.getSpecies())) {
            throw new IllegalArgumentException("Flower species cannot be empty.");
        }
        if (StringUtils.isNullOrEmpty(flower.getColor())) {
            throw new IllegalArgumentException("Flower color cannot be empty.");
        }

        LocalDate plantingDate = flower.getPlantingDate();
        if (plantingDate == null) {
            throw new IllegalArgumentException("Planting date cannot be null.");
        }
        if (DateUtils.isFutureDate(plantingDate)) {
            throw new IllegalArgumentException("Planting date cannot be in the future.");
        }
    }

    //Validates new fields for updating a Flower.
    //Only validates fields that are provided (non-null).
    public static void validateUpdateFields(String name, String species, String color, LocalDate plantingDate) {
        if (name != null && StringUtils.isNullOrEmpty(name)) {
            throw new IllegalArgumentException("Updated name cannot be empty.");
        }
        if (species != null && StringUtils.isNullOrEmpty(species)) {
            throw new IllegalArgumentException("Updated species cannot be empty.");
        }
        if (color != null && StringUtils.isNullOrEmpty(color)) {
            throw new IllegalArgumentException("Updated color cannot be empty.");
        }
        if (plantingDate != null && DateUtils.isFutureDate(plantingDate)) {
            throw new IllegalArgumentException("Updated planting date cannot be in the future.");
        }
    }

    //Checks for duplicates in the given list of Flowers.
    //Duplicate if same name, species, and planting date.
    public static void checkDuplicate(Flower newFlower, List<Flower> existingFlowers) {
        for (Flower f : existingFlowers) {
            boolean sameName = f.getName().equalsIgnoreCase(newFlower.getName());
            boolean sameSpecies = f.getSpecies().equalsIgnoreCase(newFlower.getSpecies());
            boolean sameDate = f.getPlantingDate().equals(newFlower.getPlantingDate());

            if (sameName && sameSpecies && sameDate) {
                throw new IllegalArgumentException("Duplicate flower detected (same name, species, and planting date).");
            }
        }
    }
}