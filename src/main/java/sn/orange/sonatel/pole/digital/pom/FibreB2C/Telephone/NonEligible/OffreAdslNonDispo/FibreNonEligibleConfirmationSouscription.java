package sn.orange.sonatel.pole.digital.pom.FibreB2C.Telephone.NonEligible.OffreAdslNonDispo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import sn.orange.sonatel.pole.digital.common.BrowserControl;

public class FibreNonEligibleConfirmationSouscription {
	
	BrowserControl bc;

	
	private String btn_Terminer="Retour";
	
	public Boolean btnTerminer;
	
	@FindBy(linkText="Retour")
	private WebElement btnRetour;
	

			/**
			 * Constructeur: Initialisation des éléments
			 * @param driver
			 */
			public FibreNonEligibleConfirmationSouscription(BrowserControl bc)
			{
				this.bc = bc;
				PageFactory.initElements(bc.getDriver(), this);
			}
		
	
		
			
			
			/**
			 * Cette fonction retourne un boolean
			 * elle permet de vérifier si on est à l'étape validation
			 * 
			 */
		
			public boolean IsBtnTerminer()
		    {
					btnTerminer=false;
					WebElement terminer = bc.getElementByLink(btn_Terminer);
					
					if(null != terminer)
					{
						btnTerminer= true;
						System.out.println("page de confirmation souscription");
					}
					else
					{
						System.out.println("Non confirmation souscription");
					}
					
				
				return btnTerminer;
			}
			
			
			 /**
			 * Cette fonction permet de cliquer sur le bouton je veux souscrire 
			 * 
			 **/
			 	  public void clickTerminert()
			 	  {
			 		 btnRetour.click();
			 	  }
			
		 	
		 	/**
			 * Cette fonction appelle la fonction clickSouscrire
			 */
			 	public void terminer() 
			 	{
			 		this.clickTerminert();
			 		
			    }
		 	
		 	
}
