package com.srit.tests;

import com.srit.config.*;
import com.srit.constants.FrameworkConstants;
import com.srit.driver.DriverManager;
import com.srit.pages.CastePage;
import com.srit.pages.CoreApplicationPage;
import com.srit.pages.IncomePage;
import com.srit.pages.LegalHeirPage;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CasteCertificate extends  BaseTest{

    String caste=null;

    Xls_Reader reader=new Xls_Reader(FrameworkConstants.getExcelFilepath());
    String sheetname="Caste";
@Test
    public void applyforCasteService()
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
       /* CoreApplicationPage cp=new CoreApplicationPage();
        cp.enter_username("csc1.sundar").enter_password("Pass@1231").clickLogin().clickCoreApplication()
                .clickServices().clickSubmitApplication().txt_createuai1("4462")
                .txt_createuai2("0306").txt_createuai3("0000").txt_createuai4("0299").btn_create_uai();*/

        CastePage sc= cp.click_casteCertifcate();
        sc.click_Proceed();
        System.out.println(sc.getDocumentTitle());
        DropDownUtils.selectByText(sc.districtdropdown(), reader.getCellData(sheetname, "Pdistrict", 2));
        DropDownUtils.selectByText(sc.subdivisiondropdown(), reader.getCellData(sheetname, "Psubdivision", 2));
        DropDownUtils.selectByText(sc.tahsildropdown(), reader.getCellData(sheetname, "Ptahsil", 2));
        DropDownUtils.selectByText(sc.ridropdown(), reader.getCellData(sheetname, "Pri", 2));
        DropDownUtils.selectByText(sc.villagedropdown(), reader.getCellData(sheetname, "Pvillage", 2));
        DropDownUtils.selectByText(sc.castedropdown(),reader.getCellData(sheetname, "Caste", 2));
        DropDownUtils.selectByText(sc.religiondropdown(), reader.getCellData(sheetname, "Religion", 2));
        sc.txt_policestation(reader.getCellData(sheetname, "Ppolicestation", 2));
        FileUploadUtils.fileUpload(sc.fileUpload(), FrameworkConstants.getUploadfilepath());
        sc.txt_purpose(reader.getCellData(sheetname, "Purpose", 2));
        DropDownUtils.dropdownSelect(sc.agree());
        sc.txt_place(reader.getCellData(sheetname, "Place", 2));
        sc.clicksubmit();
        HandlePop.getHandlePop();
        Thread.sleep(1000);
        sc.click_Yes();
        String text=sc.getApplicationNo();
        System.out.println(text);
        Assert.assertEquals("Application No", text.substring(0,14));
        caste=sc.getCasteCertNo();
        System.out.println(caste);
        sc.clickConfirm();
        HandlePop.getHandlePop();
        Thread.sleep(1000);
        sc.clickContinue();
        sc.clickCitizenUser();
        sc.clickCitizenlogout();



    } catch (Exception e) {
        throw new RuntimeException(e);
    }

}

@Test(dependsOnMethods = "applyforCasteService")
    public void forwardbyDAtoRI()
{
    try
    {
        CoreApplicationPage cp= new CoreApplicationPage();
        cp.enter_username("da.bargarh").enter_password("Pass@1231")
                .clickLogin()
                .clickCoreApplication().
                click_applicationbox().
                click_mypendingapplications().click_casteapplications();
        CastePage sc= new CastePage();
        sc.click_firstrecord();
        Thread.sleep(2000);
        sc.txt_da_remarks("some remarks");
        Thread.sleep(1000);
        DropDownUtils.dropdownSelect(sc.actiondropdown());
        Thread.sleep(1000);
        DropDownUtils.dropdownList(sc.actiondropdownlist(), "forward");
        Thread.sleep(1000);
        DropDownUtils.dropdownSelect(sc.officedropdown());
        Thread.sleep(1000);
        DropDownUtils.dropdownList(sc.officedropdownlist(), "ri Office");
        Thread.sleep(1000);
        JavaScriptUtils.ScrollIntoView(sc.forwardtori());
        sc.clickdasubmit();
        HandlePop.getHandlePop();
        sc.clickdacontinue();
        HandlePop.getHandlePop();
        sc.clickdaclose();
        sc.clickUser();
        sc.clickLogout();



    } catch (Exception e) {
        throw new RuntimeException(e);
    }
}

@Test(dependsOnMethods = "forwardbyDAtoRI")
    public void forwardtoTahsilByRI()
{
    try
    {
        CoreApplicationPage cp= new CoreApplicationPage();
        cp.enter_username("ri.jamurda").enter_password("Pass@1231")
                .clickLogin()
                .clickCoreApplication().
                click_applicationbox().
                click_mypendingapplications().click_casteapplications();
        CastePage sc= new CastePage();
        sc.txt_searchbox(caste);
        Thread.sleep(2000);
        DropDownUtils.dropdownSelect(sc.tahsilfirstrecord());
        Thread.sleep(3000);
        DropDownUtils.dropdownSelect(sc.getUpdateVerificationReport());
        HandlePop.getHandlePop();
        String ConfirmVerificationApplicationNo=sc.getCasteVerificationNo().substring(2);
        System.out.println(ConfirmVerificationApplicationNo);
        Assert.assertEquals(caste,ConfirmVerificationApplicationNo );
        sc.txt_verification_mouza("mouza");
        sc.txt_verification_khata("90/90");
        sc.txt_verification_plot("9090/90");
        sc.txt_verification_extent("testing");
        sc.txt_verification_khatadarname("name");
        sc.txt_verification_recorded_tenant("dinesh");
        sc.txt_verification_relation_recorded_tenant("relation");
        sc.txt_verification_original_patta("patta");
        sc.txt_verification_father_land("father");
        sc.txt_verification_occupation("occupation");
        sc.txt_verification_applicant_native("nativefapplicant");
        sc.txt_verification_remarks("some remarks");
        sc.verification_fileupload(FrameworkConstants.getUploadfilepath());
        sc.clickVerificationSubmit();
        HandlePop.getHandlePop();
        sc.clickVerificationContinue();
        HandlePop.getHandlePop();
        sc.txt_ri_remarks("some remarks");
        Thread.sleep(1000);
        DropDownUtils.dropdownSelect(sc.actiondropdown());
        Thread.sleep(1000);
        DropDownUtils.dropdownList(sc.actiondropdownlist(), "forward");
        Thread.sleep(1000);
        JavaScriptUtils.ScrollIntoView(sc.officedropdown());
        DropDownUtils.dropdownSelect(sc.officedropdown());
        Thread.sleep(1000);
        DropDownUtils.dropdownList(sc.officedropdownlist(), "tahsil Office");
        Thread.sleep(1000);
        JavaScriptUtils.ScrollIntoView(sc.forward());
        sc.clickrisubmit();
        HandlePop.getHandlePop();
        sc.clickricontinue();
        String confirm= sc.getConfirmText().substring(12,26);
        System.out.println("the Application No:" +confirm);
        Assert.assertEquals(caste, confirm, "Caste No didnt match");
        sc.clickdaclose();
        sc.clickUser();
        sc.clickLogout();

    } catch (Exception e) {
        throw new RuntimeException(e);
    }
}

@Test(dependsOnMethods = "forwardtoTahsilByRI")
    public void approvebyTahsil()
{
    try
    {
        CoreApplicationPage cp= new CoreApplicationPage();
        cp.enter_username("tdr.bargarh").enter_password("Pass@1231")
                .clickLogin()
                .clickCoreApplication().click_applicationbox()
                .click_mypendingapplications()
                .click_casteapplications();
        CastePage sc=new CastePage();
        sc.txt_searchbox(caste);
        Thread.sleep(2000);
        DropDownUtils.dropdownSelect(sc.tahsilfirstrecord());
        JavascriptExecutor js=  (JavascriptExecutor)DriverManager.getDriver();
        js.executeScript("window.scrollBy(0,1000)", "");
        sc.txt_tahsil_remarks("some remarks");
        Thread.sleep(1000);
        DropDownUtils.dropdownSelect(sc.actiondropdown());
        Thread.sleep(1000);
        DropDownUtils.dropdownList(sc.actiondropdownlist(), "approve");
        Thread.sleep(1000);
        HandlePop.getHandlePop();
        sc.clicktahsilpreviewsave();
        sc.clickTahsilsubmit();
        HandlePop.getHandlePop();
        sc.clickTahsilcontinue();
        HandlePop.getHandlePop();
        sc.clickDigitalSignature();

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
                 .clickCoreApplication().click_applicationbox().click_mypendingapplications().click_casteapplications();
         CastePage sc=new CastePage();
         sc.txt_searchbox("E-LHC/2023/149");
         Thread.sleep(2000);
         DropDownUtils.dropdownSelect(sc.tahsilfirstrecord());
         Thread.sleep(3000);
         sc.txt_ri_remarks("some remarks");
         Thread.sleep(1000);
         DropDownUtils.dropdownSelect(sc.actiondropdown());
         Thread.sleep(2000);
         DropDownUtils.dropdownList(sc.actiondropdownlist(), "Forward To Other Tahsil");
         Thread.sleep(1000);
         sc.txt_othertahsil_district("Kalahandi");
         Thread.sleep(1000);
         sc.clickhighlighted();
         Thread.sleep(1000);
         sc.txt_othertahsil_subdivision("Bhawanipatna");
         Thread.sleep(1000);
         sc.clickhighlighted();
         Thread.sleep(1000);
         sc.txt_othertahsil_tahsil("Kalahandi");
         Thread.sleep(1000);
         sc.clickhighlighted();
         Thread.sleep(1000);
         JavaScriptUtils.ScrollIntoView(sc.forward());
         sc.clickrisubmit();
         HandlePop.getHandlePop();
         sc.clickricontinue();
         String confirm= sc.getConfirmText().substring(12,26);
         System.out.println("the Application No:" +confirm);
         Assert.assertEquals("E-LHC/2023/149", confirm, "Caste No didnt match");
         sc.clickdaclose();
         sc.clickUser();
         sc.clickLogout();
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


          CastePage sc=new CastePage();
          sc.clickOtherTahsil();
          cp.click_legalapplications();
          sc.txt_searchbox("E-LHC/2023/149");
          Thread.sleep(2000);
          DropDownUtils.dropdownSelect(sc.tahsilfirstrecord());
          Thread.sleep(3000);
          sc.txt_ri_remarks("some remarks");
          Thread.sleep(1000);
          DropDownUtils.dropdownSelect(sc.actiondropdown());
          Thread.sleep(1000);
          DropDownUtils.dropdownList(sc.actiondropdownlist(), "Sendback");
          Thread.sleep(1000);
          sc.clickrisubmit();
          HandlePop.getHandlePop();
          sc.clickricontinue();
          String confirm= sc.getConfirmText().substring(12,26);
          System.out.println("the Application No:" +confirm);
          Assert.assertEquals("E-LHC/2023/149", confirm, "Caste No didnt match");
          sc.clickdaclose();
          sc.clickUser();
          sc.clickLogout();


      } catch (Exception e) {
          throw new RuntimeException(e);
      }
  }



}
