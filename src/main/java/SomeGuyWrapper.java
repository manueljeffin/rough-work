package main.java;

public class SomeGuyWrapper {

    private final Metadata metadata;

    private final SomeGuy someGuy;


    public SomeGuyWrapper(final SomeGuy someGuy, final Metadata metadata) {
        this.someGuy = someGuy;
        this.metadata = metadata;
    }

    public SomeGuy getSomeGuy() {
        return someGuy;
    }

    public Metadata getMetadata() {
        return metadata;
    }

}
