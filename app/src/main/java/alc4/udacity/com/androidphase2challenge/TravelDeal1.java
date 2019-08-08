package alc4.udacity.com.androidphase2challenge;

import java.io.Serializable;

public class TravelDeal1 implements Serializable {

    private String id;
    private String title;
    private String description;
    private String price;
    private String imageUrl;
    private String imageName;

    public TravelDeal1() {
    }

<<<<<<< HEAD
    /*public TravelDeal1(String title, String description, String price, String imageName) {
=======
    public TravelDeal1(String title, String description, String price, String imageName, String imageUrl) {
>>>>>>> 019d195b3de850a5b67763e5af86102961572320
        this.setId(id);
        this.setTitle(title);
        this.setDescription(description);
        this.setPrice(price);
        this.setImageName(imageName);
<<<<<<< HEAD
    }*/

    public TravelDeal1(String title, String description, String price, String imageUrl, String imageName) {
        this.setId(id);
        this.setTitle(title);
        this.setDescription(description);
        this.setPrice(price);
        this.setImageUrl(imageUrl);
        this.setImageName(imageName);
=======
        this.setImageUrl(imageUrl);
>>>>>>> 019d195b3de850a5b67763e5af86102961572320
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }
}
