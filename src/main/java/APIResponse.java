package main.java;

import java.util.List;

public class APIResponse {

    private List<Product> productList;

    private String something;

    public APIResponse(final List<Product> productList, final String something) {
        this.productList = productList;
        this.something = something;
    }

    public List<Product> getSomeGuyList() {
        return productList;
    }

    public String getSomething() {
        return something;
    }

}
