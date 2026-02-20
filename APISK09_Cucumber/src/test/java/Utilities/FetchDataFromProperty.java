package Utilities;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import ConstantsData.ConstantData;

public class FetchDataFromProperty {
	
	static FileReader reader;
	
	public static Properties getDataFromProperty() 
	{
		try {
			reader=new FileReader(ConstantData.PROP_FILE_PATH);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Properties prop=new Properties();
		try {
			prop.load(reader);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop;
		
		
		
		
		
	}
	
	
	
	
	

}
