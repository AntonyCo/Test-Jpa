package fr.bank;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "VIREMENT")
public class BankTransfert extends Operation{
	@Column(name = "BENEFICIAIRE", length = 50)
	public String recipient;

	public String getRecipient() {
		return recipient;
	}

	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}
	
	
}
