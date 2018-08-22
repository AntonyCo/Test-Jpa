package fr.bank;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "COMPTE")
public class Account {
	@Id
	@Column(name = "NUMERO")
	private String number;
	@Column(name = "SOLDE")
	private Double balance;
	
	@ManyToMany
	@JoinTable(name = "COMPTE_CLIENT", 
			joinColumns = @JoinColumn(name = "NUMERO_COMPTE", referencedColumnName = "NUMERO"), 
			inverseJoinColumns = @JoinColumn(name = "ID_CLIENT", referencedColumnName = "ID")
	)
	private List<Customer> customers;
	
	@OneToMany(mappedBy = "account")
	private List<Operation> operations;

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	public List<Operation> getOperations() {
		return operations;
	}

	public void setOperations(List<Operation> operations) {
		this.operations = operations;
	}
	
	
}
