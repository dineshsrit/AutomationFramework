package com.srit.pages;

import com.srit.enums.WaitStrategy;
import com.srit.reports.ExtentLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CoreApplicationPage extends BasePage{

    private final By lk_coreapplication=By.linkText("Core application");

    private final By lk_services=By.linkText("Services");

    private final By lk_submitapplication=By.linkText("Submit Application");

    private final By textbox_username=By.id("mat-input-0");
    private final By textbox_password=By.id("mat-input-1");
    private final By button_login=By.xpath("//button[@type='submit']");

    private final By txt_uai1=By.id("uai1");

    private final By txt_uai2=By.id("uai2");

    private final By txt_uai3=By.id("uai3");

    private final By txt_uai4=By.id("uai4");

    private final By btn_submit=By.xpath("//span[normalize-space()='Submit']");

    private final By clk_residentCert=By.xpath("//a[normalize-space()='Issuance of Residence Certificate']");

    private final By lk_incomeCert=By.xpath("//a[normalize-space()='Issuance of Income Certificate']");

    private final By lk_casteCert=By.xpath("//a[normalize-space()='Issuance of Schedule Caste Certificate']");

    private final By lk_tribeCert=By.xpath("//a[normalize-space()='Issuance of Scheduled Tribe Certificate']");

    private final By lk_assetCert=By.xpath("//*[contains(text(),'Asset')]");

    private final By lk_rorCert=By.xpath("//*[contains(text(),'ROR')]");

    private final By lk_applicationsbox=By.linkText("Applications Box");

    private final By lk_mypendingapplications=By.linkText("My Pending Applications");

    private final By lk_issuanceResidenceCertificate=By.xpath("//*[contains(text(),'Residence')]");

    private final By lk_issuanceIncomeCertificate=By.xpath("//*[contains(text(),'Income Cer')]");

    private final By lk_issuanceCasteCertificate=By.xpath("//*[contains(text(),'Caste')]");

    private final By lk_issuanceTribeCertificate=By.xpath("//*[contains(text(),'Tribe')]");
    private final By lk_issuanceAssetCertificate=By.xpath("//*[contains(text(),'Asset')]");

    private final By lk_issuanceRorCertificate=By.xpath("//*[contains(text(),'ROR')]");




    public CoreApplicationPage enter_username(String username) throws Exception
    {
        sendkeys(textbox_username, username, WaitStrategy.PRESENCE);
       // ExtentLogger.pass("entered the user name", true);

        return this;

    }

    public CoreApplicationPage enter_password(String password) throws Exception
    {
        sendkeys(textbox_password, password, WaitStrategy.PRESENCE);
       // ExtentLogger.pass("password entered", true);

        return this;
    }

    public CoreApplicationPage clickLogin() throws Exception
    {
        click(button_login, WaitStrategy.CLICKABLE);
       // ExtentLogger.pass("clicked on homepage", true);
        return this;
    }

    public CoreApplicationPage clickCoreApplication ()
    {
        click(lk_coreapplication, WaitStrategy.CLICKABLE);
      //  ExtentLogger.pass("Clicked on Core Application");
        return this;
    }

    public CoreApplicationPage clickServices ()
    {
        click(lk_services, WaitStrategy.CLICKABLE);
       // ExtentLogger.pass("Clicked on Service");
        return this;
    }

    public CoreApplicationPage clickSubmitApplication()
    {
        click(lk_submitapplication, WaitStrategy.CLICKABLE);
       // ExtentLogger.pass("Clicked on SubmitApplication");
        return this;
    }

    public CoreApplicationPage txt_createuai1(String uai)


    {
        sendkeys(txt_uai1, uai, WaitStrategy.PRESENCE);
        return this;
    }

    public CoreApplicationPage txt_createuai2(String uai)
    {
        sendkeys(txt_uai2, uai, WaitStrategy.PRESENCE);
        return this;
    }

    public CoreApplicationPage txt_createuai3(String uai)
    {
        sendkeys(txt_uai3, uai, WaitStrategy.PRESENCE);
        return this;
    }

    public CoreApplicationPage txt_createuai4(String uai)
    {
        sendkeys(txt_uai4, uai, WaitStrategy.PRESENCE);
        return this;
    }

    public CoreApplicationPage btn_create_uai()
    {
        click(btn_submit, WaitStrategy.CLICKABLE);
        return this;
    }

    public ResidentPage click_residentCertifcate()
    {
        click(clk_residentCert, WaitStrategy.CLICKABLE);
        return new ResidentPage();
    }
    public IncomePage click_incomeCertifcate()
    {
        click(lk_incomeCert, WaitStrategy.CLICKABLE);
        return new IncomePage();
    }

    public CastePage click_casteCertifcate()
    {
        click(lk_casteCert, WaitStrategy.CLICKABLE);
        return new CastePage();
    }
    public TribePage click_tribeCertificate()
    {
        click(lk_tribeCert, WaitStrategy.CLICKABLE);
        return new TribePage();
    }

    public RORPage click_rorCertificate()
    {
        click(lk_rorCert, WaitStrategy.CLICKABLE);
        return new RORPage();
    }

    public WebElement getassetCertificate()
    {
        return getWebElement(lk_assetCert);
    }
    public CoreApplicationPage click_applicationbox()
    {
        click(lk_applicationsbox, WaitStrategy.CLICKABLE);
        return this;
    }

    public CoreApplicationPage click_mypendingapplications()
    {
        click(lk_mypendingapplications, WaitStrategy.CLICKABLE);
        return this;
    }

    public CoreApplicationPage click_residenceapplications()
    {
        click(lk_issuanceResidenceCertificate, WaitStrategy.CLICKABLE);
        return this;
    }


    public CoreApplicationPage click_incomeapplications()
    {
        click(lk_issuanceIncomeCertificate, WaitStrategy.CLICKABLE);
        return this;
    }

    public CoreApplicationPage click_casteapplications()
    {
        click(lk_issuanceCasteCertificate, WaitStrategy.CLICKABLE);
        return this;
    }

    public CoreApplicationPage click_tribeapplications()
    {
        click(lk_issuanceTribeCertificate, WaitStrategy.CLICKABLE);
        return this;
    }

    public CoreApplicationPage click_incomeandassetapplications()
    {
        click(lk_issuanceAssetCertificate, WaitStrategy.CLICKABLE);
        return this;
    }
    public CoreApplicationPage click_rorapplications()
    {
        click(lk_issuanceRorCertificate, WaitStrategy.CLICKABLE);
        return this;
    }

}
