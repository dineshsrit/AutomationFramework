package com.srit.constants;

import com.srit.config.PropertyUti;
import com.srit.enums.ConfigProperties;

/**
 * @author Administrator
 *
 */
public final class FrameworkConstants {

	private FrameworkConstants()
	{
		
	}




	public static void setExtentreportfilepath(String extentreportfilepath) {
		FrameworkConstants.extentreportfilepath = extentreportfilepath;
	}

	private final static String CHROMEDRIVERPATH=System.getProperty("user.dir")+"/src/test/resources/executables/chromedriver.exe";
	private final static String FIREFOXDRIVERPATH=System.getProperty("user.dir")+"/src/test/resources/executables/geckodriver.exe";
	private final static String PROPERTYFILEPATH=System.getProperty("user.dir")+"/src/test/resources/config/config.properties";
	private final static String EXTENTFOLDERPATH=System.getProperty("user.dir")+"/extent-test-output/";
	private static String extentreportfilepath= "";
	private final static String EXCELFILEPATH=System.getProperty("user.dir")+"/src/test/resources/excel/testData.xlsx";

	private final static String UPLOADFILEPATH=System.getProperty("user.dir")+"/src/test/resources/images/ladies.png";

	private final static String SIGNERPATH=System.getProperty("user.dir")+"/src/test/resources/signer/Signer-Digital-Digital-Signature-PKI.crx";
	private static String createReportPath() throws Exception
	{
		if(PropertyUti.get(ConfigProperties.OVERRIDEREPORTS).equalsIgnoreCase("no"))
		{
			return EXTENTFOLDERPATH+System.currentTimeMillis()+"/index.html";
		}
		else
		{
			return EXTENTFOLDERPATH+"/index.html";
		}
	}
	
	public static String getExcelFilepath() {
		return EXCELFILEPATH;
	}

	public static String getExtentreportpath() throws Exception {
	if(extentreportfilepath.isEmpty())
	{
		extentreportfilepath=createReportPath();
	}
	return extentreportfilepath;
	
	}

	public static String getPropertyfilepath() {
		return PROPERTYFILEPATH;
	}


	private final static int  EXPLICITWAIT=15;

	public static int getExplicitWait() {
		return EXPLICITWAIT;
	}

	public static String getChromedriverpath() {
		return CHROMEDRIVERPATH;
	}

	public static String getFirefoxdriverpath() {
		return FIREFOXDRIVERPATH;
	}

	public static String getUploadfilepath() {
		return UPLOADFILEPATH;
	}

	public static String getSignerPath() {
		return SIGNERPATH;
	}

}
