import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.bookstore.entity.Book;
import com.bookstore.entity.Category;

public class MainTest {

	public static void main(String[] args) {
		
//		StandardServiceRegistry standardServiceRegistry = new StandardServiceRegistryBuilder().configure().loadProperties("hibernate.cfg.xml").build();
//		SessionFactory sf = new Configuration().buildSessionFactory(standardServiceRegistry);
//		OR
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure("src/com/bookstore/cfg/hibernate.cfg.xml").build();
		SessionFactory sessionFactory = new Configuration().buildSessionFactory(serviceRegistry);
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
//		User user = new User();
//		user.setFullName("Mr sdsf");
//		user.setEmail("hasdja@gmail.com");
//		user.setPassword("kjhdasdjk");
//		session.save(user);
//		System.out.println("Success!");

//		create category
		Category ct = new Category();
//		ct.setCategoryId(1);
		ct.setCategoryName("java");
		
		
		
//		create books
		Book bk = new Book();
		bk.setTitle("First Comic");
		bk.setAuthor("Sierra");
		bk.setDescription("Clear Java programming for beginners");
		bk.setIsbn("SD3434");
		bk.setImage(new byte[] {0,1});
		bk.setPrice(100);
//		set category
		bk.setCategory(ct);	
		
//		add books into set
//		Set<Book> books = new HashSet<Book>();
//		books.add(bk);
		
//		set books into category
//		ct.setBooks(books);
		
		session.save(ct);
		
		System.out.println("Inserted!");
		
		transaction.commit();
		session.close();
		sessionFactory.close();

	}

}
