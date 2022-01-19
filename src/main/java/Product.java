package main.java;

public class Product {

    private final String productName;

    private final Integer productId;

    public Product(final String someGuyString, final Integer productId) {
        this.productName = someGuyString;
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public Integer getProductId() {
        return productId;
    }
}
