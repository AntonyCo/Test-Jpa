package fr.essai;
import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "EMPRUNT")
public class Loaning {
	@Id
	private Integer id;
	@Column(name = "DATE_DEBUT", nullable = false)
	private Date firstDate;
	@Column(name = "DATE_FIN")
	private Date lastDate;
	@Column(name = "DELAI", length = 10)
	private Integer timeLimit;
	@Column(name = "ID_CLIENT", length = 10)
	private Integer idClient;
	@ManyToMany
	@JoinTable(name = "COMPO", 
			joinColumns = @JoinColumn(name = "ID_EMP", referencedColumnName = "ID", insertable=false, updatable=false), 
			inverseJoinColumns = @JoinColumn(name = "ID_LIV", referencedColumnName = "ID", insertable=false, updatable=false)
	)
	private List<Book> books;
	@ManyToOne
	@JoinColumn(name = "ID_CLIENT", insertable=false, updatable=false)
	private Customer customer;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getFirstDate() {
		return firstDate;
	}
	public void setFirstDate(Date firstDate) {
		this.firstDate = firstDate;
	}
	public Date getLastDate() {
		return lastDate;
	}
	public void setLastDate(Date lastDate) {
		this.lastDate = lastDate;
	}
	public Integer getTimeLimit() {
		return timeLimit;
	}
	public void setTimeLimit(Integer timeLimit) {
		this.timeLimit = timeLimit;
	}
	public Integer getIdClient() {
		return idClient;
	}
	public void setIdClient(Integer idClient) {
		this.idClient = idClient;
	}
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
}