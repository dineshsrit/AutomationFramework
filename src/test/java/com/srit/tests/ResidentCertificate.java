package com.srit.tests;

import com.srit.config.*;
import com.srit.constants.FrameworkConstants;
import com.srit.driver.DriverManager;
import com.srit.pages.CoreApplicationPage;
import com.srit.pages.ResidentPage;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;

import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;

public class ResidentCertificate extends BaseTest {

    String ResidentNo=null;
    @Test()
    public void applyforServices() throws Exception {

        try {
            CoreApplicationPage cp=new CoreApplicationPage();
            cp.enter_username("csc1.sundar").enter_password("Pass@1231").clickLogin().clickCoreApplication()
                    .clickServices().clickSubmitApplication().txt_createuai1("4462")
                    .txt_createuai2("0306").txt_createuai3("0000").txt_createuai4("0299").btn_create_uai();

            ResidentPage rp= cp.click_residentCertifcate();
            HandlePop.getHandlePop();
            rp.clickProceed();
            System.out.println(rp.getDocumentTitle());
       /* JavascriptExecutor js=(JavascriptExecutor)DriverManager.getDriver();
        js.executeScript("arguments[0].click();",rp.districtdropdown());*/

            try
            {
                JavascriptExecutor js= (JavascriptExecutor)DriverManager.getDriver();
                js.executeScript("window.scrollBy(0,300)", "");
                DropDownUtils.dropdownSelect(rp.districtdropdown());

                DropDownUtils.dropdownList(rp.districtdropdownlist(), "bargarh");
                Thread.sleep(4000);

                DropDownUtils.dropdownSelect(rp.subdivisiondropdown());
                Thread.sleep(4000);
                DropDownUtils.dropdownList(rp.subdivisiondropdownlist(), "bargarh");

                Thread.sleep(1000);
                DropDownUtils.dropdownSelect(rp.tahsildropdown());
                Thread.sleep(4000);
                DropDownUtils.dropdownList(rp.tahsildropdownlist(), "bargarh");

                Thread.sleep(1000);
                DropDownUtils.dropdownSelect(rp.ridropdown());
                Thread.sleep(4000);
                DropDownUtils.dropdownList(rp.ridropdownlist(), "jamurda");

                Thread.sleep(1000);
                DropDownUtils.dropdownSelect(rp.villagedropdown());
                Thread.sleep(6000);
                DropDownUtils.dropdownList(rp.villagedropdownlist(),"jamu");
            } catch (InterruptedException e) {
                throw new RuntimeException("Dropdown is not selected");
            }

            rp.txt_policestation("some station");
            FileUploadUtils.fileUpload(rp.fileupload(), FrameworkConstants.getUploadfilepath());
            //rp.fileupload().sendKeys(System.getProperty("user.dir")+"/src/test/resources/images/ladies.png");
            //Scroll.scrolldown(rp.districtdropdown());
            //rp.clickDistrictdropdown();
            Scroll.scrolldown(rp.years());
            rp.txt_years("2");
            rp.txt_months("2").txt_purpose("some").txt_place("some aplace");
            Thread.sleep(2000);
            DropDownUtils.dropdownSelect(rp.agree());
            rp.clicksubmit();
            HandlePop.getHandlePop();
            rp.click_Yes();
            String text=rp.getApplicationNo();
            System.out.println(text);
            Assert.assertEquals("Application Number", text.substring(0,18));
            ResidentNo=rp.getResidentNo();
            System.out.println(ResidentNo);
            rp.clickConfirm();
            HandlePop.getHandlePop();
            rp.clickContinue();
            HandlePop.getHandlePop();
            rp.clickNext();
            rp.clickUser();
            rp.clickLogout();
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


    @Test (dependsOnMethods = "applyforServices")
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
            Thread.sleep(1000);
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


}
