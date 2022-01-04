package sn.orange.sonatel.pole.digital.common;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckAvailability {
	
	private static final long TIME_OUT = 15;
	private BrowserControl bc;
	
	public CheckAvailability(BrowserControl bc)
	{
		this.bc=bc;
	}
	
	/**
	 * Fonction permettant de vérifier le titre d'une page
	 */
	public boolean checkPageTitle(String expectedTitle)
	{
		return (this.bc.getDriver().getTitle()==expectedTitle)?true:false;
	}
	
	
	/**
	 * Fonction permettant de vérifier la disponibilité d'une page
	 */
	public void checkPageAvailibilityByLink(String link_name)
	{
		WebDriverWait wait = new WebDriverWait(this.bc.getDriver(), TIME_OUT);
		try {
			wait.until(ExpectedConditions.visibilityOf(bc.getElementByLink(link_name)));
		}
		catch(NullPointerException e)
		{
			System.out.println("Link name not found");
		}
		
	}
	
	public boolean isPageLoaded(WebElement element)
	{
		return element.isDisplayed();
	}
	

}
