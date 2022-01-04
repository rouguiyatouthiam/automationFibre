package sn.orange.sonatel.pole.digital.testcase;

import org.apache.commons.lang3.time.StopWatch;



import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import junit.framework.Assert;
import sn.orange.sonatel.pole.digital.common.BrowserControl;
import sn.orange.sonatel.pole.digital.pom.FibreB2C.Telephone.Relie.AUnCentral.FibreTestParTelephoneCentral;


public class FibreNumeroCentralTestCase {
	
	private BrowserControl bc;
	WebDriver driver;
	FibreTestParTelephoneCentral fibreTestParTelephoneCentral;
	StopWatch globalTime,authentificationTime, accueilTime;
	
	@Parameters({"appUrl", "navigateur"})
	@BeforeTest
	public void setup(String appUrl, String navigateur)
	{
		globalTime = new StopWatch();
		globalTime.start();
		bc = new BrowserControl(navigateur);
		bc.launchURL(appUrl);
	}
	
	@Parameters({"appUrl"})
	@Test(description = "Ce test permet de vérifier si on est à la page d'acuueil")
	public void accueil(String appUrl)
	{
		bc.waitSomeTime(2000);
		System.out.println("appUrl" +appUrl);
		System.out.println("currentUrl" +bc.currentURL());
		Assert.assertEquals(appUrl,bc.currentURL());
		System.out.println("urls conformes");
		bc.waitSomeTime(3000);
	}
	
	@Parameters({"telephone"})
	@Test(description = "Ce test permet verifier son éligibilité par numéro telephone",dependsOnMethods = "accueil")
	public void testEligibiliteParTelephone(String telephone)
	{
		bc.waitSomeTime(1000);
		fibreTestParTelephoneCentral = new FibreTestParTelephoneCentral(this.bc);
		Assert.assertEquals(fibreTestParTelephoneCentral.IsBtnCestParti(), true);
		fibreTestParTelephoneCentral.clickCParti();
		bc.waitSomeTime(2000);
		Assert.assertEquals(fibreTestParTelephoneCentral.IsBtnOUI(), true);
		bc.waitSomeTime(2000);
		fibreTestParTelephoneCentral.oui();
		bc.waitSomeTime(2000);
		fibreTestParTelephoneCentral.saisirTelephone(telephone);
		//Temps d'attente un peu important pour verifier l'assertion vu que l'affichage des offres peut prendre du temps
		bc.waitSomeTime(3000);
		Assert.assertEquals(fibreTestParTelephoneCentral.IsBtnGeoloc(), true);
		Assert.assertEquals(fibreTestParTelephoneCentral.IsBtnGPS(), true);	
	}
	

	 @AfterTest
	 public void browserClose() 
	 {
		  bc.closeBrowser();
		  globalTime.stop();
		  System.out.println("Global Time Execution:"+globalTime);
	  }


}
