package hibernateTp.dao;

import javax.persistence.EntityManager;

import hibernateTp.Book;
import hibernateTp.Client;
import hibernateTp.model.DatabaseHelper;


public class ClientDAO {

	/**
	 * add a book purchase to client profil first method
	 * @param book1
	 */
	public void purchase(Book book1, Client client1) {
		client1.getBuyBookList().add(book1);
		//book1.getBuyBookClient().add(client1);
	}
	
	/**
	 * purchase book made with query
	 */
	public void madePurchase(Book book1, Client client1) {
		EntityManager em = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(em);
		client1.getBuyBookList().add(book1);
		em.persist(book1);
		em.persist(client1);
		DatabaseHelper.commitTxAndClose(em);
	}

	
	/**
	 * display the purchased books
	 * @param c1
	 */
	public void showPurchase(Client c1) {
		for(Book book: c1.getBuyBookList()) {
			System.out.println("Liste des livres acheté : \nTitre : " 
		+ book.getTitle() + "\nAuteur : " + book.getAuthor() + "\n");
		}
	}
	
	
	
}
