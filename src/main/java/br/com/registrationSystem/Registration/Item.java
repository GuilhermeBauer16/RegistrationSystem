package br.com.registrationSystem.Registration;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.Table;

import br.com.registrationSystem.Util.JPAUtil;

@Entity
@Table(name = "itens")
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_item")
	private long id;
	@Column(name="name_item")
	private String nameItem;
	
	public void showItens() {
		EntityManager entityManager = new JPAUtil().getEntityManager();
		String jpql = "SELECT i FROM Item i";
		Query query = entityManager.createQuery(jpql);
		List<Item> itens = query.getResultList();
		entityManager.close();
        System.out.println("=".repeat(42));
        System.out.println("ID  |            Nome do Item            |");
        System.out.println("=".repeat(42));
        
        for (Item item : itens) {
        	 System.out.printf("%-4d| %-35s|%n",
                     item.getId(),
                     item.getNameItem()
             );
        	
        }
        System.out.println("=".repeat(42));
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNameItem() {
		return nameItem;
	}

	public void setNameItem(String nameItem) {
		this.nameItem = nameItem;
	}

	

}
