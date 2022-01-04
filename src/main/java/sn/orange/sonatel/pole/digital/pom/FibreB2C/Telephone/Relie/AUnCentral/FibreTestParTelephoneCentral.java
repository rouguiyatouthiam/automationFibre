package sn.orange.sonatel.pole.digital.pom.FibreB2C.Telephone.Relie.AUnCentral;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import sn.orange.sonatel.pole.digital.common.BrowserControl;

public class FibreTestParTelephoneCentral {
	
	BrowserControl bc;
	
	///Ces strings sont déclarés pour vérifier les asserts, ils recoivent les memes valeurs que celles qui se trouvent dans le findBy
	
	public String strBtnCparti="(.//*[normalize-space(text()) and normalize-space(.)='Dalal ak Diam !'])[1]/following::img[1]";
	
	public String strBtnOui="//*/text()[normalize-space(.)='Oui']/parent::*";
	
	public String strBtnGeoloc ="//div[@id='current-message']/div[2]/div/img";
	public String strBtnGPS ="//div[@id='current-message']/div[2]/div[2]/img";
	
	
	public String strBtnValider ="sub";
	
	
	
	@FindBy(xpath="(.//*[normalize-space(text()) and normalize-space(.)='Dalal ak Diam !'])[1]/following::img[1]")
	private WebElement btn_cparti;
	
	
	@FindBy(xpath="//*/text()[normalize-space(.)='Oui']/parent::*")
	private WebElement btn_oui;
	
	@FindBy(id="sub")
	private WebElement btn_valider;
	
	@FindBy(id="tchatFieldInput")
	private WebElement numero_telephone;
	

	@FindBy(xpath="//div[@id='fibre-offres']/div/div/div/div/div/div/div/div[2]/button")
	private WebElement btn_souscrire;
	
	
	public Boolean isBtnCestParti,isBtnOui,isBtnGeoloc,isBtnBtnGPS,isBtnValider;
	

		/**
		 * Constructeur: Initialisation des éléments
		 * @param driver
		 */
		public FibreTestParTelephoneCentral(BrowserControl bc)
		{
			this.bc = bc;
			PageFactory.initElements(bc.getDriver(), this);
		}
		
	
		
		/**
		 * Cette fonction retourne un boolean, 
		 * elle permet de vérifier si le tchat se poursuit avec l'affichage des boutons [c'est parti]  et [J'irai en agence]
		 * 
		 */
		
			public boolean IsBtnCestParti()
		    {
				   isBtnCestParti=false;
				   WebElement cestparti = bc.getElementByXPath(strBtnCparti);
					
					
					if(null != cestparti)
					{
						isBtnCestParti=true;
						
						System.out.println("le tchat se poursuit avec l'affichage des boutons [Oui, c'est parti !] et [J'irai en agence]");
					}
					else
					{
						System.out.println("le tchat ne se poursuit pas avec l'affichage des boutons [Oui, c'est parti !] et [J'irai en agence]");
					}
					
				
				return isBtnCestParti;
			}
	
			
			/**
			 * Cette fonction retourne un boolean,
			 * Elle permet de vérifier si le tchat se poursuit avec l'affichage des boutons [OUI] et [Non]
			 * 
			 */
			
				public boolean IsBtnOUI()
			    {
					    isBtnOui=false;
						WebElement oui = bc.getElementByXPath(strBtnOui);
						
						if(null != oui)
						{
							isBtnOui=true;
							System.out.println("le tchat se poursuit avec l'affichage des boutons [Oui] et [non]");
						}
						else
						{
							System.out.println("le tchat ne se poursuit pas non affichage des boutons [Oui] et [non]");
						}
						
					
					return isBtnOui;
				}
			
				
				/**
				 * Cette fonction retourne un boolean,
				 * elle permet de vérifier si le tchat se poursuit avec l'affichage de la zone de saisie du numéro de téléphone et le bouton valider
				 * 
				 */
				
					public boolean IsBtnValider()
				    {
						    isBtnValider=false;
							WebElement validerNumeTel = bc.getElementByXPath(strBtnOui);
							
							if(null != validerNumeTel)
							{
								isBtnValider=true;
								System.out.println("le tchat se poursuit avec l'affichage dela zone de saisie du numTel et le bouton valider");
							}
							else
							{
								System.out.println("le tchat ne se poursuit pas non affichage du bouton valider");
							}
							
						
						return isBtnValider;
					}
				
				
				
				/**
				 * Cette fonction retourne un boolean,
				 * elle permet de vérifier si le tchat se poursuit avec l'affichage des  autres type de tests
				 * 
				 */
				
					public boolean IsBtnGeoloc()
				    {
						isBtnGeoloc=false;
						WebElement geoloc = bc.getElementByXPath(strBtnGeoloc);
							
							if(null != geoloc)
							{
								isBtnGeoloc=true;
								System.out.println("Affichage Btn Géoloc");
							}
							else
							{
								System.out.println("Non Affichage Btn Géoloc");
							}
							
						
						return isBtnGeoloc;
					}
					
					
					/**
					 * Cette fonction retourne un boolean,
					 * elle permet de vérifier si le tchat se poursuit avec l'affichage des  autres type de tests
					 * 
					 */
					
						public boolean IsBtnGPS()
					    {
							isBtnBtnGPS=false;
							WebElement geoloc = bc.getElementByXPath(strBtnGPS);
								
								if(null != geoloc)
								{
									isBtnBtnGPS=true;
									System.out.println("Affichage Btn GPS");
								}
								else
								{
									System.out.println("Non Affichage Btn GPS");
								}
								
							
							return isBtnBtnGPS;
						}
	
		/**
		 * Cette fonction permet de saisir le numero de telephone
		 * @param strnumTel
		 */
	 	public void setNumeroTelephone(String strnumTel){
	 		
	 		numero_telephone.click();
	 		numero_telephone.sendKeys(strnumTel);
	 	}
		
	 	/**Cette fonction permet de cliquer sur le bouton c'est parti
		 * 
		 */
	 	public void clickCParti(){
	 		btn_cparti.click();
	 	}
	 	
	 	/**Cette fonction permet de cliquer sur le bouton oui pour effectuer un test par numero de telephone
		 * 
		 */
	 	public void clickOui(){
	 		btn_oui.click();
	 	}
		
	 	/**Cette fonction permet de cliquer sur le bouton c'est valider
		 * 
		 */
	 	public void clickValider(){
	 		btn_valider.click();
	 	}
	 	
	 	
	 	/**Cette fonction appelle la fonction clickCParti
		 * 
		 */
	 	public void cestParti() {
	 		this.clickCParti();
	 		
	 	}
	 	
	 	/**Cette fonction appelle la fonction clickOui
		 * 
		 */
	 	public void oui() {
	 		this.clickOui();
	 		
	 	}
	 	
	 	
	 	
	 	/**Cette fonction permet de renseigner le numero de téléphone et de valider la saisie
		 * 
		 */	
         public void saisirTelephone(String strtelephone) {
	 		
	 		
	 		this.setNumeroTelephone(strtelephone);
	 		this.clickValider();
	 		bc.waitSomeTime(2000);
	 	}

}
