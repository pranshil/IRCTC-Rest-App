package com.tcs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.binding.Ticket;
import com.tcs.repository.TrainRepo;
import com.tcs.service.TicketService;

@RestController
public class TrainController {

	@Autowired
	public TicketService service;

	@PostMapping("/booking")
	public String newTicketGenerator(@RequestBody Ticket ticket) {
		boolean status = service.bookTicket(ticket);
		if (status) {
			return "Ticket Generated Successfully...";
		}
		return "Failed to Generate";
	}

	@GetMapping("/ticket")
	public List<Ticket> viewTicket(@RequestBody Ticket ticket) {
		List<Ticket> list = service.getTicket();
		return list;
	}

	@PostMapping("/cancel/{pnr}")
	public String cancelTicket(@PathVariable("pnr") Integer pnr) {

		boolean status = service.cancelTicketByPnr(pnr);
		if (status) {
			return "Ticket Cancelled Successfully...";
		}
		return "Failed to Cancel...";
	}
}
