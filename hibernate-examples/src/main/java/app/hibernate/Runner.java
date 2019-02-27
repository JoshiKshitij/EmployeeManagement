package app.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Runner {

	public static void main(String[] args) {
		Configuration configuration = new Configuration();
		configuration.configure();

		SessionFactory buildSessionFactory = configuration.buildSessionFactory();
		Session session = buildSessionFactory.openSession();
		session.beginTransaction();
		StudentDto s1 = new StudentDto("Kshitij", "ece");

		Address home = new Address("171109", "street 24-7");
		Address office = new Address("123123", "street 19");

		s1.setHomeAddress(home);
		s1.setOfficeAddress(office);

		session.save(s1);

		session.getTransaction().commit();

	}
}
