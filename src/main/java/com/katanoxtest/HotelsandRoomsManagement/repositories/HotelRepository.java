package com.katanoxtest.HotelsandRoomsManagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.katanoxtest.HotelsandRoomsManagement.model.Hotel;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {

}
