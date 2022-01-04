package sn.orange.sonatel.pole.digital.pom.FibreB2B.GPS;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import sn.orange.sonatel.pole.digital.common.BrowserControl;

public class FibreSouscriptionB2B {
	
	BrowserControl bc;

	///Ces strings sont déclarés pour vérifier les asserts, ils recoivent les memes valeurs que celles qui se trouvent dans le findBy
	
	public String strpopup="name";
	private String confirmation="Retour";
	
	///Boutons à cliquer
	
	@FindBy(xpath="//div[@id='fibre-offres']/div/div/div/div/div/div/div/div[2]/button")
	private WebElement btn_souscrire;
	
	@FindBy(xpath="//*/text()[normalize-space(.)='Sauvegarder']/parent::*")
	private WebElement btn_sauvegarder;
	
	
	// champs à renseigner
	
	@FindBy(name="name")
	private WebElement nom_entreprise;

	@FindBy(name="ninea")
	private WebElement ninea;
	
	@FindBy(name="address")
	private WebElement addressentreprise;
	
	
	@FindBy(name="firstName")
	private WebElement prenom;
	
	@FindBy(name="lastName")
	private WebElement nom;
	
	

	@FindBy(name="email")
	private WebElement email;
	
	@FindBy(name="phoneNumber")
	private WebElement phoneNumber;
	
	
	
	//Fichier 
	@FindBy(name="tradeRegister")
	private WebElement registre_commerce_file;
	String registreCommerce="tradeRegister";
	
	@FindBy(name="header")
	private WebElement entete_file;
	String entete="header";
	
	
	@FindBy(name="cni")
	private WebElement cni_file;
	String cniFile="cni";
	
	
	public Boolean isPopup,isConfirmation;
	
	
	

			/**
			 * Constructeur: Initialisation des éléments
			 * @param driver
			 */
				public FibreSouscriptionB2B(BrowserControl bc)
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
						WebElement popup = bc.getElementByName(strpopup);
						
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
						WebElement img_confirmation = bc.getElementByLink(confirmation);
						
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
				 * Cette fonction permet de saisir le nom de l'entreprise
				 * @param strnomEntreprise
				 */
				 	public void setnomEntreprise(String strnomEntreprise){
				 		nom_entreprise.sendKeys(strnomEntreprise);
				 	}
				 /**
				 * Cette fonction permet de saisir le ninea de l'entreprise
				 * @param strninea
				 */
					public void setrninea(String strninea){
						ninea.sendKeys(strninea);
					}
					
				/**
				 * Cette fonction permet de saisir l'adresse de l'entreprise
				 * @param strentreprise
				 */
					public void setadresseEntreprise(String strentreprise){
						addressentreprise.sendKeys(strentreprise);
					}
					
					
					
					/**
					 * Cette fonction permet de charger le registre de commerce
					 * @param file_Upload_tradeRegister
					 */
			 	 	public void setUpload_file(String file_Upload_tradeRegister){
			 	 		//WebElement bc.getDriver();
						WebElement uploadElement =bc.getElementByName(registreCommerce);
						bc.getElementByName(registreCommerce).sendKeys(file_Upload_tradeRegister);
			 	 	}
			 	 	/**
					 * Cette fonction permet de charger le registre de commerce
					 * @param file_Upload_header
					 */
			 	 	public void setUploadFileEntete(String file_Upload_header){
			 	 		//WebElement bc.getDriver();
						WebElement uploadElement =bc.getElementByName(entete);
						bc.getElementByName(entete).sendKeys(file_Upload_header);
			 	 	}
			 	 	
			 	 	/**
					 * Cette fonction permet de charger le registre de commerce
					 * @param file_Upload_cni
					 */
			 	 	public void setUploadFileCni(String file_Upload_cni){
			 	 		//WebElement bc.getDriver();
						WebElement uploadElement =bc.getElementByName(cniFile);
						bc.getElementByName(cniFile).sendKeys(file_Upload_cni);
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
			 		phoneNumber.sendKeys(strmobilePhone);;
			 	}
			 	
		 	

		 	//
		 	
		 	public void sauvegarder(String strnomEntreprise,String strninea, String stradress, String file_Upload_tradeRegister,String file_Upload_header,
		 			String strprenom,String strnom, String stremail,String strmobilePhone,String file_Upload_cni)
		 	{
		 		
		 		//Infos  entreprise
		 		this.setnomEntreprise(strnomEntreprise);
		 		this.setrninea(strninea);
		 		this.setadresseEntreprise(stradress);
		 		this.setUpload_file(file_Upload_tradeRegister);
		 		this.setUploadFileEntete(file_Upload_header);
		 		//Infos Gestionnaire entreprise
		 		this.setprenom(strprenom);
		 		this.setnom(strnom);
		 		this.setemail(stremail);
		 		this.setmobilePhone(strmobilePhone);
		 		this.setUploadFileCni(file_Upload_cni);
		 		this.clickSauvegarder();
		 		
		 	}
		 	
		 	
		 	
		 	
}
