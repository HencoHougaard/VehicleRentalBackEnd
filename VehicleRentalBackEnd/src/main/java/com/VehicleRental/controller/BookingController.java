package com.VehicleRental.controller;

import com.VehicleRental.domain.Booking;
import com.VehicleRental.factories.BookingFactory;
import com.VehicleRental.services.BookingService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by L.z Double E on 11/3/2017.
 */
@RestController
@RequestMapping(value = "/booking")
public class BookingController {

    @Autowired
    private Booking booking;
    private BookingService bookingService;


    @RequestMapping(value ="/{id}/add/{pickupDate}/{returnDate}/{duration}/{availabilityFK}")
    public @ResponseBody
    String addBooking(@PathVariable String pickupDate,@PathVariable String returnDate, @PathVariable  int duration,  @PathVariable boolean availabilityFK)
    {
        Map<String, String> values = new HashMap<String, String>();
        values.put("pickupDate", pickupDate);
        values.put("returnDate", returnDate);

        Booking booking = BookingFactory.buildBooking(values, duration, availabilityFK);
        bookingService.save(booking);

        return new Gson().toJson(booking);
    }

    //Update
    @RequestMapping(value ="/{id}/update/{pickupDate}/{returnDate}/{duration}/{availabilityFK}")
    public @ResponseBody String updateBooking(@PathVariable String id, @PathVariable String pickupDate,@PathVariable String returnDate, @PathVariable  int duration,  @PathVariable boolean availabilityFK)
    {
        /**category = categoryService.read(categoryId);
         Vehicle carUpdate = new Vehicle.Builder()
         .id(id)
         .make(make)
         .model(model)
         .year(year)
         .numberPlate(numberPlate)
         .status(status)
         .category(category)
         .build();

         return carService.update(carUpdate);
         Booking bookingUpdate = BookingFactory.buildBooking(values,  duration, availabilityFK);
         bookingService.update(id);**/
        return new Gson().toJson(bookingUpdate);
    }
}
