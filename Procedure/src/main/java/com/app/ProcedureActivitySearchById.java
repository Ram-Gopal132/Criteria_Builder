package com.app;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;


import com.app.util.HibernateUtil;
import jakarta.persistence.StoredProcedureQuery;

public class ProcedureActivitySearchById {

	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter the code");
		int _code=sc.nextInt();
		
		String name="";
		
		Transaction transaction=null;
		try (Session session=HibernateUtil.getSessionFactory().openSession())
		{
			transaction=session.beginTransaction();
			
			StoredProcedureQuery call=session.createNamedStoredProcedureQuery("bycodesearch");
			call.setParameter("_code", _code);
			call.setParameter("_name", name);
			
			String value=""+call.getOutputParameterValue("_name");
			System.out.println("The Name Is::"+value);
			
			transaction.commit();
			
		} catch (Exception e) {
			// TODO: handle exception
			
			System.out.println("Reason of error"+e.getMessage());
		}
				
	}
}
