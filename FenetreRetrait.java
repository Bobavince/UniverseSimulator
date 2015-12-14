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
	
	
	
	public FenetreRetrait(ListeObjet listeDesParticules){
		super("Retirer une particule");
		this.listeDesParticules = listeDesParticules;
		LinkedList<Particule> listePart = listeDesParticules.getListeParticule();
		
		
		//Instanciation des boutons
		btRetire = new JButton("Retirer");
		btAnnule = new JButton("Annuler");
		
		
		//Création du conteneur de la liste de particules (JCheckBox)
		JPanel liste = new JPanel();
		liste.setLayout(new GridLayout(listePart.size(),2,5,5));
		//Remplissage de la liste
		for (int i=0; i<listePart.size(); i++){
			listeBoutons.add(new JCheckBox(listePart.get(i).toString())); //Création d'un JCheckBox qu'on ajoute dans la liste des JCheckBox 
			liste.add(listeBoutons.get(i)); //Ajout d'un JCheckBox dans la première colonne
			//liste.add(new JLabel(listePart.get(i).toString())); //Ajout du nom de la particule (au même indice i) dans la deuxième colonne
		}
		
		
		//Ajout des écouteurs
		btRetire.addActionListener(new EcouteurFenetreRetraitRetirer(this));
		btAnnule.addActionListener(new EcouteurFenetreRetraitAnnule(this));
		
		
		//Création du conteneur de boutons
		JPanel barreOutils = new JPanel();
		barreOutils.add(btRetire);
		barreOutils.add(btAnnule);
		
		
		//Création du cadre principal
		cadre = new JPanel(new BorderLayout());
		cadre.add(barreOutils, BorderLayout.SOUTH);
		cadre.add(liste, BorderLayout.CENTER);
		
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setContentPane(cadre);
		setSize(600,400);
		setVisible(true);
	}
	
	
	
	
	
	//Obtention de la liste des particules de FenetreRetrait
	public LinkedList<Particule> getListePart(){
		return listeDesParticules.getListeParticule();
	}
	
	//Obtention de la liste de JCheckBox
	public LinkedList<JCheckBox> getListeBoutons(){
		return listeBoutons;
	}
	
}
