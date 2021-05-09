package tn.enis.test.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TemporalType;

import org.springframework.data.jpa.repository.Temporal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name = "EVENT")
@Data @NoArgsConstructor @AllArgsConstructor

public class Event {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
     // @Temporal(TemporalType.DATE)
	private Date datStart;
	private Date datEnd;
	
	private int prix;
	private String location;
	private String image;
	private int nbrticket;

}
