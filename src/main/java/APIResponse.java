package main.java;

import java.util.List;

public class APIResponse {

    private List<SomeGuy> someGuyList;

    private String something;

    public APIResponse(final List<SomeGuy> someGuyList, final String something) {
        this.someGuyList = someGuyList;
        this.something = something;
    }

    public List<SomeGuy> getSomeGuyList() {
        return someGuyList;
    }

    public String getSomething() {
        return something;
    }

}
