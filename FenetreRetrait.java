import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.util.LinkedList;

public class FenetreRetrait extends JFrame{
	
	private JPanel cadre;
	private JButton btRetire;
	private JButton btAnnule;
	private ListeObjet listeDesParticules;
	private JComboBox listeBoutons;
	/*private LinkedList<JCheckBox> listeBoutons = new LinkedList<JCheckBox>();
	 * */
	
	
	public FenetreRetrait(ListeObjet listeDesParticules){
		super("Retirer une particule");
		this.listeDesParticules = listeDesParticules;
		LinkedList<Particule> listePart = listeDesParticules.getListeParticule();
		
		
		//Instanciation des boutons
		btRetire = new JButton("Retirer");
		btAnnule = new JButton("Annuler");
		
		
		//Ajout des écouteurs
		//btRetire.addActionListener(new EcouteurRetire(this));
		btAnnule.addActionListener(new EcouteurAnnule(this));
		
		
		//Mise à jour de ListeObjet ???
		
		
		
		//Création des JCheckBox
		
		//V : Déclare une LinkedList de Checkbox. NOTE : bien sûr, il faut le mettre en haut de classe, tout joli et tout, mais c'est surtout pour te montrer.
		LinkedList<JCheckBox> listeCheckbox = new LinkedList<JCheckBox>();

		//V : Déclare un JPnael pour stocker les CheckBox
		JPanel conteneurCheckBox = new JPanel();
		//On lui attribue le nom de ligne qu'il faut (le nombre de particules) et 2 colonnes
		conteneurCheckBox.setLayout(new GridLayout(listePart.size(),2,5,5));
		
		//V : rempli ta liste de JckeckBox
		for (int i=0; i<listePart.size(); i++){
			listeCheckbox.add(new JCheckBox()); // On créer Une check box qu'on ajoute dans la liste des checkbox 
			conteneurCheckBox.add(listeCheckbox.get(i)); //On ajoute la checkbox dans la première colonne
			conteneurCheckBox.add(new JLabel(listePart.get(i).toString())); //On ajoute le nom de la particule (au même indice i) dans la deuxième colonne.
		}
		
		//V : Le code pour vérifier si les checkbox sont cochées ou pas
		for (int i=0; i<listePart.size(); i++){
			if(listeCheckbox.get(i).isSelected()){
				// Particule "listePart.get(i)" à supprimer
			}
		}
		
		//ANCIEN 
		/*
		for (int i=0; i<listePart.size(); i++){
			listeBoutons.add(new JCheckBox(listePart.get(i).getType()));
		}
		*/
		
		//NOTE : 
		/*
		JCheckBox maCheck = new JCheckBox(); // pour créer une Checkbox
		maCheck.isSelected(); // Pour avoir le boolean de la Checkbox 
		 */
		
		
		//Mise à jour des panneaux
		JPanel barreOutils = new JPanel();
		barreOutils.add(btRetire);
		barreOutils.add(btAnnule);
		
		//JPanel particules = new JPanel(); //inutile de créer un cadre pour JCheckBox ?
		//particules.add(listeBoutons);
		
		cadre = new JPanel(new BorderLayout());
		cadre.add(barreOutils, BorderLayout.SOUTH);
		//cadre.add(particules, BorderLayout.CENTER);
		
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setContentPane(cadre);
		setSize(600,400);
		setVisible(true);
	}
	
	//obtenir la liste des particules de FenetreRetrait
	public ListeObjet getListeDesParticules(){
		return listeDesParticules;
	}
	
	public LinkedList<Particule> getListePart(){
		return listeDesParticules.getListeParticule();
	}
	
	/* TU RENVOIS UNE LINKEDLIST ALOR SQUE C'EST UNE JCOMBO BOX ! 
	public LinkedList<JCheckBox> getListeBoutons(){
		return listeBoutons;
	}
	*/
}
