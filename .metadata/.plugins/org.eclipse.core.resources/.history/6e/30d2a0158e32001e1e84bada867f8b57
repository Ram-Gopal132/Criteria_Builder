package com.app;

import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

import com.app.util.HibernateUtil;

public class Aggregate_Function {

	public static void main(String[] args) {
		try(Session session=HibernateUtil.getSessionFactory().openSession()) 
		{
			String _sql="Select avg(salary),count(*) from employee";
			
			// for only avg
			 //NativeQuery<Double> _query=session.createNativeQuery(_sql,Double.class);
			
			//double _Average=_query.uniqueResult();
			
			NativeQuery<Object[]> _query=session.createNativeQuery(_sql,Object[].class);
			Object[] Valaues=_query.uniqueResult();
					
			System.out.println("The all employee of Average Salary::"+Valaues[0]);
			System.out.println("The No of Employee::"+Valaues[1]);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
