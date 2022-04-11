package com.tcs.service;

import java.util.List;

import com.tcs.binding.Ticket;

public interface TicketService {

	public List<Ticket> getTicket();
	
	public boolean bookTicket(Ticket ticket);
	
	public boolean cancelTicketByPnr(Integer pnr);
	
}