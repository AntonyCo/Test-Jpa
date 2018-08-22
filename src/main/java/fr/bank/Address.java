package fr.bank;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address {
	@Column(name = "NUMERO_ADRESSE")
	private Integer number;
	@Column(name = "RUE_ADRESSE", length = 255)
	private String street;
	@Column(name = "CODE_POSTALE")
	private Integer postalCode;
	@Column(name = "VILLE", length = 255)
	private String city;
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public Integer getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(Integer postalCode) {
		this.postalCode = postalCode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	
}
