package services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import models.Flower;
import utils.FlowerValidator;
import utils.GenericIdValidator;

public class FlowerService {
    
    private ArrayList<Flower> flowerList = new ArrayList<>();
    private int nextId = 1;

    // Create 
    public void addFlower(Flower flower) {
        // Validate fields, Check duplicates, Assign auto-increment ID, add flower to the list
        FlowerValidator.validateFlower(flower);
        FlowerValidator.checkDuplicate(flower, flowerList);
        flower.setId(nextId++);
        flowerList.add(flower);
    }

    // Read 
    public Flower getFlowerById(int id) {
        GenericIdValidator.validateId(id, flowerList, Flower::getId);
        for (Flower f : flowerList){
            if (f.getId() == id) return f;
        }
        return null; 
    }

    public List<Flower> getAllFlower() {
        return new ArrayList<>(flowerList); // return a copy
    }

    // Update flower entirely
    public boolean updateFlower(Flower flower) {
        GenericIdValidator.validateId(flower.getId(), flowerList, Flower::getId);
        FlowerValidator.validateFlower(flower);  
        FlowerValidator.checkDuplicate(flower, flowerList); 
        for (int i = 0; i < flowerList.size(); i++) {
            if (flowerList.get(i).getId() == flower.getId()) {
                flowerList.set(i, flower);  
                return true; 
            }
        }
        return false; 
    }

    // Update specific fields
    public boolean updateFlower(int id, String newName, String newSpecies, String newColor, LocalDate newPlantingDate){
        GenericIdValidator.validateId(id, flowerList, Flower::getId);
        FlowerValidator.validateUpdateFields(newName, newSpecies, newColor, newPlantingDate);
        for (Flower f : flowerList) {
            if (f.getId() == id) {
                if (newName != null && !newName.isEmpty()) f.setName(newName);
                if (newSpecies != null && !newSpecies.isEmpty()) f.setSpecies(newSpecies);
                if (newColor != null && !newColor.isEmpty()) f.setColor(newColor);
                if (newPlantingDate != null) f.setPlantingDate(newPlantingDate);
                return true; 
            }
        }
        return false; 
    }

    // Delete a flower by ID
    public boolean deleteFlower(int id) {
        GenericIdValidator.validateId(id, flowerList, Flower::getId);
        return flowerList.removeIf(f -> f.getId() == id); 
    }

    // ---------------- FILTER METHODS ----------------

    // Filter flowers by species
    public List<Flower> getFlowersBySpecies(String species){
        List<Flower> result = new ArrayList<>(); // make a new list to store all flowers with specific species
        for (Flower f : flowerList){
            if (f.getSpecies().equalsIgnoreCase(species)){
                result.add(f);
            }
        }
        return result;
    }

    // Filter flowers by name
    public Flower getFlowerByName(String name){
        for (Flower f : flowerList){
            if(f.getName().equalsIgnoreCase(name)) return f;
        }
        return null;
    }

    // Filter flowers by color
    public List<Flower> getFlowersByColor(String color) {
        List<Flower> result = new ArrayList<>();
        for (Flower f : flowerList) {
            if (f.getColor().equalsIgnoreCase(color)) {
                result.add(f);
            }
        }
        return result;
    }
    
    //Filter by specific planting date
    public List<Flower> getFlowersByPlantingDate(LocalDate date) {
        List<Flower> result = new ArrayList<>();
        for (Flower f : flowerList) {
            if (f.getPlantingDate().equals(date)) {
                result.add(f);
            }
        }
        return result;
    }

    //Filter flowers by planted before a certain date
    public List<Flower> getFlowersPlantedBefore(LocalDate date) {
        List<Flower> result = new ArrayList<>();
        for (Flower f : flowerList) {
            if (f.getPlantingDate().isBefore(date)) {
                result.add(f);
            }
        }
        return result;
    }

    // Filter flowers by planted after a certain date
    public List<Flower> getFlowersPlantedAfter(LocalDate date) {
        List<Flower> result = new ArrayList<>();
        for (Flower f : flowerList) {
            if (f.getPlantingDate().isAfter(date)) {
                result.add(f);
            }
        }
        return result;
    }
}
