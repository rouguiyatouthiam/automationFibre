package sn.orange.sonatel.pole.digital.pom.FibreB2C.Telephone.Eligible;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import sn.orange.sonatel.pole.digital.common.BrowserControl;

public class FibreEligibleSouscrire {
	
	BrowserControl bc;

	///Ces strings sont déclarés pour vérifier les asserts, ils recoivent les memes valeurs que celles qui se trouvent dans le findBy
	
	public String strpopup="(.//*[normalize-space(text()) and normalize-space(.)='Nous contacter via Facebook'])[1]/preceding::button[1]";
	private String picto_confirmation="Retour";
	
	///Boutons à cliquer
	
	@FindBy(xpath="(//button[@type='button'])[5]")
	private WebElement btn_souscrire_FMega;
	
	@FindBy(xpath="(//button[@type='button'])[6]")
	private WebElement btn_souscrire_FMax;
	
	@FindBy(xpath="(//button[@type='button'])[7]")
	private WebElement btn_souscrire_FBi;
	
	@FindBy(xpath="//div[@id='steps-desk']/div/div/div/div/span")
	private WebElement btn_retour_Etape1;
	
	
	@FindBy(xpath="(.//*[normalize-space(text()) and normalize-space(.)='Nous contacter via Facebook'])[1]/preceding::button[1]")
	private WebElement btn_sauvegarder;
	
	
	// champs à renseigner
	
	@FindBy(name="civility")
	private WebElement civility;
	
	@FindBy(xpath="(.//*[normalize-space(text()) and normalize-space(.)='Civilité'])[1]/following::label[1]")
	private WebElement civility_value;
	
	
	
	@FindBy(name="firstName")
	private WebElement prenom;
	
	
	@FindBy(name="lastName")
	private WebElement nom;
	
	@FindBy(name="identificationType")
	private WebElement identificationType;
	
	@FindBy(xpath="(.//*[normalize-space(text()) and normalize-space(.)='Type de pièce'])[1]/following::label[1]")
	private WebElement identificationType_value;
	
	@FindBy(name="cin")
	private WebElement cin;

	@FindBy(name="dateDelivrance")
	private WebElement dateDelivrance;
	
	@FindBy(name="dateValidity")
	private WebElement dateExpiration;
	
	@FindBy(xpath="(.//*[normalize-space(text()) and normalize-space(.)='Sam'])[2]/following::span[21]")
	private WebElement dateExpiration_value;
	
	
	@FindBy(name="email")
	private WebElement email;
	
	@FindBy(name="mobilePhone")
	private WebElement mobilePhone;
	
	@FindBy(id="commune-addresse")
	private WebElement commune;
	
	@FindBy(xpath="//*/text()[normalize-space(.)='bopp']/parent::*")
	private WebElement commune_value;

	
	@FindBy(id="quartier-addresse")
	private WebElement quartier;
	
	@FindBy(xpath="//*/text()[normalize-space(.)='cerf volant']/parent::*")
	private WebElement quartier_value;
	
	
	@FindBy(name="housingType")
	private WebElement housingType;
	
	@FindBy(xpath="(.//*[normalize-space(text()) and normalize-space(.)='Type de logement'])[1]/following::label[1]")
	private WebElement housingType_value;
	
	
	@FindBy(id="input_search_addresses")
	private WebElement zone_recherche_quartier;
	
	@FindBy(css=".autocomplete-result:nth-child(1) > .full-address")
	private WebElement quartir_choisir_sur_la_map;
	
	@FindBy(css=".gm-style > div:nth-child(1) > div:nth-child(3)")
	private WebElement clik__sur_la_map;
	
	
	
	public Boolean isPopup,isConfirmation;
	
	
	

			/**
			 * Constructeur: Initialisation des éléments
			 * @param driver
			 */
				public FibreEligibleSouscrire(BrowserControl bc)
				{
					this.bc = bc;
					PageFactory.initElements(bc.getDriver(), this);
				}
		
	
		
			/**
			 * Cette fonction retourne un boolean
			 * elle permet de vérifier si on est à l'étape de souscription
			 * 
			 */
		
				public boolean IsPopupSouscription()
			    {
					isPopup=false;
						WebElement popup = bc.getElementByXPath(strpopup);
						
						if(null != popup)
						{
							isPopup=true;
							System.out.println("etape souscription");
						}
						else
						{
							System.out.println("non etape souscription");
						}
						
					
					return isPopup;
				}
				
			/**
			 * Cette fonction retourne un boolean
			 * elle permet de vérifier si on est l'étape de validation
			 * 
			 */
		
				public boolean IsConfirmationSouscription()
			    {
					    isConfirmation=false;
						WebElement img_confirmation = bc.getElementByLink(picto_confirmation);
						
						if(null != img_confirmation)
						{
							isConfirmation=true;
							System.out.println("redirection page confirmation souscription");
						}
						else
						{
							System.out.println("Non redirection page confirmation souscription");
						}
						
					
					return isConfirmation;
				}
			
			
			
			
				 /**
				 * Cette fonction permet de cliquer sur le bouton Souscrire
				 * */
			 	  public void clickSauvegarder()
			 	  {
			 		btn_sauvegarder.click();
			 	  }
				
		 	
	
			 /**
			 * Cette fonction permet de cliquer sur le bouton je veux souscrire 
			 * 
			 **/
			 	  public void clickSouscrireFibreMega()
			 	  {
			 		btn_souscrire_FMega.click();
			 	  }
			
		 	
		 	/**
			 * Cette fonction appelle la fonction clickSouscrire
			 */
			 	public void souscrireFibreMega() 
			 	{
			 		this.clickSouscrireFibreMega();
			 		
			    }
			 	
			 	
			 	////////
			 	 /**
				 * Cette fonction permet de cliquer sur le bouton je veux souscrire 
				 * 
				 **/
				 	  public void clickSouscrireFibreMax()
				 	  {
				 		btn_souscrire_FMax.click();
				 	  }
				
			 	
			 	/**
				 * Cette fonction appelle la fonction clickSouscrire
				 */
				 	public void souscrireFibreMax() 
				 	{
				 		this.clickSouscrireFibreMax();
				 		
				    }
				 	
				 	
				 	//////
				 	
				 	 /**
					 * Cette fonction permet de cliquer sur le bouton je veux souscrire 
					 * 
					 **/
					 	  public void clickSouscrireFibreBi()
					 	  {
					 		btn_souscrire_FBi.click();
					 	  }
					
				 	
				 	/**
					 * Cette fonction appelle la fonction clickSouscrire
					 */
					 	public void souscrireFibreBi() 
					 	{
					 		this.clickSouscrireFibreBi();
					 		
					    }
					 	
			 
					 	 /**
						 * Cette fonction permet de cliquer sur le bouton "Je vérifie"
						 * 
						 **/
						 	  public void clickJeVerifie()
						 	  {
						 		btn_retour_Etape1.click();
						 	  }
						
					 	
					 	/**
						 * Cette fonction appelle la fonction clickSouscrire
						 */
						 	public void verifie() 
						 	{
						 		this.clickJeVerifie();
						 		
						    }
					 	

		 	/**
			 * Cette fonction permet de choisir civilite
			 * @param strcivilite
			 */
			 	public void setcivility(){
			 		civility_value.click();
			 	}
		 	
		 	
		 	/**
			 * Cette fonction permet de saisir le prenom
			 * @param strprenom
			 */
			 	public void setprenom(String strprenom){
			 		prenom.sendKeys(strprenom);
			 	}
		 	
		 	/**
			 * Cette fonction permet de saisir le nom
			 * @param strnom
			 */
			 	public void setnom(String strnom){
			 		nom.sendKeys(strnom);;
			 	}
			 	
		 	/**
			 * Cette fonction permet de choisir le type d'dentification
			 * 
			 */
			 	public void settypeIdentification(){
			 		identificationType_value.click();
			 	}
		 	
		 	/**
			 * Cette fonction permet de saisir le numero de cin
			 * @param strcin
			 */
			 	public void setcni(String strcin){
			 		cin.sendKeys(strcin);
			 	}
		 	
		 	/**
			 * Cette fonction permet de saisir la date de délivrance
			 * @param strddelivrance
			 */
			 	public void setddelivrance(String strdateDelivrance){
			 		dateDelivrance.click();
			 		dateDelivrance.sendKeys(strdateDelivrance);
			 		
			 	}
		 	
		 	/**
			 * Cette fonction permet de saisir la date d'expiration
			 * @param strdexpiration
			 */
			 	public void setdexpiration(String strdexpiration){
			 		dateExpiration.click();
			 		dateExpiration.sendKeys(strdexpiration);;
			 	}
		 	
		 	
		 	/**
			 * Cette fonction permet de saisir l'email
			 * @param stremail
			 */
			 	public void setemail(String stremail){
			 		email.sendKeys(stremail);
			 	}
		 	
		 	
		 	/**
			 * Cette fonction permet de saisir le numéro mobile
			 * @param strmobilePhone
			 */
			 	public void setmobilePhone(String strmobilePhone){
			 		mobilePhone.sendKeys(strmobilePhone);;
			 	}
			 	
		 	

		 	/**
			 * Cette fonction permet de choisir la commune
			 * @param strcommune
			 */
			 	public void setcommune(String strCommune){
			 		commune.click();
			 		bc.waitSomeTime(1000);
			 		commune.sendKeys(strCommune);
			 		bc.waitSomeTime(1000);
			 		commune_value.click();
			 		bc.waitSomeTime(2000);
			 	}
			 	
			 	
			 	
			 	/**
				 * Cette fonction permet de saisir le quartier
				 * @param strprenom
				 */
				 	public void setAdresseMap(){
				 		quartir_choisir_sur_la_map.click();
				 		clik__sur_la_map.click();
				 		//Ces commandes javascripts permettent de déplacer le curseur 
				 		bc.waitSomeTime(1000);
				 	   ((JavascriptExecutor) bc.getDriver()).executeScript("document.elementFromPoint(document.getElementById('map').offsetWidth,400).click()");
				 	}
			 	
		 	
		 	/**
			 * Cette fonction permet de choisir le quartier
			 * @param strquartier
			 */
			 	public void setquartier(){
			 		quartier.click();
			 		System.out.println(quartier_value.getText());
			 		quartier_value.click();
			 	}
		 	
		 	/**
			 * Cette fonction permet de saisir la housingType
			 * @param housingType
			 */
			 	public void sethousingType(){
			 		System.out.println(housingType_value.getText());
			 		housingType_value.click();
			 	}
		 	
		 	
		 	public void sauvegarder(String strprenom,String strnom, String strcin, String strdateDelivrance,
		 			String strdexpiration,String stremail, String strCommune,String strmobilePhone,String stradress,String setAdresseMap)
		 	{
		 		this.setcivility();
		 		this.setprenom(strprenom);
		 		this.setnom(strnom);
		 		this.settypeIdentification();
		 		this.setcni(strcin);
		 		this.setddelivrance(strdateDelivrance);
		 		this.setdexpiration(strdexpiration);
		 		JavascriptExecutor jse =(JavascriptExecutor) bc.getDriver();
				jse.executeScript("window.scrollBy(0,900)");
		 		this.setcommune(strCommune);
		 		//temps de chargement des quartiers de la commune
		 		bc.waitSomeTime(2000);
		 		this.setquartier();
		 		this.setAdresseMap();
		 		bc.waitSomeTime(2000);
		 		this.sethousingType();
		 		this.setmobilePhone(strmobilePhone);
		 		this.setemail(stremail);
		 		this.clickSauvegarder();
		 		
		 	}
		 	
		 	
		 	
		 	
}
