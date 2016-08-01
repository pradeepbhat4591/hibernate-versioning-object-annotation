package com.pradeep.hibernate.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import com.pradeep.hibernate.model.Student;

public class TestHibernateVersioning {

	public static void main(String[] args) {

		Session session = new AnnotationConfiguration().configure()
				.buildSessionFactory().openSession();

		// creating transaction object
		Transaction t = session.beginTransaction();
		Student student = new Student();
		student.setId(62);
		student.setName("Rahul");
		student.setBranch("Mech");
		student.setEmail("rahul@gmail.com");
		student.setPercentage(98);
		student.setPhone(9009166);

		session.persist(student);// persisting the object
		student.setEmail("df@goal.com");
		session.persist(student);

		t.commit();// transaction is committed
		session.close();

		System.out.println("successfully saved");

	}

}
