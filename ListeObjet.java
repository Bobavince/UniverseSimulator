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
		listeParticule.add(p);
	}

	public void sortirParticule(Particule p){
		listeParticule.remove(p);
	}

	public void sortirParticule(int i){
		listeParticule.remove(i);
	}

	public String toString(){
		if(listeParticule.size()==0){
			return "Vous n'avez pas ajouté de particules.";
		}
		else{

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
	public void setParticule(Particule particuleAJour){ // marche si la particuleAJour est une particule existante qui a seulement été modifiée

		int i=0;
		while(listeParticule.get(i).getNum()!=particuleAJour.getNum()){
			i++;
		}
		
		listeParticule.set(i,particuleAJour);

		/*for(int i=0; i<listeParticule.size(); i++){
			if(listeParticule.get(i).getNum()==particuleAJour.getNum()){
				listeParticule.set(i,particuleAJour);
			}
		}*/
	}

	public LinkedList<Particule>  mettreAJourEtat(){
		for(int i=0; i<listeParticule.size(); i++){
			listeParticule.get(i).passerEtatFutur();
		}

		return listeParticule;
	}

}
