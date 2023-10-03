package com.srit.tests;

import com.srit.config.*;
import com.srit.constants.FrameworkConstants;
import com.srit.driver.DriverManager;
import com.srit.pages.CoreApplicationPage;
import com.srit.pages.LegalHeirPage;
import com.srit.pages.SolvencyPage;
import com.srit.pages.TribePage;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SolvencyCertificate extends BaseTest{


String solvency=null;

String sheetname="Solvency";

Xls_Reader reader=new Xls_Reader(FrameworkConstants.getExcelFilepath());

@Test
    public void applyforSolvencyService()
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
        SolvencyPage so= cp.click_solCertificate();
        so.click_Proceed();
        System.out.println(so.getDocumentTitle());
        DropDownUtils.selectByText(so.districtdropdown(), reader.getCellData(sheetname, "Pdistrict", 2));
        DropDownUtils.selectByText(so.subdivisiondropdown(), reader.getCellData(sheetname, "Psubdivision", 2));
        DropDownUtils.selectByText(so.tahsildropdown(), reader.getCellData(sheetname, "Ptahsil", 2));
        DropDownUtils.selectByText(so.ridropdown(), reader.getCellData(sheetname, "Pri", 2));
        DropDownUtils.selectByText(so.villagedropdown(),reader.getCellData(sheetname, "Pvillage", 2));
        so.txt_policestation(reader.getCellData(sheetname, "Ppolicestation", 2));
        so.txt_solvencyamount(reader.getCellData(sheetname, "Amount", 2));
        so.txt_landpropertyvalue(reader.getCellData(sheetname, "LandPropertyvalue", 2));
        so.txt_builidngpropertyvalue(reader.getCellData(sheetname, "BuildingPropertyValue", 2));
        so.txt_immovableproperty(reader.getCellData(sheetname, "OtherImmovableProperty", 2));
        so.txt_immovablepropertyvalue(reader.getCellData(sheetname, "ImmovableProperty", 2));
        FileUploadUtils.fileUpload(so.fileUpload(), FrameworkConstants.getUploadfilepath());
        so.txt_purpose(reader.getCellData(sheetname, "Purpose", 2));
        DropDownUtils.dropdownSelect(so.agree());
        so.txt_place(reader.getCellData(sheetname, "Place", 2));
        so.clicksubmit();
        HandlePop.getHandlePop();
        Thread.sleep(1000);
        so.click_Yes();
        String text=so.getApplicationNo();
        System.out.println(text);
        Assert.assertEquals("Application No", text.substring(0,14));
        solvency=so.getSolvCertNo();
        System.out.println(solvency);
        so.clickConfirm();
        Thread.sleep(1000);
        so.clickContinue();
        Thread.sleep(1000);
        so.clickPaymentAdvance();
        so.clickPaymentProceed();
        /*so.clickCitizenUser();
        so.clickCitizenlogout();*/

    } catch (Exception e) {
        throw new RuntimeException(e);
    }
}

    @Test(dependsOnMethods = "applyforSolvencyService")
    public void forwardbyDAtoRI()
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
                    click_mypendingapplications().click_solapplications();
            SolvencyPage so= new SolvencyPage();
            so.click_firstrecord();
            Thread.sleep(2000);
            so.txt_da_remarks("some remarks");
            Thread.sleep(1000);
            DropDownUtils.dropdownSelect(so.actiondropdown());
            Thread.sleep(1000);
            DropDownUtils.dropdownList(so.actiondropdownlist(), "forward");
            Thread.sleep(1000);
            DropDownUtils.dropdownSelect(so.officedropdown());
            Thread.sleep(1000);
            DropDownUtils.dropdownList(so.officedropdownlist(), "ri Office");
            Thread.sleep(1000);
            JavaScriptUtils.ScrollIntoView(so.forwardtori());
            so.clickdasubmit();
            HandlePop.getHandlePop();
            so.clickdacontinue();
            HandlePop.getHandlePop();
            so.clickdaclose();
            so.clickUser();
            so.clickLogout();


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test(dependsOnMethods = "forwardbyDAtoRI")
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
                    click_mypendingapplications().click_solapplications();
            SolvencyPage so= new SolvencyPage();

            so.txt_searchbox(solvency);
            Thread.sleep(2000);
            DropDownUtils.dropdownSelect(so.tahsilfirstrecord());
            Thread.sleep(4000);
            DropDownUtils.dropdownSelect(so.getUpdateVerificationReport());
            HandlePop.getHandlePop();
            String ConfirmVerificationApplicationNo=so.getSolVerificationNo().substring(2);
            System.out.println(ConfirmVerificationApplicationNo);
            Assert.assertEquals(solvency,ConfirmVerificationApplicationNo );
            so.txt_verification_remarks("some remarks");
            so.verification_fileupload(FrameworkConstants.getUploadfilepath());
            so.clickVerificationSubmit();
            HandlePop.getHandlePop();
            so.clickVerificationContinue();
            HandlePop.getHandlePop();
            so.txt_ri_remarks("some remarks");
            Thread.sleep(1000);
            DropDownUtils.dropdownSelect(so.actiondropdown());
            Thread.sleep(1000);
            DropDownUtils.dropdownList(so.actiondropdownlist(), "forward");
            Thread.sleep(1000);
            JavaScriptUtils.ScrollIntoView(so.officedropdown());
            DropDownUtils.dropdownSelect(so.officedropdown());
            Thread.sleep(1000);
            DropDownUtils.dropdownList(so.officedropdownlist(), "tahsil Office");
            Thread.sleep(1000);
            JavaScriptUtils.ScrollIntoView(so.forward());
            so.clickrisubmit();
            HandlePop.getHandlePop();
            so.clickricontinue();
            String confirm= so.getConfirmText().substring(12,26);
            System.out.println("the Application No:" +confirm);
            Assert.assertEquals(solvency, confirm, "Solvency No didnt match");
            so.clickdaclose();
            so.clickUser();
            so.clickLogout();

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
                    .click_solapplications();
            SolvencyPage so=new SolvencyPage();
            so.txt_searchbox(solvency);
            Thread.sleep(2000);
            DropDownUtils.dropdownSelect(so.tahsilfirstrecord());
            JavascriptExecutor js=  (JavascriptExecutor)DriverManager.getDriver();
            js.executeScript("window.scrollBy(0,1000)", "");
            so.txt_tahsil_remarks("some remarks");
            Thread.sleep(1000);
            DropDownUtils.dropdownSelect(so.actiondropdown());
            Thread.sleep(1000);
            DropDownUtils.dropdownList(so.actiondropdownlist(), "approve");
            Thread.sleep(1000);
            HandlePop.getHandlePop();
            so.clicktahsilpreviewsave();
            so.clickTahsilsubmit();
            HandlePop.getHandlePop();
            so.clickTahsilcontinue();
            HandlePop.getHandlePop();
            so.clickDigitalSignature();
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
                    .clickCoreApplication().click_applicationbox().click_mypendingapplications().click_solapplications();
            SolvencyPage so=new SolvencyPage();
            so.txt_searchbox("E-LHC/2023/149");
            Thread.sleep(2000);
            DropDownUtils.dropdownSelect(so.tahsilfirstrecord());
            Thread.sleep(3000);
            so.txt_ri_remarks("some remarks");
            Thread.sleep(1000);
            DropDownUtils.dropdownSelect(so.actiondropdown());
            Thread.sleep(2000);
            DropDownUtils.dropdownList(so.actiondropdownlist(), "Forward To Other Tahsil");
            Thread.sleep(1000);
            so.txt_othertahsil_district("Kalahandi");
            Thread.sleep(1000);
            so.clickhighlighted();
            Thread.sleep(1000);
            so.txt_othertahsil_subdivision("Bhawanipatna");
            Thread.sleep(1000);
            so.clickhighlighted();
            Thread.sleep(1000);
            so.txt_othertahsil_tahsil("Kalahandi");
            Thread.sleep(1000);
            so.clickhighlighted();
            Thread.sleep(1000);
            JavaScriptUtils.ScrollIntoView(so.forward());
            so.clickrisubmit();
            HandlePop.getHandlePop();
            so.clickricontinue();
            String confirm= so.getConfirmText().substring(12,26);
            System.out.println("the Application No:" +confirm);
            Assert.assertEquals("E-LHC/2023/149", confirm, "Solvency No didnt match");
            so.clickdaclose();
            so.clickUser();
            so.clickLogout();

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


            SolvencyPage so=new SolvencyPage();
            so.clickOtherTahsil();
            cp.click_solapplications();
            so.txt_searchbox("E-LHC/2023/149");
            Thread.sleep(2000);
            DropDownUtils.dropdownSelect(so.tahsilfirstrecord());
            Thread.sleep(3000);
            so.txt_ri_remarks("some remarks");
            Thread.sleep(1000);
            DropDownUtils.dropdownSelect(so.actiondropdown());
            Thread.sleep(1000);
            DropDownUtils.dropdownList(so.actiondropdownlist(), "Sendback");
            Thread.sleep(1000);
            so.clickrisubmit();
            HandlePop.getHandlePop();
            so.clickricontinue();
            String confirm= so.getConfirmText().substring(12,26);
            System.out.println("the Application No:" +confirm);
            Assert.assertEquals("E-LHC/2023/149", confirm, "Solvency No didnt match");
            so.clickdaclose();
            so.clickUser();
            so.clickLogout();


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
