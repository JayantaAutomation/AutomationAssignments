package com.wallethub.qa.testcases;

import com.wallethub.qa.pages.WallethubLoginPage;
import com.wallethub.qa.pages.WallethubNewReviewPage;
import com.wallethub.qa.pages.WallethubTestCompanyPage;
import com.wallethub.qa.base.WebDriverFactory;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 *
 */
public class WallethubLoginPageTest {

	WebDriver driver;
	
    @BeforeTest
    public void beforeTest() {
        WebDriverFactory.startBrowser(true);
        String login = "jay.panda@rediffmail.com"; // TODO: add login/pass
        String pass = "Jayanta$123";
        
        WallethubLoginPage loginPage = new WallethubLoginPage();
        loginPage.login(login, pass);
      //  driver.manage().window().maximize();

    }

    @Test
    public void canWriteReview() {
        WallethubTestCompanyPage testCompanyPage = new WallethubTestCompanyPage();
        testCompanyPage.hoverOver(0, 0);
        WallethubNewReviewPage reviewPage = new WallethubNewReviewPage();
        reviewPage.selectPolicy(null);
        reviewPage.rateNstart(5);
        String msg = "";
        for (int i = 0; i < 30; i++) {
            msg += " Test, Ignore!";
        }
        reviewPage.fillReviewInput(msg);
        reviewPage.setSubmitReview();
        reviewPage.goToReviewsPage();
        Assert.assertTrue(reviewPage.getPageSource().contains(msg), "Unable to find review on page");
    }

    @AfterTest
    public void afterTest() {
        WebDriverFactory.finishBrowser();
    }
}