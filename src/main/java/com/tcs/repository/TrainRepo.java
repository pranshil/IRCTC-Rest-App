package com.tcs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcs.binding.Ticket;

public interface TrainRepo extends JpaRepository<Ticket, Integer>{
 
}
