import java.awt.Graphics;
import java.util.LinkedList ;
public class ListeObjet {
	
	private LinkedList<Particule> listeParticule;

	/** Constructeur
	 * @param listeParticule
	 */
	public ListeObjet() {
		listeParticule= new LinkedList<Particule>();
	}
	
	public void ajouterParticule(Particule p){
		if(!listeParticule.add(p)){
			System.out.println("La particule n'a pas pu être ajoutée.");
		}
		listeParticule.add(p); //A vérifier mais je pense qu'avec ça, on l'ajoute deux fois.
	}
	
	public void sortirParticule(Particule p){
		listeParticule.remove(p);
	}
	
	public void sortirParticule(int i){
		listeParticule.remove(i);
	}
	
	public void dessinerListe(Graphics g){}
	
	public String toString(){
		if(listeParticule.size()==0){
			return "Vous n'avez pas ajouté de particules.";
		} else {
			
			String res="";
			
			for(int i=0; i<listeParticule.size(); i++){
				res+="\n"+listeParticule.get(i).toString();
			}
			
			return res;
		}
	}

	/**
	 * @return the listeParticule
	 */
	public LinkedList<Particule> getListeParticule() {
		return listeParticule;
	}
	
	/**
	 * @param particuleAJour
	 */
	public void setParticule(Particule particuleAJour){ 

		for(int i=0; i<listeParticule.size(); i++){
            if(listeParticule.get(i).getNum()==particuleAJour.getNum()){
				listeParticule.set(i,particuleAJour);
            }
        }		
	}
	
	public void  mettreAJourEtat(){
		for(int i=0; i<listeParticule.size(); i++){
			listeParticule.get(i).passerEtatFutur();
		}		
	}

}
