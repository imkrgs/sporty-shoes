package com.learn.mycart.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.learn.mycart.entities.Product;
import com.learn.mycart.entities.purchaseReport;

public class purchaseReportDao {
	private SessionFactory factory;

	public purchaseReportDao(SessionFactory factory) {
		this.factory = factory;
	}

	public boolean saveProduct(Product product) {
		boolean f = false;

		try {

			Session session = this.factory.openSession();
			Transaction tx = session.beginTransaction();

			session.save(product);
			f = true;

			tx.commit();
			session.close();

		} catch (Exception e) {
			e.printStackTrace();
			f = false;
		}
		return f;
	}
	
	public int setPurchaseReport(purchaseReport pr ) {
		Session session = this.factory.openSession();
		session.beginTransaction();
		 //Save the employee in database
	    session.save(pr);
	 
	    //Commit the transaction
	    session.getTransaction().commit();
		return 1;
	}
	
	public List<purchaseReport> getAllPurchaseReport() {
		Session s = this.factory.openSession();
		@SuppressWarnings("unchecked")
		Query<purchaseReport> query = s.createQuery("from purchaseReport");
		List<purchaseReport> list = query.list();
		return list;

	}
}
