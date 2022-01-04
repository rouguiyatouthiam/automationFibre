package sn.orange.sonatel.pole.digital.testcase;

import org.apache.commons.lang3.time.StopWatch;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import junit.framework.Assert;
import sn.orange.sonatel.pole.digital.common.BrowserControl;
import sn.orange.sonatel.pole.digital.pom.FibreB2B.GPS.FibreSouscriptionB2B;
import sn.orange.sonatel.pole.digital.pom.FibreB2B.GPS.FibreTestParGPS;



public class FibreB2BTestCase {
	
	private BrowserControl bc;
	WebDriver driver;
	FibreTestParGPS fibreTestParGPS;
	FibreSouscriptionB2B fibreSouscriptionB2B;
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
		bc.waitSomeTime(1000);
	}
	
	@Parameters({"adresse"})
	@Test(description = "Ce test permet verifier son éligibilité par coordonnées GPS",dependsOnMethods = "accueil")
	public void testEligibiliteParGPS(String adresse)
	{
		bc.waitSomeTime(1000);
		fibreTestParGPS = new FibreTestParGPS(this.bc);
		Assert.assertEquals(fibreTestParGPS.IsCestParti(), true);
		fibreTestParGPS.clickCParti();
		bc.waitSomeTime(1000);
		Assert.assertEquals(fibreTestParGPS.IsNon(), true);
		fibreTestParGPS.clickNon();
		bc.waitSomeTime(3000);
		Assert.assertEquals(fibreTestParGPS.IsMonLieuDeTravail(), true);
		fibreTestParGPS.clickMonLieuDeTravail();
		bc.waitSomeTime(3000);
		Assert.assertEquals(fibreTestParGPS.IsTestGPS(), true);
		fibreTestParGPS.clickTestGPS();
		bc.waitSomeTime(3000);
		Assert.assertEquals(fibreTestParGPS.IsMap(), true);
		fibreTestParGPS.saisirAdresse(adresse);
		bc.waitSomeTime(3000);
		Assert.assertEquals(fibreTestParGPS.IsValiderPosition(), true);
		fibreTestParGPS.clickValiderPosition();
		bc.waitSomeTime(5000);
		Assert.assertEquals(fibreTestParGPS.IsOffre(), true);
		bc.waitSomeTime(3000);
	}
	
	@Parameters({"nomEntreprise","ninea","adresseEntreprise","enteteRegistre","entete","prenom","nom","email","tel","cni"})
	@Test(description = "Ce test permet se souscrire une fois  qu'on a effectué le test",dependsOnMethods = "testEligibiliteParGPS")
	public void souscription(String strnomEntreprise,String strninea, String stradress, String file_Upload_tradeRegister,String file_Upload_header,
			String strprenom,String strnom, String stremail,String strmobilePhone,String file_Upload_cni)
	{
		fibreSouscriptionB2B= new FibreSouscriptionB2B(this.bc );
		fibreSouscriptionB2B.souscrire();
		Assert.assertEquals(fibreSouscriptionB2B.IsPopupSouscription(), true);
		bc.waitSomeTime(2000);
		fibreSouscriptionB2B.sauvegarder(strnomEntreprise,strninea,stradress,file_Upload_tradeRegister,file_Upload_header,strprenom,strnom,stremail,strmobilePhone,file_Upload_cni);
		bc.waitSomeTime(5000);
		Assert.assertEquals(fibreSouscriptionB2B.IsConfirmationSouscription(), true);
	}
	

	 @AfterTest
	 public void browserClose() 
	 {
		  bc.closeBrowser();
		  globalTime.stop();
		  System.out.println("Global Time Execution:"+globalTime);
	  }


}
