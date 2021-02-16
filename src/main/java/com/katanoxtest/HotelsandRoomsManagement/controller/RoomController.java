package com.katanoxtest.HotelsandRoomsManagement.controller;

import java.util.Date;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.katanoxtest.HotelsandRoomsManagement.exception.ResourceNotFoundException;
import com.katanoxtest.HotelsandRoomsManagement.model.Room;
import com.katanoxtest.HotelsandRoomsManagement.repositories.RoomRepository;

@RestController
@RequestMapping("/api/v1")
public class RoomController {

	private static final Logger logger = LoggerFactory.getLogger(RoomController.class);
	@Autowired
	RoomRepository roomRepository;

	/**
	 * Get all rooms list.
	 *
	 * @return the list
	 */
	@GetMapping("/rooms")
	public List<Room> getAllRooms() {
		return roomRepository.findAll();
	}
	
	// TODO 
//	/**
//	 * Get list of available rooms .
//	 *
//	 * @return the list
//	 */
//	@GetMapping("/rooms/available")
//	public List<Room> getAvailableRooms(@RequestParam("checkIn") Date checkIn,@RequestParam("checkOut") Date checkOut) {
//		return roomRepository.getAvailableRooms(checkIn, checkOut);
//	}
	

	/**
	 * Gets rooms by id.
	 *
	 * @param roomId the room id
	 * @return the rooms by id
	 * @throws ResourceNotFoundException the resource not found exception
	 */
	@GetMapping("/rooms/{id}")
	public HttpEntity<Room> getRoomById(@PathVariable(value = "id") Long roomId) throws ResourceNotFoundException {
		Room room = roomRepository.findById(roomId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + roomId));
		return new ResponseEntity<>(room, HttpStatus.OK);
	}

	/**
	 * Create room .
	 *
	 * @param room the room
	 * @return the room
	 */
	@PostMapping("/rooms")
	public Room createRoom(@RequestBody Room room) {
		return roomRepository.save(room);
	}

	/**
	 * Update room response entity.
	 *
	 * @param roomId      the room id
	 * @param roomDetails the room details
	 * @return the response entity
	 * @throws ResourceNotFoundException the resource not found exception
	 */
	@PutMapping("/rooms/{id}")
	public ResponseEntity<Room> updateRoom(@PathVariable(value = "id") Long roomId, @RequestBody Room roomDetails)
			throws ResourceNotFoundException {

		Room room = roomRepository.findById(roomId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + roomId));

		room.setCost(roomDetails.getCost());
		room.setName(roomDetails.getName());
		room.setNumber(roomDetails.getNumber());
		room.setRoomtype(roomDetails.getRoomtype());
		final Room updatedRoom = roomRepository.save(room);
		return new ResponseEntity<>(updatedRoom, HttpStatus.OK);

	}

	/**
	 * Delete user map.
	 *
	 * @param roomId the room id
	 * @return the map
	 * @throws Exception the exception
	 */
	@DeleteMapping("/rooms/{id}")
	public Map<String, Boolean> deleteRoom(@PathVariable(value = "id") Long roomId) throws Exception {
		Room room = roomRepository.findById(roomId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + roomId));

		roomRepository.delete(room);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
