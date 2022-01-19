package main.java;

public class Product {

    private final String someGuyString;

    private final Integer someGuyInteger;

    public Product(final String someGuyString, final Integer someGuyInteger) {
        this.someGuyString = someGuyString;
        this.someGuyInteger = someGuyInteger;
    }

    public String getSomeGuyString() {
        return someGuyString;
    }

    public Integer getSomeGuyInteger() {
        return someGuyInteger;
    }
}
