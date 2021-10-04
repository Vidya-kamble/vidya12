package com.technoelevate.studentProject;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.hybernate.bean.Employee;
import java.util.List;

public class StudentDriver {
	static Scanner sc = new Scanner(System.in);
	
	Student st = new Student();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student student = new Student();
		
		boolean exit = false;
		do {
			System.out.println("Press 1 to see all data");
			System.out.println("Press 2 to see any particular data");
			System.out.println("Press 3 to update any particular data");
			System.out.println("Press 4 to delete data");
			System.out.println("Press 5 to exit");
			
			int n = sc.nextInt();
			
			switch(n)
			{
			  case 1: try {
				  Student.seeAllData();
				  
			
			  	}
				 catch(Exception e)
			  {
				throw new IdNotFoundException();	 
			  }
				  	break;
			  case 2: 
				  try {
					 Student.seeParticularData();
					 
				  	}
					 catch(Exception e)
				  {
					throw new IdNotFoundException();	 
				  }
				    break;
			  case 3: 
				  try {
					  Student.updateParticularData();
					 
				  	}
					 catch(Exception e)
				  {
					throw new IdNotFoundException();	 
				  }
				    break;
				  
				  	
			  case 4: 
				  try {
					  Student.deleteData();
					 
				  	}
					 catch(Exception e)
				  {
					throw new IdNotFoundException();	 
				  }
				    break;
			  case 5:exit=true;
				  	break;
			  default: System.out.println("Invalid choice");
			  		break;
			}
		}while(!exit);
		
		
		
		

	}

}
