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

    public List<SomeGuyWrapper> transform() {
        final List<SomeGuy> someGuyList = apiResponse.getSomeGuyList();

        final List<SomeGuyWrapper> someGuyWrapperList = new ArrayList<>();

        for (SomeGuy someGuy : someGuyList) {
            someGuyWrapperList.add(new SomeGuyWrapper(someGuy, this.metadata));
        }
        return someGuyWrapperList;
    }

}
