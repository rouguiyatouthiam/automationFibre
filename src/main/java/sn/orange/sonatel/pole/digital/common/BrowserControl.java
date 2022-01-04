package sn.orange.sonatel.pole.digital.common;


import java.io.IOException;


import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserControl {
	
	private WebDriver driver;
	private String driverType; 
	private String driverPath= "/usr/local/bin/geckodriver.exe";
	private GetPropertyValues myvalues;
	
	/** Cette méthode permet de renvoyer le driver utilisé.
	 * 
	 * @return
	 */
	public WebDriver getDriver() {
		return driver;
	}

	/** Cette méthode permet de définir le driver à utiliser : Chrome, IE ou Firefox.
	 * 
	 * @return
	 */
	
	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * C'est le controleur de la classe. Elle permet d'initialiser le driver sur lequel toutes les autres actions seront 
	 * effectuées à celui passé en paramètres lors de l'instanciation d'un objet de type BrowserControl. 
	 * @param driver
	 */
	public BrowserControl(String navigateur)
	{
		try {
			myvalues = new GetPropertyValues();
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.driverType = myvalues.getDriverType(navigateur);
		this.driverPath = myvalues.getDriverPath(navigateur);
		System.setProperty(this.driverType, this.driverPath);
		
		if(navigateur.equals("chrome"))
		{
			this.driver = new ChromeDriver();
		}
		
		if(navigateur.equals("ie"))
		{
			this.driver = new InternetExplorerDriver();
		}
		if(navigateur.equals("firefox"))
		{
			this.driver = new FirefoxDriver();
		}
	
	}
	
	/**
	 * Cette métode permet de fermer le navigateur de test. Elle est souvent utilisé à la fin des tests.
	 */
	public void closeBrowser()
	{
		this.driver.close();
	}
	
	/**
	 * Cette méthode permet d'accéder à une application à partir de l'url fourni en paramètre.
	 * @param appUrl
	 */
	public void launchURL(String appUrl)
	{
		this.driver.get(appUrl);
		
		this.driver.manage().window().maximize();
	}
	
	
	/**
	 * Cette méthode permet de recuper l'url de la pge courante.
	 * retourne une chaine
	 */
	public String currentURL()
	{
		String urlCourrant=this.driver.getCurrentUrl();
		return urlCourrant;
	}
	
	
	/**
	 * Fonction permettant de capturer une page de l'application
	 */
	public void screenshootPage()
	{
		
	}
	
	/**
	 * Cette méthode permet de récupérer un élément visible dans une page de l'application à partir de son attribut id.
	 * @param id_name
	 * @return
	 */
	public WebElement getElementByID(String id_name)
	{
		WebElement element = null;
		try {
			element=this.driver.findElement(By.id(id_name));
		}
		catch(NoSuchElementException e)
		{
			System.out.println("id not found");
		}
		
		return element;
	}
	
	
	/**
	 * Cette méthode permet de récupérer un élément visible dans une page de l'application à partir de son attribut name.
	 * @param id_name
	 * @return
	 */
	public WebElement getElementByName(String name)
	{
		WebElement element = null;
		try {
			element=this.driver.findElement(By.name(name));
		}
		catch(NoSuchElementException e)
		{
			System.out.println("name not found");
		}
	
		return element;
	}
	
	
	/**
	 * Cette méthode permet de récupérer un lien visible dans une page de l'application à partir du nom.
	 * @param link_name
	 * @return
	 */
	public WebElement getElementByLink(String link_name)
	{
		WebElement element = null;
		try {
			element=this.driver.findElement(By.linkText(link_name));
		}
		catch(Exception e)
		{
			System.out.println("link name not found");
		}
		
		return element;
	}
	
	/**
	 * Cette méthode permet de récupérer un lien visible dans une page de l'application à partir de son xpath.
	 * @param xpath_name
	 * @return
	 */
	public WebElement getElementByXPath(String xpath_name)
	{
		WebElement element = null;
		try {
			element=this.driver.findElement(By.xpath(xpath_name));
		}
		catch(Exception e)
		{
			System.out.println("xpath name not found");
		}
		
		return element;
	}
	
	
	/** rajout rougui
	 * Cette méthode permet de récupérer un lien visible dans une page de l'application à partir de son className.
	 * @param className
	 * @return
	 */
	public WebElement getElementByClassName(String className)
	{
		WebElement element = null;
		try {
			element=this.driver.findElement(By.className(className));
		}
		catch(Exception e)
		{
			System.out.println("xpath name not found");
		}
		
		return element;
	}
	
	
	
	/**
	 * Cette méthode permet de faire une pause de X millisecondes.
	 * @param time
	 */
	public void waitSomeTime(long time)
	{
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	/**
	 * Cette méthode permet de clicker sur un button visible.
	 * @param element
	 */
	@SuppressWarnings("finally")
	public boolean clickButton(WebElement element)
	{
		boolean click_Ok = false;
		try {
			element.click();
			click_Ok = true;
		}
		catch(NoSuchElementException e)
		{
			System.out.println("id not found");
		}
		finally {
			return click_Ok;
		}
	}
	
	/**
	 * Cette méthode permet de s'authentifer sur une application.
	 * @param username_field
	 * @param username
	 * @param password_field
	 * @param password
	 */
	public void userLogin(WebElement username_field, String username, WebElement password_field, String password, WebElement loginButton)
	{
		username_field.clear();
		username_field.sendKeys(username);
		password_field.clear();
		password_field.sendKeys(password);
	    loginButton.click();
	}
	
	/**
	 * Cette methode permet de se déconnecter d'une application
	 * @param logoutBouton
	 */
	public void userLogout(WebElement logoutButton)
	{
		logoutButton.click();
	}
	

}
