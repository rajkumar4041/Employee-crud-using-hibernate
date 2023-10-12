package com.dao;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import javax.persistence.PersistenceException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.model.Employee;
import com.sessionFactory.hibernateUtil;

public class EmployeeDao {
	public static int length = 0;

	static Employee e = new Employee();

//	public Employee getE() {
//		return e;
//	}
//
//	public void setE(Employee e) {
//		this.e = e;
//	}

	public static SessionFactory sf = hibernateUtil.getFactory();

	public static boolean create() {
		try {
			Session session1 = sf.openSession();
			session1.save(e);

			session1.beginTransaction().commit();
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public static void insert() {
		Scanner sc = new Scanner(System.in);
		int a = 10;
		do {
			try {
				Session session6 = sf.openSession();

				System.out.println("enter id :");
				e.setEid(sc.nextInt());// ab10
				System.out.println("enter name :");
				e.setEname(sc.next());
				System.out.println("enter Adress :");
				e.setEadd(sc.next());

				session6.save(e);
				session6.beginTransaction().commit();
				System.out.println("-----------------------------------------------------------");
				System.out.println("|     DATA INSERTED SUCCESSFULLY   		  |");
				System.out.println("-----------------------------------------------------------");

				System.out.println("press 1. INSERT MORE DATA ");
				System.out.println("press any other key : for exit'");
				a = sc.nextInt();

			} catch (PersistenceException e1) {
				System.out.println("duplicate id : please enter valid id  ");
				System.out.println("press 1. try again ");
				System.out.println("press any other key : for exit'");
				a = sc.nextInt();
			} catch (InputMismatchException e2) {
				System.out.println("------------------------------");
				System.out.println("enter valid datatype of field ");
				System.out.println("press 1. try again ");
				System.out.println("press any other key : for exit'");
//				sc.nextInt();
				a = sc.nextInt();
				System.out.println("------------------------------");
			}
		} while (a == 1);

	}

	public static void read(int id) {

		Session session2 = sf.openSession();

		Employee a = session2.get(Employee.class, id);
		System.out.println(a);
		session2.beginTransaction().commit();
		if (a == null) {
			System.out.println("duplicate id : please enter valid id  ");
			System.out.println("press 1. try again ");
			System.out.println("press any other key . for exit'");
		}

	}

	public static void update() {
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("enter id to check in database and update its value :");
			try {
				int ac2 = sc.nextInt();
				e.setEid(ac2);

				if (checkId(ac2)) {
					System.out.println("1. update_name   2.update_address ");
					Session session3 = sf.openSession();
					switch (sc.nextInt()) {
					case 1: {
						EmployeeDao.update_name(session3);
						break;
					}
					case 2: {
						EmployeeDao.update_address(session3);
						break;
					}
					default:
						throw new IllegalArgumentException("Unexpected value: " + sc.nextInt());
					}
//				
				} else {
					System.out.println("id does not match");
				}

				System.out.println("");
				System.out.println("press 1. update more ");
				System.out.println("press any other key : for exit'");
			} catch (Exception e1) {
				System.out.println("duplicate id : please enter valid id  ");
				System.out.println("press 1. try again ");
				System.out.println("press any other key : for exit'");
			}
		} while (sc.nextInt() == 1);

	}

	public static boolean checkId(int a) {
		Session session8 = sf.openSession();
//
//		Query<Employee> qry = session8.createQuery("from Employee");
//		List<Employee> emplist = qry.getResultList();
//		for (Employee s : emplist) {
//			if (s.getEid() == e.getEid()) {
//				session8.beginTransaction().commit();
//				return true;
//			}
//		}
//		return false;
		Employee a2 = session8.get(Employee.class, a);
		if (a2 == null) {
			return false;
		} else {
			return true;
		}
	}

	public static void update_address(Session session) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter address update :");
		e.setEadd(sc.next());
		try {
//		session.get(Employee.class, e.getEid());
		} catch (Exception e3) {
			e3.printStackTrace();
			System.out.println("this is exception of get method ()--");
		}
		session.saveOrUpdate(e);
		session.beginTransaction().commit();
		System.out.println("-----------------------------------------------------------");
		System.out.println("|     DATA UPDATED SUCCESSFULLY   		  |");
		System.out.println("-----------------------------------------------------------");

	}

	public static void update_name(Session session) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter name update :");
		e.setEname(sc.next());

		session.saveOrUpdate(e);

		session.beginTransaction().commit();
		System.out.println("-----------------------------------------------------------");
		System.out.println("|     DATA UPDATED SUCCESSFULLY   		  |");
		System.out.println("-----------------------------------------------------------");

	}

	public static void delete() {
		Scanner sc = new Scanner(System.in);
		do {
			showAllEmp();
			System.out.println("");
			System.out.println("how many employee you wanna delete");
			int count = sc.nextInt();

			Session session4 = sf.openSession();
			if (count < length) {
				for (int i = 1; i <= count; i++) {
					try {
						System.out.println("enter id to delete");
						e.setEid(sc.nextInt());

//					System.out.println("press 1. try again ");
//					System.out.println("press any other key : for exit'");

						session4.delete(e);

						System.out.println("-----------------------------------------------------------");
						System.out.println("|     DATA DELETE SUCCESSFULLY   				  |");
						System.out.println("-----------------------------------------------------------");
					} catch (Exception e1) {
						System.out.println(" ID does not match : please enter valid id  ");
						System.out.println("press 1. try again ");
						System.out.println("press any other key : for exit'");
						break;
					}
				}
				session4.beginTransaction().commit();
			} else {
				System.out.println("length of emploees is :" + length);
				System.out.println("press 1. try again ");
				System.out.println("press any other key : for exit'");
			}
		} while (sc.nextInt() == 1);

	}

	public static void showAllEmp() {
		Session session5 = sf.openSession();

		Query<Employee> qry = session5.createQuery("from Employee");
		List<Employee> emplist = qry.getResultList();
		System.out.println("");
//		System.out.println(emplist);

		for (Employee s : emplist) {
			length += 1;
			System.out.println(s);
		}

		session5.beginTransaction().commit();

	}

}
