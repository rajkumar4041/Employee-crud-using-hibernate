package com.controller;

import java.util.Scanner;

import com.dao.EmployeeDao;
import com.model.Employee;

public class mainClassCRUD {

	static {
		System.out.println("|____________ EMPLOYEE MANAGEMENT USING HIBERNATE CRUD OPERATION   ____________|");
	}

	public static int eid;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Employee e = null;

		boolean mainFlag = true;
		while (mainFlag) {

			System.out.println(
					"-------------------------------------------------------------------------------------------------");
			System.out.println(
					"| PRESS : 1.CREATE   2.INSERT  3.SELECTED_EMP  4.UPDATE  5.DELETE  6.SHOW_ALLEMP 7.EXIT-APP     |");
			System.out.println(
					"-------------------------------------------------------------------------------------------------");
			int choisequery = sc.nextInt();

			switch (choisequery) {
			case 1: {

//						System.out.println("--create()--");

				Boolean flag = EmployeeDao.create();
				if (flag) {
					System.out.println("----------------------------------------------------------------------");
					System.out.println("-- TABLE EMPLOYEE CREATED SUCCESSFULLY -> FIELD : ID, NAME, ADDRESS --");
					System.out.println("----------------------------------------------------------------------");
				} else if (!flag) {
					System.out.println("TABLE ALREADY CREATED ");
				}

			}
				break;

			case 2: {
//						System.out.println("--INSERt ()--");
				try {

					EmployeeDao.insert();
					
				} catch (Exception e1) {
					System.out.println("--------- Duplicate Key ---------");
				}

				break;
			}
			case 3: {
//						System.out.println("--select ()--");

				try {
					System.out.println("ENTER EMPLOYE ID: TO GET DETAILS :");
					int id = sc.nextInt();
					EmployeeDao.read(id);

				} catch (Exception e1) {
					System.out.println("--------- PLEASE ENTER VALID DATA-TYPE ---------");
				}
				System.out.println("|---------------------------------------------------------|");
				System.out.println("|     DATA FETCH SUCCESSFULLY   				  |");
				System.out.println("|---------------------------------------------------------|");
				break;
			}

			case 4: {

				try {
					EmployeeDao.update();

				} catch (Exception e1) {
					System.out.println("--------- PLEASE ENTER VALID DATA-TYPE ---------");
				}

				break;
			}
			case 5: {

				try {

					EmployeeDao.delete();
					System.out.println("____________________________________________________________");

				} catch (Exception e1) {
					System.out.println("--------- PLEASE ENTER VALID DATA-TYPE ---------");
				}
				break;
			}

			case 6: {
//						System.out.println(" -- show allemp()--");
				EmployeeDao.showAllEmp();

				break;
			}

			case 7: {

				mainFlag = false;
				System.out.println("_______________________________________________________________________");
				System.out.println("	  		----	 YOU ARE SUCCEESSFULLY EXIT 	----			   ");
				System.out.println("	    	⪗	 THANK YOU FOR USING JAVA APPLICATION 	⫸			   ");
				System.out.println("-----------------------------------------------------------------------");

				break;
			}
			default:
				System.out.println("--- ENTER VALID DETAIL OR PRESS: 6 TO EXIT ---");
				mainFlag = true;
			}
		}
	}
}
