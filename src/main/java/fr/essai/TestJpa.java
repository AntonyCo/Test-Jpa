package fr.essai;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import fr.bank.Account;
import fr.bank.Address;
import fr.bank.Bank;
import fr.bank.Operation;

public class TestJpa {

	public static void main(String[] args) {
		StringBuilder strb = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pu_essai");
		EntityManager em = entityManagerFactory.createEntityManager();
		
		int choice = 0;
		while(choice != 99){
			displayMenu();
			choice = sc.nextInt();
			switch(choice){
			case 1:
				System.out.println("1. Enter book id (1 -5)");
				int idBook = sc.nextInt();
				Book book = em.find(Book.class, idBook);
				if(book != null){
					strb.setLength(0);
					strb.append(book.getId());
					strb.append(": ");
					strb.append(book.getTitle());
					strb.append(" - ");
					strb.append(book.getAuthor());
					System.out.println(strb);
				}
				break;
			case 2:
				System.out.println("2. Enter book title");
				sc.nextLine();
				String title = sc.nextLine();
				System.out.println();
				TypedQuery<Book> query = em.createQuery("select b from Book b where b.title='"+title+"'", Book.class);
				Book bookFromQuery = query.getResultList().get(0);

				strb.setLength(0);
				strb.append(bookFromQuery.getId());
				strb.append(": ");
				strb.append(bookFromQuery.getTitle());
				strb.append(" - ");
				strb.append(bookFromQuery.getAuthor());
				System.out.println(strb);
				break;
			case 3:
				//Réaliser une requête qui permet d’extraire un emprunt et tous ses livres associés.
				System.out.println("3. Enter loaning id (1-5)");
				int idLoaning = sc.nextInt();
				TypedQuery<Loaning> queryLoaning = em.createQuery("select l from Loaning l where l.id = :idLoaning", Loaning.class);
				queryLoaning.setParameter("idLoaning", idLoaning);
				Loaning loaningFromQuery = queryLoaning.getResultList().get(0);
				for(Book b : loaningFromQuery.getBooks()){
					strb.setLength(0);
					strb.append("Loaning n°"+loaningFromQuery.getId());
					strb.append("| Book n°");
					strb.append(b.getId());
					strb.append(": ");
					strb.append(b.getTitle());
					strb.append(" - ");
					strb.append(b.getAuthor());
					System.out.println(strb);
				}
				break;
			case 4:
				//Réaliser une requête qui permet d’extraire tous les emprunts d’un client donné.
				System.out.println("4. Enter customer id (1-3)");
				int idCustomer = sc.nextInt();
				TypedQuery<Customer> queryCustomer = em.createQuery("select c from Customer c where c.id = :idCustomer", Customer.class);
				queryCustomer.setParameter("idCustomer", idCustomer);
				Customer customerFromQuery = queryCustomer.getResultList().get(0);
				for(Loaning loa : customerFromQuery.getLoanings()){
					strb.setLength(0);
					strb.append("Customer n°"+customerFromQuery.getId());
					strb.append("| ");
					strb.append(loa.getFirstDate());
					strb.append(" -> ");
					strb.append(loa.getLastDate());
					strb.append(" - ");
					strb.append("time: ");
					strb.append(loa.getTimeLimit());
					System.out.println(strb);
				}
				break;
			case 5:
				//TP 4 
				System.out.println("Begininng generation...");
				EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu_bank");
				EntityManager entm = emf.createEntityManager();
				EntityTransaction et = entm.getTransaction();
				et.begin();
				
				Bank b = new Bank();
				b.setName("Crédit Agricole");

				Address a = new Address();
				a.setCity("Lozanne");
				a.setNumber(45);
				a.setPostalCode(69380);
				a.setStreet("Rue des cerisiers");
				
				Account acc = new Account();
				acc.setBalance(1000d);
				acc.setNumber("000AC");
				
				Operation op = new Operation();
				op.setAccount(acc);
				op.setAmount(100d);
				op.setDate(LocalDateTime.now());
				op.setReason("Test");
				List<Operation> opList = new ArrayList<>();
				opList.add(op);
				acc.setOperations(opList);
				
				fr.bank.Customer c = new fr.bank.Customer();
				c.setFirstname("Antony");
				c.setLastname("Correoso");
				c.setDateOfBirth(LocalDate.of(1994, 02, 14));
				c.setBank(b);
				c.setAddress(a);
				
				List<fr.bank.Customer> cList = new ArrayList<>();
				cList.add(c);
				b.setCustomers(cList);
				acc.setCustomers(cList);
				
				List<Account> accList = new ArrayList<>();
				accList.add(acc);
				c.setAccounts(accList);
				
				entm.persist(b);
				entm.persist(acc);
				entm.persist(op);
				entm.persist(c);

				et.commit();
				entm.close();
				emf.close();
				break;
			case 99:
				sc.close();
				em.close();
				entityManagerFactory.close();
				System.out.println("Bye :)");
				break;
			}
		}
	}

	public static void displayMenu(){
		System.out.println("----- Menu -----");
		System.out.println("1. Find a book with id");
		System.out.println("2. Find a book with title");
		System.out.println("3. Find a loaning and display its books");
		System.out.println("4. Find a customer and dispaly its loanings");
		System.out.println("5. TP 4 - Generate table from JPA");
		System.out.println("99. Exit");
	}
}
