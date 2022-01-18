package main.java;

public class SomeGuy {

    private final String someGuyString;

    private final Integer someGuyInteger;

    public SomeGuy(final String someGuyString, final Integer someGuyInteger) {
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
