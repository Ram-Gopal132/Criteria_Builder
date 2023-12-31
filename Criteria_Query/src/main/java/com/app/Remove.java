package com.app;

import java.util.Scanner;

import org.hibernate.Session;

import com.app.entity.Employee;
import com.app.util.HibernateUtil;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaDelete;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transaction;

public class Remove {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the code");
		int _code=sc.nextInt();
		
		org.hibernate.Transaction transaction=null;
		
		try(Session session=HibernateUtil.getSessionFactory().openSession())
		{
			CriteriaBuilder cb=session.getCriteriaBuilder();
			
			CriteriaDelete<Employee> cd=cb.createCriteriaDelete(Employee.class);
			Root<Employee> root=cd.from(Employee.class);
			
			cd.where(cb.equal(root.get("code"), _code));
			transaction=session.beginTransaction();
			session.createMutationQuery(cd).executeUpdate();
			
			transaction.commit();
			System.out.println("Record Delete");
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
