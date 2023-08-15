package br.com.reservationSystem.DAO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="reservations")
public class Reservation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_reservation;
	@ManyToOne
	@JoinColumn(name="id_item")
	private Item item;
	@ManyToOne
	@JoinColumn(name="id_method")
	private PaymentMethod paymentMethod;
	private String customerName;
	private String phone;
	private String email;
	private String address;
	private double payment;
	
	

}
