package hibernateTp;

import java.util.ArrayList;
import java.util.List; 

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Book {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column
	@NotBlank
	private String title;
	
	@Column
	@NotBlank
	private String author;
	
	@OneToMany(mappedBy = "book")
	private List<Client> client;
	
	@ManyToMany(mappedBy = "buyBookList")
	private List<Client> buyBookClient;
	
	public Book() {
		this.id = null;
		this.title = null;
		this.author = null;
		this.buyBookClient = new ArrayList<Client>();
		this.client = new ArrayList<Client>();
	}

	public Book(Long id, String title, String author) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.buyBookClient = new ArrayList<Client>();
		this.client = new ArrayList<Client>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public List<Client> getClient() {
		return client;
	}

	public void setClient(List<Client> client) {
		this.client = client;
	}

	public List<Client> getBuyBookClient() {
		return buyBookClient;
	}

	public void setBuyBookClient(List<Client> buyBookClient) {
		this.buyBookClient = buyBookClient;
	}

	
	
	
}
