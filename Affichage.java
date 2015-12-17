import java.awt.*;
import java.util.*;

import javax.swing.*;

public class Affichage extends JFrame {

	//---- ELEMENTS NON GRAPHIQUES ----
	ListeObjet listeDesParticules = new ListeObjet();
	Moteur moteurPhysique = new Moteur(-10); //1 est le Coef de gravit�

	//---- ELEMENTS NECESSAIRES ----
	// AJOUT/RETIRER BOUTONS
	private JButton boutonAjout = new JButton("Ajouter Particule");
	private JButton boutonRetirer = new JButton("Retirer Particule");
	// LISTE PARTICULE ELEMENTS
	private JLabel labelListe = new JLabel("Liste particules");
	private JComboBox<Particule> listeObjets = new JComboBox<Particule>();
	// COORDONNES ELEMENTS
	private JLabel labelCoord = new JLabel("Coordonnées");
	private JLabel labelX = new JLabel(" x ");
	private JLabel labelY = new JLabel(" y ");
	private JSpinner coordX = new JSpinner();
	private JSpinner coordY = new JSpinner();
	// VITESSES ELEMENTS
	private JLabel labelVitesse = new JLabel("Vitesse");
	private JLabel labelVx = new JLabel(" Vx ");
	private JLabel labelVy = new JLabel(" Vy ");
	private JSpinner vitesX = new JSpinner();
	private JSpinner vitesY = new JSpinner();
	//ACCELERATION ELEMENT
	private JLabel labelAcceleration = new JLabel("Acceleration");
	private JLabel labelAx = new JLabel(" Ax ");
	private JLabel labelAy = new JLabel(" Ay ");
	private JSpinner accelX = new JSpinner();
	private JSpinner accelY = new JSpinner();
	//MASSE COULEUR RAYON
	private JLabel labelMasse = new JLabel(" Masse ");
	private JLabel labelCouleur = new JLabel(" Couleur ");
	private JLabel labelRayon = new JLabel(" Rayon ");
	private JSpinner spinnerMasse = new JSpinner();
	private JSpinner spinnerRayon = new JSpinner();
	private JButton boutonCouleur = new  JButton("Modifier couleur");

	// NEXT BOUTON
	private JButton boutonNext = new JButton("t -> t+1");
	private JToggleButton  boutonStartPause = new JToggleButton ("START");
	private JToggleButton boutonAutoScale = new JToggleButton("AUTOSCALE");

	//---- ELEMENTS EVOLUES ----
	private JLabel labelConsole = new JLabel("Console");
	private JTextArea areaConsole = new JTextArea();

	private JLabel labelCstGravitation = new JLabel("Constante Gravitation");
	private JSpinner cstGravitation = new JSpinner();

	private JLabel labelVitesseSimulation = new JLabel("Vitesse simulation");
	private JSpinner vitesseSimulation = new JSpinner();

	//TOUS LE JPANEL
	JPanel conteneurPrincipal;
	PanelDessin conteneurNordPrincipal;
	JPanel conteneurSudPrincipal;
	JPanel conteneurSudOuest;
	JPanel conteneurSudEst;

	//DEBUG
	static boolean debug = true;

	public Affichage() {
		setSize(new Dimension((int)(java.awt.Toolkit.getDefaultToolkit().getScreenSize().getWidth()*0.8), (int)(java.awt.Toolkit.getDefaultToolkit().getScreenSize().getHeight()*0.8))); //Dimension initiales
		setMinimumSize(new Dimension(1000, 600)); // dimensions minimales pour affichage correct/!\ 
		this.setPreferredSize(new Dimension((int)(java.awt.Toolkit.getDefaultToolkit().getScreenSize().getWidth()*0.8), (int)(java.awt.Toolkit.getDefaultToolkit().getScreenSize().getHeight()*0.8)));

		// ---- ELEMENTS GENERAUX ----
		//CONTENEUR PRINCIPAL DE LA FENETRE 
		conteneurPrincipal = new JPanel();

		//DEUX PRINCIPAUX CONTENEURS
		conteneurNordPrincipal = new PanelDessin(this);
		conteneurSudPrincipal = new JPanel();

		//DEUX PETITS CONTENEURS
		conteneurSudOuest = new JPanel();
		conteneurSudEst = new JPanel();

		//STRUCTURE PRINCIPALE AVEC 2 STRUCTURES SECONDAIRES
		conteneurPrincipal.setLayout(new BorderLayout());
		conteneurPrincipal.add(conteneurNordPrincipal, BorderLayout.CENTER);
		conteneurPrincipal.add(conteneurSudPrincipal, BorderLayout.SOUTH);

		//STRUCTURE SECONDAIRE SUD AVEC 2 STRUCTURES TERTIAIRES
		conteneurSudPrincipal.setLayout(new GridLayout(1,2,5,5));
		conteneurSudPrincipal.add(conteneurSudOuest, BorderLayout.WEST);
		conteneurSudPrincipal.add(conteneurSudEst, BorderLayout.EAST);

		//On cr�e un conteneur pour un affichage pour les boutons ajouter/retirer
		JPanel conteneurAjoutRetirer = new JPanel();
		conteneurAjoutRetirer.setLayout(new GridLayout(1,2,5,5));
		conteneurAjoutRetirer.add(boutonAjout);
		conteneurAjoutRetirer.add(boutonRetirer);

		//On cr�e un conteneur pour un affichage � l'utilisateur
		JPanel conteneurConsole = new JPanel();
		conteneurConsole.setLayout(new GridLayout(1,2,5,5));
		conteneurConsole.add(labelConsole);
		conteneurConsole.add(areaConsole);

		//On cr�e un conteneur pour la gravitation
		JPanel conteneurGravitation = new JPanel();
		conteneurGravitation.setLayout(new GridLayout(1,2,5,5));
		conteneurGravitation.add(labelCstGravitation);
		conteneurGravitation.add(cstGravitation);

		//On cr�e un conteneur pour la vitesse de Simulation
		JPanel conteneurVitesseSimulation = new JPanel();
		conteneurVitesseSimulation.setLayout(new GridLayout(1,2,5,5));
		conteneurVitesseSimulation.add(labelVitesseSimulation);
		conteneurVitesseSimulation.add(vitesseSimulation);

		//On cr�e un conteneur pour la Autoscale et Next
		JPanel conteneurPauseNext = new JPanel();
		conteneurPauseNext.setLayout(new GridLayout(1,2,5,5));
		conteneurPauseNext.add(boutonAutoScale);
		conteneurPauseNext.add(boutonNext);

		//On créé un conteneur pour le start et stop
		JPanel conteneurStartStop = new JPanel();
		conteneurStartStop.setLayout(new GridLayout(1,2,5,5));
		conteneurStartStop.add(boutonStartPause);

		//On centres les JLabel
		labelConsole.setHorizontalAlignment(JLabel.CENTER);
		labelCstGravitation.setHorizontalAlignment(JLabel.CENTER);
		labelVitesseSimulation.setHorizontalAlignment(JLabel.CENTER);

		//GESTON LOGO
		ImageIcon image = new ImageIcon("UNIVERSE2.png");
		JLabel imagelabel = new JLabel(image);

		//DEFINIT FORME QUART BAS GAUCHE + AJOUTS ELEMENTS
		conteneurSudOuest.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5)); 
		conteneurSudOuest.setLayout(new GridLayout(0,1,5,5));
		conteneurSudOuest.add(conteneurAjoutRetirer);
		conteneurSudOuest.add(imagelabel);
		//--- POUR L'INSTANT INUTILE, DECOMMENTEZ SI IMPLEMENTE ----
		//conteneurSudOuest.add(conteneurConsole);
		//conteneurSudOuest.add(conteneurGravitation);
		//conteneurSudOuest.add(conteneurVitesseSimulation);
		conteneurSudOuest.add(conteneurPauseNext);
		conteneurSudOuest.add(conteneurStartStop);
		//---- FIN BLOC SUD OUEST ----

		//---- DEBUT BLOC SUD EST ----
		//On cr�e un conteneur pour la liste de particule
		JPanel conteneurListe = new JPanel();
		conteneurListe.setLayout(new GridLayout(1,2,5,5));
		conteneurListe.add(labelListe);
		conteneurListe.add(listeObjets);

		//On centre tous les JLabel
		labelListe.setHorizontalAlignment(JLabel.CENTER);

		//On cr�e un conteneur pour les coordonn�es
		JPanel conteneurCoord = new JPanel();
		conteneurCoord.setLayout(new GridLayout(1,7,5,5));
		conteneurCoord.add(labelCoord);
		conteneurCoord.add(labelX);
		conteneurCoord.add(coordX);
		conteneurCoord.add(labelY);
		conteneurCoord.add(coordY);

		//On centre tous les JLabel
		labelCoord.setHorizontalAlignment(JLabel.CENTER);
		labelX.setHorizontalAlignment(JLabel.CENTER);
		labelY.setHorizontalAlignment(JLabel.CENTER);

		//On cr�e un conteneur pour les vitesse
		JPanel conteneurVitesse = new JPanel();
		conteneurVitesse.setLayout(new GridLayout(1,7,5,5));
		conteneurVitesse.add(labelVitesse);
		conteneurVitesse.add(labelVx);
		conteneurVitesse.add(vitesX);
		conteneurVitesse.add(labelVy);
		conteneurVitesse.add(vitesY);

		//On centre tous les JLabel
		labelVitesse.setHorizontalAlignment(JLabel.CENTER);
		labelVx.setHorizontalAlignment(JLabel.CENTER);
		labelVy.setHorizontalAlignment(JLabel.CENTER);

		//On cr�e un conteneur pour les acc�l�rations
		JPanel conteneurAcceleration = new JPanel();
		conteneurAcceleration.setLayout(new GridLayout(1,7,5,5));
		conteneurAcceleration.add(labelAcceleration);
		conteneurAcceleration.add(labelAx);
		conteneurAcceleration.add(accelX);
		conteneurAcceleration.add(labelAy);
		conteneurAcceleration.add(accelY);

		//On centre tous les JLabel
		labelAcceleration.setHorizontalAlignment(JLabel.CENTER);
		labelAx.setHorizontalAlignment(JLabel.CENTER);
		labelAy.setHorizontalAlignment(JLabel.CENTER);

		//On cr�e un conteneur pour les acc�l�rations
		JPanel conteneurMasseRayonCouleur = new JPanel();
		conteneurMasseRayonCouleur.setLayout(new GridLayout(1,6,5,5));
		conteneurMasseRayonCouleur.add(labelMasse);
		conteneurMasseRayonCouleur.add(spinnerMasse);
		conteneurMasseRayonCouleur.add(labelRayon);
		conteneurMasseRayonCouleur.add(spinnerRayon);
		conteneurMasseRayonCouleur.add(labelCouleur);
		conteneurMasseRayonCouleur.add(boutonCouleur);

		//On centre tous les JLabel
		labelMasse.setHorizontalAlignment(JLabel.CENTER);
		labelCouleur.setHorizontalAlignment(JLabel.CENTER);
		labelRayon.setHorizontalAlignment(JLabel.CENTER);

		//On met les boutons dans les interfaces : interface bas droite
		JPanel conteneurParticule = new JPanel();
		conteneurParticule.setLayout(new GridLayout(4,1,5,5));
		conteneurParticule.add(conteneurCoord);
		conteneurParticule.add(conteneurVitesse);
		conteneurParticule.add(conteneurAcceleration);
		conteneurParticule.add(conteneurMasseRayonCouleur);

		//On rajoute des bordures pour que ce soit a�r�.
		conteneurSudEst.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		conteneurListe.setBorder(BorderFactory.createEmptyBorder(0, 5, 5, 5));

		//On met tout dans le conteneur SUD EST.
		conteneurSudEst.setLayout(new BorderLayout());
		conteneurSudEst.add(conteneurListe, BorderLayout.NORTH);
		conteneurSudEst.add(conteneurParticule, BorderLayout.CENTER);

		//---- FIN BLOC SUD EST ----

		// ---- ECOUTEURS ----
		// AJOUT/RETIRER ECOUTEUR
		EcouteurBoutonAjout EboutonAjout = new EcouteurBoutonAjout(this);
		boutonAjout.addActionListener(EboutonAjout);
		EcouteurBoutonRetirer EboutonRetirer = new EcouteurBoutonRetirer(this);
		boutonRetirer.addActionListener(EboutonRetirer);

		// LISTE OBJET ECOUTEUR
		EcouteurListeObjet ElisteObjets = new EcouteurListeObjet(this);
		listeObjets.addActionListener(ElisteObjets);
		// COORDONNES ECOUTEUR
		EcouteurCoordX EcoordX = new EcouteurCoordX(this);
		EcouteurCoordY EcoordY = new EcouteurCoordY(this);
		coordX.addChangeListener(EcoordX);
		coordY.addChangeListener(EcoordY);

		// VITESSES ECOUTEUR
		EcouteurVitesX EvitesX = new EcouteurVitesX(this);
		EcouteurVitesY EvitesY = new EcouteurVitesY(this);
		vitesX.addChangeListener(EvitesX);
		vitesY.addChangeListener(EvitesY);

		//ACCELERATION ECOUTEUR
		EcouteurAccelX EaccelX = new EcouteurAccelX(this);
		EcouteurAccelY EaccelY = new EcouteurAccelY(this);
		accelX.addChangeListener(EaccelX);
		accelY.addChangeListener(EaccelY);

		//MASSE RAYON COULEUR ECOUTEURS
		EcouteurMasse Emasse = new EcouteurMasse(this);
		EcouteurRayon Erayon = new EcouteurRayon(this);
		EcouteurCouleur EboutonCouleur = new EcouteurCouleur(this);
		spinnerMasse.addChangeListener(Emasse);
		spinnerRayon.addChangeListener(Erayon);
		boutonCouleur.addActionListener(EboutonCouleur);

		// NEXT BOUTON ECOUTEUR
		EcouteurBoutonNext EboutonNext = new EcouteurBoutonNext(this);
		boutonNext.addActionListener(EboutonNext);
		EcouteurBoutonAutoScale EboutonAutoScale = new EcouteurBoutonAutoScale(this);
		boutonAutoScale.addActionListener(EboutonAutoScale);
		EcouteurBoutonStartPause EboutonStartPause = new EcouteurBoutonStartPause(this);
		boutonStartPause.addActionListener(EboutonStartPause);

		// ---- FINALISATION ----
		//On attribue le conteneur principal à la fen�tre
		this.setContentPane(conteneurPrincipal);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Fermer le programme avec la croix
		this.setLocationRelativeTo(null); //Centre la fen�tre � l'�cran
		this.setTitle("Universe Simulator"); //Ent�te de la fen�tre
		setVisible(true); //Afficher la fen�tre
	}

	// GETTEURS PARTICULIERS 
	public ListeObjet getListeObjets(){
		return listeDesParticules;
	}

	public Moteur getMoteur(){
		return moteurPhysique;
	}

	public JComboBox<Particule> getJComboBox(){
		return listeObjets;
	}

	public PanelDessin getZoneDessin(){
		return conteneurNordPrincipal;
	}

	//SETTEURS PARTICULIERS
	public void setBoutonStartPause(JToggleButton boutonStartPause) {
		this.boutonStartPause = boutonStartPause;
	}

	public void setBoutonAutoScale(JToggleButton boutonAutoScale) {
		this.boutonAutoScale = boutonAutoScale;
	}

	// LES SETTEURS des COORDONNES / VITESSES / ACCELERATIONS / MASSE / RAYON 
	public void setCoordX(double coordX) {
		this.coordX.setValue(coordX);
	}

	public void setCoordY(double coordY) {
		this.coordY.setValue(coordY);
	}

	public void setVitesX(double vitesX) {
		this.vitesX.setValue(vitesX);
	}

	public void setVitesY(double vitesY) {
		this.vitesY.setValue(vitesY);
	}

	public void setAccelX(double accelX) {
		this.accelX.setValue(accelX);
	}

	public void setAccelY(double accelY) {
		this.accelY.setValue(accelY);
	}

	public void setMasse(double masse) {
		this.spinnerMasse.setValue(masse);
	}

	public void setRayon(double rayon) {
		this.spinnerRayon.setValue(rayon);
	}

	// LES GETTEURS des COORDONNES / VITESSES / ACCELERATIONS / MASSE / RAYON
	public double getCoordX(){
		return stringToDouble(coordX);
	}

	public double getCoordY(){
		return stringToDouble(coordY);
	}

	public double getVitesX(){
		return stringToDouble(vitesX);
	}

	public double getVitesY(){
		return stringToDouble(vitesY);
	}

	public double getAccelX(){
		return stringToDouble(accelX) ;
	}

	public double getAccelY(){
		return stringToDouble(accelY) ;
	}

	public double getMasse(){
		return stringToDouble(spinnerMasse);
	}

	public double getRayon(){
		return stringToDouble(spinnerRayon);
	}

	/** Méthode pour renvoyer le double contenu dans un Spinner
	 * @param spinner : le spinner dont on veut extraire "sûrement" le double entré par l'utilisateur
	 * @return le double entré dans le spinner ou 0 si la valeur n'est pas bonne.
	 */
	public double stringToDouble(JSpinner spinner){
		double answer = 0;

		try {
			if(spinner==null){
				answer = 0;
			} else if(spinner.getValue()==null){
				answer = 0;
			} else if(spinner.getValue().toString().length()==0){
				answer = 0;
			} else {
				answer = Double.parseDouble(spinner.getValue().toString());
			}
		} catch (NumberFormatException e) {
			System.out.println("VOUS AVEZ ENTRE UNE CHAINE DE CARACTERE ! ");
			answer = -1;
		}

		return answer;
	}


	/** Méthode pour ajouter une particule proprement
	 * @param particule : la particule à ajouter
	 */
	public void ajouterParticule(Particule particule){
		// On ajoute la particule à la listeObjet
		listeDesParticules.ajouterParticule(particule);
		// On ajoute la particule dans la liste déroulante
		listeObjets.addItem(particule);

		//DEBUG //
		if(Affichage.debug){listeDesParticules.toString();}
		if(Affichage.debug){listeObjets.toString();}
		//DEBUG - Connaitre l'état de la liste des Particules //
	}

	/** Méthode pour retirer une particule proprement
	 * @param particule : la particule à retirer
	 */
	public void retirerParticule(Particule particule){
		// On retire la particule à la listeObjet
		listeDesParticules.getListeParticule().remove(particule);
		// On retire la particule dans la liste déroulante
		listeObjets.removeItem(particule);

		//DEBUG //
		if(Affichage.debug){listeDesParticules.toString();}
		if(Affichage.debug){listeObjets.toString();}
		//DEBUG - Connaitre l'état de la liste des Particules //
	}

	/** Méthode qui met à jour les champs de la fenêtre principale (Coordonnées, vitesse, masse ...)
	 * 
	 */
	public void mettreAJourChamps(){
		if(this.getJComboBox().getSelectedItem() instanceof Particule){
			Particule particule = (Particule) this.getJComboBox().getSelectedItem();

			// On change tous les JSpinner de la fenêtre principale.
			this.setCoordX(particule.getCoordonnees().getTabVecteur()[0]);
			this.setCoordY(particule.getCoordonnees().getTabVecteur()[1]);
			this.setVitesX(particule.getVitesse().getTabVecteur()[0]);
			this.setVitesY(particule.getVitesse().getTabVecteur()[1]);
			this.setAccelX(particule.getAcceleration().getTabVecteur()[0]);
			this.setAccelY(particule.getAcceleration().getTabVecteur()[1]);
			this.setMasse(particule.getMasse());
			this.setRayon(particule.getRayon());
			//On repaint la fenetre puisque la position des objets a chang�.
			this.getZoneDessin().repaint();
		} else {
			System.out.println("Pas de particule dans la liste déroulante sélectionnée");
			//On mets tous les indices à 0 si il n'y a aucune particule
				this.setCoordX(0);
				this.setCoordY(0);
				this.setVitesX(0);
				this.setVitesY(0);
				this.setAccelX(0);
				this.setAccelY(0);
				this.setMasse(0);
				this.setRayon(0);
		}
	}

}
