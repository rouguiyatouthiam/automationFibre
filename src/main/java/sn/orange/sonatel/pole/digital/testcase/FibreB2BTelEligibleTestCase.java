package sn.orange.sonatel.pole.digital.testcase;

import org.apache.commons.lang3.time.StopWatch;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import junit.framework.Assert;
import sn.orange.sonatel.pole.digital.common.BrowserControl;
import sn.orange.sonatel.pole.digital.pom.FibreB2B.Telephone.Eligible.FibreSouscrireTestTelephoneB2BEligible;
import sn.orange.sonatel.pole.digital.pom.FibreB2B.Telephone.Eligible.FibreTestTelephoneEligibleB2B;
import sn.orange.sonatel.pole.digital.pom.FibreB2C.Telephone.Eligible.FibreConfirmationSouscription;


public class FibreB2BTelEligibleTestCase {
	
	private BrowserControl bc;
	WebDriver driver;
	FibreTestTelephoneEligibleB2B fibreTestParTelephoneB2B;
	FibreSouscrireTestTelephoneB2BEligible fibreTestTelephone_EligibleSouscrireB2B;
	StopWatch globalTime,authentificationTime, accueilTime;
	FibreConfirmationSouscription fibreConfirmationSouscription;
	
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
		bc.waitSomeTime(2000);
	}
	
	@Parameters({"telephone"})
	@Test(description = "Ce test permet verifier son éligibilité par numéro telephone",dependsOnMethods = "accueil")
	public void testEligibiliteParTelephone(String telephone)
	{
		bc.waitSomeTime(1000);
		fibreTestParTelephoneB2B = new FibreTestTelephoneEligibleB2B(this.bc);
		Assert.assertEquals(fibreTestParTelephoneB2B.IsBtnCestParti(), true);
		fibreTestParTelephoneB2B.clickCParti();
		bc.waitSomeTime(2000);
		Assert.assertEquals(fibreTestParTelephoneB2B.IsBtnOUI(), true);
		bc.waitSomeTime(2000);
		fibreTestParTelephoneB2B.oui();
		bc.waitSomeTime(2000);
		fibreTestParTelephoneB2B.saisirTelephone(telephone);
		//Temps d'attente un peu important pour verifier l'assertion vu que l'affichage des offres peut prendre du temps
		bc.waitSomeTime(3000);
		Assert.assertEquals(fibreTestParTelephoneB2B.IsOffre(), true);
			
	}
	
	@Test(description = "Ce test permet se souscrire une fois  qu'on est eligible",dependsOnMethods = "testEligibiliteParTelephone")
	public void souscription()
	{
		bc.waitSomeTime(2000);
		fibreTestTelephone_EligibleSouscrireB2B = new FibreSouscrireTestTelephoneB2BEligible(this.bc);
		fibreTestTelephone_EligibleSouscrireB2B.souscrireOItense();
		bc.waitSomeTime(1000);
		Assert.assertEquals(fibreTestTelephone_EligibleSouscrireB2B.IsPopupSouscription(), true);
		fibreTestTelephone_EligibleSouscrireB2B.verifie();
		fibreTestTelephone_EligibleSouscrireB2B.souscrireFOffice();
		bc.waitSomeTime(1000);
		Assert.assertEquals(fibreTestTelephone_EligibleSouscrireB2B.IsPopupSouscription(), true);
		fibreTestTelephone_EligibleSouscrireB2B.verifie();
		fibreTestTelephone_EligibleSouscrireB2B.souscrireFPro();
		bc.waitSomeTime(1000);
		Assert.assertEquals(fibreTestTelephone_EligibleSouscrireB2B.IsPopupSouscription(), true);
		fibreTestTelephone_EligibleSouscrireB2B.verifie();
		bc.waitSomeTime(2000);
		fibreTestTelephone_EligibleSouscrireB2B.terminer();
		bc.waitSomeTime(2000);
		
	}
	
	@Parameters({"appUrl"})
	@Test(description = "Ce test permet de vérifier si on redirigé aaprès click du bouton terminer",dependsOnMethods = "souscription")
	public void redirection(String appUrl)
	{
		bc.waitSomeTime(2000);
		Assert.assertNotSame("urls non différents", appUrl, bc.currentURL());
	}
	

	 @AfterTest
	 public void browserClose() 
	 {
		  bc.closeBrowser();
		  globalTime.stop();
		  System.out.println("Global Time Execution:"+globalTime);
	  }


}
