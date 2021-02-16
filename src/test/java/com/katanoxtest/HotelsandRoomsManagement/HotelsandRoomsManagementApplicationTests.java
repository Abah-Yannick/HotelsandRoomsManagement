package com.katanoxtest.HotelsandRoomsManagement;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;

import com.katanoxtest.HotelsandRoomsManagement.model.Hotel;
import com.katanoxtest.HotelsandRoomsManagement.model.Room;
import com.katanoxtest.HotelsandRoomsManagement.model.User;




@RunWith(SpringRunner.class)
@SpringBootTest(classes = HotelsandRoomsManagementApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HotelsandRoomsManagementApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;

	@LocalServerPort
	private int port;

	private String getRootUrl() {
		return "http://localhost:" + port;
	}

	@Test
	public void contextLoads() {
	}

	@Test
	public void testGetAllUsers() {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/users",
				HttpMethod.GET, entity, String.class);

		Assert.assertNotNull(response.getBody());
	}
	
	@Test
	public void testGetAllRooms() {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/rooms",
				HttpMethod.GET, entity, String.class);

		Assert.assertNotNull(response.getBody());
	}
	
	@Test
	public void testGetAllHotels() {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/rooms",
				HttpMethod.GET, entity, String.class);

		Assert.assertNotNull(response.getBody());
	}

	@Test
	public void testGetUserById() {
		User user = restTemplate.getForObject(getRootUrl() + "/users/1", User.class);
		System.out.println(user.getFirstName());
		Assert.assertNotNull(user);
	}
	
	@Test
	public void testGetRoomById() {
		Room room = restTemplate.getForObject(getRootUrl() + "/rooms/1", Room.class);
		System.out.println(room.getName());
		Assert.assertNotNull(room);
	}
	
	@Test
	public void testGetHotelById() {
		Hotel hotel = restTemplate.getForObject(getRootUrl() + "/hotels/1", Hotel.class);
		System.out.println(hotel.getName());
		Assert.assertNotNull(hotel);
	}



	@Test
	public void testCreateUser() {
		User user = new User();
		user.setEmail("admin@gmail.com");
		user.setFirstName("admin");
		user.setLastName("admin");
		user.setCreatedBy("admin");
		user.setUpdatedBy("admin");

		ResponseEntity<User> postResponse = restTemplate.postForEntity(getRootUrl() + "/users", user, User.class);
		Assert.assertNotNull(postResponse);
		Assert.assertNotNull(postResponse.getBody());
	}
	
	@Test
	public void testCreateRoom() {
		Room room = new Room();
		room.setCost(200.00);
		room.setName("AFRICA");
		room.setNumber(200);
		room.setRoomtype("PREMIUM");

		ResponseEntity<Room> postResponse = restTemplate.postForEntity(getRootUrl() + "/rooms", room, Room.class);
		Assert.assertNotNull(postResponse);
		Assert.assertNotNull(postResponse.getBody());
	}
	
	@Test
	public void testCreateHotel() {
		Hotel hotel = new Hotel();
		hotel.setUrl("hotelUrlTest");
		hotel.setDescription("hotelDescTest");
		hotel.setName("hotelNameTest");

		ResponseEntity<Hotel> postResponse = restTemplate.postForEntity(getRootUrl() + "/hotels", hotel, Hotel.class);
		Assert.assertNotNull(postResponse);
		Assert.assertNotNull(postResponse.getBody());
	}
	
	@Test
	public void testUpdateUserPost() {
		int id = 1;
		User user = restTemplate.getForObject(getRootUrl() + "/users/" + id, User.class);
		user.setFirstName("admin1");
		user.setLastName("admin2");

		restTemplate.put(getRootUrl() + "/users/" + id, user);

		User updatedUser = restTemplate.getForObject(getRootUrl() + "/users/" + id, User.class);
		Assert.assertNotNull(updatedUser);
	}
	
	@Test
	public void testUpdateHotelPost() {
		int id = 1;
		Hotel hotel = restTemplate.getForObject(getRootUrl() + "/hotels/" + id, Hotel.class);
		hotel.setUrl("hotelUrlTest1");
		hotel.setDescription("hotelDescTest1");
		hotel.setName("hotelNameTest1");
		restTemplate.put(getRootUrl() + "/hotels/" + id, hotel);

		Hotel updatedHotel = restTemplate.getForObject(getRootUrl() + "/users/" + id, Hotel.class);
		Assert.assertNotNull(updatedHotel);
	}
	
	@Test
	public void testUpdateRoomPost() {
		int id = 1;
		Room room = restTemplate.getForObject(getRootUrl() + "/rooms/" + id, Room.class);
		room.setCost(500.00);
		room.setName("ASIA");
		room.setNumber(200);
		room.setRoomtype("GOLD");

		restTemplate.put(getRootUrl() + "/rooms/" + id, room);

		Room updatedRoom = restTemplate.getForObject(getRootUrl() + "/rooms/" + id, Room.class);
		Assert.assertNotNull(updatedRoom);
	}

	@Test
	public void testDeleteUserPost() {
		int id = 2;
		User user = restTemplate.getForObject(getRootUrl() + "/users/" + id, User.class);
		Assert.assertNotNull(user);

		restTemplate.delete(getRootUrl() + "/users/" + id);

		try {
			user = restTemplate.getForObject(getRootUrl() + "/users/" + id, User.class);
		} catch (final HttpClientErrorException e) {
			Assert.assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
		}
	}
	
	@Test
	public void testDeleteRoomPost() {
		int id = 2;
		Room room = restTemplate.getForObject(getRootUrl() + "/rooms/" + id, Room.class);
		Assert.assertNotNull(room);

		restTemplate.delete(getRootUrl() + "/rooms/" + id);

		try {
			room = restTemplate.getForObject(getRootUrl() + "/rooms/" + id, Room.class);
		} catch (final HttpClientErrorException e) {
			Assert.assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
		}
	}
	
	@Test
	public void testDeleteHotelPost() {
		int id = 2;
		Hotel hotel = restTemplate.getForObject(getRootUrl() + "/hotels/" + id, Hotel.class);
		Assert.assertNotNull(hotel);

		restTemplate.delete(getRootUrl() + "/hotels/" + id);

		try {
			hotel = restTemplate.getForObject(getRootUrl() + "/hotels/" + id, Hotel.class);
		} catch (final HttpClientErrorException e) {
			Assert.assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
		}
	}

}
