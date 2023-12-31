package com.srit.tests;

import com.srit.config.*;
import com.srit.constants.FrameworkConstants;
import com.srit.driver.DriverManager;
import com.srit.pages.CoreApplicationPage;
import com.srit.pages.IncomeAssetPage;
import com.srit.pages.LegalHeirPage;
import com.srit.pages.TribePage;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IncomeandAssetCertificate extends BaseTest{

    String incomeasset=null;

    String Incomeno=null;

    Xls_Reader reader=new Xls_Reader(FrameworkConstants.getExcelFilepath());
    String sheetname="Incomeandasset";
    @Test
    public void applyforIncomeAssetService()
    {
        try{

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
                    .txt_createuai2("0306").txt_createuai3("0000").txt_createuai4("0299").btn_create_uai();
            JavascriptExecutor js=  (JavascriptExecutor) DriverManager.getDriver();
            js.executeScript("window.scrollBy(0,500)","");
            Thread.sleep(1000);*/
            IncomeAssetPage ia=  cp.getassetCertificate();
            ia.click_Proceed();
            System.out.println(ia.getDocumentTitle());

            try
            {
                DropDownUtils.selectByText(ia.categorydropdown(), reader.getCellData(sheetname, "Category", 2));
                DropDownUtils.dropdownSelect(ia.clicksibling());
                ia.txt_sibling_name(reader.getCellData(sheetname, "Sname", 2));
                ia.txt_sibling_age(reader.getCellData(sheetname, "Sage", 2));
                DropDownUtils.selectByText(ia.siblinggenderdropdown(), reader.getCellData(sheetname, "Sgender", 2));
                DropDownUtils.selectByText(ia.siblingrelationdropdown(), reader.getCellData(sheetname, "Srelation", 2));
                DropDownUtils.dropdownSelect(ia.clickchildren());
                ia.txt_children_name(reader.getCellData(sheetname, "Cname", 2));
                ia.txt_children_age(reader.getCellData(sheetname, "Cage", 2));
                DropDownUtils.selectByText(ia.childrengenderdropdown(), reader.getCellData(sheetname, "Cgender", 2));
                DropDownUtils.selectByText(ia.childrenrelationdropdown(), reader.getCellData(sheetname, "Crelation", 2));
                DropDownUtils.selectByText(ia.districtdropdown(), reader.getCellData(sheetname, "Pdistrict", 2));
                DropDownUtils.selectByText(ia.subdivisiondropdown(), reader.getCellData(sheetname, "Psubdivision", 2));
                DropDownUtils.selectByText(ia.tahsildropdown(), reader.getCellData(sheetname, "Ptahsil", 2));
                DropDownUtils.selectByText(ia.ridropdown(), reader.getCellData(sheetname, "Pri", 2));
                DropDownUtils.selectByText(ia.villagedropdown(), reader.getCellData(sheetname, "Pvillage", 2));

            } catch (Exception e) {
                throw new RuntimeException(e);
            }

            ia.txt_policestation(reader.getCellData(sheetname, "Ppolicestation", 2));
            ia.txt_salary(reader.getCellData(sheetname, "Salary", 2));
            ia.txt_business(reader.getCellData(sheetname, "Business", 2));
            ia.txt_agriculture(reader.getCellData(sheetname, "Agriculture", 2));
            ia.txt_profession(reader.getCellData(sheetname, "Profession", 2));
            DropDownUtils.dropdownSelect(ia.chkotherSources());
            ia.txt_pleasespecify(reader.getCellData(sheetname, "Pleasespecify", 2));
            ia.txt_incomefromothersource(reader.getCellData(sheetname, "Othersourcesincome", 2));
            DropDownUtils.selectByText(ia.assetdropdown(), reader.getCellData(sheetname, "Asset", 2));
            ia.txt_assert_area(reader.getCellData(sheetname, "Area", 2));
            DropDownUtils.selectByText(ia.unitdropdown(), reader.getCellData(sheetname, "Unit", 2));
            ia.txt_assert_location(reader.getCellData(sheetname, "Location", 2));
            FileUploadUtils.fileUpload(ia.fileUpload(), FrameworkConstants.getUploadfilepath());
            ia.txt_purpose(reader.getCellData(sheetname, "Purpose", 2));
            DropDownUtils.dropdownSelect(ia.agree());
            ia.txt_place(reader.getCellData(sheetname, "Place", 2));
            ia.clicksubmit();
            HandlePop.getHandlePop();
            Thread.sleep(1000);
            ia.click_Yes();
            String text=ia.getApplicationNo();
            System.out.println(text);
            Assert.assertEquals("Application No", text.substring(0,14));
            incomeasset=ia.getincomeassetCertNo();
            System.out.println(incomeasset);
            ia.clickConfirm();
            HandlePop.getHandlePop();
            Thread.sleep(1000);
            ia.clickContinue();
            ia.clickCitizenUser();
            ia.clickCitizenlogout();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }



    }

    @Test(dependsOnMethods = "applyforIncomeAssetService")
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
                    click_mypendingapplications().click_incomeandassetapplications();
            IncomeAssetPage ia= new IncomeAssetPage();
            ia.click_firstrecord();
            Thread.sleep(2000);
            ia.txt_da_remarks("some remarks");
            Thread.sleep(1000);
            DropDownUtils.dropdownSelect(ia.actiondropdown());
            Thread.sleep(1000);
            DropDownUtils.dropdownList(ia.actiondropdownlist(), "forward");
            Thread.sleep(1000);
            DropDownUtils.dropdownSelect(ia.officedropdown());
            Thread.sleep(1000);
            DropDownUtils.dropdownList(ia.officedropdownlist(), "ri Office");
            Thread.sleep(1000);
            JavaScriptUtils.ScrollIntoView(ia.forwardtori());
            ia.clickdasubmit();
            HandlePop.getHandlePop();
            ia.clickdacontinue();
            HandlePop.getHandlePop();
            ia.clickdaclose();
            ia.clickUser();
            ia.clickLogout();

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
                    click_mypendingapplications().click_incomeandassetapplications();
            IncomeAssetPage ia= new IncomeAssetPage();
            ia.txt_searchbox(incomeasset);
            Thread.sleep(4000);
            DropDownUtils.dropdownSelect(ia.tahsilfirstrecord());
            Thread.sleep(4000);
            DropDownUtils.dropdownSelect(ia.getUpdateVerificationReport());
            HandlePop.getHandlePop();
            String ConfirmVerificationApplicationNo=ia.getIncomeAssetVerificationNo().substring(2);
            System.out.println(ConfirmVerificationApplicationNo);
            Assert.assertEquals(incomeasset,ConfirmVerificationApplicationNo );
            ia.txt_verification_remarks("some remarks");
            ia.verification_fileupload(FrameworkConstants.getUploadfilepath());
            ia.clickVerificationSubmit();
            HandlePop.getHandlePop();
            ia.clickVerificationContinue();
            HandlePop.getHandlePop();
            ia.txt_ri_remarks("some remarks");
            Thread.sleep(1000);
            DropDownUtils.dropdownSelect(ia.actiondropdown());
            Thread.sleep(1000);
            DropDownUtils.dropdownList(ia.actiondropdownlist(), "forward");
            Thread.sleep(1000);
            JavaScriptUtils.ScrollIntoView(ia.officedropdown());
            DropDownUtils.dropdownSelect(ia.officedropdown());
            Thread.sleep(1000);
            DropDownUtils.dropdownList(ia.officedropdownlist(), "tahsil Office");
            Thread.sleep(1000);
            JavaScriptUtils.ScrollIntoView(ia.forward());
            ia.clickrisubmit();
            HandlePop.getHandlePop();
            ia.clickricontinue();
            String confirm= ia.getConfirmText().substring(12,26);
            System.out.println("the Application No:" +confirm);
            Assert.assertEquals(incomeasset, confirm, "Income asset No didnt match");
            ia.clickdaclose();
            ia.clickUser();
            ia.clickLogout();

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
                    .clickCoreApplication().
                    click_applicationbox().
                    click_mypendingapplications().click_incomeandassetapplications();
            IncomeAssetPage ia=new IncomeAssetPage();
            ia.txt_searchbox(incomeasset);
            Thread.sleep(2000);
            DropDownUtils.dropdownSelect(ia.tahsilfirstrecord());
            JavascriptExecutor js=  (JavascriptExecutor)DriverManager.getDriver();
            js.executeScript("window.scrollBy(0,1000)", "");
            ia.txt_tahsil_remarks("some remarks");
            Thread.sleep(1000);
            DropDownUtils.dropdownSelect(ia.actiondropdown());
            Thread.sleep(2000);
            DropDownUtils.dropdownList(ia.actiondropdownlist(), "approve");
            Thread.sleep(1000);
            HandlePop.getHandlePop();
            ia.clicktahsilpreviewsave();
            ia.clickTahsilsubmit();
            HandlePop.getHandlePop();
            ia.clickTahsilcontinue();
            HandlePop.getHandlePop();
            ia.clickDigitalSignature();

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
                    .clickCoreApplication().click_applicationbox().click_mypendingapplications().click_incomeandassetapplications();
            IncomeAssetPage ia=new IncomeAssetPage();
            ia.txt_searchbox("E-LHC/2023/149");
            Thread.sleep(2000);
            DropDownUtils.dropdownSelect(ia.tahsilfirstrecord());
            Thread.sleep(3000);
            ia.txt_ri_remarks("some remarks");
            Thread.sleep(1000);
            DropDownUtils.dropdownSelect(ia.actiondropdown());
            Thread.sleep(2000);
            DropDownUtils.dropdownList(ia.actiondropdownlist(), "Forward To Other Tahsil");
            Thread.sleep(1000);
            ia.txt_othertahsil_district("Kalahandi");
            Thread.sleep(1000);
            ia.clickhighlighted();
            Thread.sleep(1000);
            ia.txt_othertahsil_subdivision("Bhawanipatna");
            Thread.sleep(1000);
            ia.clickhighlighted();
            Thread.sleep(1000);
            ia.txt_othertahsil_tahsil("Kalahandi");
            Thread.sleep(1000);
            ia.clickhighlighted();
            Thread.sleep(1000);
            JavaScriptUtils.ScrollIntoView(ia.forward());
            ia.clickrisubmit();
            HandlePop.getHandlePop();
            ia.clickricontinue();
            String confirm= ia.getConfirmText().substring(12,26);
            System.out.println("the Application No:" +confirm);
            Assert.assertEquals("E-LHC/2023/149", confirm, "incomeandasset No didnt match");
            ia.clickdaclose();
            ia.clickUser();
            ia.clickLogout();
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


            IncomeAssetPage ia=new IncomeAssetPage();
            ia.clickOtherTahsil();
            cp.click_incomeandassetapplications();
            ia.txt_searchbox("E-LHC/2023/149");
            Thread.sleep(2000);
            DropDownUtils.dropdownSelect(ia.tahsilfirstrecord());
            Thread.sleep(3000);
            ia.txt_ri_remarks("some remarks");
            Thread.sleep(1000);
            DropDownUtils.dropdownSelect(ia.actiondropdown());
            Thread.sleep(1000);
            DropDownUtils.dropdownList(ia.actiondropdownlist(), "Sendback");
            Thread.sleep(1000);
            ia.clickrisubmit();
            HandlePop.getHandlePop();
            ia.clickricontinue();
            String confirm= ia.getConfirmText().substring(12,26);
            System.out.println("the Application No:" +confirm);
            Assert.assertEquals("E-LHC/2023/149", confirm, "Income Asset No didnt match");
            ia.clickdaclose();
            ia.clickUser();
            ia.clickLogout();



        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
