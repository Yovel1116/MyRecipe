
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RecipeDAO recipeDAO = new RecipeDAO();

        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. Add recipe");
            System.out.println("2. Find recipes");
            System.out.println("3. Show all recipes");
            System.out.println("4. Delete recipe");
            System.out.println("5. Exit\n\n>>");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    newRecipe(scanner, recipeDAO);
                    break;
                case 2:
                    findRecipesByFilters(scanner, recipeDAO);
                    break;
                case 3:
                    showAllRecipes(recipeDAO);
                    break;
                case 4:
                    deleteRecipe(scanner, recipeDAO);
                    break;
                case 5:
                    System.out.println("Exiting...\n");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.\n");
            }
        }
    }

    private static void deleteRecipe(Scanner scanner, RecipeDAO recipeDAO) {
        while (true) {
            System.out.println("Enter recipe id:");
            if (scanner.hasNextInt()) {
                int id = scanner.nextInt();
                recipeDAO.deleteRecipe(id);
                break;
            } else {
                scanner.nextLine();
                System.out.println("Invalid input. Please enter an integer.");
            }
        }
    }

    private static void newRecipe(Scanner scanner, RecipeDAO recipeDAO) {
        // Prompt user to input recipe details
        System.out.println("Enter recipe details:");

        System.out.println("Name:");
        String name = scanner.nextLine().trim();

        System.out.println("Ingredients:");
        String ingredients = scanner.nextLine().trim();

        System.out.println("Instructions:");
        String instructions = scanner.nextLine().trim();

        System.out.println("Cuisine:");
        String cuisine = scanner.nextLine().trim();

        int flag = 1;
        int cookingTime = 0;
        float ratingInput = 0;

        while (flag == 1) {
            System.out.println("Cooking Time (in minutes):");
            if (scanner.hasNextInt()) {
                cookingTime = scanner.nextInt();
                flag = 0;
            } else {
                scanner.nextLine();
                System.out.println("Wrong input\n");
            }
        }

        flag = 1;
        while (flag == 1) {
            System.out.println("Rating (0-5):");
            if (scanner.hasNextInt()) {
                ratingInput = scanner.nextFloat();
                flag = 0;
            } else {
                scanner.nextLine();
                System.out.println("Wrong input\n");
            }
        }

        // Create a Recipe object with the user-input details
        Recipe recipe = new Recipe();
        recipe.setName(name);
        recipe.setIngredients(ingredients);
        recipe.setInstructions(instructions);
        recipe.setCuisine(cuisine);
        recipe.setCookingTime(cookingTime);
        recipe.setRating(ratingInput);

        // Add the recipe to the database
        recipeDAO.addRecipe(recipe);

        System.out.println("Recipe added successfully!\n\n");
    }

    private static void findRecipesByFilters(Scanner scanner, RecipeDAO recipeDAO) {
        // Prompt user for inputs
        System.out.println("Enter cuisine (leave blank for any): ");
        String cuisine = scanner.nextLine().trim();

        float ratingInput = 0;
        int cookingTimeInput = 0;
        int flag = 1;

        while (flag == 1) {
            System.out.println("Enter maximum cooking time in minutes : ");
            if (scanner.hasNextInt()) {
                cookingTimeInput = scanner.nextInt();
                flag = 0;
            } else {
                scanner.nextLine();
                System.out.println("Wrong input\n");
            }
        }

        flag = 1;
        while (flag == 1) {
            System.out.println("Enter minimum rating 0-5 : ");
            if (scanner.hasNextInt()) {
                ratingInput = scanner.nextFloat();
                flag = 0;
            } else {
                scanner.nextLine();
                System.out.println("Wrong input\n");
            }
        }

        // Retrieve recipes from database based on user inputs
        List<Recipe> recipes = recipeDAO.getRecipesByFilters(cuisine, cookingTimeInput, ratingInput);

        // Display the retrieved recipes
        if (recipes.isEmpty()) {
            System.out.println("No recipes found matching the criteria.\n");
        } else {
            System.out.println("Recipes matching the criteria:\n");
            for (Recipe recipe : recipes) {
                System.out.println("Name: " + recipe.getName());
                System.out.println("Ingredients: " + recipe.getIngredients());
                System.out.println("Instructions: " + recipe.getInstructions());
                System.out.println("Cuisine: " + recipe.getCuisine());
                System.out.println("Cooking Time: " + recipe.getCookingTime() + " minutes");
                System.out.println("Rating: " + recipe.getRating());
                System.out.println();
            }
        }
    }

    private static void showAllRecipes(RecipeDAO recipeDAO) {
        List<Recipe> allRecipes = recipeDAO.getAllRecipes();
        System.out.println("List of all recipes:\n");
        for (Recipe recipe : allRecipes) {
            System.out.println(recipe.getId() + ". " + recipe.getName());
        }
        System.out.println("\n");
    }
}