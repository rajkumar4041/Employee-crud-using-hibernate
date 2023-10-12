package com.sessionFactory;

import java.util.HashMap;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;

import com.model.Employee;
import com.model.Payment;
import com.model.Perk;
import com.model.Product;

public class hibernateUtil {
	public static StandardServiceRegistry registry;
	public static SessionFactory sf;

	public static SessionFactory getFactory() {

		if (sf == null) {
			HashMap<String, Object> hmap = new HashMap<String, Object>();
			hmap.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
			hmap.put(Environment.URL, "jdbc:mysql://localhost:3306/hbmCRUDApp");
			hmap.put(Environment.USER, "root");
			hmap.put(Environment.PASS, "");
			
			hmap.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
			hmap.put(Environment.HBM2DDL_AUTO, "update");
			hmap.put(Environment.SHOW_SQL, true);
			System.out.println("______________________________________________________________________________________");
			registry = new StandardServiceRegistryBuilder().applySettings(hmap).build();
			MetadataSources mds = new MetadataSources(registry).addAnnotatedClass(Employee.class).addAnnotatedClass(Product.class).addAnnotatedClass(Perk.class).addAnnotatedClass(Payment.class);

			Metadata md = mds.getMetadataBuilder().build();
			sf = md.buildSessionFactory();
			return sf;
		}

		return sf;
	}
}
