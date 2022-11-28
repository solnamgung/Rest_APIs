package com.udacity.bootstrap.web;

import com.udacity.bootstrap.entity.Location;
import com.udacity.bootstrap.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
/**
 * This marks a class as a REST API.
 * @RestController is a convenience annotation that combines @Controller and @ResponseBody.
 */
@RestController
public class LocationController {
    private LocationService locationService;

    @Autowired
    public void setLocationService(LocationService locationService) {
        this.locationService = locationService;
    }

    /**
     * This annotation handles HTTP GET requests
     * and acts as a shortcut for @RequestMapping (method = RequestMethod.GET)
     */
    @GetMapping("/location")
    public ResponseEntity<List<Location>> getAllLocations() {
        List<Location> list = locationService.retrieveLocations();
        return new ResponseEntity<List<Location>>(list, HttpStatus.OK);
    }

}
