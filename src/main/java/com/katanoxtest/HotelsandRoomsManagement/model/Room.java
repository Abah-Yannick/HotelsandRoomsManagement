package com.katanoxtest.HotelsandRoomsManagement.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "room")
@EntityListeners(AuditingEntityListener.class)
public class Room {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;


	@Column
    private String type;
    
	@Column(name = "number")
	private int number;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "roomtype")
	private String roomtype;
	
	@Column(name = "cost")
	private Double cost;
	
	
	@OneToMany(cascade = CascadeType.ALL, fetch=FetchType.LAZY)
    @JoinColumn(name = "room_id")
	private List<RoomsBooked> roomsBooked;
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}


	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRoomtype() {
		return roomtype;
	}

	public void setRoomtype(String roomtype) {
		this.roomtype = roomtype;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public List<RoomsBooked> getRoomsBooked() {
		return roomsBooked;
	}

	public void setRoomsBooked(List<RoomsBooked> roomsBooked) {
		this.roomsBooked = roomsBooked;
	}
	
	
	
	



}
