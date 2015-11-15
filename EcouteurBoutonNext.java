import java.awt.event.*;
import javax.swing.*;

public class EcouteurBoutonNext implements ActionListener {
	private Affichage fenetreParente;
	
	public EcouteurBoutonNext(Affichage fenetreParente){
		this.fenetreParente = fenetreParente;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		//On compute toutes les interactions en appellant le moteur et en lui envoyant la liste des objets (la classe qui g�re tout �a)
		fenetreParente.getMoteur().miseAJourParticules(fenetreParente.getListeObjets());
		
		//On fait passer toutes les particules � leur �tat futur gr�ce � ListeObjet
		fenetreParente.getListeObjets().mettreAJourEtat();
		
		//On repaint la fen�tre puisque la position des objets a chang�.
		fenetreParente.getZoneDessin().repaint();
	}

}