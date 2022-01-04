package sn.orange.sonatel.pole.digital.common;

import org.openqa.selenium.WebDriver;

public class PageNavigation {
	
	/**
	 * Fonction permettant de naviguer sur l'application par lien
	 */
	public void navigateByLink()
	{
		
	}

	/**
	 * Fonction permettant de naviguer sur la page précédente
	 * @param driver
	 */
	public void navigateBack(WebDriver driver)
	{
		driver.navigate().back();
	}
	
	/**
	 * Fonction permettant de naviguer sur la page suivante
	 * @param driver
	 */
	public void navigateForward(WebDriver driver)
	{
		driver.navigate().forward();
	}
	
	/**
	 * Fonction permettant de rafraichir la page
	 * @param driver
	 */
	public void navigatePageRefresh(WebDriver driver)
	{
		driver.navigate().refresh();
	}
	
}
