//Print all data
package com.app;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

import com.app.entity.Employee;
import com.app.util.HibernateUtil;

public class FirstActivity {
	public static void main(String[] args) {
		
		try(Session session=HibernateUtil.getSessionFactory().openSession()) 
		{
			String _sql="Select * from employee";
			NativeQuery<Employee> _query=session.createNativeQuery(_sql,Employee.class);
			
			List<Employee> _list=_query.getResultList();
			for(Employee emp:_list)
			{
				System.out.println(emp);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("reason of error"+e.getMessage());
		}
	}
}
