package br.com.reservationSystem.DAO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="payment_methods")

public class PaymentMethod {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String methodPayment;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getMethodPayment() {
		return methodPayment;
	}
	public void setMethodPayment(String methodPayment) {
		this.methodPayment = methodPayment;
	}
}
