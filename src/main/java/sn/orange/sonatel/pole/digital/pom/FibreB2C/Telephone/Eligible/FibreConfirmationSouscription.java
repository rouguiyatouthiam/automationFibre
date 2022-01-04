package sn.orange.sonatel.pole.digital.pom.FibreB2C.Telephone.Eligible;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import sn.orange.sonatel.pole.digital.common.BrowserControl;

public class FibreConfirmationSouscription {
	
	BrowserControl bc;

	
	private String btn_Terminer="Retour";
	
	public Boolean btnTerminer;
	

			/**
			 * Constructeur: Initialisation des éléments
			 * @param driver
			 */
			public FibreConfirmationSouscription(BrowserControl bc)
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
		 	
		 	
}
