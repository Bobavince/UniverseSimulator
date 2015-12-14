import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class FenetreAjout extends JFrame{
	//couleur de la particule
	Color couleurParticule= Color.BLUE;
	
	private Affichage fenetrePrincipale;
	
	private JComboBox<Particule> particulesPredefinies;
	
	private JLabel legendeCX= new JLabel("x");
	private JLabel legendeCY= new JLabel("y");
	//private JLabel legendeCZ= new JLabel("z");
	
	
	private JTextField coordX= new JTextField("0",4);
	private JTextField coordY= new JTextField("0",4);
	//private JTextField coordZ= new JTextField("0",4);
	
	private JLabel legendeVX= new JLabel("Vx");
	private JLabel legendeVY= new JLabel("Vy");
	//private JLabel legendeVZ= new JLabel("Vz");
	
	private JTextField vitX= new JTextField("0",4);
	private JTextField vitY= new JTextField("0",4);
	//private JTextField vitZ= new JTextField("0",4);
	
	private JLabel legendeAX= new JLabel("Ax");
	private JLabel legendeAY= new JLabel("Ay");
	//private JLabel legendeAZ= new JLabel("Az");
	
	private JTextField accX= new JTextField("0",4);
	private JTextField accY= new JTextField("0",4);
	//private JTextField accZ= new JTextField("0",4);
	
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
		EcouteurLancement ecouteurBtnLancer= new EcouteurLancement(this);
		btnLancer.addActionListener(ecouteurBtnLancer);
		
		EcouteurAnnuler ecouteurBtnAnnuler= new EcouteurAnnuler(this);
		btnAnnuler.addActionListener(ecouteurBtnAnnuler);
		
		EcouteurParticulesPredefinies ecouteurListeParticulesPredefinies= new EcouteurParticulesPredefinies(this);
		particulesPredefinies.addActionListener(ecouteurListeParticulesPredefinies);
		
		EcouteurCouleurParticule ecouteurCouleurParticule= new EcouteurCouleurParticule(this);
		btnCouleur.addActionListener(ecouteurCouleurParticule);
		
		particulesPredefinies.addItem( new Particule(0,0,0,0,0,0,0,0,0,0,"...",0));
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
	
	//setteurs
	
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
	
	//getteurs
	public double getCoordX(){//test de la nullité oblig?
		return Double.parseDouble(coordX.getText());
	}
	
	public double getCoordY(){
		return Double.parseDouble(coordY.getText());
	}
	
	public double getVitX(){
		return Double.parseDouble(vitX.getText());
	}
	
	public double getVitY(){
		return Double.parseDouble(vitY.getText());
	}
	
	
	public double getAccX(){
		return Double.parseDouble(accX.getText());
	}
	
	public double getAccY(){
		return Double.parseDouble(accY.getText());
	}
	
	
	public double getMasse(){
		return Double.parseDouble(masse.getText());
	}
	
	public double getRayon(){
		return Double.parseDouble(rayon.getText());
	}
	
	public String getTypeParticule(){
		return type.getText();
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


}
