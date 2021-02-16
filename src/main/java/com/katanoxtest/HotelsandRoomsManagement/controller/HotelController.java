package com.katanoxtest.HotelsandRoomsManagement.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.katanoxtest.HotelsandRoomsManagement.exception.ResourceNotFoundException;
import com.katanoxtest.HotelsandRoomsManagement.model.Hotel;
import com.katanoxtest.HotelsandRoomsManagement.repositories.HotelRepository;


@RestController
@RequestMapping("/api/v1")
public class HotelController {

	private static final Logger logger = LoggerFactory.getLogger(HotelController.class);
	@Autowired
	HotelRepository hotelRepository;

	/**
	 * Get all hotels list.
	 *
	 * @return the list
	 */
	@GetMapping("/hotels")
	public List<Hotel> getAllhotels() {
		return hotelRepository.findAll();
	}

	/**
	 * Gets hotels by id.
	 *
	 * @param hotelId the hotel id
	 * @return the hotels by id
	 * @throws ResourceNotFoundException the resource not found exception
	 */
	@GetMapping("/hotels/{id}")
	public HttpEntity<Hotel> gethotelById(@PathVariable(value = "id") Long hotelId) throws ResourceNotFoundException {
		Hotel hotel = hotelRepository.findById(hotelId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + hotelId));
		return new ResponseEntity<>(hotel, HttpStatus.OK);
	}

	/**
	 * Create hotel .
	 *
	 * @param hotel the hotel
	 * @return the hotel
	 */
	@PostMapping("/hotels")
	public Hotel createHotel(@RequestBody Hotel hotel) {
		return hotelRepository.save(hotel);
	}

	/**
	 * Update hotel response entity.
	 *
	 * @param hotelId      the hotel id
	 * @param hotelDetails the hotel details
	 * @return the response entity
	 * @throws ResourceNotFoundException the resource not found exception
	 */
	@PutMapping("/hotels/{id}")
	public ResponseEntity<Hotel> updateHotel(@PathVariable(value = "id") Long hotelId, @RequestBody Hotel hotelDetails)
			throws ResourceNotFoundException {

		Hotel hotel = hotelRepository.findById(hotelId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + hotelId));

		hotel.setCategoryName(hotelDetails.getCategoryName());
		hotel.setName(hotelDetails.getName());
		hotel.setUrl(hotelDetails.getUrl());
		hotel.setLatitude(hotelDetails.getLatitude());
		hotel.setLongitude(hotelDetails.getLongitude());
		final Hotel updatedHotel = hotelRepository.save(hotel);
		return new ResponseEntity<>(updatedHotel, HttpStatus.OK);

	}

	/**
	 * Delete user map.
	 *
	 * @param hotelId the hotel id
	 * @return the map
	 * @throws Exception the exception
	 */
	@DeleteMapping("/hotels/{id}")
	public Map<String, Boolean> deletehotel(@PathVariable(value = "id") Long hotelId) throws Exception {
		Hotel hotel = hotelRepository.findById(hotelId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + hotelId));

		hotelRepository.delete(hotel);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
