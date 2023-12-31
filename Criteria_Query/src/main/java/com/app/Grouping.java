package com.app;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SharedSessionContract;
import org.hibernate.query.Query;

import com.app.entity.Employee;
import com.app.util.HibernateUtil;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public class Grouping {
	
	private static void getAverage(Session session2) 
	{
		SharedSessionContract session = null;
		CriteriaBuilder cb=session.getCriteriaBuilder();
		
		CriteriaQuery<Double> cr=cb.createQuery(Double.class);
		Root<Employee> root=cr.from(Employee.class);
		cr.multiselect(cb.avg(root.get("salary")));
		
		Query<Double>_query=session.createQuery(cr);
		
		List<Double> _list=_query.getResultList();
		
		System.out.println(_list);
	}
	
	public static void main(String[] args) {
		
		try (Session session=HibernateUtil.getSessionFactory().openSession())
		{
			
			CriteriaBuilder cb=session.getCriteriaBuilder();
			CriteriaQuery<Long> cr=cb.createQuery(Long.class);
			Root<Employee> root=cr.from(Employee.class);
			cr.multiselect(cb.count(root));
			Query<Long> _query=session.createQuery(cr);
			
			List<Long> _list=_query.getResultList();
			System.out.println("The Number of employee"+_list);
			
			getAverage(session);
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
