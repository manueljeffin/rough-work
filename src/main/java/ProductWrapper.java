package main.java;

public class ProductWrapper {

    private final Metadata metadata;

    private final Product product;


    public ProductWrapper(final Product product, final Metadata metadata) {
        this.product = product;
        this.metadata = metadata;
    }

    public Product getSomeGuy() {
        return product;
    }

    public Metadata getMetadata() {
        return metadata;
    }

}
