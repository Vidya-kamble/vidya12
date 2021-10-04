package com.technoelevate.studentProject;

import java.io.Serializable;
import java.util.List;
import java.util.Scanner;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Id;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

@Entity
public class Student implements Serializable {
	@Id
	
	private int roll_no;
	private String name;
	private long phono;
	private String standard;
	
	static Scanner sc = new Scanner(System.in);
	
	
	public Student()
	{
		
	}
	@Override
	public String toString() {
		return "Student [roll_no=" + roll_no + ", name=" + name + ", phono=" + phono + ", standard=" + standard + "]";
	}
	public int getRoll_no() {
		return roll_no;
	}
	public void setRoll_no(int roll_no) {
		this.roll_no = roll_no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getPhono() {
		return phono;
	}
	public void setPhono(long phono) {
		this.phono = phono;
	}
	public String getStandard() {
		return standard;
	}
	public void setStandard(String standard) {
		this.standard = standard;
	}
	
	
	public static void seeAllData()
	{

		EntityManagerFactory factory=null;
		EntityManager manager = null;
		
		try {
			factory = Persistence.createEntityManagerFactory("emp");
			
			manager=factory.createEntityManager();
			String findById = "from Student";
			Query query = manager.createQuery(findById);
			List<Student> list = query.getResultList();

			for (Student student : list ) {
				System.out.println(student);
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
			finally {
				if(factory!=null)
					factory.close();
				if(manager!=null)
					manager.close();
			}
		
	}
	
	

	public static void seeParticularData()
	{
		EntityManagerFactory factory=null;
		EntityManager manager = null;
		
		try {
			factory = Persistence.createEntityManagerFactory("emp");
			
			manager=factory.createEntityManager();
			String findById = "from Student where id=:i";
			Query query = manager.createQuery(findById);
			System.out.println("Enter roll_no to see particular data");
			int i = sc.nextInt();
			query.setParameter("i", i);
			Student student = (Student) query.getSingleResult();
			System.out.println(student);
			
		}
		catch(Exception e)
		{
			throw new IdNotFoundException();
		}
		
			finally {
				if(factory!=null)
					factory.close();
				if(manager!=null)
					manager.close();
			}
	}
	
	
	
	public static void updateParticularData()
	{

		Scanner sc = new Scanner(System.in);
		EntityManagerFactory factory=null;
		EntityManager manager = null;
		EntityTransaction transaction=null;
		try
		{
			factory = Persistence.createEntityManagerFactory("emp");
			 manager = factory.createEntityManager();
			 transaction = manager.getTransaction();
			
			 boolean exit = false;
			 do {
				 System.out.println("Enter 1 to update student name ");
				 System.out.println("Enter 2 to update student phone_no");
				 System.out.println("Enter 3 to update student standard");
				 System.out.println("Enter 4 to exit");
				 
				 int n = sc.nextInt();
				 
				 switch(n)
				 {
				 case 1: { 
				 System.out.println("Enter roll_no");
		 			int roll_no=sc.nextInt();
		 			String update1 = "from Student where roll_no=:roll_no";
		 			Query query = manager.createQuery(update1);
		 			query.setParameter("roll_no", roll_no);
		 			Student student= (Student)query.getSingleResult();
		 			if(student==null)
		 			{
		 				throw new IdNotFoundException();
		 			}
		 			else
		 			{
		 				transaction.begin();
		 				 System.out.println("Enter name");
				 			String name=sc.next();
				 			
					 		String update="update Student set name=:name where roll_no=:roll_no";
				 			Query query1 = manager.createQuery(update);
				 			query1.setParameter("name",name);
				 			query1.setParameter("roll_no",roll_no);
				 			int result = query1.executeUpdate();
				 			 transaction.commit();
		 			}
					
				 			
				 		};
				 		
				 		break;
				 		
				 case 2:{
					 	System.out.println("Enter roll_no");
			 			int roll_no=sc.nextInt();
			 			String update1 = "from Student where roll_no=:roll_no";
			 			Query query = manager.createQuery(update1);
			 			query.setParameter("roll_no", roll_no);
			 			Student student= (Student)query.getSingleResult();
			 			if(student==null)
			 			{
			 				throw new IdNotFoundException();
			 			}
			 			else {
			 				 transaction.begin();
			 				System.out.println("Enter phone_no");
				 			long phono=sc.nextLong();
					 		String update="update Student set phono=:phono where roll_no=:roll_no";
				 			Query query1 = manager.createQuery(update);
				 			query1.setParameter("phono",phono);
				 			query1.setParameter("roll_no",roll_no);
				 			int result = query1.executeUpdate();
				 			 transaction.commit();
			 				
			 			}
					 
				
				 		};
		 		
				 		break;
				 case 3: {  
					 		
					 	System.out.println("Enter roll_no");
			 			int roll_no=sc.nextInt();
			 			String update1 = "from Student where roll_no=:roll_no";
			 			Query query = manager.createQuery(update1);
			 			query.setParameter("roll_no", roll_no);
			 			Student student= (Student)query.getSingleResult();
			 			if(student==null)
			 			{
			 				throw new IdNotFoundException();
			 			}
			 			else
			 			{
			 					transaction.begin();
			 				 
						  		System.out.println("Enter standard");
					 			String standard=sc.next();
						 		String update="update Student set standard=:standard where roll_no=:roll_no";
					 			Query query1 = manager.createQuery(update);
					 			query1.setParameter("standard",standard);
					 			query1.setParameter("roll_no",roll_no);
					 			int result = query1.executeUpdate();
					 			 transaction.commit();	
			 				
			 			}
	
				 			
				 		};
 		
				 		break;
				 case 4: exit = true;
				 		break;
				 default:System.out.println("Invalid choose");
				 		break;
				 }
				
			 }while(!exit);
			
				
		}
		
		
		catch(NoResultException e)
		{
			throw new IdNotFoundException();
		
			
		}
		
		finally {
			if(factory!=null)
				factory.close();
			if(manager!=null)
				manager.close();
		}
		

	}

	
	public static void deleteData()
	{

		Scanner sc = new Scanner(System.in);
		EntityManagerFactory factory=null;
		EntityManager manager = null;
		EntityTransaction transaction=null;
		try
		{
			factory = Persistence.createEntityManagerFactory("emp");
			 manager = factory.createEntityManager();
			 transaction = manager.getTransaction();
			
			 
			 
			 
				
			 	System.out.println("Enter roll_no");
	 			int roll_no=sc.nextInt();
	 			String update1 = "from Student where roll_no=:roll_no";
	 			Query query = manager.createQuery(update1);
	 			query.setParameter("roll_no", roll_no);
	 			Student student= (Student)query.getSingleResult();
	 			if(student==null)
	 			{
	 				throw new IdNotFoundException();
	 			}
	 			else {
	 				 transaction.begin();
	 				String delete = "delete from Student where roll_no=:roll_no";
	 				 Query query1 = manager.createQuery(delete);
	 				 query1.setParameter("roll_no", roll_no);
	 				 int result = query1.executeUpdate();
	 				 transaction.commit();
	 				
	 			}
			 
			
			 
		}
		catch(Exception e)
		{
			
			throw new IdNotFoundException();
		}
		finally {
			if(factory!=null)
				factory.close();
			if(manager!=null)
				manager.close();
			
		}
		
		
	}
	
	

}
