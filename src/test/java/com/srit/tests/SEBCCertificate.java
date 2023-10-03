package com.srit.tests;

import com.srit.config.*;
import com.srit.constants.FrameworkConstants;
import com.srit.driver.DriverManager;
import com.srit.pages.*;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SEBCCertificate extends BaseTest{


    String sebc=null;

   Xls_Reader reader=new Xls_Reader(FrameworkConstants.getExcelFilepath());
   String sheetname="Sebc";

    @Test
    public void applyforSEBCServices()
    {
        try
        {

         CoreApplicationPage cp=new CoreApplicationPage();
         cp.click_citizenlogin();
         cp.txt_email(reader.getCellData(sheetname, "Portalemailaddress", 2));
         cp.txt_password(reader.getCellData(sheetname, "Portalpassword", 2));
         cp.click_sigin();
         cp.click_applyforServices();
         cp.click_viewallavailableServices();
            /*CoreApplicationPage cp=new CoreApplicationPage();
            cp.enter_username("csc1.sundar").enter_password("Pass@1231").clickLogin().clickCoreApplication()
                    .clickServices().clickSubmitApplication().txt_createuai1("4462")
                    .txt_createuai2("0306").txt_createuai3("0000").txt_createuai4("0299").btn_create_uai();*/
         SebcPage sp= cp.click_sebcCertificate();
         sp.click_Proceed();
         System.out.println(sp.getDocumentTitle());
            try
            {
             DropDownUtils.dropdownSelect(sp.clickpermanentAddress());
             DropDownUtils.selectByText(sp.permanentdistrictdropdown(), reader.getCellData(sheetname, "Perdistrict", 2));
             Thread.sleep(1000);
             DropDownUtils.selectByText(sp.permanentblockdropdown(), reader.getCellData(sheetname, "Perblock", 2));
             Thread.sleep(1000);
             DropDownUtils.selectByText(sp.permanentgpdropdown(), reader.getCellData(sheetname, "Pergp", 2));
             Thread.sleep(1000);
             DropDownUtils.selectByText(sp.permanentvillagedropdown(), reader.getCellData(sheetname, "Pervillage", 2));
             DropDownUtils.selectByText(sp.districtdropdown(), reader.getCellData(sheetname, "Pdistrict", 2));
             DropDownUtils.selectByText(sp.subdivisiondropdown(),reader.getCellData(sheetname, "Psubdivision", 2));
             DropDownUtils.selectByText(sp.tahsildropdown(), reader.getCellData(sheetname, "Ptahsil", 2));
             DropDownUtils.selectByText(sp.ridropdown(), reader.getCellData(sheetname, "Pri", 2));
             DropDownUtils.selectByText(sp.villagedropdown(), reader.getCellData(sheetname, "Pvillage", 2));
             sp.txt_policestation(reader.getCellData(sheetname, "Ppolicestation", 2));

             DropDownUtils.dropdownSelect(sp.clickpresentAddress());
             DropDownUtils.selectByText(sp.presentdistrictdropdown(), reader.getCellData(sheetname, "Predistrict", 2));
             Thread.sleep(1000);
             DropDownUtils.selectByText(sp.presentblockdropdown(), reader.getCellData(sheetname, "Preblock", 2));
             Thread.sleep(1000);
             DropDownUtils.selectByText(sp.presentgpdropdown(),reader.getCellData(sheetname, "Pregp", 2));
             Thread.sleep(1000);
             DropDownUtils.selectByText(sp.presenttvillagedropdown(),reader.getCellData(sheetname, "Previllage", 2));
             DropDownUtils.selectByText(sp.castedropdown(), reader.getCellData(sheetname, "Caste", 2));

             DropDownUtils.selectByText(sp.religiondropdown(), reader.getCellData(sheetname, "Religion", 2));
             DropDownUtils.dropdownSelect(sp.clickFather());
             DropDownUtils.selectByText(sp.servicedropdown(), reader.getCellData(sheetname, "Service", 2));
             sp.txt_designation(reader.getCellData(sheetname, "Designation", 2));
             sp.txt_scaleofpay(reader.getCellData(sheetname, "Govscaleofpay", 2));
             sp.txt_father_age(reader.getCellData(sheetname, "Age", 2));
             sp.txt_father_organization(reader.getCellData(sheetname, "InterOrganization", 2));
             sp.txt_father_intdesignation(reader.getCellData(sheetname, "Interdesignation", 2));
             sp.txt_father_puborganization(reader.getCellData(sheetname, "PubOrganization", 2));
             sp.txt_gov_designation(reader.getCellData(sheetname, "Pubdesignation", 2));
             sp.txt_annualincome(reader.getCellData(sheetname, "Annualincome", 2));
             sp.txt_father_paradesignation(reader.getCellData(sheetname, "Paradesignation", 2));
             sp.txt_father_parascaleofpay(reader.getCellData(sheetname, "ParaScaleofpay", 2));
             sp.txt_father_occupation(reader.getCellData(sheetname, "Appoccupation", 2));
             sp.txt_father_agri_landlocation(reader.getCellData(sheetname, "Proplocation", 2));
             sp.txt_father_agri_landsize(reader.getCellData(sheetname, "Propsize", 2));
             sp.txt_father_irrigateone(reader.getCellData(sheetname, "Irrigatedone", 2));
             sp.txt_father_irrigatetwo(reader.getCellData(sheetname, "Irrigatedtwo", 2));
             sp.txt_father_irrigatethree(reader.getCellData(sheetname, "Irrigatedthree", 2));
             sp.txt_father_uniirrigateone(reader.getCellData(sheetname, "UnirragatedOne", 2));
             sp.txt_father_unirrigatetwo(reader.getCellData(sheetname, "Unirragatedtwo", 2));
             sp.txt_father_unirrigatethree(reader.getCellData(sheetname, "Unirragatedthree", 2));
             DropDownUtils.selectByText(sp.cropsndropdown(), reader.getCellData(sheetname, "Crops", 2));
             sp.txt_plantation_location(reader.getCellData(sheetname, "Location", 2));
             sp.txt_plantation_area(reader.getCellData(sheetname, "Areaofplantation", 2));
             sp.txt_vacant_locationproperty(reader.getCellData(sheetname, "Locationofproperty", 2));
             sp.txt_vacant_detailsofproperty(reader.getCellData(sheetname, "Detailsofproperty", 2));
             sp.txt_vacant_useto(reader.getCellData(sheetname, "Use", 2));
             sp.txt_father_annualincome(reader.getCellData(sheetname, "Wealthannualincome", 2));
             sp.txt_father_wealthtax(reader.getCellData(sheetname, "Wealthtaxdetails", 2));
             sp.txt_otherremarks(reader.getCellData(sheetname, "remarks", 2));
             FileUploadUtils.fileUpload(sp.fileUpload(), FrameworkConstants.getUploadfilepath());
             sp.txt_purpose(reader.getCellData(sheetname, "Purpose", 2));
             Thread.sleep(2000);
             DropDownUtils.dropdownSelect(sp.agree());
             sp.txt_place(reader.getCellData(sheetname, "Place", 2));
             sp.clicksubmit();
             HandlePop.getHandlePop();
             Thread.sleep(1000);
             sp.click_Yes();
             String text=sp.getApplicationNo();
             System.out.println(text);
             Assert.assertEquals("Application No", text.substring(0,14));
             sebc=sp.getSebcCertNo();
             System.out.println(sebc);
             sp.clickConfirm();
             HandlePop.getHandlePop();
             Thread.sleep(1000);
             sp.clickContinue();
             sp.clickCitizenUser();
             sp.clickCitizenlogout();

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
 //dependsOnMethods = "applyforSEBCServices"
  @Test()
  public void forwardtoRIbyDA()
 {
   try
   {
    CoreApplicationPage cp= new CoreApplicationPage();
    cp.click_OfficialLogin();
    HandleTab.getHandleTab(1);
    cp.enter_username("da.bargarh").enter_password("Pass@1231")
            .clickLogin()
            .clickCoreApplication().
            click_applicationbox().
            click_mypendingapplications().click_sebcapplications();
    SebcPage sp= new SebcPage();
    sp.click_csv();
    Thread.sleep(2000);
    System.out.println(sp.click_firstrecord().getAttribute("class"));
    JavascriptExecutor js=(JavascriptExecutor)DriverManager.getDriver();
    js.executeScript("window.scrollBy(0,50)");
    js.executeScript("arguments[0].click()", sp.click_firstrecord());
    //sp.click_firstrecord();
    Thread.sleep(2000);
    sp.txt_da_remarks("some remarks");
    Thread.sleep(1000);
    DropDownUtils.dropdownSelect(sp.actiondropdown());
    Thread.sleep(1000);
    DropDownUtils.dropdownList(sp.actiondropdownlist(), "forward");
    Thread.sleep(1000);
    DropDownUtils.dropdownSelect(sp.officedropdown());
    Thread.sleep(1000);
    DropDownUtils.dropdownList(sp.officedropdownlist(), "ri Office");
    Thread.sleep(1000);
    JavaScriptUtils.ScrollIntoView(sp.forwardtori());
    sp.clickdasubmit();
    HandlePop.getHandlePop();
    sp.clickdacontinue();
    HandlePop.getHandlePop();
    sp.clickdaclose();
    sp.clickUser();
    sp.clickLogout();

   } catch (Exception e) {
    throw new RuntimeException(e);
   }
 }

 @Test(dependsOnMethods = "forwardtoRIbyDA")
 public void forwardtoTahsilbyRI()
 {
  try
  {
   CoreApplicationPage cp= new CoreApplicationPage();
   cp.click_OfficialLogin();
   HandleTab.getHandleTab(1);
   cp.enter_username("ri.jamurda").enter_password("Pass@1231")
           .clickLogin()
           .clickCoreApplication().
           click_applicationbox().
           click_mypendingapplications().click_sebcapplications();
   SebcPage sp= new SebcPage();
   sp.txt_searchbox(sebc);
   Thread.sleep(2000);
   DropDownUtils.dropdownSelect(sp.tahsilfirstrecord());
   Thread.sleep(4000);
   JavascriptExecutor js = (JavascriptExecutor) DriverManager.getDriver();
   js.executeScript("window.scrollBy(0,500)");
   DropDownUtils.dropdownSelect(sp.getUpdateVerificationReport());
   HandlePop.getHandlePop();
   String ConfirmVerificationApplicationNo=sp.getsebVerificationNo().substring(2);
   System.out.println(ConfirmVerificationApplicationNo);
   Assert.assertEquals(sebc,ConfirmVerificationApplicationNo );
   sp.txt_landproperty("property");
   sp.txt_familyincome("1000");
   sp.txt_verification_remarks("some remarks");
   sp.verification_fileupload(FrameworkConstants.getUploadfilepath());
   sp.clickVerificationSubmit();
   HandlePop.getHandlePop();
   sp.clickVerificationContinue();
   HandlePop.getHandlePop();
   sp.txt_ri_remarks("some remarks");
   Thread.sleep(1000);
   DropDownUtils.dropdownSelect(sp.actiondropdown());
   Thread.sleep(1000);
   DropDownUtils.dropdownList(sp.actiondropdownlist(), "forward");
   Thread.sleep(1000);
   JavaScriptUtils.ScrollIntoView(sp.officedropdown());
   DropDownUtils.dropdownSelect(sp.officedropdown());
   Thread.sleep(1000);
   DropDownUtils.dropdownList(sp.officedropdownlist(), "tahsil Office");
   Thread.sleep(1000);
   JavaScriptUtils.ScrollIntoView(sp.forward());
   sp.clickrisubmit();
   HandlePop.getHandlePop();
   sp.clickricontinue();
   String confirm= sp.getConfirmText().substring(12,26);
   System.out.println("the Application No:" +confirm);
   Assert.assertEquals(sebc, confirm, "sebc No didnt match");
   sp.clickdaclose();
   sp.clickUser();
   sp.clickLogout();


  } catch (Exception e) {
   throw new RuntimeException(e);
  }


 }

  @Test(dependsOnMethods = "forwardtoTahsilbyRI")
  public void approvebyTahsil()
  {
   try
   {
    CoreApplicationPage cp= new CoreApplicationPage();
    cp.click_OfficialLogin();
    HandleTab.getHandleTab(1);
    cp.enter_username("tdr.bargarh").enter_password("Pass@1231")
            .clickLogin()
            .clickCoreApplication().click_applicationbox()
            .click_mypendingapplications()
            .click_sebcapplications();
    SebcPage sp=new SebcPage();
    sp.txt_searchbox(sebc);
    Thread.sleep(2000);
    DropDownUtils.dropdownSelect(sp.tahsilfirstrecord());
    JavascriptExecutor js=  (JavascriptExecutor)DriverManager.getDriver();
    js.executeScript("window.scrollBy(0,1000)");
    sp.txt_tahsil_remarks("some remarks");
    Thread.sleep(1000);
    DropDownUtils.dropdownSelect(sp.actiondropdown());
    Thread.sleep(1000);
    DropDownUtils.dropdownList(sp.actiondropdownlist(), "approve");
    Thread.sleep(1000);
    HandlePop.getHandlePop();
    sp.clicktahsilpreviewsave();
    sp.clickTahsilsubmit();
    HandlePop.getHandlePop();
    sp.clickTahsilcontinue();
    HandlePop.getHandlePop();
    sp.clickDigitalSignature();

   } catch (Exception e) {
    throw new RuntimeException(e);
   }
  }

  @Test
  public void forwardtoOtherTahsil()
  {
    try
    {
     CoreApplicationPage cp= new CoreApplicationPage();
     cp.click_OfficialLogin();
     HandleTab.getHandleTab(1);
     cp.enter_username("tdr.bargarh").enter_password("Pass@1231")
             .clickLogin()
             .clickCoreApplication().click_applicationbox().click_mypendingapplications().click_sebcapplications();
     SebcPage sp=new SebcPage();
     sp.txt_searchbox("E-LHC/2023/149");
     Thread.sleep(2000);
     DropDownUtils.dropdownSelect(sp.tahsilfirstrecord());
     Thread.sleep(3000);
     sp.txt_ri_remarks("some remarks");
     Thread.sleep(1000);
     DropDownUtils.dropdownSelect(sp.actiondropdown());
     Thread.sleep(2000);
     DropDownUtils.dropdownList(sp.actiondropdownlist(), "Forward To Other Tahsil");
     Thread.sleep(1000);
     sp.txt_othertahsil_district("Kalahandi");
     Thread.sleep(1000);
     sp.clickhighlighted();
     Thread.sleep(1000);
     sp.txt_othertahsil_subdivision("Bhawanipatna");
     Thread.sleep(1000);
     sp.clickhighlighted();
     Thread.sleep(1000);
     sp.txt_othertahsil_tahsil("Kalahandi");
     Thread.sleep(1000);
     sp.clickhighlighted();
     Thread.sleep(1000);
     JavaScriptUtils.ScrollIntoView(sp.forward());
     sp.clickrisubmit();
     HandlePop.getHandlePop();
     sp.clickricontinue();
     String confirm= sp.getConfirmText().substring(12,26);
     System.out.println("the Application No:" +confirm);
     Assert.assertEquals("E-LHC/2023/149", confirm, "Sebc No didnt match");
     sp.clickdaclose();
     sp.clickUser();
     sp.clickLogout();

    } catch (Exception e) {
     throw new RuntimeException(e);
    }

  }

   @Test
   public void sendBacktoParentTahsil()
   {
     try
     {
      CoreApplicationPage cp= new CoreApplicationPage();
      cp.click_OfficialLogin();
      HandleTab.getHandleTab(1);
      cp.enter_username("tdr.kalahand").enter_password("Pass@1231")
              .clickLogin()
              .clickCoreApplication().click_applicationbox();
      cp.click_scrollleftlapplications();
      JavascriptExecutor js=(JavascriptExecutor) DriverManager.getDriver();
      js.executeScript("window.scrollBy(0,50);");
      DropDownUtils.dropdownSelect(cp.othertahsilapplications());


      SebcPage sp=new SebcPage();
      sp.clickOtherTahsil();
      cp.click_sebcapplications();
      sp.txt_searchbox("E-LHC/2023/149");
      Thread.sleep(2000);
      DropDownUtils.dropdownSelect(sp.tahsilfirstrecord());
      Thread.sleep(3000);
      sp.txt_ri_remarks("some remarks");
      Thread.sleep(1000);
      DropDownUtils.dropdownSelect(sp.actiondropdown());
      Thread.sleep(1000);
      DropDownUtils.dropdownList(sp.actiondropdownlist(), "Sendback");
      Thread.sleep(1000);
      sp.clickrisubmit();
      HandlePop.getHandlePop();
      sp.clickricontinue();
      String confirm= sp.getConfirmText().substring(12,26);
      System.out.println("the Application No:" +confirm);
      Assert.assertEquals("E-LHC/2023/149", confirm, "Sebc No didnt match");
      sp.clickdaclose();
      sp.clickUser();
      sp.clickLogout();

     } catch (Exception e) {
      throw new RuntimeException(e);
     }

   }

}
