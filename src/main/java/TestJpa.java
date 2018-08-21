import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class TestJpa {

	public static void main(String[] args) {
		StringBuilder strb = new StringBuilder();
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pu_essai");
		EntityManager em = entityManagerFactory.createEntityManager();
		Book book = em.find(Book.class, 1);
		if(book != null){
			strb.setLength(0);
			strb.append(book.getId());
			strb.append(": ");
			strb.append(book.getTitle());
			strb.append(" - ");
			strb.append(book.getAuthor());
			System.out.println(strb);
		}
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter title (ex: Germinal):");
		String title = sc.nextLine();
		TypedQuery<Book> query = em.createQuery("select b from Book b where b.title='"+title+"'", Book.class);
		Book bookFromQuery = query.getResultList().get(0);
		
		strb.setLength(0);
		strb.append(bookFromQuery.getId());
		strb.append(": ");
		strb.append(bookFromQuery.getTitle());
		strb.append(" - ");
		strb.append(bookFromQuery.getAuthor());
		System.out.println(strb);
		
		em.close();
		entityManagerFactory.close();
	}

}
 