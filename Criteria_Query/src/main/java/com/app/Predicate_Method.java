package com.app;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.app.entity.Employee;
import com.app.util.HibernateUtil;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class Predicate_Method {
	
	public static void main(String[] args) {
		try(Session session=HibernateUtil.getSessionFactory().openSession()) 
		{
			CriteriaBuilder cb=session.getCriteriaBuilder();
			CriteriaQuery<Employee> cr=cb.createQuery(Employee.class);
			Root<Employee> root=cr.from(Employee.class);
			Predicate[] pridicate=new Predicate[2];
			
			pridicate[0]=cb.like(root.get("name"), "%"+"Ra"+"%");
			pridicate[1]=cb.gt(root.get("salary"), 4000);
			
			cr.select(root).where(pridicate);
			Query<Employee> _query=session.createQuery(cr);
			
			List<Employee> list=_query.list();
			
			for(Employee emp:list)
			{
				System.out.println(emp);
			}
			
			System.out.println("Record Found");
		} catch (Exception e) {
			
			System.out.println("Reason of errror"+e.getMessage());
			// TODO: handle exception
		}
	}
}
