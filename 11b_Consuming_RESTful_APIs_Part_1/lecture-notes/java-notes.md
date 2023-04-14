# Java lecture code

You can either implement each method and then start the application, or show the output of each change by restarting the application after each change.

## Starting code

The starting code should look familiar to students who went through the tutorial. The only difference here is the domain model.

### `App.java`

Start by walking through the starting code in `App.java`.

There are private variables to refer to instances of the `ConsoleService` and `HotelService` classes. Although students have already seen the `ConsoleService` class in the tutorial, remind them that it writes to the console and retrieves user input.

The `HotelService` class encapsulates all of the requests to the web API.

```java
ConsoleService consoleService = new ConsoleService();
HotelService hotelService = new HotelService();
```

You'll update the `while` loop in the `run` method throughout the lecture; specifically, you'll replace the `System.out.println` for menu options 1-6.

### Hotel service

Open the `HotelService` class.

The web API is running locally, so this class declares a constant named `API_BASE_URL` pointing to the root URL:

```java
private static final String API_BASE_URL = "http://localhost:3000/";
```

> Note: the URL has path and query parameters appended as necessary.

Point out that a new `RestTemplate` has been instantiated for you and stored in the instance variable `restTemplate`. Explain that `RestTemplate` makes HTTP requests and deserializes the returned JSON response into an object:

```java
private RestTemplate restTemplate = new RestTemplate();
```

## List hotels

Next, you'll implement a method that's used for the _List Hotels_ menu option. You can use the `getForObject()` method, which takes a URL and the response type:

```java
public Hotel[] listHotels() {
    return restTemplate.getForObject(API_BASE_URL + "hotels", Hotel[].class);
}
```

Find the `if()` statement for option `1`. In that `if` block, call your new method and pass the return value to `consoleService.printHotels()`:

```java
if (menuSelection == 1) {
    consoleService.printHotels(hotelService.listHotels());
}
```

## List reviews

Create a similar method to call the API for a list of reviews. Show the different endpoint URLs:

```java
public Review[] listReviews() {
    return restTemplate.getForObject(API_BASE_URL + "reviews", Review[].class);
}
```

Now implement the `if else` for option `2` to print the reviews:

```java
} else if (menuSelection == 2) {
    consoleService.printReviews(hotelService.listReviews());
}
```

## Get hotel by ID

Introduce the concept of querying a specific `Hotel` by appending the hotel's ID as a path parameter. The `getHotelById()` method
accepts a single `int` parameter that's the ID of the hotel to request. Create the URL by concatenating it with the correct URL:

```java
public Hotel getHotelById(int id) {
    return restTemplate.getForObject(API_BASE_URL + "hotels/" + id, Hotel.class);
}
```

Now implement the `if else` for option `3` to print the individual hotel:

```java
} else if (menuSelection == 3) {
    consoleService.printHotel(hotelService.getHotelById(1));
}
```

## List reviews by hotel

Next, introduce the idea that URL paths can be used to show relationships. The next method requests reviews related to a specific hotel.

You'll pass the hotel ID into the method, and create a URL string to access the reviews. The `getReviewsByHotelId()` method accepts a single integer parameter that's the ID of the hotel:

```java
public Review[] getReviewsByHotelId(int hotelId) {
    return restTemplate.getForObject(API_BASE_URL + "hotels/" + hotelId + "/reviews", Review[].class);
}
```

Now implement the `if else` for option `4` to print the list of reviews for hotels with an ID of `1`:

```java
} else if (menuSelection == 4) {
    consoleService.printReviews(hotelService.getReviewsByHotelId(1));
}
```

## Get hotels by star rating

The next option presents the opportunity to discuss filtering requests with query parameters.

In the next method, accept an integer that represents a star rating. Then query for a filtered list of hotels that have a star rating equal to the parameter:

```java
public Hotel[] getHotelsByStarRating(int stars) {
    return restTemplate.getForObject(API_BASE_URL + "hotels?stars=" + stars, Hotel[].class);
}
```

Now implement the `if else` for option `5` that queries for a star rating of `5`:

```java
} else if (menuSelection == 5) {
    consoleService.printHotels(hotelService.getHotelsByStarRating(3));
}
```

## Get with custom query

Finally, the last menu option allows you to revisit the public API. There's a `City` class in `com.techelevator.hotels.model` that captures a small portion of the city response:

```java
public City getWithCustomQuery(){
    return restTemplate.getForObject("https://api.teleport.org/api/cities/geonameid:5128581/", City.class);
}
```

Then, implement the `if else` for option `6` by sending the return to the console. The City `toString()` method prints the city name:

```java
} else if (menuSelection == 6) {
    System.out.println(hotelService.getWithCustomQuery());
}
```

Modify the custom query option as much as desired.

## Notes

- Remember to restart the server after each change.
- Students might ask if you should split anything related to reviews (or custom queries) into their own service classes. This is probably a good idea, but to keep this example simple, the curriculum team decided to leave them all in the `HotelService`.



