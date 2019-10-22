package hibernateTp;

import javax.persistence.EntityManager;

import hibernateTp.dao.BookDAO;
import hibernateTp.dao.ClientDAO;
import hibernateTp.model.DatabaseHelper;

public class App {

	public static void main(String[] args) {
		EntityManager em = null;
		
		/**
		 * creer book + push
		 */
		Book b1 = new Book();
		b1.setTitle("test");
		b1.setAuthor("testAussi");
		
		em = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(em);
		em.persist(b1);
		DatabaseHelper.commitTxAndClose(em);
		
		/**
		 * creer client + push
		 */
		Client c1 = new Client();
		c1.setFirstName("Didier");
		c1.setLastName("Super");
		c1.setGenre(Genre.MALE);
		
		em = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(em);
		em.persist(c1);
		DatabaseHelper.commitTxAndClose(em);
		
		
		/**
		 * creer client + livre + achat + push
		 */
		Client c2 = new Client();
		c2.setFirstName("Bruno");
		c2.setLastName("Mars");
		c2.setGenre(Genre.MALE);
		
		Book b2 = new Book();
		b2.setTitle("test2");
		b2.setAuthor("testAussi2");
		
		em = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(em);
		
		ClientDAO cdao = new ClientDAO();
		cdao.madePurchase(b2, c2);
	
		DatabaseHelper.commitTxAndClose(em);
		
		cdao.showPurchase(c2);
		
		BookDAO bdao = new BookDAO();
		bdao.showClientByBook(b2);
		
		/**
		 * purchase multiple book
		 */
		Book b3 = new Book();
		b3.setTitle("test3");
		b3.setAuthor("testAussi3");
		
		Book b4 = new Book();
		b4.setTitle("test4");
		b4.setAuthor("testAussi4");
		
		Book b5 = new Book();
		b5.setTitle("test5");
		b5.setAuthor("testAussi5");
		
		Client c3 = new Client();
		c3.setFirstName("Sylvie");
		c3.setLastName("Favier");
		c3.setGenre(Genre.FEMALE);
		
		em = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(em);
		
		cdao.madePurchase(b3, c3);
		

		DatabaseHelper.commitTxAndClose(em);
		
		em = DatabaseHelper.createEntityManager();
		bdao.showAllBookPurchase(em);
		DatabaseHelper.beginTx(em);
		bdao.showClientByBookQuery(b4, em);
		DatabaseHelper.commitTxAndClose(em);
		
		
		
		
		
		
		
		
		
		

	}

}
