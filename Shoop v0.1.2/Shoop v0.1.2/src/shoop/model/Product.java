
package shoop.model;

import java.util.Date;

public class Product {
    
    private String Category;
    private String ImageUrl;
    private String Name;
    private String ID;
    private String Description;
    private String Price;
    private String Provider;
    private String MinCant;
    private String ActualCant;
    
    public Product(String Category, String Name, String ImageUrl, String Description, String Provider, String Price, String MinCant, String ID, String ActualCant) {
        this.Category = Category;
        this.ImageUrl = ImageUrl;
        this.Name = Name;
        this.ID = ID;
        this.Description = Description;
        this.Price = Price;
        this.Provider = Provider;
        this.MinCant = MinCant;
        this.ActualCant = ActualCant;
    }
    
    public String getCategory() {
        return Category;
    }

    public void setCategory(String Category) {
        this.Category = Category;
    }
    
    public Product(String ImageUrl, String Name, String Provider) {
        this.ImageUrl = ImageUrl;
        this.Name = Name;
        this.Provider = Provider;
    }
    
     public String getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(String ImageUrl) {
        this.ImageUrl = ImageUrl;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String Price) {
        this.Price = Price;
    }

    public String getProvider() {
        return Provider;
    }

    public void setProvider(String Provider) {
        this.Provider = Provider;
    }

    public String getMinCant() {
        return MinCant;
    }

    public void setMinCant(String MinCant) {
        this.MinCant = MinCant;
    }

    public String getActualCant() {
        return ActualCant;
    }

    public void setActualCant(String ActualCant) {
        this.ActualCant = ActualCant;
    }
    
    
    
}