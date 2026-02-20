package Utilities;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import POJOMapper.EmployeePOJO;

public class FetchDataFromPojo {
	
	public static String createEmployee() throws JsonProcessingException
	{
		EmployeePOJO emp=new EmployeePOJO();
		emp.setName("Harry");
		emp.setJobRole("QA Manager");
		emp.setId(34567);
		
		ObjectMapper obj=new ObjectMapper();
		
	String empJSON=	obj.writerWithDefaultPrettyPrinter().writeValueAsString(emp);
		
	return empJSON;
		
	}
	

}
