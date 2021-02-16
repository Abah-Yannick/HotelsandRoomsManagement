package com.katanoxtest.HotelsandRoomsManagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.katanoxtest.HotelsandRoomsManagement.model.RoomsBooked;

public interface RoomsBookedRepository extends JpaRepository<RoomsBooked, Long> {
}
