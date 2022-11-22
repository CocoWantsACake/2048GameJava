package projet_java;

public class Tuile {
	
	// attributs
	private int positionI; // coordonnee x d'un objet
	private int positionJ; // coordonnee y d'un objet
	private int valeur; // valeur associee a la tuile
	private Grille saGrille;
	private boolean estDeplacable = false; // quand true, peut etre deplacee dans la grille
	int nbDeplacementsRestants = 1; // permet de ne pas additionner plusieurs fois une tuile
	
	// constructeur
	public Tuile(int positionI, int positionJ, int valeur, Grille g) {
		this.positionI = positionI;
		this.positionJ = positionJ;
		this.valeur = valeur;
		this.saGrille = g;
	}
	
	// getters et setters
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
			if (! estAuBord(direction)) { // on verifie qu'elle n'est pas au bord
				int val = saGrille.getTuile(positionI, positionJ - 1).getValeur();
				
				if (this.valeur != 0) {
					if (val == this.valeur && nbDeplacementsRestants != 0) {
						estDeplacable = true;	
					}
					else if (val == 0) {
						estDeplacable = true;
					}
					else { // la valeur de la tuile n'est pas nulle mais ne peut pas etre deplacee
						estDeplacable = false;
					}
				}
				else { // la valeur de la tuile est nulle
					estDeplacable = false;
				}
			}
		break;
		
		case "droite" :
			if (! estAuBord(direction)) { // on verifie qu'elle n'est pas au bord
				int val = saGrille.getTuile(positionI, positionJ + 1).getValeur();
				
				if (this.valeur != 0) {
					if (val == this.valeur && nbDeplacementsRestants != 0) {
						estDeplacable = true;
						
					}
					else if (val == 0) {
						estDeplacable = true;
					}
					else { // la valeur de la tuile n'est pas nulle mais ne peut pas etre deplacee
						estDeplacable = false;
					}
				}
				
				else { // la valeur de la tuile est nulle
					estDeplacable = false;
				}
			}
		break;
		
		case "haut" :
			if (! estAuBord(direction)) { // on verifie qu'elle n'est pas au bord
				int val = saGrille.getTuile(positionI - 1, positionJ).getValeur();
				
				if (this.valeur != 0) {
					if (val == this.valeur && nbDeplacementsRestants != 0) {
						estDeplacable = true;
						
					}
					else if (val == 0) {
						estDeplacable = true;
					}
					else { // la valeur de la tuile n'est pas nulle mais ne peut pas etre deplacee
						estDeplacable = false;
					}
				}
				else { // la valeur de la tuile est nulle
					estDeplacable = false;
				}
			}				
		break;
		
		case "bas" : 
			if (! estAuBord(direction)) { // on verifie qu'elle n'est pas au bord
				int val = saGrille.getTuile(positionI + 1, positionJ).getValeur();
				
				if (this.valeur != 0) {
					if (val == this.valeur && nbDeplacementsRestants != 0) {
						estDeplacable = true;
						
					}
					else if (val == 0) {
						estDeplacable = true;
					}
					else { // la valeur de la tuile n'est pas nulle mais ne peut pas etre deplacee
						estDeplacable = false;
					}
				}
				else { // la valeur de la tuile est nulle
					estDeplacable = false;
				}
			}				
		break;
		}
	}

	// autres methodes
	public void deplacer(String direction) {
		switch (direction) {
		
		case "gauche" : 
			if (! estAuBord(direction)) {
				int val = saGrille.getTuile(positionI, positionJ - 1).getValeur();
				
				if (val == 0) {
					saGrille.getTuile(positionI, positionJ - 1).setValeur(valeur);
					this.setValeur(0);
				}
				else if (val == this.valeur && nbDeplacementsRestants != 0) {
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
				}
				else if (val == this.valeur && nbDeplacementsRestants != 0) {
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
				}
				else if (val == this.valeur && nbDeplacementsRestants != 0) {
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
				}	
				else if (val == this.valeur && nbDeplacementsRestants != 0) {
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
	
	// fonction qui verifie que la tuile n'est pas au bord
	public boolean estAuBord(String direction) {
		boolean retour = false;
		
		switch (direction) {
	
		case "gauche" : 
			retour = positionJ == 0;
		break;
		
		case "droite" :
			retour = positionJ == saGrille.getTaille() - 1;
		break;
		
		case "haut" :
			retour = positionI == 0;
		break;
		
		case "bas" : 
			retour = positionI == saGrille.getTaille() - 1;
		break;
		}
		return retour;
	}

}
