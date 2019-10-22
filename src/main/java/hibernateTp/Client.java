package hibernateTp;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.hibernate.validator.constraints.NotBlank;


@Entity
public class Client {
	
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column
	@NotBlank
	private String firstName;
	
	@Column
	@NotBlank
	private String lastName;
	
	@Enumerated(EnumType.STRING)
    @Column
	private Genre genre;
	
	@ManyToOne
	private Book book;
	
	@ManyToMany
	private List<Book> buyBookList;

	
	public Client() {
		this.id = null;
		this.firstName = null;
		this.lastName = null;
		this.genre = null;
		this.buyBookList = new ArrayList<Book>();
	}
	
	public Client(Long id, String firstName, String lastName, Genre genre) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.genre = genre;
		this.buyBookList = new ArrayList<Book>();
	}
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public List<Book> getBuyBookList() {
		return buyBookList;
	}

	public void setBuyBookList(List<Book> buyBookList) {
		this.buyBookList = buyBookList;
	}
	

}
