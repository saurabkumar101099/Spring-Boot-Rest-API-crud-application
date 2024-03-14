package com.rest.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.springboot.dao.TicketBookingDAO;
import com.rest.springboot.entities.Ticket;

@Service
public class TicketBookingService {
	@Autowired
	private TicketBookingDAO bookingDAO;

	public Ticket createTicket(Ticket ticket) {
		return bookingDAO.save(ticket);

	}

	public Ticket getTicketById(Integer ticketId) {
		return bookingDAO.findById(ticketId).get();
	}

	public Iterable<Ticket> getAllTicket() {
		return bookingDAO.findAll();
	}

	public void deleteTicket(Integer ticketId) {
		bookingDAO.deleteById(ticketId);
	}

	public Ticket updateTicket(Integer ticketId, String newEmail) {
		Ticket ticketFromDb = bookingDAO.findById(ticketId).get();
		ticketFromDb.setEmail(newEmail);
		Ticket updateTicket = bookingDAO.save(ticketFromDb);
		return updateTicket;
	}
}
