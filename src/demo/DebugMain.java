package backend.demo;

import java.time.LocalDate;
import java.util.Scanner;

import backend.models.Flower;
import backend.services.FlowerService;

public class DebugMain {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        FlowerService service = new FlowerService();

        while (true) {
            System.out.println("\n===== FLOWER DEBUG MENU =====");
            System.out.println("1. Add Flower");
            System.out.println("2. View All Flowers");
            System.out.println("3. Get Flower by ID");
            System.out.println("4. Update Flower (specific fields)");
            System.out.println("5. Delete Flower");
            System.out.println("6. Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            try {
                switch (choice) {

                    // ------------------- ADD FLOWER -------------------
                    case 1:
                        System.out.print("Enter name: ");
                        String name = sc.nextLine();

                        System.out.print("Enter species: ");
                        String species = sc.nextLine();

                        System.out.print("Enter color: ");
                        String color = sc.nextLine();

                        System.out.print("Enter planting date (YYYY-MM-DD): ");
                        LocalDate date = LocalDate.parse(sc.nextLine());

                        Flower f = new Flower(name, species, color, date);
                        service.addFlower(f);

                        System.out.println("Flower added successfully!");
                        break;

                    // ------------------- VIEW ALL -------------------
                    case 2:
                        System.out.println("\n--- All Flowers ---");
                        for (Flower flower : service.getAllFlower()) {
                            System.out.println(
                                flower.getId() + " | " + 
                                flower.getName() + " | " +
                                flower.getSpecies() + " | " +
                                flower.getColor() + " | " +
                                flower.getPlantingDate()
                            );
                        }
                        break;

                    // ------------------- GET BY ID -------------------
                    case 3:
                        System.out.print("Enter ID to search: ");
                        int searchId = sc.nextInt();
                        sc.nextLine();

                        Flower found = service.getFlowerById(searchId);
                        if (found != null) {
                            System.out.println("Found: " + found.getName() + " (" + found.getSpecies() + ")");
                        }
                        break;

                    // ------------------- UPDATE SPECIFIC FIELDS -------------------
                    case 4:
                        System.out.print("Enter ID to update: ");
                        int updateId = sc.nextInt();
                        sc.nextLine();

                        System.out.print("New name (or leave blank): ");
                        String newName = sc.nextLine();
                        if (newName.isBlank()) newName = null;

                        System.out.print("New species (or leave blank): ");
                        String newSpecies = sc.nextLine();
                        if (newSpecies.isBlank()) newSpecies = null;

                        System.out.print("New color (or leave blank): ");
                        String newColor = sc.nextLine();
                        if (newColor.isBlank()) newColor = null;

                        System.out.print("New planting date YYYY-MM-DD (or leave blank): ");
                        String dateInput = sc.nextLine();
                        LocalDate newDate = dateInput.isBlank() ? null : LocalDate.parse(dateInput);

                        boolean updated = service.updateFlower(updateId, newName, newSpecies, newColor, newDate);

                        System.out.println(updated ? "Update successful!" : "Flower not found.");
                        break;

                    // ------------------- DELETE -------------------
                    case 5:
                        System.out.print("Enter ID to delete: ");
                        int deleteId = sc.nextInt();
                        sc.nextLine();

                        boolean removed = service.deleteFlower(deleteId);
                        System.out.println(removed ? "Deleted successfully!" : "Flower not found.");
                        break;

                    // ------------------- EXIT -------------------
                    case 6:
                        System.out.println("Exiting...");
                        return;

                    default:
                        System.out.println("Invalid choice.");
                }

            } catch (Exception e) {
                System.out.println("ERROR: " + e.getMessage());
            }
            sc.close();
        }
    }
}