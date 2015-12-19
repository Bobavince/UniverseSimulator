import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/** Classe qui gère la fenêtre d'ajout de Particule, par l'utilisateur, une fois le bouton "Ajouter particule" pressé.
 */
public class FenetreAjout extends JFrame{
	//couleur de la particule
	private static Color couleurParticule= Color.BLUE;

	private Affichage fenetrePrincipale;

	private JComboBox<Particule> particulesPredefinies;

	private JLabel legendeCX= new JLabel("x");
	private JLabel legendeCY= new JLabel("y");

	private JTextField coordX= new JTextField("0",4);
	private JTextField coordY= new JTextField("0",4);

	private JLabel legendeVX= new JLabel("Vx");
	private JLabel legendeVY= new JLabel("Vy");

	private JTextField vitX= new JTextField("0",4);
	private JTextField vitY= new JTextField("0",4);

	private JLabel legendeAX= new JLabel("Ax");
	private JLabel legendeAY= new JLabel("Ay");

	private JTextField accX= new JTextField("0",4);
	private JTextField accY= new JTextField("0",4);

	private JLabel legendeMasse= new JLabel("Masse ");
	private JLabel legendeType= new JLabel("Type ");
	private JLabel legendeRayon= new JLabel("Rayon ");

	private JTextField masse= new JTextField("0",4);
	private JTextField type= new JTextField("...",6);
	private JTextField rayon= new JTextField("0",4);

	private JButton btnAnnuler= new JButton(" Annuler ");
	private JButton btnLancer= new JButton(" Lancer ");
	private JButton btnCouleur= new JButton(" Couleur ");

	/** Constructeur de la fenêtre d'ajout de particule appelé via le bouton "Ajout Particule"
	 * @param fenetrePrincipale : Fenetre parente, où se situe le bouton "Ajout Particule"
	 */
	public FenetreAjout(Affichage fenetrePrincipale) {
		super("Ajouter une particule");

		//Instanciation des attributs
		this.fenetrePrincipale = fenetrePrincipale;
		particulesPredefinies = new JComboBox<Particule>();

		//Ecouteurs
		EcouteurFenetreAjoutAjouter ecouteurBtnLancer= new EcouteurFenetreAjoutAjouter(this);
		btnLancer.addActionListener(ecouteurBtnLancer);

		EcouteurFenetreAjoutAnnuler ecouteurBtnAnnuler= new EcouteurFenetreAjoutAnnuler(this);
		btnAnnuler.addActionListener(ecouteurBtnAnnuler);

		EcouteurParticulesPredefinies ecouteurListeParticulesPredefinies= new EcouteurParticulesPredefinies(this);
		particulesPredefinies.addActionListener(ecouteurListeParticulesPredefinies);

		EcouteurFenetreAjoutCouleur ecouteurCouleurParticule= new EcouteurFenetreAjoutCouleur(this);
		btnCouleur.addActionListener(ecouteurCouleurParticule);

		// AJout des particules prédéfinies
		particulesPredefinies.addItem(new Particule(0,0,0,0,0,0,0,0,0,0,"Personnalisée N°" + Particule.compteur,0, false));
		particulesPredefinies.addItem(new Terre(0,0,0,0,0,0,0,0,0,false));
		particulesPredefinies.addItem(new EtoileNaineRouge(0,0,0,0,0,0,0,0,0, false));
		particulesPredefinies.addItem(new Meteorite(0,0,0,0,0,0,0,0,0, false));

		//Cadres
		JPanel cadrePrincipal = new JPanel(new BorderLayout());
		JPanel cadreDeroulant = new JPanel(new BorderLayout());
		JPanel cadreAttributs= new JPanel(new GridLayout(3,6,5,5));
		JPanel cadreBoutons= new JPanel(new GridLayout(1,3,5,5));

		cadrePrincipal.add(cadreDeroulant,BorderLayout.NORTH);
		cadrePrincipal.add(cadreAttributs,BorderLayout.CENTER);
		cadrePrincipal.add(cadreBoutons,BorderLayout.SOUTH);

		cadreDeroulant.add(particulesPredefinies);

		cadreAttributs.add(legendeCX);
		cadreAttributs.add(coordX);
		cadreAttributs.add(legendeVX);
		cadreAttributs.add(vitX);
		cadreAttributs.add(legendeAX);
		cadreAttributs.add(accX);
		cadreAttributs.add(legendeCY);
		cadreAttributs.add(coordY);
		cadreAttributs.add(legendeVY);
		cadreAttributs.add(vitY);
		cadreAttributs.add(legendeAY);
		cadreAttributs.add(accY);

		cadreAttributs.add(legendeRayon);
		cadreAttributs.add(rayon);
		cadreAttributs.add(legendeMasse);
		cadreAttributs.add(masse);
		cadreAttributs.add(legendeType);
		cadreAttributs.add(type);

		cadreBoutons.add(btnCouleur, BorderLayout.WEST);
		cadreBoutons.add(btnLancer,BorderLayout.CENTER);
		cadreBoutons.add(btnAnnuler,BorderLayout.EAST);

		//Alignement
		legendeCX.setHorizontalAlignment(JLabel.CENTER);
		legendeVX.setHorizontalAlignment(JLabel.CENTER);
		legendeAX.setHorizontalAlignment(JLabel.CENTER);
		legendeCY.setHorizontalAlignment(JLabel.CENTER);
		legendeVY.setHorizontalAlignment(JLabel.CENTER);
		legendeAY.setHorizontalAlignment(JLabel.CENTER);
		legendeRayon.setHorizontalAlignment(JLabel.CENTER);
		legendeMasse.setHorizontalAlignment(JLabel.CENTER);
		legendeType.setHorizontalAlignment(JLabel.CENTER);
		legendeCX.setVerticalAlignment(JLabel.CENTER);
		legendeVX.setVerticalAlignment(JLabel.CENTER);
		legendeAX.setVerticalAlignment(JLabel.CENTER);
		legendeCY.setVerticalAlignment(JLabel.CENTER);
		legendeVY.setVerticalAlignment(JLabel.CENTER);
		legendeAY.setVerticalAlignment(JLabel.CENTER);
		legendeRayon.setVerticalAlignment(JLabel.CENTER);
		legendeMasse.setVerticalAlignment(JLabel.CENTER);
		legendeType.setVerticalAlignment(JLabel.CENTER);

		//Parametrage fenetre
		cadreDeroulant.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		cadreBoutons.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		cadreAttributs.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		setContentPane(cadrePrincipal);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setMinimumSize(new Dimension(800,300));
		this.setMaximumSize(new Dimension (10000,600));
		this.setMinimumSize(new Dimension (800,300));
		setLocationRelativeTo(null);
		setVisible(true);
	}

	// SETTEURS
	/** Setteur de du champ Couleur
	 * @param c : Couleur à associer au champ
	 */
	public void setCouleurParticule(Color c){
		couleurParticule=c;
	}

	/** Setteur de du champ CoordX
	 * @param s : Coordonnées X à associer au champ
	 */
	public void setCoordX(String s){
		coordX.setText(s);
	}

	/** Setteur de du champ CoordY
	 * @param s : Coordonnées Y à associer au champ
	 */
	public void setCoordY(String s){
		coordY.setText(s);
	}

	/** Setteur de du champ VitesX
	 * @param s : Vitesse X à associer au champ
	 */
	public void setVitX(String s){
		vitX.setText(s);
	}

	/** Setteur de du champ VitesY
	 * @param s : Vitesse Y à associer au champ
	 */
	public void setVitY(String s){
		vitY.setText(s);
	}

	/** Setteur de du champ AccelX
	 * @param s : AccelX à associer au champ
	 */
	public void setAccX(String s){
		accX.setText(s);
	}

	/** Setteur de du champ AccelY
	 * @param s : AccelY à associer au champ
	 */
	public void setAccY(String s){
		accY.setText(s);
	}

	/** Setteur de du champ masse
	 * @param s : Masse à associer au champ
	 */
	public void setMasse(String s){
		masse.setText(s);
	}

	/** Setteur de du champ Type
	 * @param s : Type à associer au champ
	 */
	public void setType(String s){
		type.setText(s);
	}

	/** Setteur de du champ rayon
	 * @param s : Rayon à associer au champ
	 */
	public void setRayon(String s){
		rayon.setText(s);
	}

	// GETTEURS
	/** Getteur du champ CoordX
	 * @return la coordonnées X du champ CoordX
	 */
	public double getCoordX(){//test de la nullité oblig?
		return stringToDouble(coordX);
	}

	/** Getteur du champ CoordY
	 * @return la coordonnées Y du champ CoordY
	 */
	public double getCoordY(){
		return stringToDouble(coordY);
	}

	/** Getteur du champ VitesX
	 * @return la vitesse X du champ VitesX
	 */
	public double getVitX(){
		return stringToDouble(vitX);
	}

	/** Getteur du champ VitesY
	 * @return la vitesse Y du champ VitesY
	 */
	public double getVitY(){
		return stringToDouble(vitY);
	}

	/** Getteur du champ AccelX
	 * @return l'acceleration du champ AccelX
	 */
	public double getAccX(){
		return stringToDouble(accX);
	}

	/** Getteur du champ AccelY
	 * @return l'acceleration du champ AccelY
	 */
	public double getAccY(){
		return stringToDouble(accY);
	}

	/** Getteur du champ masse
	 * @return la valeur du champ masse
	 */
	public double getMasse(){
		return stringToDouble(masse);
	}

	/** Getteur du champ rayon
	 * @return la valeur du champ rayon
	 */
	public double getRayon(){
		return stringToDouble(rayon);
	}

	//AUTRES GETTEURS

	/** Getteur du champ TYPE
	 * @return la valeur du champ Type sous forme de String
	 */
	public String getTypeParticule(){
		return type.getText().toString();
	}

	/** Getteur de la liste déroulante
	 * @return la valeur de la liste déroulante sous forme de Particule
	 */
	public Particule getSelectedParticule(){
		Particule p =(Particule) particulesPredefinies.getSelectedItem();
		return p;
	}

	/** Getteur du champ Couleur
	 * @return la valeur du champ Couleur sous forme d'un Objet de type Color
	 */
	public Color getCouleurParticule(){
		return couleurParticule;
	}

	/** Getteur de la fenêtre principale associée à la fenêtre AjoutParticule
	 * @return L'instance de la fenêtre Principale "Affichage"
	 */
	public Affichage getFenAffichage(){
		return fenetrePrincipale;
	}

	// METHODES UTILES

	/** Méthode permettant de convertir une string (particulièrement celle des champs CoordX, CoordY ...) en un double, avec vérifications diverses.
	 * @param textfield : Le JTextField conteant le double à convertir.
	 * @return un double "propre", 0 si le champ n'est pas défini, -1 si la chaine entrée n'est pas d'un type nombre. (par exemple si un user entre des caractères ASCII non numéraires)
	 */
	public double stringToDouble(JTextField textfield){
		double answer = 0;

		try {
			if(textfield==null){
				answer = 0;
				System.out.println("1");
			} else if(textfield.getText()==null){
				answer = 0;
				System.out.println("2");
			} else if(textfield.getText().toString().length()==0){
				answer = 0;
				System.out.println("3");
			} else {
				answer = Double.parseDouble(textfield.getText().toString());
			}
		} catch (NumberFormatException e) {
			System.out.println("VOUS AVEZ ENTRE UNE CHAINE DE CARACTERE ! ");
			answer = -1;
		}

		return answer;
	}
}
