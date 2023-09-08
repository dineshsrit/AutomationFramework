package com.srit.config;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.srit.config.ExcelUtils;
import org.testng.annotations.DataProvider;

public class DataproviderUtils {

	@DataProvider(parallel = true)
 public static Object[] getData(Method m)
{
	String testname=m.getName();
   List<Map<String, String>> list=ExcelUtils.getTestDetails("data");

   List<Map<String, String>> iterattionlist=new ArrayList<>();

   for(int i=0;i<list.size();i++)
   {
	   if(list.get(i).get("testname").equalsIgnoreCase(testname) &&
			   list.get(i).get("execute").equalsIgnoreCase("yes"))
	   {
		   iterattionlist.add(list.get(i));
	   }
   }
	
	return iterattionlist.toArray();
	
}

}
