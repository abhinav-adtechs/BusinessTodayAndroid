package io.cse325.businesstoday.Model.Pojos;

/**
 * Created by abhinav on 25/04/17.
 */

public class Products {

    private String productName ;
    private Integer productId ;

    public Products(String productName, Integer productId) {
        this.productName = productName;
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }
}
