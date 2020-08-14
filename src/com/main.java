package com;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class main {
	
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
				
				Category category1=new Category("Computer");
				Product laptop1=new Product("oDell","VeryGood",34000);
				Product laptop2=new Product("oApple","VeryGood",74000);
				Product laptop3=new Product("oHP","VeryGood",44000);
				Product laptop4=new Product("oLenovo","Good",34000);
				Product laptop5=new Product("oToshiba","VeryGood",54000);
				
				List<Product> list=new ArrayList<Product>();
				list.add(laptop1);
				list.add(laptop2);
				list.add(laptop3);
				list.add(laptop4);
				list.add(laptop5);
				
				category1.setProducts(list);
				
				/*	@@@@@@@   for second category	@@@@@@@ */
				
				Category category2= new Category("Tablet");
				
				Product tablet1=new Product("ot1","VeryGood",34000);
				Product tablet2=new Product("ot2","VeryGood",74000);
				Product tablet3=new Product("ot3","VeryGood",44000);
				Product tablet4=new Product("ot4","Good",34000);
				Product tablet5=new Product("ot5","VeryGood",54000);
				
				
				
				List<Product> list1 =new ArrayList<Product>();
				list1.add(tablet1);
				list1.add(tablet2);
				list1.add(tablet3);
				list1.add(tablet4);
				list1.add(tablet5);
						
		
				
				category2.setProducts(list1);
				
				session.save(category1);
				session.save(category2);
				
				
				session.getTransaction().commit();
				session.close();
		
		
	}

}
