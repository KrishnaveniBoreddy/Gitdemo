package pages;

import java.io.IOException;
import java.time.Duration;

import org.apache.log4j.Logger;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageobjectmodel.Excelutility;

public class Amazonpage extends Excelutility {
Excelutility e = new Excelutility();
WebDriver driver;
//Logger log=LogManager.getLogger(Amazonpage.class.getName());
@FindBy(css="input#ap_email")
WebElement phonenum;
@FindBy(xpath="//span[@class='a-button-inner']/input")
WebElement continuebutton;
@FindBy(css="input#ap_password")
WebElement password;
@FindBy(id="signInSubmit")
WebElement signinsubmit;
@FindBy(xpath="//*[@data-csa-c-content-id='nav_cs_giftfinder']")
WebElement giftideas;
@FindBy(xpath="//span[text()='Women']")
WebElement women;
@FindBy(xpath="//button[text()='Planters']")
WebElement planters;
@FindBy(partialLinkText="Unique Shape Marvel Avengers ")
WebElement groot;
@FindBy(id="submit.add-to-cart")
WebElement addtocart;
@FindBy(xpath="//*[contains(text(),'Go to Cart')]")
WebElement gotocart;
@FindBy(xpath="//input[contains(@name,'submit.delete.')]")
WebElement delete;
@FindBy(xpath="//*[contains(text(),'was removed')]")
WebElement removedmsg;
@FindBy(xpath="//span[text()='Sign Out']")
WebElement signout;
Logger logger=Logger.getLogger(Amazonpage.class);
public Amazonpage(WebDriver driver) {
	
	PageFactory.initElements(driver, this);
	this.driver=driver;
}
public void logintoamazon() throws IOException{
	//log.error("no error");
	//log.debug("clicked sigin button");
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Sign in')]"))).click();
	logger.info("Entered phonenum");
	phonenum.sendKeys(e.Username());
 continuebutton.click();
 logger.info("Entered password");
	password.sendKeys(e.Password());
	logger.info("clicked on signinbutton");
	signinsubmit.click();
	logger.info("logged in successfully");
}
public void gift() {
	logger.debug("clicked on gift ideas");
giftideas.click();
logger.debug("clicked on women link");
	women.click();
	logger.debug("clicked on planters");
	planters.click();
	}
public void Addtocart(){
	logger.debug("clicked on planters");
	groot.click();
	JavascriptExecutor j = (JavascriptExecutor) driver;
    j.executeScript("window.scrollBy(0,500)");
	logger.debug("add item to the cart");
	addtocart.click();
	logger.debug("view the cart");
	gotocart.click();
}
public void deletefromcart() {
	logger.debug("delete item from the cart");
	delete.click();
	
}
public void logout() {
	logger.info("signout successfully");
	Actions action = new Actions(driver);
	action.moveToElement(signout).click();
}
}

