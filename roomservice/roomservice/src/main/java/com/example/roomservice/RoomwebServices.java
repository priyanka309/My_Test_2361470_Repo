package com.example.roomservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rooms")
public class RoomwebServices {
	
	RoomRepository roomRepository;
	
	public RoomwebServices(RoomRepository roomRepository) {
		super();
		this.roomRepository = roomRepository;
	}

	@GetMapping
	public Iterable<Room> getAllRooms(){
		return roomRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Room getAllRoomById(@PathVariable("id") long id){
		return roomRepository.findById(id).get();
	}
}
