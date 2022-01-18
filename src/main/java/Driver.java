package main.java;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Driver {
    public static void main(String[] args) {
        SomeGuy someGuyOne = new SomeGuy("s1", 1);
        SomeGuy someGuyTwo = new SomeGuy("s2", 2);

        APIResponse apiResponseOne = new APIResponse(Arrays.asList(someGuyOne, someGuyTwo), "something");
        APIResponse apiResponseTwo = new APIResponse(Arrays.asList(someGuyOne, someGuyTwo), "something");

        //Now let's say we also have some metadata for each response
        Metadata metadataForAPIResponseOne = new Metadata("someMetadata1");
        Metadata metadataForAPIResponseTwo = new Metadata("someMetadata2");

        //This metadata has to be added to each level of SomeGuy
        //But then the below "someMethod" takes in two APIResponse
        //So have to append Metadata at APIResponse level first
        //So creating a wrapper APIResponseWrapper and changing someMethod's contract to take in APIResponseWrapper


        //someMethod returns List<SomeGuy>. But we don't want to lose metadata.
        //So creating SomeGuyWrapper to hold this metadata and making it return List<SomeGuyWrapper>


        List<SomeGuyWrapper> list = someMethod(new APIResponseWrapper(metadataForAPIResponseOne, apiResponseOne),
                   new APIResponseWrapper(metadataForAPIResponseTwo, apiResponseTwo));

        System.out.println(list);

    }

    private static List<SomeGuyWrapper> someMethod(APIResponseWrapper apiResponseOne, APIResponseWrapper apiResponseTwo) {
        return Stream.of(apiResponseOne, apiResponseTwo)
                .map(APIResponseWrapper::transform)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }


}
