package tn.enis.test;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import tn.enis.test.entities.Event;
import tn.enis.test.repositories.EventRepository;

@SpringBootApplication
public class PfaApplication implements CommandLineRunner {

	@Autowired
	private EventRepository eventRepository;

	public static void main(String[] args) {
		SpringApplication.run(PfaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		eventRepository.save(new Event(null, "Lorem Ipsum", new Date(), new Date(), 0, "ENIS", "", 30));
		eventRepository.save(new Event(null, "Xtreem", new Date(), new Date(), 0, "ENIS", "", 30));
		eventRepository.save(new Event(null, "hello word", new Date(), new Date(), 0, "ENIS", "", 30));
		eventRepository.save(new Event(null, "NMTC", new Date(), new Date(), 0, "ENIS", "", 30));

		eventRepository.findAll().forEach(p -> {
			System.out.println(p.toString());
		});
		
		System.out.println("***********************");
        
	}

}
