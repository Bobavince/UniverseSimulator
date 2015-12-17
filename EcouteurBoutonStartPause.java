import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import javax.swing.Timer;
import javax.swing.JToggleButton;


public class EcouteurBoutonStartPause implements ActionListener {
	private Affichage fenetreAffichage;
	Timer timer;
	
	public EcouteurBoutonStartPause(Affichage fenetreAffichage){
		this.fenetreAffichage = fenetreAffichage;
		this.timer = new Timer(10, new EcouteurBoutonNext(fenetreAffichage));
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		JToggleButton boutonStartStop = (JToggleButton)arg0.getSource();
        if (boutonStartStop.isSelected()) {
        	timer.start();
        	
        	//DEBUG // 
			if(Affichage.debug){System.out.println("ECOUTEUR STARTSTOP : bouton SELECTIONE");}
			//DEBUG - Pour savoir si la rayon été changée effectivement. //
			
        } else {
        	timer.stop();
        	//DEBUG // 
			if(Affichage.debug){System.out.println("ECOUTEUR STARTSTOP : bouton NON SELECTIONE");}
			//DEBUG - Pour savoir si la rayon été changée effectivement. //
			
        }
	}
	
}
