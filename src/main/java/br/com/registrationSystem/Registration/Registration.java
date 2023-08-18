package br.com.registrationSystem.Registration;
import javax.persistence.EntityManager;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.registrationSystem.Functions.CreateParameter;

@Entity
@Table(name="registration")
public class Registration {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String customerName;
	private int age;
	private String phone;
	private String email;
	private String address;

	public Registration  registration() {
		CreateParameter createParameter = new CreateParameter();

		this.customerName = createParameter.createString("Nome: ");
		this.setAge(createParameter.createInt("Sua idade: "));
		this.phone = createParameter.createString("telefone (XX) XX-XXXXX-XXXX: ");
		this.email = createParameter.createString("email: ");
		this.address = createParameter.createString("Endereço: ");
		return this;

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


	public void setId_registration(long id_registration) {
		this.id = id_registration;
	}



	public long getId_registration() {
		return id;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}



}
