package com.app;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.app.entity.Employee;
import com.app.util.HibernateUtil;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public class Asecnding_Desecending {
	
	public static void main(String[] args) {
		//Scanner sc=new Scanner(System.in);
		//System.out.println("Enter");
		
		try(Session session=HibernateUtil.getSessionFactory().openSession()) 
		{
			CriteriaBuilder cb=session.getCriteriaBuilder();
			CriteriaQuery<Employee> cr=cb.createQuery(Employee.class);
			Root<Employee>root=cr.from(Employee.class);
			cr.select(root);
			cr.orderBy(cb.desc(root.get("salary")),
			cb.desc(root.get("name")));
			
			Query<Employee> _query=session.createQuery(cr);
			List<Employee> result=_query.getResultList();
			
			for(Employee emp:result)
			{
				System.out.println(emp);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			
			System.out.println("Reason of error"+e.getMessage());
		}
	}

}
