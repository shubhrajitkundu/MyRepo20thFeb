package Utilities;

public class CommonFunction {
	
	public static String getEmailId()
	{
		String email = "tom" + java.util.UUID.randomUUID().toString().replace("-", "").substring(0,8) + "@gmail.com";
		return email;
	}

}
