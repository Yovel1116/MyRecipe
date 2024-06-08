
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RecipeDAO {

    // Method to delete a recipe by its ID
    public void deleteRecipe(int id) {
        String sql = "DELETE FROM recipes WHERE id = ?";

        try (Connection connection = DatabaseManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);

            // Execute the delete operation
            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                // Recipe deleted successfully
                System.out.println("Recipe with ID " + id + " deleted successfully!");

                // Find the maximum id value after deletion
                int maxId = getMaxId(connection);

                // Reset auto-increment to the next available id value
                resetAutoIncrement(connection, maxId + 1);
            } else {
                // No recipe found with the specified id
                System.out.println("No recipe found with ID " + id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Helper method to find the maximum id value in the table
    private int getMaxId(Connection connection) throws SQLException {
        String sql = "SELECT MAX(id) AS max_id FROM recipes";
        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            if (resultSet.next()) {
                return resultSet.getInt("max_id");
            }
        }
        return 0; // Default value if no records exist in the table
    }

    // Helper method to reset auto-increment to the specified value
    private void resetAutoIncrement(Connection connection, int value) throws SQLException {
        String sql = "ALTER TABLE recipes AUTO_INCREMENT = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, value);
            statement.executeUpdate();
        }
    }

    // Method to add a new recipe to the database
    public void addRecipe(Recipe recipe) {
        String sql = "INSERT INTO recipes (name, ingredients, instructions, cuisine, cooking_time, rating) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, recipe.getName());
            statement.setString(2, recipe.getIngredients());
            statement.setString(3, recipe.getInstructions());
            statement.setString(4, recipe.getCuisine());
            statement.setInt(5, recipe.getCookingTime());
            statement.setFloat(6, recipe.getRating());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to retrieve all recipes from the database
    public List<Recipe> getAllRecipes() {
        List<Recipe> recipes = new ArrayList<>();
        String sql = "SELECT * FROM recipes";

        try (Connection connection = DatabaseManager.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                Recipe recipe = new Recipe();
                recipe.setId(resultSet.getInt("id"));
                recipe.setName(resultSet.getString("name"));
                recipe.setIngredients(resultSet.getString("ingredients"));
                recipe.setInstructions(resultSet.getString("instructions"));
                recipe.setCuisine(resultSet.getString("cuisine"));
                recipe.setCookingTime(resultSet.getInt("cooking_time"));
                recipe.setRating(resultSet.getFloat("rating"));
                recipes.add(recipe);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return recipes;
    }

    // Method to retrieve recipes based on filters
    public List<Recipe> getRecipesByFilters(String cuisine, int maxCookingTime, float minRating) {
        List<Recipe> filteredRecipes = new ArrayList<>();
        String sql = "SELECT * FROM recipes WHERE cuisine LIKE ? AND cooking_time <= ? AND rating >= ?";

        try (Connection connection = DatabaseManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            // Set parameters
            statement.setString(1, "%" + cuisine + "%");
            statement.setInt(2, maxCookingTime);
            statement.setFloat(3, minRating);

            // Execute query
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Recipe recipe = new Recipe();
                    recipe.setId(resultSet.getInt("id"));
                    recipe.setName(resultSet.getString("name"));
                    recipe.setIngredients(resultSet.getString("ingredients"));
                    recipe.setInstructions(resultSet.getString("instructions"));
                    recipe.setCuisine(resultSet.getString("cuisine"));
                    recipe.setCookingTime(resultSet.getInt("cooking_time"));
                    recipe.setRating(resultSet.getFloat("rating"));
                    filteredRecipes.add(recipe);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return filteredRecipes;
    }
}