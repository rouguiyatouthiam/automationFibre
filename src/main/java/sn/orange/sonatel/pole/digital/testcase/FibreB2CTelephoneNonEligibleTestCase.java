package sn.orange.sonatel.pole.digital.testcase;

import org.apache.commons.lang3.time.StopWatch;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import junit.framework.Assert;
import sn.orange.sonatel.pole.digital.common.BrowserControl;
import sn.orange.sonatel.pole.digital.pom.FibreB2C.Telephone.NonEligible.OffreAdslNonDispo.FibreNonEligibleConfirmationSouscription;
import sn.orange.sonatel.pole.digital.pom.FibreB2C.Telephone.NonEligible.OffreAdslNonDispo.FibreNonEligibleSouscrire;
import sn.orange.sonatel.pole.digital.pom.FibreB2C.Telephone.NonEligible.OffreAdslNonDispo.FibreTestParTelephoneNonEligible;


public class FibreB2CTelephoneNonEligibleTestCase {
	
	private BrowserControl bc;
	WebDriver driver;
	FibreTestParTelephoneNonEligible fibreTestParTelephoneNonEligible;
	FibreNonEligibleSouscrire fibreNonEligibleSouscrire;
	StopWatch globalTime,authentificationTime, accueilTime;
	FibreNonEligibleConfirmationSouscription fibreNonEligibleConfirmationSouscription;
	
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
		bc.waitSomeTime(1000);
	}
	
	@Parameters({"telephone"})
	@Test(description = "Ce test permet verifier son éligibilité par numéro telephone",dependsOnMethods = "accueil")
	public void testEligibiliteParTelephone(String telephone)
	{
		bc.waitSomeTime(1000);
		fibreTestParTelephoneNonEligible = new FibreTestParTelephoneNonEligible(this.bc);
		Assert.assertEquals(fibreTestParTelephoneNonEligible.IsBtnCestParti(), true);
		fibreTestParTelephoneNonEligible.clickCParti();
		bc.waitSomeTime(2000);
		Assert.assertEquals(fibreTestParTelephoneNonEligible.IsBtnOUI(), true);
		bc.waitSomeTime(2000);
		fibreTestParTelephoneNonEligible.oui();
		bc.waitSomeTime(2000);
		fibreTestParTelephoneNonEligible.saisirTelephone(telephone);
		//Temps d'attente un peu important pour verifier l'assertion vu que l'affichage des offres peut prendre du temps
		bc.waitSomeTime(3000);
		Assert.assertEquals(fibreTestParTelephoneNonEligible.IsOffre(), true);
			
	}
	
	@Parameters({"prenom","nom","email","tel"})
	@Test(description = "Ce test permet se souscrire une fois  qu'on est eligible",dependsOnMethods = "testEligibiliteParTelephone")
	public void souscription( String strprenom,String strnom,String stremail, String strmobilePhone)
	{
		bc.waitSomeTime(2000);
		fibreNonEligibleSouscrire = new FibreNonEligibleSouscrire(this.bc);
		fibreNonEligibleSouscrire.clickSouscrire();
		Assert.assertEquals(fibreNonEligibleSouscrire.IsPopupSouscription(), true);
		bc.waitSomeTime(2000);
		fibreNonEligibleSouscrire.sauvegarder( strprenom,strnom,stremail, strmobilePhone);
		bc.waitSomeTime(3000);
		Assert.assertEquals(fibreNonEligibleSouscrire.IsConfirmationSouscription(), true);
		
	}
	
	@Test(description = "Ce test permet verifier sa souscription est validée",dependsOnMethods = "souscription")
	public void confirmationSouscription()
	{
		fibreNonEligibleConfirmationSouscription = new FibreNonEligibleConfirmationSouscription(this.bc);
		Assert.assertEquals(fibreNonEligibleConfirmationSouscription.IsBtnTerminer(), true);
		fibreNonEligibleConfirmationSouscription.clickTerminert();
		
	}
	

	 @AfterTest
	 public void browserClose() 
	 {
		  bc.closeBrowser();
		  globalTime.stop();
		  System.out.println("Global Time Execution:"+globalTime);
	  }


}
