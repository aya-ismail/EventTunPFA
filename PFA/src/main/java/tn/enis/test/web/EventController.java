package tn.enis.test.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.enis.test.entities.Event;
import tn.enis.test.exceptions.ResourceNotFoundException;
import tn.enis.test.repositories.EventRepository;

@RestController
@RequestMapping("/api/v1/")
public class EventController {

	@Autowired
	private EventRepository eventRepository;

	@GetMapping("/events")
	public List<Event> events() {
		return eventRepository.findAll();
	}

	// create event rest api
	@PostMapping("/events")
	public Event createEvent(@RequestBody Event event) {
		return eventRepository.save(event);
	}

	// get event by id rest api
	@GetMapping("/events/{id}")
	public ResponseEntity<Event> getEventById1(@PathVariable Long id) {
		Event event = eventRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("event not exist with id:" + id));
		return ResponseEntity.ok(event);
	}

	// update employee rest api

	@PutMapping(value = "/events/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Event> updateEvent(@PathVariable Long id, @RequestBody Event eventDetails) {
		Event event = eventRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("event not exist with id:" + id));

		event.setName(eventDetails.getName());
		Event updateEvent = eventRepository.save(event);
		return ResponseEntity.ok(updateEvent);
	}

	// delete organizers rest api
	@DeleteMapping("/events/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteOrganizer(@PathVariable Long id) {
		Event event = eventRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Eventnot exist with id:" + id));
		eventRepository.delete(event);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);

	}
}
