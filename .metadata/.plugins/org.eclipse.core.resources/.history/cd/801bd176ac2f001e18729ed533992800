package com.app;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.entity.Employee;
import com.app.util.HibernateUtil;



public class Insertion {
	
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter Your Name");
		String name=sc.nextLine();
		
		System.out.println("Enter your Salary");
		Double salary=sc.nextDouble();
		
		Employee emp=new Employee();
		emp.setName(name);
		emp.setSalary(salary);
		
		Transaction transaction=null;
		
		try (Session session=HibernateUtil.getSessionFactory().openSession())
		{
			transaction=session.beginTransaction();
			
			session.persist(emp);
			
			transaction.commit();
			session.close();
			
			System.out.println("Record Inserted");
			
		} catch (Exception e) {
			
			System.out.println("Reason of error"+e.getMessage());
			// TODO: handle exception
			if(transaction!=null)
			{
				transaction.rollback();
			}
		}
	}

}
