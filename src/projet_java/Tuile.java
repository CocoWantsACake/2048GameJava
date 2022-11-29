package projet_java;

public class Tuile {
	
	private int positionI;
	private int positionJ;
	private int valeur;
	private Grille grille;
	private boolean estDeplacable = false;
	int nbDeplacementsRestants = 1;

	public Tuile(int positionI, int positionJ, int valeur, Grille g) {
		this.positionI = positionI;
		this.positionJ = positionJ;
		this.valeur = valeur;
		this.grille = g;
	}
	
	public void setPositionI(int positionI) {
		this.positionI = positionI;
	}
	
	public int getPositionI() {
		return positionI;
	}
	
	public void setPositionJ(int positionJ) {
		this.positionJ = positionJ;
	}
	
	public int getPositionJ() {
		return positionJ;
	}
	
	public void setValeur(int valeur) {
		this.valeur = valeur;
	}
	
	public int getValeur() {
		return valeur;
	}
	
	public void setNbDeplacementsRestants(int i) {
		nbDeplacementsRestants = i;
	}
	
	public boolean getEstDeplacable() {
		return estDeplacable;
	}
	
	public void checkIfDeplacable(int positionI_OK, int positionJ_OK, String direction) {
		if (! estAuBord(direction)) {
			int val = grille.getTuile(positionI_OK, positionJ_OK).getValeur();
			
			if (this.valeur != 0) {
				if (val == this.valeur && nbDeplacementsRestants != 0) {
					estDeplacable = true;	
				} else if (val == 0) {
					estDeplacable = true;
				} else {
					estDeplacable = false;
				}
			} else {
				estDeplacable = false;
			}
		}
	}
	
	public void setEstDeplacable(String direction) {
		int positionI_OK, positionJ_OK;
		switch (direction) {
			case "gauche" : 
				positionI_OK = positionI;
				positionJ_OK = positionJ - 1;
				checkIfDeplacable(positionI_OK, positionJ_OK, direction);
				break;
			
			case "droite" :
				positionI_OK = positionI;
				positionJ_OK = positionJ + 1;
				checkIfDeplacable(positionI_OK, positionJ_OK, direction);
				break;
			
			case "haut" :
				positionI_OK = positionI - 1;
				positionJ_OK = positionJ;			
				checkIfDeplacable(positionI_OK, positionJ_OK, direction);
				break;
			
			case "bas" : 
				positionI_OK = positionI + 1;
				positionJ_OK = positionJ;			
				checkIfDeplacable(positionI_OK, positionJ_OK, direction);
				break;
		}
	}

	public void doDeplacement(int positionI_OK, int positionJ_OK, String direction) {
		if (!estAuBord(direction)) {
			int val = grille.getTuile(positionI_OK, positionJ_OK).getValeur();
			
			if (val == 0) {
				grille.getTuile(positionI_OK, positionJ_OK).setValeur(valeur);
				this.setValeur(0);
			} else if (val == this.valeur && nbDeplacementsRestants != 0) {
				grille.getTuile(positionI_OK, positionJ_OK).setValeur(val+val);
				this.setValeur(0);
				nbDeplacementsRestants = 0;
				grille.getSaPartie().augmenterScore(val+val);
			}
		}
	}
	
	public void deplacer(String direction) {
		int positionI_OK, positionJ_OK;
		switch (direction) {
			case "gauche" : 
				positionI_OK = positionI;
				positionJ_OK = positionJ - 1;
				doDeplacement(positionI_OK, positionJ_OK, direction);
				break;
			
			case "droite" :
				positionI_OK = positionI;
				positionJ_OK = positionJ + 1;
				doDeplacement(positionI_OK, positionJ_OK, direction);
				break;
			
			case "haut" :
				positionI_OK = positionI - 1;
				positionJ_OK = positionJ;
				doDeplacement(positionI_OK, positionJ_OK, direction);		
				break;
			
			case "bas" : 
				positionI_OK = positionI + 1;
				positionJ_OK = positionJ;
				doDeplacement(positionI_OK, positionJ_OK, direction);		
				break;
		}
	}
	
	public boolean estAuBord(String direction) {
		switch (direction) {
			case "gauche" : 
				return positionJ == 0;
			
			case "droite" :
				return positionJ == grille.getTaille() - 1;
			
			case "haut" :
				return positionI == 0;
			
			case "bas" : 
				return positionI == grille.getTaille() - 1;
				
			default:
				return false;
		}
	}
	
	public String toString() {
		return "" + this.valeur;
	}

}

