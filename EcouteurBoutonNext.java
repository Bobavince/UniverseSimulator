import java.awt.event.*;
import javax.swing.*;

public class EcouteurBoutonNext implements ActionListener {
	private Affichage fenetreParente;
	
	public EcouteurBoutonNext(Affichage fenetreParente){
		this.fenetreParente = fenetreParente;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		//On compute toutes les interactions en appellant le moteur et en lui envoyant la liste des objets (la classe qui gère tout ça)
		fenetreParente.getMoteur().miseAJourParticules(fenetreParente.getListeObjets());
		
		//On fait passer toutes les particules à leur état futur grâce à ListeObjet
		fenetreParente.getListeObjets().mettreAJourEtat();
		
		//On repaint la fenêtre puisque la position des objets a changé.
		fenetreParente.getZoneDessin().repaint();
	}

}