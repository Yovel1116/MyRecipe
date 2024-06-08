public class Recipe {
    private int id;
    private String name;
    private String ingredients;
    private String instructions;
    private String cuisine;
    private int cookingTime;
    private float rating;

    // Getters and setters for all fields
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getIngredients() { return ingredients; }
    public void setIngredients(String ingredients) { this.ingredients = ingredients; }

    public String getInstructions() { return instructions; }
    public void setInstructions(String instructions) { this.instructions = instructions; }

    public String getCuisine() { return cuisine; }
    public void setCuisine(String cuisine) { this.cuisine = cuisine; }

    public int getCookingTime() { return cookingTime; }
    public void setCookingTime(int cookingTime) { this.cookingTime = cookingTime; }

    public float getRating() { return rating; }
    public void setRating(float rating) { this.rating = rating; }
}
