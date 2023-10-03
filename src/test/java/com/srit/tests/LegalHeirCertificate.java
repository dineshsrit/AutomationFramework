package com.srit.tests;

import com.srit.config.*;
import com.srit.constants.FrameworkConstants;
import com.srit.driver.DriverManager;
import com.srit.pages.CoreApplicationPage;
import com.srit.pages.IncomePage;
import com.srit.pages.LegalHeirPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LegalHeirCertificate extends BaseTest{


    String legal=null;

    Xls_Reader reader=new Xls_Reader(FrameworkConstants.getExcelFilepath());
    String sheetname="LegalHeir";

    @Test
    public void applyforLegalHeirService()
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
            LegalHeirPage lp= cp.click_legalCertificate();
            lp.click_Proceed();
            System.out.println(lp.getDocumentTitle());
            lp.txt_deceasedFirstName(reader.getCellData(sheetname, "DeceasedPerson", 2));
            lp.txt_deceasedSpouseFirstName(reader.getCellData(sheetname, "DeceasedFather", 2));
            DropDownUtils.selectByText(lp.relationdropdown(), reader.getCellData(sheetname, "Relationship", 2));
            DropDownUtils.selectByText(lp.deceasedgenderdropdown(), reader.getCellData(sheetname, "Gender", 2));
            lp.txt_placeofdeath(reader.getCellData(sheetname, "DeathPlace", 2));
            Thread.sleep(1000);
            DropDownUtils.dropdownSelect(lp.getdateofdeath());
            HandlePop.getHandlePop();
            DropDownUtils.selectByText(lp.getmonth(), "Sep");
            DropDownUtils.selectByText(lp.getyear(), "2023");
            lp.clickDate();
           //lp.txt_dateofdeath("20/09/2023");
            lp.txt_deathaddress(reader.getCellData(sheetname, "DeathAddress", 2));
            lp.txt_legalname(reader.getCellData(sheetname, "Legalname", 2));
            lp.txt_legalage(reader.getCellData(sheetname, "Legalage", 2));
            DropDownUtils.selectByText(lp.getlegalstatus(), reader.getCellData(sheetname, "LegalmartialStatus", 2));
            lp.txt_legalrelation(reader.getCellData(sheetname, "RelationshipDeceased", 2));
            DropDownUtils.dropdownSelect(lp.clickreceipt());
            lp.txt_others(reader.getCellData(sheetname, "Others", 2));
            DropDownUtils.selectByText(lp.districtdropdown(), reader.getCellData(sheetname, "Pdistrict", 2));
            DropDownUtils.selectByText(lp.subdivisiondropdown(), reader.getCellData(sheetname, "Psubdivision", 2));
            DropDownUtils.selectByText(lp.tahsildropdown(), reader.getCellData(sheetname, "Ptahsil", 2));
            DropDownUtils.selectByText(lp.ridropdown(), reader.getCellData(sheetname, "Pri", 2));
            DropDownUtils.selectByText(lp.villagedropdown(), reader.getCellData(sheetname, "Pvillage", 2));
            lp.txt_policestation(reader.getCellData(sheetname, "Ppolicestation", 2));
            FileUploadUtils.fileUpload(lp.fileUpload(), FrameworkConstants.getUploadfilepath());
            FileUploadUtils.fileUpload(lp.fileUploadSupport(), FrameworkConstants.getUploadfilepath());
            DropDownUtils.dropdownSelect(lp.agree());
            lp.txt_place(reader.getCellData(sheetname, "Place", 2));
            lp.clicksubmit();
            HandlePop.getHandlePop();
            Thread.sleep(1000);
            lp.click_Yes();
            String text=lp.getApplicationNo();
            System.out.println(text);
            Assert.assertEquals("Application No", text.substring(0,14));
            legal=lp.getIhcCertNo();
            System.out.println(legal);
            lp.clickConfirm();
            HandlePop.getHandlePop();
            Thread.sleep(1000);
            lp.clickContinue();
            lp.clickCitizenUser();
            lp.clickCitizenlogout();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void forwardtoRIbyDA()
    {
        try
        {
            CoreApplicationPage cp= new CoreApplicationPage();
            cp.click_OfficialLogin();
            HandleTab.getHandleTab(1);
            cp.enter_username(reader.getCellData(sheetname, "OfficialDA", 2)).enter_password(reader.getCellData(sheetname, "Password", 2))
                    .clickLogin()
                    .clickCoreApplication().
                    click_applicationbox().
                    click_mypendingapplications().click_legalapplications();
            LegalHeirPage lp=new LegalHeirPage();
            //lp.click_csv();
            //lp.click_search();
            //Wait.waitClickable(20, lp.click_firstrecord());
            Thread.sleep(4000);

            lp.click_firstrecord();
            lp.txt_da_remarks("some remarks");
            Thread.sleep(1000);
            DropDownUtils.dropdownSelect(lp.actiondropdown());
            Thread.sleep(1000);
            DropDownUtils.dropdownList(lp.actiondropdownlist(), "forward");
            Thread.sleep(1000);
            DropDownUtils.dropdownSelect(lp.officedropdown());
            Thread.sleep(1000);
            DropDownUtils.dropdownList(lp.officedropdownlist(), "ri Office");
            Thread.sleep(1000);
            JavaScriptUtils.ScrollIntoView(lp.forwardtori());
            lp.clickdasubmit();
            HandlePop.getHandlePop();
            lp.clickdacontinue();
            HandlePop.getHandlePop();
            lp.clickdaclose();
            lp.clickUser();
            lp.clickLogout();


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void forwardtoTahsilByRI()
    {
        try
        {
            CoreApplicationPage cp= new CoreApplicationPage();
            cp.click_OfficialLogin();
            HandleTab.getHandleTab(1);
            cp.enter_username("ri.jamurda").enter_password("Pass@1231")
                    .clickLogin()
                    .clickCoreApplication().click_applicationbox().click_mypendingapplications().click_legalapplications();
            LegalHeirPage lp=new LegalHeirPage();
            lp.txt_searchbox("E-LHC/2023/149");
            Thread.sleep(2000);
            DropDownUtils.dropdownSelect(lp.tahsilfirstrecord());
            Thread.sleep(3000);
            DropDownUtils.dropdownSelect(lp.getUpdateVerificationReport());
            HandlePop.getHandlePop();
            String ConfirmVerificationApplicationNo=lp.getIncomeVerificationNo().substring(2);
            System.out.println(ConfirmVerificationApplicationNo);
            Assert.assertEquals("E-LHC/2023/149",ConfirmVerificationApplicationNo );
            lp.txt_ri_purpose("some purpose");
            lp.txt_verification_remarks("some remarks");
            lp.verification_fileupload(FrameworkConstants.getUploadfilepath());
            lp.clickVerificationSubmit();
            HandlePop.getHandlePop();
            lp.clickVerificationContinue();
            HandlePop.getHandlePop();
            lp.txt_ri_remarks("some remarks");
            Thread.sleep(1000);
            DropDownUtils.dropdownSelect(lp.actiondropdown());
            Thread.sleep(1000);
            DropDownUtils.dropdownList(lp.actiondropdownlist(), "forward");
            Thread.sleep(1000);
            JavaScriptUtils.ScrollIntoView(lp.officedropdown());
            DropDownUtils.dropdownSelect(lp.officedropdown());
            Thread.sleep(1000);
            DropDownUtils.dropdownList(lp.officedropdownlist(), "tahsil Office");
            Thread.sleep(1000);
            JavaScriptUtils.ScrollIntoView(lp.forward());
            lp.clickrisubmit();
            HandlePop.getHandlePop();
            lp.clickricontinue();
            String confirm= lp.getConfirmText().substring(12,26);
            System.out.println("the Application No:" +confirm);
            Assert.assertEquals("E-LHC/2023/149", confirm, "legal No didnt match");
            lp.clickdaclose();
            lp.clickUser();
            lp.clickLogout();
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
                    .clickCoreApplication().click_applicationbox().click_mypendingapplications().click_legalapplications();
            LegalHeirPage lp=new LegalHeirPage();
            lp.txt_searchbox("E-LHC/2023/149");
            Thread.sleep(2000);
            DropDownUtils.dropdownSelect(lp.tahsilfirstrecord());
            Thread.sleep(3000);
            lp.txt_ri_remarks("some remarks");
            Thread.sleep(1000);
            DropDownUtils.dropdownSelect(lp.actiondropdown());
            Thread.sleep(2000);
            DropDownUtils.dropdownList(lp.actiondropdownlist(), "Forward To Other Tahsil");
            Thread.sleep(1000);
            lp.txt_othertahsil_district("Kalahandi");
            Thread.sleep(1000);
            lp.clickhighlighted();
            Thread.sleep(1000);
            lp.txt_othertahsil_subdivision("Bhawanipatna");
            Thread.sleep(1000);
            lp.clickhighlighted();
            Thread.sleep(1000);
            lp.txt_othertahsil_tahsil("Kalahandi");
            Thread.sleep(1000);
            lp.clickhighlighted();
            Thread.sleep(1000);
            JavaScriptUtils.ScrollIntoView(lp.forward());
            lp.clickrisubmit();
            HandlePop.getHandlePop();
            lp.clickricontinue();
            String confirm= lp.getConfirmText().substring(12,26);
            System.out.println("the Application No:" +confirm);
            Assert.assertEquals("E-LHC/2023/149", confirm, "legal No didnt match");
            lp.clickdaclose();
            lp.clickUser();
            lp.clickLogout();
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


            LegalHeirPage lp=new LegalHeirPage();
            lp.clickOtherTahsil();
            cp.click_legalapplications();
            lp.txt_searchbox("E-LHC/2023/149");
            Thread.sleep(2000);
            DropDownUtils.dropdownSelect(lp.tahsilfirstrecord());
            Thread.sleep(3000);
            lp.txt_ri_remarks("some remarks");
            Thread.sleep(1000);
            DropDownUtils.dropdownSelect(lp.actiondropdown());
            Thread.sleep(1000);
            DropDownUtils.dropdownList(lp.actiondropdownlist(), "Sendback");
            Thread.sleep(1000);
            lp.clickrisubmit();
            HandlePop.getHandlePop();
            lp.clickricontinue();
            String confirm= lp.getConfirmText().substring(12,26);
            System.out.println("the Application No:" +confirm);
            Assert.assertEquals("E-LHC/2023/149", confirm, "legal No didnt match");
            lp.clickdaclose();
            lp.clickUser();
            lp.clickLogout();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
  }



}
