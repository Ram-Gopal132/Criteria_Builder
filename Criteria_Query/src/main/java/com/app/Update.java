package com.app;

import java.util.Scanner;

import org.hibernate.Session;

import com.app.entity.Employee;
import com.app.util.HibernateUtil;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaUpdate;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transaction;

public class Update {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the code");
		int _code=sc.nextInt();
		
		System.out.println("Enter New Salary");
		double _salary=sc.nextDouble();
		
		org.hibernate.Transaction transaction=null;
		
		try (Session session=HibernateUtil.getSessionFactory().openSession())
		{
			CriteriaBuilder cb=session.getCriteriaBuilder();
			CriteriaUpdate<Employee> cu=cb.createCriteriaUpdate(Employee.class);
			Root<Employee> root=cu.from(Employee.class);
			cu.set("salary",_salary);
			cu.where(cb.equal(root.get("code"), _code));
			transaction=session.beginTransaction();
			
			session.createMutationQuery(cu).executeUpdate();
			transaction.commit();
			
			System.out.println("Record Updated");
			
		} catch (Exception e) {
			System.out.println("Reason of error"+e.getMessage());
			// TODO: handle exception
		}
	}

}
