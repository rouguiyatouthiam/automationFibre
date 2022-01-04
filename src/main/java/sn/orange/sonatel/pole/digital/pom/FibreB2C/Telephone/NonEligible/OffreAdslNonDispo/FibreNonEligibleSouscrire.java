package sn.orange.sonatel.pole.digital.pom.FibreB2C.Telephone.NonEligible.OffreAdslNonDispo;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import sn.orange.sonatel.pole.digital.common.BrowserControl;

public class FibreNonEligibleSouscrire {
	
	BrowserControl bc;

	///Ces strings sont déclarés pour vérifier les asserts, ils recoivent les memes valeurs que celles qui se trouvent dans le findBy
	
	public String strpopup="//button[@class='col-sm-12 col-12 btn btn-primary']";
	
	
	///Boutons à cliquer
	
	@FindBy(xpath="//div[@class='content-swiper']/div[2]/button/span")
	private WebElement btn_souscrire;
	
	@FindBy(xpath="//button[@class='col-sm-12 col-12 btn btn-primary']")
	private WebElement btn_sauvegarder;
	
	
	// champs à renseigner
	
	
	
	@FindBy(name="firstName")
	private WebElement prenom;
	
	
	@FindBy(name="lastName")
	private WebElement nom;
	
	
	@FindBy(name="email")
	private WebElement email;
	
	@FindBy(name="mobilePhone")
	private WebElement mobilePhone;
	
	
	
	String strBtnRetour="Retour";
	
	public Boolean isPopup,isConfirmation;
	
	
	

			/**
			 * Constructeur: Initialisation des éléments
			 * @param driver
			 */
				public FibreNonEligibleSouscrire(BrowserControl bc)
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
						WebElement boutonRetour = bc.getElementByLink(strBtnRetour);
						
						if(null != boutonRetour)
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
			 	  public void clickSouscrire()
			 	  {
			 		btn_souscrire.click();
			 	  }
			
		 	
		 	/**
			 * Cette fonction appelle la fonction clickSouscrire
			 */
			 	public void souscrire() 
			 	{
			 		this.clickSouscrire();
			 		
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
			 	
		 	
		 	
		 	
		 	public void sauvegarder(String strprenom,String strnom,String stremail, String strmobilePhone)
		 	{
		 		this.setprenom(strprenom);
		 		this.setnom(strnom);
		 		this.setmobilePhone(strmobilePhone);
		 		this.setemail(stremail);
		 		this.clickSauvegarder();
		 		
		 	}
		 	
		 	
		 	
		 	
}
