			package com.app.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil
	{
		private static SessionFactory sessionFactory=buildSessionFactory();

		private static SessionFactory buildSessionFactory() {
			// TODO Auto-generated method stub
			
			try {
				if(sessionFactory==null)
				{
					StandardServiceRegistry registry=new StandardServiceRegistryBuilder().
							configure("hibernate.cfg.xml").build();
					
					Metadata metadata=new MetadataSources(registry).getMetadataBuilder().build();
					sessionFactory=metadata.getSessionFactoryBuilder().build();
					
					
				}
				return sessionFactory;
			}
			catch (Exception e) {
				// TODO: handle exception
				
				throw new ExceptionInInitializerError();
			}
			
		}
		public static SessionFactory getSessionFactory()
		{
			return sessionFactory;
		}
		
		public static void shutDown() 
		{
			getSessionFactory().close();
		}
	}


