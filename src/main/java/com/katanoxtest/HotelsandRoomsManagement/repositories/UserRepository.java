package com.katanoxtest.HotelsandRoomsManagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.katanoxtest.HotelsandRoomsManagement.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
