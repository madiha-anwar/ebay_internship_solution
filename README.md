This project is about a service to estimate a price to send something from Pickup point to delivery point using X vehicle. 

"QuoteInterface" folder consist of the interface made to consume the service. 
Most of the basic checks are covered on the interface side 
.e.g. vehicle input is only through a drop down list, and for pickup and delivery postcode a minimum character length is also specified.


Details of the service are as follows.

## Features

### 1) Simple variable prices by vehicle

Our price changes based upon the vehicle. Implement a "vehicle" attribute on the request, that takes one of the following values, applying the appropriate markup:

* bicycle: 10%
* motorbike: 15%
* parcel_car: 20%
* small_van: 30%
* large_van: 40%

For example, if the base price was 100, the `small_van` price with markup will be 130.
The vehicle should also be returned in the response, and the price should be rounded to the nearest integer.

Request:
```
{
  "pickup_postcode":   "SW1A1AA",
  "delivery_postcode": "EC2A3LT",
  "vehicle": "bicycle"
}
```
Response:
```
{
  "pickup_postcode":   "SW1A1AA",
  "delivery_postcode": "EC2A3LT"
  "vehicle": "bicycle"
  "price": 348
}
```

### 2) Build an interface for your app!

Build a webpage that makes the above call.

It should contain a form with the following fields:
`pickup_postcode`, `delivery_postcode` and `vehicle`.

Under the form, based on the response, list the price in the following format:
`A delivery from <pickup_postcode> to <delivery_postcode> using a <vehicle> will cost you £<price>.`
Substitute the variables in the <> with the appropriate values.

While the page is waiting for the response, an appropriate message should be displayed.

**Bonus**:
- Make sure that the page displays well both on smaller and larger screens, ie that is `responsive`.
- The action linked to the submit button could retrieve the data from the service without refreshing the page.

# Dependencies

`gradle`: make sure is correctly installed on your machine. `brew` can help you with the installation if you are using a Mac Machine. For Windows users you can follow the installation steps on the gradle website: https://gradle.org/install/

## Useful commands

Run tests from command line:
```
gradle test
```

Run server locally:
```
gradle bootRun
```

Make quote request:
```
echo '{"pickupPostcode": "SW1A1AA", "deliveryPostcode": "EC2A3LT" }' | \
curl -d @- http://localhost:8080/quote --header "Content-Type:application/json"
```
