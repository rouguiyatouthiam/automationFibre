package sn.orange.sonatel.pole.digital.testcase;

import org.apache.commons.lang3.time.StopWatch;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import junit.framework.Assert;
import sn.orange.sonatel.pole.digital.common.BrowserControl;
import sn.orange.sonatel.pole.digital.pom.FibreB2C.Telephone.Eligible.FibreConfirmationSouscription;
import sn.orange.sonatel.pole.digital.pom.FibreB2C.Telephone.Eligible.FibreEligibleSouscrire;
import sn.orange.sonatel.pole.digital.pom.FibreB2C.Telephone.Eligible.FibreTestParTelephone;


public class FibreB2CTelephoneEligibleTestCase {
	
	private BrowserControl bc;
	WebDriver driver;
	FibreTestParTelephone fibreTestParTelephone;
	FibreEligibleSouscrire fibreEligibleSouscrire;
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
		fibreTestParTelephone = new FibreTestParTelephone(this.bc);
		Assert.assertEquals(fibreTestParTelephone.IsBtnCestParti(), true);
		fibreTestParTelephone.clickCParti();
		bc.waitSomeTime(2000);
		Assert.assertEquals(fibreTestParTelephone.IsBtnOUI(), true);
		bc.waitSomeTime(2000);
		fibreTestParTelephone.oui();
		bc.waitSomeTime(2000);
		fibreTestParTelephone.saisirTelephone(telephone);
		//Temps d'attente un peu important pour verifier l'assertion vu que l'affichage des offres peut prendre du temps
		bc.waitSomeTime(10000);
		Assert.assertEquals(fibreTestParTelephone.IsOffre(), true);
			
	}
	
	@Parameters({"prenom","nom","cin","dvalidite","dexpiration","email","commune","tel","adresse","adresseMap"})
	@Test(description = "Ce test permet se souscrire une fois  qu'on est eligible",dependsOnMethods = "testEligibiliteParTelephone")
	public void souscription( String strprenom,String strnom, String strcin,String strdateDelivrance,String strdexpiration
 			,String stremail,String strCommune,String strmobilePhone,String stradress,String setAdresseMap)
	{
		bc.waitSomeTime(2000);
		fibreEligibleSouscrire = new FibreEligibleSouscrire(this.bc);
		fibreEligibleSouscrire.souscrireFibreMax();
		Assert.assertEquals(fibreEligibleSouscrire.IsPopupSouscription(), true);
		fibreEligibleSouscrire.verifie();
		fibreEligibleSouscrire.souscrireFibreMega();
		Assert.assertEquals(fibreEligibleSouscrire.IsPopupSouscription(), true);
		fibreEligibleSouscrire.verifie();
		fibreEligibleSouscrire.souscrireFibreBi();
		Assert.assertEquals(fibreEligibleSouscrire.IsPopupSouscription(), true);
		bc.waitSomeTime(2000);
		fibreEligibleSouscrire.sauvegarder( strprenom, strnom, strcin,strdateDelivrance,strdexpiration, stremail,strCommune , strmobilePhone, stradress,setAdresseMap);
		bc.waitSomeTime(3000);
		Assert.assertEquals(fibreEligibleSouscrire.IsConfirmationSouscription(), true);
		
	}
	
	@Test(description = "Ce test permet verifier sa souscription est validée",dependsOnMethods = "souscription")
	public void confirmationSouscription()
	{
		fibreConfirmationSouscription = new FibreConfirmationSouscription(this.bc);
		Assert.assertEquals(fibreConfirmationSouscription.IsBtnTerminer(), true);
		
	}
	

	 @AfterTest
	 public void browserClose() 
	 {
		  bc.closeBrowser();
		  globalTime.stop();
		  System.out.println("Global Time Execution:"+globalTime);
	  }


}
