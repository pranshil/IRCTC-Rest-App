package com.tcs.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.tcs.binding.Ticket;
import com.tcs.repository.TrainRepo;

@Service
public class TicketServiceImpl implements TicketService {

	@Autowired
	public TrainRepo trainRepo;

	@Override
	public List<Ticket> getTicket() {
		Ticket ticket=new Ticket();
		ticket.setActiveSw("Y");
		Example<Ticket> example = Example.of(ticket);
		return trainRepo.findAll(example);
	}

	@Override
	public boolean bookTicket(Ticket ticket) {
		ticket.setActiveSw("Y");
		Ticket save = trainRepo.save(ticket);
		if (save != null) {
			return true;
		} else
			return false;
	}

	@Override
	public boolean cancelTicketByPnr(Integer pnr) {
		Optional<Ticket> findById = trainRepo.findById(pnr);
		if (findById.isPresent()) {
			Ticket ticket = findById.get();
			ticket.setActiveSw("N");
			trainRepo.save(ticket);
			return true;
		}
		return false;
	}
}
