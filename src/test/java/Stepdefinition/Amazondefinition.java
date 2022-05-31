package Stepdefinition;


import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import pageobjectmodel.Library;
import pages.Amazonpage;



public class Amazondefinition extends Library {
Amazonpage a;



@BeforeMethod 
public void launchapp() throws IOException{
config();
ExtentTest test= extent.createTest("Amazonlogintest");
		login();
	
}
@Test
public void logintoAmazon() throws IOException {
	Logger logger=Logger.getLogger(Amazondefinition.class);
	
	 logger.info("-----Started executing the methods----");
	 logger.debug("-----Debug Started executing the methods----");
	 
	a=new Amazonpage(driver);
    a.logintoamazon();
    logger.info("Successfully executed-----");
	a.gift();
	a.Addtocart();
	a.deletefromcart();
}
@Test
public void m() {
	Logger logger=Logger.getLogger(Amazondefinition.class);
	 logger.info("-----2nd testcase----");
}

@AfterMethod
public void closeapp() {
	//a.logout();
	driver.close();
	extent.flush();
}
}
