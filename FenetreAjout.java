import javax.swing.*;

import java.awt.*;

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
		particulesPredefinies.addItem(new Particule(0,0,0,0,0,0,0,0,0,0,"Personnalisée N°" + Particule.compteur,0));
		particulesPredefinies.addItem(new Terre(0,0,0,0,0,0,0,0,0));
		particulesPredefinies.addItem(new EtoileNaineRouge(0,0,0,0,0,0,0,0,0));
		particulesPredefinies.addItem(new Meteorite(0,0,0,0,0,0,0,0,0));
					
		//Cadres
		JPanel cadrePrincipal = new JPanel( new BorderLayout());
		JPanel cadreDeroulant = new JPanel(new BorderLayout());
		JPanel cadreAttributs= new JPanel(new GridLayout(3,6,5,5));
		JPanel cadreBoutons= new JPanel(new BorderLayout());
		
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
		
		//Parametrage fenetre
		cadreDeroulant.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		cadreBoutons.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		cadreAttributs.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(cadrePrincipal);
		
		//setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setMinimumSize(new Dimension(350,300));
		setVisible(true);
	}
	
	// SETTEURS
	
	public void setCouleurParticule(Color c){
		couleurParticule=c;
	}
	
	public void setCoordX(String s){
		coordX.setText(s);
	}
	public void setCoordY(String s){
		coordY.setText(s);
	}
	
	public void setVitX(String s){
		vitX.setText(s);
	}
	
	public void setVitY(String s){
		vitY.setText(s);
	}
	public void setAccX(String s){
		accX.setText(s);
	}
	
	public void setAccY(String s){
		accY.setText(s);
	}
	
	public void setMasse(String s){
		masse.setText(s);
	}
	
	public void setType(String s){
		type.setText(s);
	}
	
	public void setRayon(String s){
		rayon.setText(s);
	}
	
	// GETTEURS
	public double getCoordX(){//test de la nullité oblig?
		return stringToDouble(coordX);
	}
	
	public double getCoordY(){
		return stringToDouble(coordY);
	}
	
	public double getVitX(){
		return stringToDouble(vitX);
	}
	
	public double getVitY(){
		return stringToDouble(vitY);
	}
	
	public double getAccX(){
		return stringToDouble(accX);
	}
	
	public double getAccY(){
		return stringToDouble(accY);
	}
	
	public double getMasse(){
		return stringToDouble(masse);
	}
	
	public double getRayon(){
		return stringToDouble(rayon);
	}
	
	
	//AUTRES GETTEURS
	public String getTypeParticule(){
		return type.getText().toString();
	}
	
	public Particule getSelectedParticule(){
		Particule p =(Particule) particulesPredefinies.getSelectedItem();
		return p;
	}
	
	public Color getCouleurParticule(){
		return couleurParticule;
	}
	
	public Affichage getFenAffichage(){
		return fenetrePrincipale;
	}
	
	// METHODES UTILES
	
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
