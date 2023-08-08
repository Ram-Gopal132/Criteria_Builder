package com.app;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.hibernate.type.StandardBasicTypes;

import com.app.util.HibernateUtil;

public class Add_Scalar {
	public static void main(String[] args) {
		
		try(Session session=HibernateUtil.getSessionFactory().openSession()) 
		{
			String _sql="Select name,salary from employee";
			NativeQuery<Object[]> _query=session.createNativeQuery(_sql,Object[].class);
			
			_query.addScalar("Name",StandardBasicTypes.STRING);
			_query.addScalar("Salary",StandardBasicTypes.DOUBLE);
			
			List<Object[]> _list=_query.getResultList();
			
			for(Object[] row:_list)
			{
				String name=(String)row[0];
				Double Salary=(Double)row[1];
				
				System.out.println(name);
				System.out.println(Salary);
			}
			
		} catch (Exception e) {
			
			System.out.println("Reason of error"+e.getMessage());
			// TODO: handle exception
		}
	}
}
