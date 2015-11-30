import java.awt.*;
import java.util.*;

import javax.swing.*;

import java.util.LinkedList;

public class FenetreRetrait extends JFrame{
	
	private JPanel cadrePrincipal;
	private JButton btRetire;
	private JButton btAnnule;
	private LinkedList<JCheckBox> listeBoutons = new LinkedList<JCheckBox>();
	private LinkedList<Particule> listePart;
	
	public FenetreRetrait(ListeObjet listeDesParticules){
		super("Retirer une particule");
		listePart = listeDesParticules.getListeParticule();
		
		
		//Instanciation des boutons
		btRetire = new JButton("Retirer");
		btAnnule = new JButton("Annuler");
		
		
		//Ajout des écouteurs
		btRetire.addActionListener(new EcouteurRetire(this));
		btAnnule.addActionListener(new EcouteurAnnule(this)); //ERREUR ICI 
		
		
		//Mise à jour de ListeObjet ???
		
		
		
		
		//Création des JCheckBox
		for (int i=0; i<listePart.size(); i++){
//			listeBoutons.add(new JCheckBox(listePart[i].getType())); //ERREUR ICI 
		}
		
		
		//Mise à jour des panneaux
		JPanel barreOutils = new JPanel();
		barreOutils.add(btRetire);
		barreOutils.add(btAnnule);
		
		JPanel particules = new JPanel();
//		particules.add(listeBoutons); //ERREUR ICI (add)
		
		cadrePrincipal = new JPanel(new BorderLayout());
		cadrePrincipal.add(barreOutils, BorderLayout.SOUTH);
		cadrePrincipal.add(particules, BorderLayout.CENTER);
		
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
//		setContentPane(cadre); //ERREUR ICI CADRE NON DEFINI
		setSize(600,400);
		setVisible(true);
	}
	
	public LinkedList<JCheckBox> getListeBoutons(){
		return listeBoutons;
	}
	
}
