package main.java;

import java.util.ArrayList;
import java.util.List;

public class APIResponseWrapper {

    private final Metadata metadata;

    private final APIResponse apiResponse;

    public APIResponseWrapper(final Metadata metadata, final APIResponse apiResponse) {
        this.metadata = metadata;
        this.apiResponse = apiResponse;
    }

    public Metadata getMetadata() {
        return metadata;
    }

    public APIResponse getApiResponse() {
        return apiResponse;
    }

    public List<ProductWrapper> transform() {
        final List<Product> productList = apiResponse.getSomeGuyList();

        final List<ProductWrapper> productWrapperList = new ArrayList<>();

        for (Product product : productList) {
            productWrapperList.add(new ProductWrapper(product, this.metadata));
        }
        return productWrapperList;
    }

}
