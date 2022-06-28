package com.example.reservationservice;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reservations")
public class ReservationWebServices {
	
	private ReservationRepository reservationRepository;
	
	public ReservationWebServices(ReservationRepository reservationRepository) {
		super();
		this.reservationRepository = reservationRepository;
	}

	@GetMapping
	public Iterable<Reservation> getReservations(){
		return reservationRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Reservation getReservationById(@PathVariable("id") long id) {
		
		return reservationRepository.findById(id).get();
		
	}
}
