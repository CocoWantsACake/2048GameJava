package projet_java;

public class Tuile {
	
	private int positionI;
	private int positionJ;
	private int valeur;
	private Grille saGrille;
	private boolean estDeplacable = false;
	int nbDeplacementsRestants = 1;

	public Tuile(int positionI, int positionJ, int valeur, Grille g) {
		this.positionI = positionI;
		this.positionJ = positionJ;
		this.valeur = valeur;
		this.saGrille = g;
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
	
	public void setEstDeplacable(String direction) {
		switch (direction) {
		
		case "gauche" : 
			if (! estAuBord(direction)) {
				int val = saGrille.getTuile(positionI, positionJ - 1).getValeur();
				
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
		break;
		
		case "droite" :
			if (! estAuBord(direction)) { 
				int val = saGrille.getTuile(positionI, positionJ + 1).getValeur();
				
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
		break;
		
		case "haut" :
			if (! estAuBord(direction)) {
				int val = saGrille.getTuile(positionI - 1, positionJ).getValeur();
				
				if (this.valeur != 0) {
					if (val == this.valeur && nbDeplacementsRestants != 0) {
						estDeplacable = true;
					} else if (val == 0) {
						estDeplacable = true;
					} else {
						estDeplacable = false;
					}
				}
				else {
					estDeplacable = false;
				}
			}				
		break;
		
		case "bas" : 
			if (! estAuBord(direction)) {
				int val = saGrille.getTuile(positionI + 1, positionJ).getValeur();
				
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
		break;
		}
	}

	public void deplacer(String direction) {
		switch (direction) {
			case "gauche" : 
				if (! estAuBord(direction)) {
					int val = saGrille.getTuile(positionI, positionJ - 1).getValeur();
					
					if (val == 0) {
						saGrille.getTuile(positionI, positionJ - 1).setValeur(valeur);
						this.setValeur(0);
					} else if (val == this.valeur && nbDeplacementsRestants != 0) {
						int score = val + val;
						saGrille.getTuile(positionI, positionJ - 1).setValeur(score);
						this.setValeur(0);
						nbDeplacementsRestants = 0;
						saGrille.getSaPartie().augmenterScore(score);
					}
				}
				break;
			
			case "droite" :
				if (! estAuBord(direction)) {
					int val = saGrille.getTuile(positionI, positionJ + 1).getValeur();
					
					if (val == 0) {
						saGrille.getTuile(positionI, positionJ + 1).setValeur(valeur);
						this.setValeur(0);
					} else if (val == this.valeur && nbDeplacementsRestants != 0) {
						int score = val + val;
						saGrille.getTuile(positionI, positionJ + 1).setValeur(score);
						this.setValeur(0);
						nbDeplacementsRestants = 0;
						saGrille.getSaPartie().augmenterScore(score);
					}
				}
			break;
			
			case "haut" :
				if (! estAuBord(direction)) {
					int val = saGrille.getTuile(positionI -1, positionJ).getValeur();
					
					if (val == 0) {
						saGrille.getTuile(positionI -1, positionJ).setValeur(valeur);
						this.setValeur(0);
					} else if (val == this.valeur && nbDeplacementsRestants != 0) {
						int score = val + val;
						saGrille.getTuile(positionI -1, positionJ).setValeur(score);
						this.setValeur(0);
						nbDeplacementsRestants = 0;
						saGrille.getSaPartie().augmenterScore(score);
					}	
				}				
			break;
			
			case "bas" : 
				if (! estAuBord(direction)) {
					int val = saGrille.getTuile(positionI +1, positionJ).getValeur();
					
					if (val == 0) {
						saGrille.getTuile(positionI+1, positionJ).setValeur(valeur);
						this.setValeur(0);
					} else if (val == this.valeur && nbDeplacementsRestants != 0) {
						int score = val + val;
						saGrille.getTuile(positionI+1, positionJ).setValeur(score);
						this.setValeur(0);
						nbDeplacementsRestants = 0;
						saGrille.getSaPartie().augmenterScore(score);
					}
				}				
			break;
		}
	}
	
	public boolean estAuBord(String direction) {
		switch (direction) {
			case "gauche" : 
				return positionJ == 0;
			
			case "droite" :
				return positionJ == saGrille.getTaille() - 1;
			
			case "haut" :
				return positionI == 0;
			
			case "bas" : 
				return positionI == saGrille.getTaille() - 1;
				
			default:
				return false;
		}
	}
	
	public String toString() {
		return "" + this.valeur;
	}
}

