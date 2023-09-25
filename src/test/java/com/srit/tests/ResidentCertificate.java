package com.srit.tests;

import com.srit.config.*;
import com.srit.constants.FrameworkConstants;
import com.srit.driver.DriverManager;
import com.srit.pages.CoreApplicationPage;
import com.srit.pages.LegalHeirPage;
import com.srit.pages.ResidentPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;

public class ResidentCertificate extends BaseTest {

    String ResidentNo=null;
    String sheetname="Resident";

    Xls_Reader reader=new Xls_Reader(FrameworkConstants.getExcelFilepath());

    @Test()
    public void applyforServices() throws Exception {

        try {
            CoreApplicationPage cp=new CoreApplicationPage();
            cp.click_citizenlogin();
            cp.txt_email(reader.getCellData(sheetname, "Portalemailaddress", 2));
            cp.txt_password(reader.getCellData(sheetname, "Portalpassword", 2));
            cp.click_sigin();
            cp.click_applyforServices();
            cp.click_viewallavailableServices();


           /* HandleTab.getHandleTab(1);
            cp.enter_username("csc1.sundar").enter_password("Pass@1231").clickLogin().clickCoreApplication()
                    .clickServices().clickSubmitApplication().txt_createuai1("4462")
                    .txt_createuai2("0306").txt_createuai3("0000").txt_createuai4("0299").btn_create_uai();*/

            ResidentPage rp= cp.click_residentCertifcate();
            HandlePop.getHandlePop();
            rp.clickProceed();
            System.out.println(rp.getDocumentTitle());
            rp.txt_years(reader.getCellData(sheetname, "Years", 2));
            rp.txt_months(reader.getCellData(sheetname, "Months", 2));
            DropDownUtils.selectByText(rp.getdistrict(), reader.getCellData(sheetname, "Pdistrict", 2));
            DropDownUtils.selectByText(rp.subdivisiondropdown(), reader.getCellData(sheetname, "Psubdivision", 2));
            DropDownUtils.selectByText(rp.tahsildropdown(), reader.getCellData(sheetname, "Ptahsil", 2));
            DropDownUtils.selectByText(rp.ridropdown(), reader.getCellData(sheetname, "Pri", 2));
            DropDownUtils.selectByText(rp.villagedropdown(), reader.getCellData(sheetname, "Pvillage", 2));
            rp.txt_policestation("Ppolicestation");
            FileUploadUtils.fileUpload(rp.fileupload(), FrameworkConstants.getUploadfilepath());
            rp.txt_purpose(reader.getCellData(sheetname, "Purpose", 2)).txt_place(reader.getCellData(sheetname, "Place", 2));
            DropDownUtils.dropdownSelect(rp.agree());
            rp.clicksubmit();
            HandlePop.getHandlePop();
            Thread.sleep(1000);
            rp.click_Yes();
            String text=rp.getApplicationNo();
            System.out.println(text);
            Assert.assertEquals("Application No", text.substring(0,14));
            ResidentNo=rp.getResidentNo();
            System.out.println(ResidentNo);
            rp.clickConfirm();
            HandlePop.getHandlePop();
            Thread.sleep(1000);
            rp.clickContinue();
            rp.clickCitizenUser();
            rp.clickCitizenlogout();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }


    //@Test
    public void editByOperator()
    {

        try
        {
            CoreApplicationPage cp=new CoreApplicationPage();
            cp.enter_username("csc1.sundar").enter_password("Pass@1231").clickLogin().clickCoreApplication().clickServices();
            ResidentPage rp= new ResidentPage();

            rp.clickreturnedtoApplicant();
            rp.txtreturnedsearchbox("E-RES/2023/627");
            Thread.sleep(5000);
            DropDownUtils.dropdownSelect(rp.returnedtoedit());
            String text=rp.getApplicationNo();
            System.out.println(text);
            //rp.clickreturnedtoedit();
            rp.clear_returnedyear();
            rp.txt_returned_edit_year("34");
            rp.clear_returnedpurpose();
            rp.txt_returned_edit_purpose("purpose");
            Thread.sleep(2000);
            //DropDownUtils.dropdownSelect(rp.getEditSubmit());
            JavaScriptUtils.ScrollIntoView(rp.getEditSubmit());
                // rp.clicksubmit();
            HandlePop.getHandlePop();
            rp.click_Yes();
            rp.clickConfirm();
            HandlePop.getHandlePop();
            rp.clickContinue();
            HandlePop.getHandlePop();
            rp.clickNext();
            rp.clickUser();
            rp.clickLogout();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }


   // @Test(dependsOnMethods = "applyforServices")
    public void forwardByDA() throws Exception {

        try
        {
            CoreApplicationPage cp= new CoreApplicationPage();
            cp.enter_username("da.bargarh").enter_password("Pass@1231")
                    .clickLogin()
                    .clickCoreApplication().click_applicationbox().click_mypendingapplications().click_residenceapplications();
            ResidentPage rp= new ResidentPage();
            rp.click_firstrecord();
            rp.txt_da_remarks("some remarks");
            Thread.sleep(1000);
            DropDownUtils.dropdownSelect(rp.actiondropdown());
            Thread.sleep(1000);
            DropDownUtils.dropdownList(rp.actiondropdownlist(), "forward");
            Thread.sleep(1000);
            DropDownUtils.dropdownSelect(rp.officedropdown());
            Thread.sleep(1000);
            DropDownUtils.dropdownList(rp.officedropdownlist(), "tahsil Office");
            Thread.sleep(1000);
            JavaScriptUtils.ScrollIntoView(rp.forward());
            //DropDownUtils.dropdownSelect(rp.forward());
            //rp.click_forward();
            rp.clickdasubmit();
            HandlePop.getHandlePop();
            rp.clickdacontinue();
            HandlePop.getHandlePop();
            rp.clickdaclose();
            rp.clickUser();
            rp.clickLogout();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

//dependsOnMethods = "applyforServices"
    @Test ()
    public void forwardByDAtoRI() throws Exception {

        try
        {
            CoreApplicationPage cp= new CoreApplicationPage();
            cp.enter_username("da.bargarh").enter_password("Pass@1231")
                    .clickLogin()
                    .clickCoreApplication().click_applicationbox().click_mypendingapplications().click_residenceapplications();
            ResidentPage rp= new ResidentPage();
            rp.click_firstrecord();
            Thread.sleep(2000);
            //DropDownUtils.dropdownSelect(rp.tahsilfirstrecord());
            rp.txt_da_remarks("some remarks");
            Thread.sleep(1000);
            DropDownUtils.dropdownSelect(rp.actiondropdown());
            Thread.sleep(2000);
            DropDownUtils.dropdownList(rp.actiondropdownlist(), "forward");
            Thread.sleep(1000);
            DropDownUtils.dropdownSelect(rp.officedropdown());
            Thread.sleep(1000);
            DropDownUtils.dropdownList(rp.officedropdownlist(), "ri Office");
            Thread.sleep(1000);
            JavaScriptUtils.ScrollIntoView(rp.forwardtori());
            //DropDownUtils.dropdownSelect(rp.forward());
            //rp.click_forward();
            rp.clickdasubmit();
            HandlePop.getHandlePop();
            rp.clickdacontinue();
            HandlePop.getHandlePop();
            rp.clickdaclose();
            rp.clickUser();
            rp.clickLogout();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        }

   // dependsOnMethods = "forwardByDAtoRI"
    @Test(dependsOnMethods = "forwardByDAtoRI")
    public void forwardtoTahsilByRI() throws Exception {

        try
        {
            CoreApplicationPage cp= new CoreApplicationPage();
            cp.enter_username("ri.jamurda").enter_password("Pass@1231")
                    .clickLogin()
                    .clickCoreApplication().click_applicationbox().click_mypendingapplications().click_residenceapplications();
            ResidentPage rp= new ResidentPage();
            rp.txt_searchbox(ResidentNo);
            Thread.sleep(2000);
            DropDownUtils.dropdownSelect(rp.tahsilfirstrecord());
            Thread.sleep(3000);
            JavaScriptUtils.ScrollIntoView(rp.getUpdateVerificationReport());
            //DropDownUtils.dropdownSelect(rp.getUpdateVerificationReport());
            HandlePop.getHandlePop();
            String ConfirmVerificationApplicationNo=rp.getResidentVerificationNo().substring(2);
            System.out.println(ConfirmVerificationApplicationNo);
            Assert.assertEquals(ResidentNo,ConfirmVerificationApplicationNo );



            rp.txt_verification_mouza("mouze");
            rp.txt_verification_khata("090/90");
            rp.txt_verification_plot("9090/90");
            rp.txt_verification_extent("9090");
            rp.txt_verification_khatadarname("name");
            rp.txt_verification_remarks("some remarks");
            rp.txt_verification_fileupload(FrameworkConstants.getUploadfilepath());
            rp.clickVerificationSubmit();
            HandlePop.getHandlePop();
            rp.clickVerificationContinue();
            HandlePop.getHandlePop();
            rp.txt_da_remarks("some remarks");
            Thread.sleep(1000);
            //JavaScriptUtils.ScrollIntoView(rp.actiondropdown());
            DropDownUtils.dropdownSelect(rp.actiondropdown());
            Thread.sleep(1000);
            DropDownUtils.dropdownList(rp.actiondropdownlist(), "forward");
            Thread.sleep(1000);
            JavaScriptUtils.ScrollIntoView(rp.officedropdown());
            DropDownUtils.dropdownSelect(rp.officedropdown());
            Thread.sleep(1000);
            DropDownUtils.dropdownList(rp.officedropdownlist(), "tahsil Office");
            Thread.sleep(1000);
            JavaScriptUtils.ScrollIntoView(rp.forward());
            //DropDownUtils.dropdownSelect(rp.forward());
            //rp.click_forward();
            rp.clickdasubmit();
            HandlePop.getHandlePop();
            rp.clickdacontinue();
            HandlePop.getHandlePop();
            String confirm= rp.getConfirmText().substring(12,26);
            System.out.println("the Application No:" +confirm);
            Assert.assertEquals(ResidentNo, confirm, "Resident No didnt match");
            rp.clickdaclose();
            rp.clickUser();
            rp.clickLogout();
        }

        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    //dependsOnMethods = "forwardtoTahsilByRI"
   @Test(dependsOnMethods = "forwardtoTahsilByRI")
    public void approvebyTahsil() throws Exception {

        try
        {
            CoreApplicationPage cp= new CoreApplicationPage();
            cp.enter_username("tdr.bargarh").enter_password("Pass@1231")
                    .clickLogin()
                    .clickCoreApplication().click_applicationbox().click_mypendingapplications().click_residenceapplications();
            ResidentPage rp= new ResidentPage();

            rp.txt_searchbox(ResidentNo);
            Thread.sleep(2000);
            //rp.click_tahsilfirstrecord();

            DropDownUtils.dropdownSelect(rp.tahsilfirstrecord());
            JavascriptExecutor js=  (JavascriptExecutor)DriverManager.getDriver();
            js.executeScript("window.scrollBy(0,1000)", "");
            rp.txt_da_remarks("some remarks");

            Thread.sleep(1000);
            DropDownUtils.dropdownSelect(rp.actiondropdown());
            Thread.sleep(1000);
            DropDownUtils.dropdownList(rp.actiondropdownlist(), "approve");
            Thread.sleep(1000);
            HandlePop.getHandlePop();
            rp.clicktahsilpreviewsave();
            rp.clickdasubmit();
            HandlePop.getHandlePop();
            rp.clickdacontinue();
            HandlePop.getHandlePop();
            rp.clickDigitalSignature();

            Robot rb= new Robot();
            Thread.sleep(2000);

            //Alertutils.acceptAlert();

            rb.keyPress(KeyEvent.VK_ENTER);
            rb.keyRelease(KeyEvent.VK_ENTER);
            Thread.sleep(1000);
            rb.keyPress(KeyEvent.VK_TAB);
            rb.keyRelease(KeyEvent.VK_TAB);
            Thread.sleep(1000);
            rb.keyPress(KeyEvent.VK_ENTER);
            rb.keyRelease(KeyEvent.VK_ENTER);
            Thread.sleep(1000);
            rb.keyPress(KeyEvent.VK_ENTER);
            rb.keyRelease(KeyEvent.VK_ENTER);
            Thread.sleep(1000);
            rb.keyPress(KeyEvent.VK_TAB);
            rb.keyRelease(KeyEvent.VK_TAB);
            Thread.sleep(1000);
            rb.keyPress(KeyEvent.VK_ENTER);
            rb.keyRelease(KeyEvent.VK_ENTER);
            Thread.sleep(5000);
            rb.keyPress(KeyEvent.VK_ENTER);
            rb.keyRelease(KeyEvent.VK_ENTER);


        }

        catch (Exception e)
        {
            e.printStackTrace();
        }
        //Alertutils.acceptAlert();

        /*DropDownUtils.dropdownSelect(rp.officedropdown());
        Thread.sleep(1000);
        DropDownUtils.dropdownList(rp.officedropdownlist(), "tahsil office");
        Thread.sleep(1000);*/

    }

    @Test
    public void forwardtoOtherTahsil()
    {
        try
        {
            CoreApplicationPage cp= new CoreApplicationPage();
            cp.enter_username("tdr.bargarh").enter_password("Pass@1231")
                    .clickLogin()
                    .clickCoreApplication().click_applicationbox().click_mypendingapplications().click_residenceapplications();
            ResidentPage rb=new ResidentPage();
            rb.txt_searchbox("E-LHC/2023/149");
            Thread.sleep(2000);
            DropDownUtils.dropdownSelect(rb.tahsilfirstrecord());
            Thread.sleep(3000);
            rb.txt_ri_remarks("some remarks");
            Thread.sleep(1000);
            DropDownUtils.dropdownSelect(rb.actiondropdown());
            Thread.sleep(2000);
            DropDownUtils.dropdownList(rb.actiondropdownlist(), "Forward To Other Tahsil");
            Thread.sleep(1000);
            rb.txt_othertahsil_district("Kalahandi");
            Thread.sleep(1000);
            rb.clickhighlighted();
            Thread.sleep(1000);
            rb.txt_othertahsil_subdivision("Bhawanipatna");
            Thread.sleep(1000);
            rb.clickhighlighted();
            Thread.sleep(1000);
            rb.txt_othertahsil_tahsil("Kalahandi");
            Thread.sleep(1000);
            rb.clickhighlighted();
            Thread.sleep(1000);
            JavaScriptUtils.ScrollIntoView(rb.forward());
            rb.clickrisubmit();
            HandlePop.getHandlePop();
            rb.clickricontinue();
            String confirm= rb.getConfirmText().substring(12,26);
            System.out.println("the Application No:" +confirm);
            Assert.assertEquals("E-LHC/2023/149", confirm, "resident No didnt match");
            rb.clickdaclose();
            rb.clickUser();
            rb.clickLogout();


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
            ResidentPage rb=new ResidentPage();
            rb.clickOtherTahsil();
            cp.click_residenceapplications();
            rb.txt_searchbox("E-LHC/2023/149");
            Thread.sleep(2000);
            DropDownUtils.dropdownSelect(rb.tahsilfirstrecord());
            Thread.sleep(3000);
            rb.txt_ri_remarks("some remarks");
            Thread.sleep(1000);
            DropDownUtils.dropdownSelect(rb.actiondropdown());
            Thread.sleep(1000);
            DropDownUtils.dropdownList(rb.actiondropdownlist(), "Sendback");
            Thread.sleep(1000);
            rb.clickrisubmit();
            HandlePop.getHandlePop();
            rb.clickricontinue();
            String confirm= rb.getConfirmText().substring(12,26);
            System.out.println("the Application No:" +confirm);
            Assert.assertEquals("E-LHC/2023/149", confirm, "Resident No didnt match");
            rb.clickdaclose();
            rb.clickUser();
            rb.clickLogout();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
