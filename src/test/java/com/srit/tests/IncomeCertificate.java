package com.srit.tests;

import com.srit.config.*;
import com.srit.constants.FrameworkConstants;
import com.srit.driver.DriverManager;
import com.srit.pages.CoreApplicationPage;
import com.srit.pages.IncomePage;
import com.srit.pages.LegalHeirPage;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IncomeCertificate extends BaseTest{

    String Incomeno=null;

    Xls_Reader reader=new Xls_Reader(FrameworkConstants.getExcelFilepath());
    String sheetname="Income";

@Test
    public void applyforIncomeService()
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

    /*    CoreApplicationPage cp=new CoreApplicationPage();
        cp.enter_username("csc1.sundar").enter_password("Pass@1231").clickLogin().clickCoreApplication()
                .clickServices().clickSubmitApplication().txt_createuai1("4462")
                .txt_createuai2("0306").txt_createuai3("0000").txt_createuai4("0299").btn_create_uai();*/

        IncomePage in=cp.click_incomeCertifcate();
        in.click_Proceed();
        System.out.println(in.getDocumentTitle());
        JavascriptExecutor js= (JavascriptExecutor) DriverManager.getDriver();
        js.executeScript("window.scrollBy(0,300)", "");

        DropDownUtils.selectByText(in.districtdropdown(), reader.getCellData(sheetname, "Pdistrict", 2));
        DropDownUtils.selectByText(in.subdivisiondropdown(), reader.getCellData(sheetname, "Psubdivision", 2));
        DropDownUtils.selectByText(in.tahsildropdown(), reader.getCellData(sheetname, "Ptahsil", 2));
        DropDownUtils.selectByText(in.ridropdown(), reader.getCellData(sheetname, "Pri", 2));
        DropDownUtils.selectByText(in.villagedropdown(), reader.getCellData(sheetname, "Pvillage", 2));
        in.txt_policestation(reader.getCellData(sheetname, "Ppolicestation", 2));
        in.txt_agriculture(reader.getCellData(sheetname, "Agriculture", 2));
        in.txt_salary(reader.getCellData(sheetname, "Salary", 2));
        in.txt_trade(reader.getCellData(sheetname, "Trade", 2));
        in.txt_others(reader.getCellData(sheetname, "Othersources", 2));
        FileUploadUtils.fileUpload(in.fileUpload(), FrameworkConstants.getUploadfilepath());
        in.txt_purpose(reader.getCellData(sheetname, "Purpose", 2));
        Thread.sleep(2000);
        DropDownUtils.dropdownSelect(in.agree());
        in.txt_place(reader.getCellData(sheetname, "Place", 2));
        in.clicksubmit();
        HandlePop.getHandlePop();
        Thread.sleep(1000);
        in.click_Yes();
        String text=in.getApplicationNo();
        System.out.println(text);
        Assert.assertEquals("Application No", text.substring(0,14));
        Incomeno=in.getIncomeCertNo();
        System.out.println(Incomeno);
        in.clickConfirm();
        HandlePop.getHandlePop();
        Thread.sleep(1000);
        in.clickContinue();
        in.clickCitizenUser();
        in.clickCitizenlogout();

    } catch (Exception e) {
        throw new RuntimeException(e);
    }
}

   // dependsOnMethods = "applyforIncomeService"
@Test()
    public void forwardbyDAtoRI()
{
    try
    {
        CoreApplicationPage cp= new CoreApplicationPage();
        cp.click_OfficialLogin();
        HandleTab.getHandleTab(1);
        cp.enter_username("da.bargarh").enter_password("Pass@1231")
                .clickLogin()
                .clickCoreApplication().click_applicationbox().click_mypendingapplications().click_incomeapplications();

        IncomePage in= new IncomePage();
        Thread.sleep(2000);
        in.click_firstrecord();
        Thread.sleep(2000);
        in.txt_da_remarks("some remarks");
        Thread.sleep(1000);
        DropDownUtils.dropdownSelect(in.actiondropdown());
        Thread.sleep(1000);
        DropDownUtils.dropdownList(in.actiondropdownlist(), "forward");
        Thread.sleep(1000);
        DropDownUtils.dropdownSelect(in.officedropdown());
        Thread.sleep(1000);
        DropDownUtils.dropdownList(in.officedropdownlist(), "ri Office");
        Thread.sleep(1000);
        JavaScriptUtils.ScrollIntoView(in.forwardtori());
        in.clickdasubmit();
        HandlePop.getHandlePop();
        in.clickdacontinue();
        HandlePop.getHandlePop();
        in.clickdaclose();
        in.clickUser();
        in.clickLogout();


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
        cp.click_OfficialLogin();
        HandleTab.getHandleTab(1);
        cp.enter_username("ri.jamurda").enter_password("Pass@1231")
                .clickLogin()
                .clickCoreApplication().click_applicationbox().click_mypendingapplications().click_incomeapplications();
        IncomePage in=new IncomePage();
        in.txt_searchbox(Incomeno);
        Thread.sleep(2000);
        DropDownUtils.dropdownSelect(in.tahsilfirstrecord());
        Thread.sleep(3000);
        DropDownUtils.dropdownSelect(in.getUpdateVerificationReport());
        HandlePop.getHandlePop();
        String ConfirmVerificationApplicationNo=in.getIncomeVerificationNo().substring(2);
        System.out.println(ConfirmVerificationApplicationNo);
        Assert.assertEquals(Incomeno,ConfirmVerificationApplicationNo );
        in.txt_verification_remarks("some remarks");
        in.verification_fileupload(FrameworkConstants.getUploadfilepath());
        in.clickVerificationSubmit();
        HandlePop.getHandlePop();
        in.clickVerificationContinue();
        HandlePop.getHandlePop();
        in.txt_ri_remarks("some remarks");
        Thread.sleep(1000);
        DropDownUtils.dropdownSelect(in.actiondropdown());
        Thread.sleep(1000);
        DropDownUtils.dropdownList(in.actiondropdownlist(), "forward");
        Thread.sleep(1000);
        JavaScriptUtils.ScrollIntoView(in.officedropdown());
        DropDownUtils.dropdownSelect(in.officedropdown());
        Thread.sleep(1000);
        DropDownUtils.dropdownList(in.officedropdownlist(), "tahsil Office");
        Thread.sleep(1000);
        JavaScriptUtils.ScrollIntoView(in.forward());
        in.clickrisubmit();
        HandlePop.getHandlePop();
        in.clickricontinue();
        String confirm= in.getConfirmText().substring(12,26);
        System.out.println("the Application No:" +confirm);
        Assert.assertEquals(Incomeno, confirm, "Income No didnt match");
        in.clickdaclose();
        in.clickUser();
        in.clickLogout();


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
        cp.click_OfficialLogin();
        HandleTab.getHandleTab(1);
        cp.enter_username("tdr.bargarh").enter_password("Pass@1231")
                .clickLogin()
                .clickCoreApplication().click_applicationbox()
                .click_mypendingapplications()
                .click_incomeapplications();
        IncomePage in= new IncomePage();
        in.txt_searchbox(Incomeno);
        Thread.sleep(2000);
        DropDownUtils.dropdownSelect(in.tahsilfirstrecord());
        JavascriptExecutor js=  (JavascriptExecutor)DriverManager.getDriver();
        js.executeScript("window.scrollBy(0,1000)", "");
        in.txt_tahsil_remarks("some remarks");
        Thread.sleep(1000);
        DropDownUtils.dropdownSelect(in.actiondropdown());
        Thread.sleep(1000);
        DropDownUtils.dropdownList(in.actiondropdownlist(), "approve");
        Thread.sleep(1000);
        HandlePop.getHandlePop();
        in.clicktahsilpreviewsave();
        in.clickTahsilsubmit();
        HandlePop.getHandlePop();
        in.clickTahsilcontinue();
        HandlePop.getHandlePop();
        in.clickDigitalSignature();


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
                  .clickCoreApplication().click_applicationbox().click_mypendingapplications().click_incomeapplications();
          IncomePage in=new IncomePage();
          in.txt_searchbox("E-LHC/2023/149");
          Thread.sleep(2000);
          DropDownUtils.dropdownSelect(in.tahsilfirstrecord());
          Thread.sleep(3000);
          in.txt_ri_remarks("some remarks");
          Thread.sleep(1000);
          DropDownUtils.dropdownSelect(in.actiondropdown());
          Thread.sleep(2000);
          DropDownUtils.dropdownList(in.actiondropdownlist(), "Forward To Other Tahsil");
          Thread.sleep(1000);
          in.txt_othertahsil_district("Kalahandi");
          Thread.sleep(1000);
          in.clickhighlighted();
          Thread.sleep(1000);
          in.txt_othertahsil_subdivision("Bhawanipatna");
          Thread.sleep(1000);
          in.clickhighlighted();
          Thread.sleep(1000);
          in.txt_othertahsil_tahsil("Kalahandi");
          Thread.sleep(1000);
          in.clickhighlighted();
          Thread.sleep(1000);
          JavaScriptUtils.ScrollIntoView(in.forward());
          in.clickrisubmit();
          HandlePop.getHandlePop();
          in.clickricontinue();
          String confirm= in.getConfirmText().substring(12,26);
          System.out.println("the Application No:" +confirm);
          Assert.assertEquals("E-LHC/2023/149", confirm, "Income No didnt match");
          in.clickdaclose();
          in.clickUser();
          in.clickLogout();

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


          IncomePage in=new IncomePage();
          in.clickOtherTahsil();
          cp.click_legalapplications();
          in.txt_searchbox("E-LHC/2023/149");
          Thread.sleep(2000);
          DropDownUtils.dropdownSelect(in.tahsilfirstrecord());
          Thread.sleep(3000);
          in.txt_ri_remarks("some remarks");
          Thread.sleep(1000);
          DropDownUtils.dropdownSelect(in.actiondropdown());
          Thread.sleep(1000);
          DropDownUtils.dropdownList(in.actiondropdownlist(), "Sendback");
          Thread.sleep(1000);
          in.clickrisubmit();
          HandlePop.getHandlePop();
          in.clickricontinue();
          String confirm= in.getConfirmText().substring(12,26);
          System.out.println("the Application No:" +confirm);
          Assert.assertEquals("E-LHC/2023/149", confirm, "Income No didnt match");
          in.clickdaclose();
          in.clickUser();
          in.clickLogout();




      } catch (Exception e) {
          throw new RuntimeException(e);
      }
  }



}
