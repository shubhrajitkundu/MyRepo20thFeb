package Utilities;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import ConstantsData.ConstantData;



public class ReadDataFromExcel {
	
	public static Map readValueFromExcel() throws IOException
	{
		FetchDataFromExcel obj=new FetchDataFromExcel(ConstantData.EXCEL_PATH,ConstantData.SHEET_NAME);
		Map<String,Object>mp=new LinkedHashMap<String,Object>();
		mp.put("id",FetchDataFromExcel.getDataExcel(1, 0));
		mp.put("name",FetchDataFromExcel.getDataExcel(1, 1));
		mp.put("email",CommonFunction.getEmailId());
		mp.put("gender",FetchDataFromExcel.getDataExcel(1, 2));
		mp.put("status",FetchDataFromExcel.getDataExcel(1, 3));
		
		return mp;
	}
	
	

}
