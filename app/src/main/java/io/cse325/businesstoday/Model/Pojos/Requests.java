package io.cse325.businesstoday.Model.Pojos;


public class Requests {

    private Integer companyId ;

    private String companyName ;

    private Integer productId ;

    private String productName ;

    private Integer productQuantity ;

    private Integer dealStatus ;

    private Integer productRate ;


    public Requests(Integer companyId, String companyName, Integer productId, String productName, Integer productQuantity, Integer dealStatus, Integer productRate) {
        this.companyId = companyId;
        this.companyName = companyName;
        this.productId = productId;
        this.productName = productName;
        this.productQuantity = productQuantity;
        this.dealStatus = dealStatus;
        this.productRate = productRate;
    }

    public Requests(Integer companyId, String companyName, Integer productId, String productName, Integer productQuantity, Integer dealStatus) {
        this.companyId = companyId;
        this.companyName = companyName;
        this.productId = productId;
        this.productName = productName;
        this.productQuantity = productQuantity;
        this.dealStatus = dealStatus;
    }

    public Requests(String companyName, String productName, Integer productQuantity, Integer productRate) {
        this.companyName = companyName;
        this.productName = productName;
        this.productQuantity = productQuantity;
        this.productRate = productRate;
    }

    public Integer getProductRate() {
        return productRate;
    }

    public void setProductRate(Integer productRate) {
        this.productRate = productRate;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(Integer productQuantity) {
        this.productQuantity = productQuantity;
    }

    public Integer getDealStatus() {
        return dealStatus;
    }

    public void setDealStatus(Integer dealStatus) {
        this.dealStatus = dealStatus;
    }
}
