import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

/** Classe qui gère la zone de dessin dans la fenêtre principale.
 *
 */
public class PanelDessin extends JPanel {
	private Affichage fenetreParente;
	double[] coefficient = {1,0};

	/** Constructeur de la zone de dessin.
	 * @param fenetreParente : Fenêtre principale, parente, conteant le JPanel de dessin.
	 */
	public PanelDessin(Affichage fenetreParente){
		this.fenetreParente = fenetreParente;
		setBackground(Color.BLACK); //Le Fond en noir pour faire Spatial
	}

	/* Méthode standard de dessin du JPanel
	 */
	@Override
	protected void paintComponent(Graphics g) {
		//Appel de la fonction n�cessaire pour commencer � dessiner la zone de dessin
		super.paintComponent(g); 

		//DEBUG // 
		if(Affichage.debug){System.out.println("DANS PANEL DESSIN : fenetre repeinte ! ");}
		//DEBUG // 

		//On demande à la liste des Objets de dessiner toutes les particules
		fenetreParente.getListeObjets().dessinerListe(g, coefficient, this.getWidth(), this.getHeight());

		//DEBUG // 
		if(Affichage.debug){System.out.println("DANS PANEL DESSIN : coefficient, getWidht, getHeight " + coefficient + " " + this.getWidth() + " " + this.getHeight());}
		//DEBUG // 

		//On mets à jour tous les champs de l'interface.
		fenetreParente.mettreAJourChamps();

	}

	/** Méthode permettant de définir un coefficient de dilatation/rétractation/mise à l'échelle lors du dessin des particules.
	 * @param coefDilatation : Double sous la forme affine, a*X + b permettant de définir le coefficient et la constante de correction pour la mise à l'échelle de l'ensemble des particules lors de leur dessin.
	 */
	public void setCoefficient(double[] coefDilatation){
		this.coefficient = coefDilatation;
	}
}
