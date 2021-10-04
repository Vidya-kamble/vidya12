package com.technoelevate.studentProject;

public class IdNotFoundException extends RuntimeException{
	
	public String getMessage()
	{
		return "ID NOT FOUND";
	}

}
