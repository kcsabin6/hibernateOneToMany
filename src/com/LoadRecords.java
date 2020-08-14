package com;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class LoadRecords {
	
	public static void main(String[] args) {
		
		// loads configuration and mappings
				Configuration configuration = new Configuration().configure();
				ServiceRegistryBuilder registry = new ServiceRegistryBuilder();
				registry.applySettings(configuration.getProperties());
				ServiceRegistry serviceRegistry = registry.buildServiceRegistry();
				
				// builds a session factory from the service registry
				SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
				
				// obtains the session
				Session session = sessionFactory.openSession();
				session.beginTransaction();
				
		Category c = (Category) session.get(Category.class, 3l);
		System.out.println("category is "+c);//associated products are printed too
		List<Product> plist=c.getProducts();
		//System.out.println("list of product is "+plist);
		System.out.println("second product is "+plist.get(1));
		
		//Accessing parent from child..............WRONG...not possible
		/*System.out.println(plist.get(1));
		Product p =(Product)session.get(Product.class,5L);
		System.out.println(p);
		System.out.println(p.getCategory().getName());*/
				
				
				session.getTransaction().commit();
				session.close();
		
		
	}

}
