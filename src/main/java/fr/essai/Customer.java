package fr.essai;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="CLIENT")
public class Customer {
	@Id
	private Integer id;
	@Column(name = "NOM", length = 50, nullable = false)
	private String lastname;
	@Column(name = "PRENOM", length = 50, nullable = false)
	private String firstname;
	@OneToMany(mappedBy = "customer")
	private List<Loaning> loanings;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public List<Loaning> getLoanings() {
		return loanings;
	}
	public void setLoanings(List<Loaning> loanings) {
		this.loanings = loanings;
	}
	
	
}