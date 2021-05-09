package tn.enis.test.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.enis.test.entities.Event;


public interface EventRepository extends JpaRepository<Event, Long> {
	
	

}
