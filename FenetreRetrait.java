import java.awt.*;
import java.util.*;

import javax.swing.*;

import java.util.LinkedList;

public class FenetreRetrait extends JFrame{

	private JPanel cadre;
	private JButton btRetire;
	private JButton btAnnule;
	private ListeObjet listeDesParticules;
	private LinkedList<JCheckBox> listeBoutons = new LinkedList<JCheckBox>();
	private Affichage fenetreAffichage ;

	public FenetreRetrait(ListeObjet listeDesParticules, Affichage fenetreAffichage){
		super("Retirer une particule");
		
		//Instanciations
		this.fenetreAffichage = fenetreAffichage;
		this.listeDesParticules = listeDesParticules;
		LinkedList<Particule> listePart = listeDesParticules.getListeParticule();

		//Instanciation des boutons
		btRetire = new JButton("Retirer");
		btAnnule = new JButton("Annuler");
		int hauteurFenetre = 400;

		//Création du conteneur de la liste de particules (JCheckBox)
		JPanel liste = new JPanel();
		
		if(listePart.size()==0){
			// On créé un JLabel d'avertissement
			JLabel avertissement = new JLabel(" ---=== [ PAS DE PARTICULES ! ] ===--- ");
			// On définit la hauteur 
			hauteurFenetre = 200;
			// On range l'avertissement dans la Layout
			liste.setLayout(new BorderLayout());
			liste.add(avertissement,BorderLayout.CENTER);
			// On centre l'avertissement
			avertissement.setHorizontalAlignment(JLabel.CENTER);
			avertissement.setVerticalAlignment(JLabel.CENTER);
			
		} else {
			
			liste.setLayout(new GridLayout(listePart.size(),2,5,5));
			
			//Remplissage de la liste
			for (int i=0; i<listePart.size(); i++){
				listeBoutons.add(new JCheckBox(listePart.get(i).toString())); //Création d'un JCheckBox qu'on ajoute dans la liste des JCheckBox 
				liste.add(listeBoutons.get(i)); //Ajout d'un JCheckBox dans la première colonne
				//liste.add(new JLabel(listePart.get(i).toString())); //Ajout du nom de la particule (au même indice i) dans la deuxième colonne
				listeBoutons.get(i).setHorizontalAlignment(JLabel.CENTER);
				listeBoutons.get(i).setVerticalAlignment(JLabel.CENTER);
			}
			//On calcul la hauteur de fenêtre pour un affichage correct.
			hauteurFenetre = 100+listePart.size()*20;
		}

		//Ajout des écouteurs
		btRetire.addActionListener(new EcouteurFenetreRetraitRetirer(this, fenetreAffichage));
		btAnnule.addActionListener(new EcouteurFenetreRetraitAnnule(this));

		//Création du conteneur de boutons
		JPanel barreOutils = new JPanel();
		if(listePart.size()!=0){
			barreOutils.add(btRetire);
		}
		barreOutils.add(btAnnule);
		
		//Création du cadre principal
		cadre = new JPanel(new BorderLayout());
		cadre.add(liste, BorderLayout.CENTER);
		cadre.add(barreOutils, BorderLayout.SOUTH);
		
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setContentPane(cadre);
		setSize(600,hauteurFenetre);
		setLocationRelativeTo(null);
		//On pose des dimension maximales pour éviter des redimensionnements
		this.setMaximumSize(new Dimension (600,hauteurFenetre));
		this.setMinimumSize(new Dimension (600,hauteurFenetre));
		setVisible(true);
	}


	//Obtention de la liste des particules de FenetreRetrait
	public LinkedList<Particule> getListeParticules(){
		return listeDesParticules.getListeParticule();
	}

	//Obtention de la liste de JCheckBox
	public LinkedList<JCheckBox> getListeJCheckBox(){
		return listeBoutons;
	}

}
