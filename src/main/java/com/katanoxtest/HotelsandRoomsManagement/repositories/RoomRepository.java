package com.katanoxtest.HotelsandRoomsManagement.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.katanoxtest.HotelsandRoomsManagement.model.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
	
	
	// TODO 
//	@Query("SELECT r FROM Room r WHERE r.id NOT IN (SELECT rb.roomId FROM   Booking b"
//			+ "JOIN RoomsBooked rb ON b.id = rb.bookingId"
//			+ "    WHERE  (  checkIn <= @check_in AND checkOut >= @check_in)"
//			+ "           OR (checkIn < @check_out AND checkOut >= @check_out )"
//			+ "           OR (@check_in <= checkIn AND @check_out >= checkIn) "
//			+ ")")
//	 public List<Room> getCarsByidPerson(@Param("check_in")Date checkIn,@Param("check_out")Date checkOut);
	

}
