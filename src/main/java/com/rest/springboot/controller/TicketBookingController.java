package com.rest.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.springboot.entities.Ticket;
import com.rest.springboot.service.TicketBookingService;

@RestController
@RequestMapping(value = "/api/tickets")
public class TicketBookingController {
@Autowired
	private TicketBookingService bookingService;
	@PostMapping(value = "/create")
	public Ticket createTicket(@RequestBody Ticket ticket) {
		return bookingService.createTicket(ticket);

	}
	@GetMapping(value = "/ticket/{tickedId}")
	public Ticket getTicketById(@PathVariable("tickedId") Integer ticketId) {
		return bookingService.getTicketById(ticketId);
	}
@GetMapping(value="/ticket/alltickes")
	public Iterable<Ticket> getAllTicket() {
		return bookingService.getAllTicket();
	}
@DeleteMapping(value="/ticket/{ticketId}")
	public void deleteTicket(@PathVariable("ticketId")Integer ticketId) {
		bookingService.deleteTicket(ticketId);
	}

	public Ticket updateTicket(Integer ticketId, String newEmail) {
		Ticket ticketFromDb = bookingService.getTicketById(ticketId);
		ticketFromDb.setEmail(newEmail);
		Ticket updateTicket = bookingService.createTicket(ticketFromDb);
		return updateTicket;
	}
}
