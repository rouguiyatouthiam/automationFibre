package sn.orange.sonatel.pole.digital.testcase;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.time.StopWatch;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import junit.framework.Assert;
import sn.orange.sonatel.pole.digital.common.BrowserControl;
import sn.orange.sonatel.pole.digital.pom.FibreB2B.Geoloc.FibreTestParGeolocalisations;



public class FibreB2BGeolocTestCase {
	
	private BrowserControl bc;
	WebDriver driver;
	FibreTestParGeolocalisations fibreTestParGeolocalisation;
	StopWatch globalTime,authentificationTime, accueilTime;
	
	@Parameters({"appUrl", "navigateur"})
	@BeforeTest
	public void setup(String appUrl, String navigateur)
	{
		DesiredCapabilities caps = new DesiredCapabilities();
	    caps.setCapability("browser", "Chrome");
	  
	  	ChromeOptions options = new ChromeOptions();
	    Map < String, Object > prefs = new HashMap < String, Object > ();
	    Map < String, Object > profile = new HashMap < String, Object > ();
	    Map < String, Object > contentSettings = new HashMap < String, Object > ();
	    
	    // SET CHROME OPTIONS
	    // 0 - Default, 1 - Allow, 2 - Block
	    contentSettings.put("geolocation", 1);
	    profile.put("managed_default_content_settings", contentSettings);
	    prefs.put("profile", profile);
	    options.setExperimentalOption("prefs", prefs);
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
	
	
	@Test(description = "Ce test permet verifier son éligibilité par coordonnées GPS",dependsOnMethods = "accueil")
	public void testEligibiliteParGPS()
	{
		bc.waitSomeTime(1000);
		fibreTestParGeolocalisation = new FibreTestParGeolocalisations(this.bc);
		Assert.assertEquals(fibreTestParGeolocalisation.IsCestParti(), true);
		fibreTestParGeolocalisation.clickCParti();
		bc.waitSomeTime(1000);
		Assert.assertEquals(fibreTestParGeolocalisation.IsNon(), true);
		fibreTestParGeolocalisation.clickNon();
		bc.waitSomeTime(2000);
		Assert.assertEquals(fibreTestParGeolocalisation.IsMonLieuDeTravail(), true);
		fibreTestParGeolocalisation.clickMonLieuDeTravail();
		bc.waitSomeTime(2000);
		Assert.assertEquals(fibreTestParGeolocalisation.IsTestGPS(), true);
		fibreTestParGeolocalisation.clickTestGPS();
		bc.waitSomeTime(2000);
		if (fibreTestParGeolocalisation.IsTestGPS()==true) 
	    {
			bc.waitSomeTime(130000);
	    }
		
		Assert.assertEquals(fibreTestParGeolocalisation.IsValiderPosition(), true);
		fibreTestParGeolocalisation.clickValiderPosition();
		bc.waitSomeTime(5000);
		Assert.assertEquals(fibreTestParGeolocalisation.IsOffre(), true);
		bc.waitSomeTime(3000);
	}
	
	

	 @AfterTest
	 public void browserClose() 
	 {
		  bc.closeBrowser();
		  globalTime.stop();
		  System.out.println("Global Time Execution:"+globalTime);
	  }


}
