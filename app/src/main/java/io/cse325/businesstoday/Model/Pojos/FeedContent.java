package io.cse325.businesstoday.Model.Pojos;


public class FeedContent {

    private String productId ;

    private String productName ;

    private String productDescription ;

    private String companyName ;

    private String imageUrl ;

    public FeedContent(String productName, String productDescription, String companyName) {
        this.productName = productName;
        this.productDescription = productDescription;
        this.companyName = companyName;
    }

    public FeedContent(String productId, String productName, String productDescription, String companyName, String imageUrl) {
        this.productId = productId;
        this.productName = productName;
        this.productDescription = productDescription;
        this.companyName = companyName;
        this.imageUrl = imageUrl;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
