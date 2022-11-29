package projet_java;

import java.util.ArrayList;

public class Grille {
	
	private int taille; // taille de la grille 
	private Tuile[][] grille; // tableau contenant toutes les tuiles
	private Partie saPartie; // partie associee a la grille
	
	public Grille(int taille) {
		super();
		this.taille = taille;
		this.grille = new Tuile[taille][taille];
		this.initialiser();
	}
	
    public void initialiserGrille() {
    	for (int i = 0; i<this.taille; i++) {
    		for (int j = 0; j<this.taille; j++) {
        		this.grille[i][j].setValeur(0);
    		}
    	}
    	this.ajoutDeuxHasard();
    	saPartie.setScoreCourant(0);
    }
    
    //Ajoute une tuile 1 ou 2 au hasard dans la grille
    public void ajoutDeuxHasard() {
    	ArrayList<Integer> listeI = new ArrayList<Integer>(); // liste contenant les coordonnees x de toutes les tuiles vides
    	ArrayList<Integer> listeJ = new ArrayList<Integer>(); // listes contenant les coordonnees y de toutes les tuiles vides
    	
    	for (int i=0; i<this.taille; i++) {
    		for (int j=0; j<this.taille; j++) {
        		if (this.grille[i][j].getValeur() == 0){
        			listeI.add(i);
        			listeJ.add(j);
        		}
        	}
    	}
    	
    	int Max = listeI.size();
    	int Min = 0;
    	int valueToSet;
    	
    	if (!listeI.isEmpty()) {
    		if(Math.random()>0.7) {
    			valueToSet = 1;
    		} else {
    			valueToSet = 2;
    		}
        	int nbAleatoire = (int)(Math.random() * (Max - Min));
        	this.grille[listeI.get(nbAleatoire)][listeJ.get(nbAleatoire)].setValeur(valueToSet);
    	} else { 
    		if(saPartie.getEstGagnee()) {
        		System.out.println("Vous ne pouvez plus deplacer de tuiles\nVous allez etre redirige vers l'accueil\nFin de la partie");
    		} else {
    			System.out.println("Vous avez perdu !\nVous allez etre redirige vers l'accueil\nPerdu");
    		}
    		saPartie.setEstPerdue(true);
    		saPartie.setScoreCourant(0);
    	}
    }
    
	public Tuile getTuile(int x, int y) {
		return grille[x][y];
	}
	
	public int getTaille() {
		return this.taille;
	}
	
	public void setSaPartie(Partie p) {
		saPartie = p;
	}
	
	public Partie getSaPartie() {
		return saPartie;
	}
	
	public void initialiser() { // initialise la grille et la remplie de tuiles avec pour valeur 0
		for (int i = 0; i<grille.length; i++) {
			for (int j = 0; j < grille[i].length; j++) {
				this.grille[i][j] = new Tuile(i, j, 0, this);
				grille[i][j].setValeur(0);
			}
		}
	}
	
	public boolean grilleModifiable(String direction) {
		boolean result = false;
		boolean res = false;
		
		for (int i=0; i<taille; i++) {
			for (int j=0; j<taille; j++) {
				this.grille[i][j].setEstDeplacable(direction);
				result = grille[i][j].getEstDeplacable();
				if (result) res = true;
			}
		}	
		result = res;
		return result;
	}
	
	public void reinitialiserDeplacements() {
		for (int i=0; i<taille; i++) {
			for (int j=0; j<taille; j++) {	
				this.grille[i][j].setNbDeplacementsRestants(1);
			}
		}
	}
	
	public void verifGagnee() {
		for (int i=0; i<taille; i++) {
			for (int j=0; j<taille; j++) {	
				if (this.grille[i][j].getValeur() == 2048) {
					saPartie.setEstGagnee(true);
				}
			}
		}
		if(saPartie.getEstGagnee()) {
    		System.out.println("Vous avez atteint la tuile 2048 !\nVous avez gagne !\nContinuez pour obtenir le meilleur score possible !");
		}
	}
	
	public void deplacerTuiles(String direction) {
		while(grilleModifiable(direction)) {
			if (direction == "gauche" || direction == "haut") {
				for (int i=0; i<taille; i++) {
					for (int j=0; j<taille; j++) {
						this.grille[i][j].deplacer(direction);	
					}
				}
			} else {
				for (int i=taille-1; i>-1; i--) {
					for (int j=taille-1; j>-1; j--) {
						this.grille[i][j].deplacer(direction);		
					}
				}
			}
		}
		this.reinitialiserDeplacements();
		
		if (!saPartie.getEstGagnee()) {
			this.verifGagnee();
		}
	}
	
	public void afficherGrille() {
		for(int i=0; i<this.taille;i++) {
			for(int j=0; j<this.taille;j++) {
				System.out.print(this.grille[i][j] + "\t");
			}
			System.out.println();
		}
	}
}