package sn.orange.sonatel.pole.digital.testcase;

import org.apache.commons.lang3.time.StopWatch;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import junit.framework.Assert;
import sn.orange.sonatel.pole.digital.common.BrowserControl;
import sn.orange.sonatel.pole.digital.pom.FibreB2C.Telephone.NonEligible.OffreAdslDispo.FibreNonEligibleConfirmationSouscriptionOffreAdsl;
import sn.orange.sonatel.pole.digital.pom.FibreB2C.Telephone.NonEligible.OffreAdslDispo.FibreNonEligibleSouscrireOffreAdsl;
import sn.orange.sonatel.pole.digital.pom.FibreB2C.Telephone.NonEligible.OffreAdslDispo.FibreTestParTelephoneNonEligible_AffichageOffreAdsl;



public class FibreB2CTelNonEli_Avec_OffreAdslTestCase {
	
	private BrowserControl bc;
	WebDriver driver;
	FibreTestParTelephoneNonEligible_AffichageOffreAdsl fibreTestParTelephoneNonEligible_AffichageOffreAdsl;
	FibreNonEligibleSouscrireOffreAdsl fibreNonEligibleSouscrireOffreAdsl;
	StopWatch globalTime,authentificationTime, accueilTime;
	FibreNonEligibleConfirmationSouscriptionOffreAdsl fibreNonEligibleConfirmationSouscriptionOffreAdsl;
	
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
		fibreTestParTelephoneNonEligible_AffichageOffreAdsl = new FibreTestParTelephoneNonEligible_AffichageOffreAdsl(this.bc);
		Assert.assertEquals(fibreTestParTelephoneNonEligible_AffichageOffreAdsl.IsBtnCestParti(), true);
		fibreTestParTelephoneNonEligible_AffichageOffreAdsl.clickCParti();
		bc.waitSomeTime(2000);
		Assert.assertEquals(fibreTestParTelephoneNonEligible_AffichageOffreAdsl.IsBtnOUI(), true);
		bc.waitSomeTime(2000);
		fibreTestParTelephoneNonEligible_AffichageOffreAdsl.oui();
		bc.waitSomeTime(2000);
		fibreTestParTelephoneNonEligible_AffichageOffreAdsl.saisirTelephone(telephone);
		//Temps d'attente un peu important pour verifier l'assertion vu que l'affichage des offres peut prendre du temps
		bc.waitSomeTime(3000);
		Assert.assertEquals(fibreTestParTelephoneNonEligible_AffichageOffreAdsl.IsOffre(), true);
			
	}
	
	@Parameters({"prenom","nom","email","tel"})
	@Test(description = "Ce test permet se souscrire une fois  qu'on est eligible",dependsOnMethods = "testEligibiliteParTelephone")
	public void souscription( String strprenom,String strnom,String stremail, String strmobilePhone)
	{
		bc.waitSomeTime(2000);
		fibreNonEligibleSouscrireOffreAdsl = new FibreNonEligibleSouscrireOffreAdsl(this.bc);
		fibreNonEligibleSouscrireOffreAdsl.clickSouscrirekeurGui();
		Assert.assertEquals(fibreNonEligibleSouscrireOffreAdsl.IsPopupSouscription(), true);
		fibreNonEligibleSouscrireOffreAdsl.verifie();
		bc.waitSomeTime(2000);
		
		
		fibreNonEligibleSouscrireOffreAdsl.clickSouscrireboxBi();
		Assert.assertEquals(fibreNonEligibleSouscrireOffreAdsl.IsPopupSouscription(), true);
		fibreNonEligibleSouscrireOffreAdsl.verifie();
		bc.waitSomeTime(2000);
		
		fibreNonEligibleSouscrireOffreAdsl.accederAuFormulaire();
		Assert.assertEquals(fibreNonEligibleSouscrireOffreAdsl.IsPopupSouscription(), true);
		fibreNonEligibleSouscrireOffreAdsl.sauvegarder( strprenom,strnom,stremail, strmobilePhone);
		bc.waitSomeTime(3000);
		Assert.assertEquals(fibreNonEligibleSouscrireOffreAdsl.IsConfirmationSouscription(), true);
		
	}
	
	@Test(description = "Ce test permet verifier sa souscription est validée",dependsOnMethods = "souscription")
	public void confirmationSouscription()
	{
		fibreNonEligibleConfirmationSouscriptionOffreAdsl = new FibreNonEligibleConfirmationSouscriptionOffreAdsl(this.bc);
		Assert.assertEquals(fibreNonEligibleConfirmationSouscriptionOffreAdsl.IsBtnTerminer(), true);
		fibreNonEligibleConfirmationSouscriptionOffreAdsl.clickTerminert();
		
	}
	

	 @AfterTest
	 public void browserClose() 
	 {
		  bc.closeBrowser();
		  globalTime.stop();
		  System.out.println("Global Time Execution:"+globalTime);
	  }


}
