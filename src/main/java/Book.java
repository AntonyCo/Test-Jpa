import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="LIVRE")
public class Book {
	@Id
	private Integer id;
	@Column(name = "TITRE", length = 255, nullable = false)
	private String title;
	@Column(name = "AUTEUR", length = 50, nullable = false)
	private String author;
	@ManyToMany(mappedBy = "books")
	private List<Loaning> loanings;
	public int getId() {
		return id;
	}

	public void setId(int id) {
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
	
	
}
