package main.java;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Driver {
    public static void main(String[] args) {

        Driver driver = new Driver();


        //Aim is to call 2 APIs and merge the response in decorated fashion.
        //API-I will have one metadata
        //API-2 will have another metadata

        //Now lets say API-I returns 5 products and API-II returns another 5
        //We would want to stitch those 10 products together,
        // with each product having the metadata of it's corresponding parent API response

        /*
        Product structure:

        {
          "productName": "product1",
          "productId": "1"
        }


        API Response:

        {
          "something": "something",
          "productList": [
                {
                  "productName": "product1",
                  "productId": "1"
                },
                {
                  "productName": "product2",
                  "productId": "2"
                }
            ]
        }

         */


        List<ProductWrapper> list = driver.someMethod(driver.getResponseForOne(), driver.getResponseForTwo());

    }

    private CompletableFuture<APIResponseWrapper> getResponseForOne() {

        return CompletableFuture.supplyAsync(() -> {
            //Simulate first API call
            Product productOne = new Product("product1", 1);
            Product productTwo = new Product("product2", 2);
            return new APIResponseWrapper(new Metadata("someMetadata1"),
                                          new APIResponse(Arrays.asList(productOne, productTwo), "something1"));
        });
    }

    private CompletableFuture<APIResponseWrapper> getResponseForTwo() {
        //Simulate second API call
        return CompletableFuture.supplyAsync(() -> {
            Product productThree = new Product("product3", 3);
            Product productFour = new Product("product4", 4);
            return new APIResponseWrapper(new Metadata("someMetadata2"),
                                          new APIResponse(Arrays.asList(productThree, productFour), "something2"));
        });
    }


    private List<ProductWrapper> someMethod(CompletableFuture<APIResponseWrapper> future1,
                                            CompletableFuture<APIResponseWrapper> future2) {
        return Stream.of(future1, future2)
                     .map(CompletableFuture::join)
                     .map(APIResponseWrapper::transform)
                     .flatMap(Collection::stream)
                     .collect(Collectors.toList());
    }


}
