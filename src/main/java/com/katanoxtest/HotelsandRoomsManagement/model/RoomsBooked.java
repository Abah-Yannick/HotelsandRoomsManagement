package com.katanoxtest.HotelsandRoomsManagement.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "rooms_booked")
@EntityListeners(AuditingEntityListener.class)
public class RoomsBooked {
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
	
    @Column(name = "booking_id", nullable = false)
    private long bookingId;
    
    @Column(name = "room_id", nullable = false)
    private long roomId;
    
    
    

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getBookingId() {
		return bookingId;
	}

	public void setBookingId(long bookingId) {
		this.bookingId = bookingId;
	}

	public long getRoomId() {
		return roomId;
	}

	public void setRoomId(long roomId) {
		this.roomId = roomId;
	}

    
    
    

}
