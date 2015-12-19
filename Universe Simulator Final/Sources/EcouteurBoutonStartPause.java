import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JToggleButton;
import javax.swing.Timer;

/**Classe Ecouteur du champ masse de la fenêtre Affichage
 */
public class EcouteurBoutonStartPause implements ActionListener {
	private Affichage fenetreAffichage;
	Timer timer;
	
	/** Constructeur de l'écouteur du bouton Start/stop
	 * @param fenetreAffichage : la fenêtre Affichage parente qui contient le bouton Start/stop
	 */
	public EcouteurBoutonStartPause(Affichage fenetreAffichage){
		this.fenetreAffichage = fenetreAffichage;
		this.timer = new Timer(10, new EcouteurBoutonNext(fenetreAffichage));
	}

	/* Méthode de standard de traitement d'actions.
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		JToggleButton boutonStartStop = (JToggleButton)arg0.getSource();
        if (boutonStartStop.isSelected()) {
        	timer.start();
        	fenetreAffichage.getBoutonStartPause().setText("PAUSE");
        	//DEBUG // 
			if(Affichage.debug){System.out.println("ECOUTEUR STARTSTOP : bouton SELECTIONE");}
			//DEBUG - Pour savoir si la rayon été changée effectivement. //
			
        } else {
        	timer.stop();
        	fenetreAffichage.getBoutonStartPause().setText("START");
        	//DEBUG // 
			if(Affichage.debug){System.out.println("ECOUTEUR STARTSTOP : bouton NON SELECTIONE");}
			//DEBUG - Pour savoir si la rayon été changée effectivement. //
			
        }
	}
	
}
