package com.trackfic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trackfic.model.Location;
import com.trackfic.service.LocationServiceImpl;

@RestController
@RequestMapping("/location")
@CrossOrigin
public class LocationController {

	@Autowired
	LocationServiceImpl locationService;

	@GetMapping("/locations")
	public List<Location> getAllLocations() {

		List<Location> locations = locationService.getAllLocations();
		return locations;
	}

//	Currently unimplemented in front end so hiding end point	
//	
//	@GetMapping("/{id}")
//	public Location getLocationById(@PathVariable int id)
//	{
//		Location location = locationService.getLocationById(id);
//		return location;
//	}

	@PostMapping("/add")
	public Location addLocation(@RequestBody Location location) {
		Location location1 = locationService.addNewLocation(location);
		return location1;
	}

//	Currently unimplemented in front end so hiding end point	
//	
//	@PutMapping("{id}")
//	public Location updateLocation(@PathVariable int id, @RequestBody Location location)
//	{
//		Location location1 = locationService.updateLocationData(id, location);
//		return location1;
//		
//	}

	@DeleteMapping("/{id}")
	public void deleteLocation(@PathVariable int id) {
		locationService.deleteLocation(id);

	}

}
