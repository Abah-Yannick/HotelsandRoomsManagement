package com.katanoxtest.HotelsandRoomsManagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.katanoxtest.HotelsandRoomsManagement.model.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long> {

}
