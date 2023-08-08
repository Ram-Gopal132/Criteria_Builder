package com.app;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.entity.Workers;
import com.app.util.HibernateUtil;



public class Insertion {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter your name");
		String name=sc.nextLine();
		
		System.out.println("Enter Your salary");
		Double salary=sc.nextDouble();
		
		Workers emp=new Workers();
		emp.setName(name);
		emp.setSalary(salary);
		
		
		
		Transaction transaction=null;
		
		try (Session session=HibernateUtil.getSessionFactory().openSession())
		{
			transaction=session.beginTransaction();
			
			session.persist(emp);
			
			transaction.commit();
			System.out.println("Record Inserted!");
			// Refres System.out.println(emp);
			session.close();
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			
			System.out.println("Reason of error"+e.getMessage());
		}
	}
}
