package com.app;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.app.entity.Employee;
import com.app.util.HibernateUtil;

public class NamedQueryOne {
	
	public static void main(String[] args) {
		
		
		try (Session session=HibernateUtil.getSessionFactory().openSession())
		{
			Query<Employee> _query=session.createNamedQuery("AllRec",Employee.class);
			
			List<Employee> _list=_query.getResultList();
			for(Employee emp:_list)
			{
				System.out.println(emp);
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			
			System.out.println("Reason of error"+e.getMessage());
		}
	}

}
