package backend.models;
import java.time.LocalDate;

public class Flower {
    private int id;
    private String name;
    private String species;
    private String color;
    private LocalDate plantingDate;

    public Flower() {}

    public Flower(int id, String name, String species, String color, LocalDate plantingDate) {
        this.id = id;
        this.name = name;
        this.species = species;
        this.color = color;
        this.plantingDate = plantingDate;
    }

    public Flower(String name, String species, String color, LocalDate plantingDate) {
        this.name = name;
        this.species = species;
        this.color = color;
        this.plantingDate = plantingDate;
    }

    //getters
    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getSpecies(){
        return species;
    }

    public String getColor(){
        return color;
    }

    public LocalDate getPlantingDate(){
        return plantingDate;
    }

    //setters
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setPlantingDate(LocalDate plantingDate) {
        this.plantingDate = plantingDate;
    }

}
