package com.srit.tests;

import com.srit.config.DropDownUtils;
import com.srit.config.FileUploadUtils;
import com.srit.config.HandlePop;
import com.srit.config.JavaScriptUtils;
import com.srit.constants.FrameworkConstants;
import com.srit.driver.DriverManager;
import com.srit.pages.CoreApplicationPage;
import com.srit.pages.LegalHeirPage;
import com.srit.pages.SebcPage;
import com.srit.pages.TribePage;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SEBCCertificate extends BaseTest{


    String sebc=null;

    @Test
    public void applyforSEBCServices()
    {
        try
        {

         CoreApplicationPage cp=new CoreApplicationPage();
         cp.click_citizenlogin();
         cp.txt_email("sunnyxmail@gmail.com");
         cp.txt_password("Sunil@123");
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
             DropDownUtils.selectByText(sp.permanentdistrictdropdown(), "Balangir");
             Thread.sleep(1000);
             DropDownUtils.selectByText(sp.permanentblockdropdown(), "Balangir");
             Thread.sleep(1000);
             DropDownUtils.selectByText(sp.permanentgpdropdown(), "Balangir");
             Thread.sleep(1000);
             DropDownUtils.selectByText(sp.permanentvillagedropdown(), "Adendungri");
             DropDownUtils.selectByText(sp.districtdropdown(), "Bargarh");
             DropDownUtils.selectByText(sp.subdivisiondropdown(),"Bargarh");
             DropDownUtils.selectByText(sp.tahsildropdown(), "Bargarh");
             DropDownUtils.selectByText(sp.ridropdown(), "Jamurda");
             DropDownUtils.selectByText(sp.villagedropdown(), "jamu");
             sp.txt_policestation("police station");

             DropDownUtils.dropdownSelect(sp.clickpresentAddress());
             DropDownUtils.selectByText(sp.presentdistrictdropdown(), "Balangir");
             Thread.sleep(1000);
             DropDownUtils.selectByText(sp.presentblockdropdown(), "Balangir");
             Thread.sleep(1000);
             DropDownUtils.selectByText(sp.presentgpdropdown(),"Balangir");
             Thread.sleep(1000);
             DropDownUtils.selectByText(sp.presenttvillagedropdown(),"Adendungri");
             DropDownUtils.selectByText(sp.castedropdown(), "Hansi");

             DropDownUtils.selectByText(sp.religiondropdown(), "Hindu");
             DropDownUtils.dropdownSelect(sp.clickFather());
             DropDownUtils.selectByText(sp.servicedropdown(), "State");
             sp.txt_designation("designation");
             sp.txt_scaleofpay("1000");
             sp.txt_father_age("23");
             sp.txt_father_organization("srit");
             sp.txt_father_intdesignation("designation");
             sp.txt_father_puborganization("public organization");
             sp.txt_gov_designation("designation");
             sp.txt_annualincome("1000");
             sp.txt_father_paradesignation("paradesignation");
             sp.txt_father_parascaleofpay("1000");
             sp.txt_father_occupation("occupation");
             sp.txt_father_agri_landlocation("location");
             sp.txt_father_agri_landsize("23");
             sp.txt_father_irrigateone("78");
             sp.txt_father_irrigatetwo("78");
             sp.txt_father_irrigatethree("ui");
             sp.txt_father_uniirrigateone("78");
             sp.txt_father_unirrigatetwo("6767");
             sp.txt_father_unirrigatethree("56556");
             DropDownUtils.selectByText(sp.cropsndropdown(), "Crop plant");
             sp.txt_plantation_location("location");
             sp.txt_plantation_area("89");
             sp.txt_vacant_locationproperty("testing");
             sp.txt_vacant_detailsofproperty("testing");
             sp.txt_vacant_useto("testing");
             sp.txt_father_annualincome("100");
             sp.txt_father_wealthtax("1000");
             sp.txt_otherremarks("testing");
             FileUploadUtils.fileUpload(sp.fileUpload(), FrameworkConstants.getUploadfilepath());
             sp.txt_purpose("some purpose");
             Thread.sleep(2000);
             DropDownUtils.dropdownSelect(sp.agree());
             sp.txt_place("place");
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
