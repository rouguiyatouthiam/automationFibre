package sn.orange.sonatel.pole.digital.pom.FibreB2B.GPS;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import sn.orange.sonatel.pole.digital.common.BrowserControl;

public class FibreTestParGPS {
	
	BrowserControl bc;
	 private WebDriver driver;
	
	///Ces strings sont déclarés pour vérifier les asserts, ils recoivent les memes valeurs que celles qui se trouvent dans le findBy
	
	public String strBtnCparti="(.//*[normalize-space(text()) and normalize-space(.)='Dalal ak Diam !'])[1]/following::img[1]";
	
	public String strBtnNon="(.//*[normalize-space(text()) and normalize-space(.)='Oui'])[1]/following::div[1]";
	
	public String strBtnMonLieuDeTravail="(.//*[normalize-space(text()) and normalize-space(.)='Mon domicile'])[1]/following::div[1]";
	
	public String strBtnTestGPS="//div[@id='current-message']/div[2]/div[2]/img";
	
	public String strMap="input-search-addresses";
	
	public String strBtnValiderPosition="validate-postiion";
	
	public String strBtnSouscrire ="//div[@id='fibre-offres']/div/div/div/div/div/div/div/div[2]/button";
	
	
	
	
	@FindBy(xpath="(.//*[normalize-space(text()) and normalize-space(.)='Dalal ak Diam !'])[1]/following::img[1]")
	private WebElement btn_cparti;
	
	@FindBy(xpath="(.//*[normalize-space(text()) and normalize-space(.)='Oui'])[1]/following::div[1]")
	private WebElement btn_Non;
	
	
	@FindBy(xpath="(.//*[normalize-space(text()) and normalize-space(.)='Mon domicile'])[1]/following::div[1]")
	private WebElement btn_monLieuDeTravail;
	
	
	@FindBy(xpath="//div[@id='current-message']/div[2]/div[2]/img")
	private WebElement btn_testGPS;
	
	@FindBy(id="input-search-addresses")
	private WebElement adresse;
	
	
	@FindBy(xpath="//*/text()[normalize-space(.)='Plateau, Dakar, Sénégal']/parent::*")
	private WebElement btn_rechercherQuartier;
	
	
	@FindBy(id="validate-postiion")
	private WebElement btn_validerPosition;
	
	
	@FindBy(xpath="//div[@id='fibre-offres']/div/div/div/div/div/div/div/div[2]/button")
	private WebElement btn_souscrire;
	
	public Boolean isBtnCestParti,isBtnNon,isBtnMonLieuDeTravail,isBtnTestGPS,isAffichageMap,isBtnValiderPosition,isBtnSouscrire;
	

		/**
		 * Constructeur: Initialisation des éléments
		 * @param driver
		 */
		public FibreTestParGPS(BrowserControl bc)
		{
			this.bc = bc;
			PageFactory.initElements(bc.getDriver(), this);
		}
		
	
		
		/**
		 * Cette fonction retourne un boolean, 
		 * elle permet de vérifier si le tchat se poursuit avec l'affichage des boutons [c'est parti]  et [J'irai en agence]
		 * 
		 */
		
			public boolean IsCestParti()
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
			 * elle permet de vérifier si le tchat se poursuit avec l'affichage des boutons [OUI]  et [NON]
			 * 
			 */
			
				public boolean IsNon()
			    {
					isBtnNon=false;
					   WebElement non = bc.getElementByXPath(strBtnNon);
						
						
						if(null != non)
						{
							isBtnNon=true;
							
							System.out.println("le tchat se poursuit avec l'affichage des boutons [Oui] et [Non]");
						}
						else
						{
							System.out.println("le tchat ne se poursuit pas avec l'affichage des boutons [Oui] et [Non]");
						}
						
					
					return isBtnNon;
				}
		
			
				
				
				/**
				 * Cette fonction retourne un boolean, 
				 * elle permet de vérifier si le tchat se poursuit avec l'affichage des boutons [Mon domicile]  et [Mon lieu de travail]
				 * 
				 */
				
					public boolean IsMonLieuDeTravail()
				    {
						isBtnMonLieuDeTravail=false;
						   WebElement lieuTravail = bc.getElementByXPath(strBtnMonLieuDeTravail);
							
							
							if(null != lieuTravail)
							{
								isBtnMonLieuDeTravail=true;
								
								System.out.println("le tchat se poursuit avec l'affichage des boutons [Mon domicile]  et [Mon lieu de travail]");
							}
							else
							{
								System.out.println("le tchat ne se poursuit pas avec l'affichage des boutons [Mon domicile]  et [Mon lieu de travail]");
							}
							
						
						return isBtnMonLieuDeTravail;
					}
					
			
				
					/**
					 * Cette fonction retourne un boolean, 
					 * elle permet de vérifier si le tchat se poursuit avec l'affichage des boutons [Activer la geolocalisation]  et [Non, je suis à un autre endroit]
					 * 
					 */
					
						public boolean IsTestGPS()
					    {
							isBtnTestGPS=false;
							   WebElement gps = bc.getElementByXPath(strBtnTestGPS);
								
								
								if(null != gps)
								{
									isBtnTestGPS=true;
									
									System.out.println("le tchat se poursuit avec l'affichage des boutons [Activer la geolocalisation]  et [Non, je suis à un autre endroit]");
								}
								else
								{
									System.out.println("le tchat ne se poursuit pas avec l'affichage des boutons [Activer la geolocalisation]  et [Non, je suis à un autre endroit]");
								}
								
							
							return isBtnTestGPS;
						}
						
					/**
						 * Cette fonction retourne un boolean, 
						 * elle permet de vérifier si la map est affichée
						 * 
					 */
						
							public boolean IsMap()
						    {
								isAffichageMap=false;
								   WebElement gps = bc.getElementByID(strMap);
									
									
									if(null != gps)
									{
										isAffichageMap=true;
										
										System.out.println("la carte map est affichée");
									}
									else
									{
										System.out.println("la carte map n'est pas affichée");
									}
									
								
								return isAffichageMap;
							}
			
							
							/**
							 * Cette fonction retourne un boolean, 
							 * elle permet de vérifier si le bouton valider ma position est affichée
							 * 
							 */
							
								public boolean IsValiderPosition()
							    {
									isBtnValiderPosition=false;
									   WebElement Validerposition = bc.getElementByID(strBtnValiderPosition);
										
										
										if(null != Validerposition)
										{
											isBtnValiderPosition=true;
											
											System.out.println("le btn valider position est affiché");
										}
										else
										{
											System.out.println("le btn valider position n'est pas affichée");
										}
										
									
									return isBtnValiderPosition;
								}
								
								
								/**
								 * Cette fonction retourne un boolean,
								 * elle permet de vérifier si le tchat se poursuit avec l'affichage du resultat du test et des offres
								 * 
								 */
								
									public boolean IsOffre()
								    {
										isBtnSouscrire=false;
										WebElement offre = bc.getElementByXPath(strBtnSouscrire);
											
											if(null != offre)
											{
												isBtnSouscrire=true;
												System.out.println("le tchat se poursuit avec l'affichage des offres");
											}
											else
											{
												System.out.println("le tchat ne se poursuit pas  avec l'affichage des offres");
											}
											
										
										return isBtnSouscrire;
									}
	 	/**Cette fonction permet de cliquer sur le bouton c'est parti
		 * 
		 */
	 	public void clickCParti(){
	 		btn_cparti.click();
	 	}
	 	
	 	/**Cette fonction permet de cliquer sur le bouton Non
		 * 
		 */
	 	public void clickNon(){
	 		btn_Non.click();
	 	}
	 	
	 	/**Cette fonction permet de cliquer sur le bouton Je suis à mon lieu travail
		 * 
		 */
	 	public void clickMonLieuDeTravail(){
	 		btn_monLieuDeTravail.click();
	 	}
	 	
	 	/**Cette fonction permet de cliquer sur le bouton Non, je suis à un autre endroit
		 * 
		 */
	 	public void clickTestGPS(){
	 		btn_testGPS.click();
	 	}
	 	
	 	
	 	/**
		 * Cette fonction permet de saisir le quartier
		 * @param strquartier
		 */
		 	public void setadresse(String strquartier){
		 		adresse.click();
		 		bc.waitSomeTime(1000);
		 		adresse.sendKeys(strquartier);
		 		bc.waitSomeTime(2000);
		 		btn_rechercherQuartier.click();
		 		bc.waitSomeTime(2000);
		 		//Ces commandes javascripts permettent de déplacer le curseur 
		 		((JavascriptExecutor) bc.getDriver()).executeScript("myMarker.setPosition({lat:14.662404069714459, lng:-17.43748030000006, map:myMap})");
		 		bc.waitSomeTime(1000);
		 	   ((JavascriptExecutor) bc.getDriver()).executeScript("document.elementFromPoint(document.getElementById('map').offsetWidth,400).click()");
		 	   bc.waitSomeTime(1000);
		 		
		 	}
		 	
		 	
		 	
		 	/**Cette fonction permet de cliquer sur le bouton valider ma recherche
			 * 
			 */
		 	public void clickValiderPosition(){
		 		btn_validerPosition.click();
		 	}
		 	
		 	public void saisirAdresse(String stradress)
		 	{
		 		this.setadresse(stradress);
		 	}
}
