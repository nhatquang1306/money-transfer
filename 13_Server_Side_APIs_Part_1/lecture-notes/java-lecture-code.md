# Server Side APIs: Part 1 - Java Lecture Notes

## Running the application

To run this application, open the Java application in IntelliJ and run it as a Spring Boot App. You'll test the API in Postman, and connect a client application as the last step. The client application is the end result of the previous day's lecture.

## Student starting code

The students' code has a similar structure to the `lecture-final` code that you have. The only difference is that the students' code is missing the methods to:

- List all reservations in the system
- Get a reservation by its id
- List all reservations by a hotel
- Create a new reservation
- Filter hotels by city and state

## Lecture code walkthrough

**Overview**

- Project Walkthrough
  - Import existing project into IntelliJ
  - Run the Project
  - MVC Structure
- Models
  - Hotel
  - Address
  - Reservation
- DAOs
- HotelController
  - GET
    - all reservations
    - single reservation by id
    - all reservations by hotel
  - POST
    - create new reservation
  - Filter hotels by state and city
- Connect the client to the API

### Project walkthrough

Before you write any code, walk through importing the existing project into IntelliJ and running it to make sure there are no errors. You can also walk through the structure of a Spring Boot project and answer any questions the students might have.

There is some existing code that you can walk through before you create methods in the controller:

- `model/Hotel.java`: Represents a Hotel in the API
- `model/Address.java`: Represents an Address in the API
- `model/Reservation.java`: Represents a Reservation in the API
- `dao/HotelDao.java`: Interface that all hotel DAOs must implement
- `dao/MemoryHotelDao.java`: A class that handles in memory storage and hotel data access
- `dao/ReservationDao.java`: Interface that all reservation DAOs must implement
- `dao/MemoryReservationDao.java`: A class that handles in memory storage and reservation data access

### Controllers

In the application, you'll find the package `com.techelevator.reservations.controllers` and a class called `HotelController.java`:

```java
public class HotelController {

    private HotelDao hotelDao;
    private ReservationDao reservationDao;

    public HotelController() {
        this.hotelDao = new MemoryHotelDao();
        this.reservationDao = new MemoryReservationDao(hotelDao);
    }

    // ...

}
```

Take some time to walk through what the constructor does. They haven't learned about dependency injection yet, so for the time being, the controller just creates a new instance of the DAOs.

If you run this application, nothing works. Ask the students what you need to do to tell Spring that this is a special class that accepts requests. Try and lead the students into the answer, which is `@RestController`.

```java
@RestController
public class HotelController {

    private HotelDao hotelDao;
    private ReservationDao reservationDao;

    public HotelController() {
        this.hotelDao = new MemoryHotelDao();
        this.reservationDao = new MemoryReservationDao(hotelDao);
    }

    // ...

}
```

#### Testing your API with Postman

This is a great opportunity to show the students good practices when it comes to building APIs. A careful programmer isn't going to worry about hooking up the client-end code until they know their API does what they want.

You can take the opportunity to use tools like Postman, Chrome Developer Tools (Network Tab), and debugger break points to step through the process of handling a request.

Run the application and test the existing request mappings:

- GET: /hotels
- GET: /hotels/{id} (1-7)

![List Hotels](./img/list_hotels.png)

#### Request mappings

At this point, you can map out on the board what methods you need in your controller based on the requirements that the front end team gave to you:

- list all reservations
  - path: /reservations
  - request method: `GET`
  - return: list of all reservations in the system
- get reservation by id
  - path: /reservations/{id}
  - request method: `GET`
  - return: reservation info for given id using path variable
- list all reservations by hotel
  - path: /hotels/{id}/reservations
  - request method: `GET`
  - return: list of all reservations in the system by hotel
- add new reservation
  - path: /reservations
  - request method: `POST`
  - add a new reservation based on the request body
- filter hotels
  - path: /hotels?state={state}&city={city}
  - request method: `GET`
  - find hotels by state and city (optional)

#### List reservations

The first method you'll write returns all the reservations in the list:

```java
@RequestMapping( path = "/reservations", method = RequestMethod.GET)
public List<Reservation> listReservations() {
    return reservationDao.findAll();
}
```

![List Reservations](./img/list_reservations.png)

#### Get a reservation by ID

Next, you need the ability to get a single reservation using the reservation ID. The first thing to point out is the use of a `@PathVariable`. The reservation ID is a `int`, so you'll map whatever comes through in the path to a int named `id`:

```java
@RequestMapping( path = "reservations/{id}", method = RequestMethod.GET)
public Reservation getReservation(@PathVariable int id) {
    return reservationDao.get(id);
}
```

![Get Reservation](./img/get_reservation.png)

#### List reservations by hotel

Next, you'll list all reservations by hotel. This is similar to the previous method, but with one difference: the name of the path variable and the argument to the method don't always have to be the same. When they're not, you'll pass the path variable name to the `@PathVariable()` annotation and then assign a type and name to the argument:

```java
@RequestMapping( path = "/hotels/{id}/reservations", method = RequestMethod.GET)
public List<Reservation> listReservationsByHotel(@PathVariable("id") int hotelId) {
    return reservationDao.findByHotel(hotelId);
}
```

![List Reservations by Hotel](./img/list_reservations_by_hotel.png)

#### Add a reservation

Last but not least, there is a way to add a new hotel in the application. Be sure to point out that the `@RequestBody` annotation takes the JSON body and converts it over to a `Reservation` object:

```java
@RequestMapping( path = "/reservations", method = RequestMethod.POST)
public Reservation addReservation(@RequestBody Reservation reservation) {
    return reservationDao.create(reservation, reservation.getHotelId());
}
```

![Create Reservation](./img/create_reservation.png)

#### Filter hotels by city and state

The client has come back to you and said that they want to filter hotels by state and optionally, city. You can implement this capability by modifying the `/hotels` path so that it calls on the `filterByStateAndCity` method. 

Until now, all of the variables you've used have been path variables. This method is a good example of how to use a `@RequestParam` and how to have an optional param. Take the time to point out when you would use a `@PathVariable` versus `@RequestParam`:

```java
    /**
     * /hotels
     * /hotels?state=ohio
     * /hotels?state=ohio&city=cleveland
     *
     * @param state the state to filter by
     * @param city  the city to filter by
     * @return a list of hotels that match the city & state
     */
    @RequestMapping(path = "/hotels", method = RequestMethod.GET)
    public List<Hotel> filterByStateAndCity(@RequestParam(required=false) String state, @RequestParam(required = false) String city) {
        return hotelDao.getFilteredList(state, city);
    }
```

### Connecting the client application

The client application from the previous lecture is located in `/client/java`. The API that you built out today modeled the fake API that was used. The only code that changed was the URL of the API:

```java
private static final String API_BASE_URL = "http://localhost:8080/";
```

If the API that you worked on today is running, run the command-line application and verify that everything works.

> The previous client application has the ability to update and delete a reservation which is covered in a future lecture. The client also doesn't have the ability to filter by state and city, but that could be something the students can work on if they have time.

At this point, you'll see the two applications communicating with each other.
