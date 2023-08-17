package br.com.registrationSystem.Registration;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.reservationSystem.Functions.CreateParameter;

@Entity
@Table(name="registration")
public class Registration {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_registration;
	@ManyToOne
	@JoinColumn(name="id_item")
	private Item item;
	@ManyToOne
	@JoinColumn(name="id_method")
	private PaymentMethod paymentMethod;
	private String customerName;
	
	public  Registration() {
		CreateParameter createParameter = new CreateParameter();
		this.id_registration = getId_registration();
		this.customerName = createParameter.createString("Nome: ");
		this.phone = createParameter.createString("telefone (XX) XX-XXXXX-XXXX: ");
		this.email = createParameter.createString("email: ");
		this.address = createParameter.createString("Endereço: ");
		this.payment = createParameter.createDouble("valorR$: ");
		
		
	}
	
	public String getCustomerName() {
		return customerName;
	}


	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public double getPayment() {
		return payment;
	}


	public void setPayment(double payment) {
		this.payment = payment;
	}


	public void setId_registration(long id_registration) {
		this.id_registration = id_registration;
	}


	private String phone;
	private String email;
	private String address;
	private double payment;
	
	



	public long getId_registration() {
		return id_registration;
	}



}
