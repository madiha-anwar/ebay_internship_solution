package com.example.demo.controller;

import com.example.demo.model.Quote;
import com.example.demo.model.VehicleType;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.Dictionary;
import java.util.Hashtable;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class QuoteController {
    private Integer ErrorValue = -1;

    private int getVehicleMarkup(String vehicle_name) {
        for ( VehicleType vehicle: VehicleType.values()) {
            if ( vehicle.equalsName(vehicle_name) )
                return vehicle.getMarkup();
        }
//       incase the vehicle doesn't exists
        return ErrorValue;
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/quote", method = POST)
    public @ResponseBody Quote quote(@RequestBody Quote quote) {
        if (quote.getPickupPostcode() == null || quote.getDeliveryPostcode() == null || quote.getVehicle() == null) {
            return quote;
        }

        Integer vehicleMarkup = getVehicleMarkup(quote.getVehicle());
        if (vehicleMarkup.equals(ErrorValue)) {
            return quote;
        }

        Long price = Math.abs((Long.valueOf(quote.getDeliveryPostcode(), 36) - Long.valueOf(quote.getPickupPostcode(), 36)) / 100000000);
        price += (price * vehicleMarkup / 100);

        return new Quote(quote.getPickupPostcode(), quote.getDeliveryPostcode(), quote.getVehicle(), price);
    }

    @RequestMapping(value = "/test", method= GET)
    public @ResponseBody String test_endpoint(@RequestParam String t) {
        return t;
    }

    @RequestMapping(value = "/ui", method= GET, produces = MediaType.TEXT_HTML_VALUE)
    public @ResponseBody String test_ui_endpoint() {
        return "<html></html>; this ui is for interface ?";
    }
}
