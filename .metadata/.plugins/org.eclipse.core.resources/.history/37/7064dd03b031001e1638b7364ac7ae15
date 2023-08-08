package com.app;

import java.util.Map;

import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

import com.app.util.HibernateUtil;

public class Mapping {
	public static void main(String[] args) {
		
		try (Session session=HibernateUtil.getSessionFactory().openSession())
		{
			String _sql="Select max(salary),count(*),avg(salary) from employee";
			
			NativeQuery<Map> _query=session.createNativeQuery(_sql,Map.class);
			
			Map<String, Double> _map=_query.uniqueResult();
			System.out.println(_map);
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("reason of error::"+e.getMessage());
		}
	}

}
