
import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.bookstore.entity.Book;
import com.bookstore.entity.Category;

public class BookTest {

	public static void main(String[] args) {
		
		
		Category ct = new Category();
		ct.setCategoryId(2);
		ct.setCategoryName("code");
		
		byte[] b = new byte[] {0,1};
		
		Book b1= new Book();
		b1.setAuthor("efuhailf");
		b1.setCategory(ct);
		b1.setImage(b);
		b1.setDescription("afsfa");
		b1.setPrice(12212);
		b1.setTitle("c++");
		b1.setIsbn("sdjsjd");
//		b1.setBookId(101);
		
//		Set<Book> bSet = new HashSet<Book>();
//		bSet.add(b1);
//		
//		
//		ct.setBookSet(bSet);
		
				
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("BookStoreWebsite");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		
		
//		entityManager.persist(ct);
		entityManager.persist(b1);
		entityManager.getTransaction().commit();
		
		entityManager.close();
		entityManagerFactory.close();
		
		System.out.println("persisted");
		
	}
}