//Limited Column print
package com.app;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

import com.app.util.HibernateUtil;

public class SecondActivity {
	public static void main(String[] args) {
		
		try(Session session=HibernateUtil.getSessionFactory().openSession())
		
		{
			String _sql="Select name,salary from employee";
			NativeQuery<Object[]> _query=session.createNativeQuery(_sql,Object[].class);
			List<Object[]> _list=_query.getResultList();
			
			for(Object[] emp:_list)
			{
				System.out.println("Name::"+emp[0]);
				System.out.println("Salary::"+emp[1]);
				System.out.println("----------------------------");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Reason of error::"+e.getMessage());
		}
	}
}
