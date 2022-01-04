package sn.orange.sonatel.pole.digital.pom.FibreB2B.Telephone.Eligible;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import sn.orange.sonatel.pole.digital.common.BrowserControl;

public class FibreSouscrireTestTelephoneB2BEligible {
	
	BrowserControl bc;

	///Ces strings sont déclarés pour vérifier les asserts, ils recoivent les memes valeurs que celles qui se trouvent dans le findBy
	
	public String strpopup="name";
	
	///Boutons à cliquer
	
	@FindBy(xpath="(//button[@type='button'])[5]")
	private WebElement btn_souscrire_FOItense;
	
	@FindBy(xpath="(//button[@type='button'])[6]")
	private WebElement btn_souscrire_FOffice;
	
	@FindBy(xpath="(//button[@type='button'])[7]")
	private WebElement btn_souscrire_FPro;
	
	@FindBy(xpath="//div[@id='steps-desk']/div/div/div/div/span")
	private WebElement btn_retour_Etape1;
	
	@FindBy(xpath="//div[@id='fibre-offres']/div/div[2]/button[2]/img")
	private WebElement fleche_navigation;
	
	@FindBy(linkText="Terminer")
	private WebElement btn_terminer;
	
	
	public Boolean isPopup,isConfirmation;
	
	
	

			/**
			 * Constructeur: Initialisation des éléments
			 * @param driver
			 */
				public FibreSouscrireTestTelephoneB2BEligible(BrowserControl bc)
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
			 * Cette fonction permet de cliquer sur le bouton je veux souscrire 
			 * 
			 **/
			 	  public void clickSouscrireOItense()
			 	  {
			 		btn_souscrire_FOItense.click();
			 	  }
			
		 	
		 	/**
			 * Cette fonction appelle la fonction clickSouscrire
			 */
			 	public void souscrireOItense() 
			 	{
			 		this.clickSouscrireOItense();
			 		
			    }
			 	
			 	
			 	////////
			 	 /**
				 * Cette fonction permet de cliquer sur le bouton je veux souscrire 
				 * 
				 **/
				 	  public void clickSouscrireFOffice()
				 	  {
				 		btn_souscrire_FOffice.click();
				 	  }
				
			 	
			 	/**
				 * Cette fonction appelle la fonction clickSouscrire
				 */
				 	public void souscrireFOffice() 
				 	{
				 		this.clickSouscrireFOffice();
				 		
				    }
				 	
				 	
				//////
				 	
				 	 /**
					 * Cette fonction permet de cliquer sur le bouton je veux souscrire 
					 * 
					 **/
					 	  public void clickSouscrireFPro()
					 	  {
					 		btn_souscrire_FPro.click();
					 	  }
					
				 	
				 	/**
					 * Cette fonction appelle la fonction clickSouscrire
					 */
					 	public void souscrireFPro() 
					 	{
					 		this.clickSouscrireFPro();
					 		
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
							 * Cette fonction permet de cliquer sur le bouton "Terminer"
							 * 
							 **/
							 	  public void clickTerminer()
							 	  {
							 		 fleche_navigation.click();
							 		fleche_navigation.click();
							 		 btn_terminer.click();
							 	  }
							
						 	
						 	/**
							 * Cette fonction appelle la fonction clickSouscrire
							 */
							 	public void terminer() 
							 	{
							 		this.clickTerminer();
							 		
							    }
		 	
		 	
		 	
}
