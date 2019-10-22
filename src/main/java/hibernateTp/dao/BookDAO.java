package hibernateTp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import hibernateTp.Book;
import hibernateTp.Client;

public class BookDAO {
	
	
	

	/**
	 * show client by book first method
	 * @param book1
	 */
	public void showClientByBook(Book book1) {
		for(Client client : book1.getBuyBookClient()) {
			System.out.println("Acheteur du livre : " + book1.getTitle() + "\n" 
		+ "\n----------\nNom : " + client.getLastName() + "\nPrenom : " + client.getFirstName());
		}
	}
	
	
	/**
	 * show all book purchased query method
	 * @param em
	 */
	public void showAllBookPurchase(EntityManager em) {
		TypedQuery<Book> query = em.createQuery("select b FROM Book b join b.buyBookClient", Book.class);
		List<Book> bookTemp = query.getResultList();
		
		System.out.println("Liste des livres vendus : \n");
		
		for(Book book: bookTemp) {
			System.out.println("Titre :" + book.getTitle());
			System.out.println("Auteur :" + book.getAuthor() + "\n");
		}
	}
	
	
	/**
	 * show client by book second method (query)
	 * @param book1
	 * @param em
	 */
	public void showClientByBookQuery(Book book1, EntityManager em) {
		TypedQuery<Client> query = em.createQuery("select c FROM Client c join c.buyBookList b where b.id=:id ", Client.class);
		query.setParameter("id", book1.getId());
		List<Client> clientTemp = query.getResultList();
		System.out.println("------------\nclient ayant acheté le livre : " + book1.getTitle() + "\n");
		for(Client client: clientTemp) {
			System.out.println("Nom :" + client.getFirstName());
			System.out.println("Prenom :" + client.getLastName() + "\n");
		}
		
		
	}

}
