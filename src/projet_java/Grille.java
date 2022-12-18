package projet_java;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Grille {
	/*
	 * A l'écran, la tuile la plus en haut à droite a la coordonnée i=0 et j=3
	 * l'inverse, la tuile la plus en haut à gauche aura la coordonnée i=0 et j=0
	 */
	private int taille;
	private Tuile[][] grille;
	private Partie saPartie;
	private int first = 0;

	public Grille(int taille) {
		super();
		this.taille = taille;
		this.grille = new Tuile[taille][taille];
		this.initialiser();
	}

	public void initialiser() {
		for (int i = 0; i < grille.length; i++) {
			for (int j = 0; j < grille[i].length; j++) {
				this.grille[i][j] = new Tuile(i, j, 0, this);
				grille[i][j].setValeur(0);
			}
		}
	}

	public boolean ajoutDeuxHasard() {
		ArrayList<Integer> listeI = new ArrayList<Integer>();
		ArrayList<Integer> listeJ = new ArrayList<Integer>();
		for (int i = 0; i < this.taille; i++) {
			for (int j = 0; j < this.taille; j++) {
				if (this.grille[i][j].getValeur() == 0) {
					listeI.add(i);
					listeJ.add(j);
				}
			}
		}
		int Max = listeI.size();
		int Min = 0;
		int valueToSet;

		if (listeI.isEmpty()) {
			return grilleModifiableAllDir();
		}

		valueToSet = Math.random() > 0.7 ? 2 : 4;
		int nbAleatoire = (int) (Math.random() * (Max - Min));
		// TO REMOVE
		if (this.first < 2) {
			valueToSet = 1024;
			this.first = this.first + 1;
		}
		this.grille[listeI.get(nbAleatoire)][listeJ.get(nbAleatoire)].setValeur(valueToSet);
		return true;
	}

	// Vérifie si la grille peut être modifiée dans n'importe quelle direction.
	// Utilisé pour vérifier simplement,
	// lorsque la grille est entièrement remplie, s'il reste des combinaisons
	// possibles.
	public boolean grilleModifiableAllDir() {
		for (int i = 0; i < this.taille; i++) {
			for (int j = 0; j < this.taille; j++) {
				Tuile temp = this.grille[i][j];
				temp.setEstDeplacable("haut");
				if (temp.getEstDeplacable()) {
					return true;
				}
				temp.setEstDeplacable("bas");
				if (temp.getEstDeplacable()) {
					return true;
				}
				temp.setEstDeplacable("gauche");
				if (temp.getEstDeplacable()) {
					return true;
				}
				temp.setEstDeplacable("droite");
				if (temp.getEstDeplacable()) {
					return true;
				}
			}
		}
		return false;
	}

	// Vérifie si le mouvement souhaité (indiqué par "direction") est faisable.
	public boolean grilleModifiable(String direction) {
		boolean result = false;
		for (int i = 0; i < taille; i++) {
			for (int j = 0; j < taille; j++) {
				this.grille[i][j].setEstDeplacable(direction);
				result = grille[i][j].getEstDeplacable();
				if (result) {
					return result;
				}
			}
		}
		return result;
	}

	public void deplacerTuiles(String direction) {
		while (grilleModifiable(direction)) {
			if (direction == "gauche" || direction == "haut") {
				for (int i = 0; i < taille; i++) {
					for (int j = 0; j < taille; j++) {
						this.grille[i][j].deplacer(direction);
					}
				}
			} else {
				for (int i = taille - 1; i > -1; i--) {
					for (int j = taille - 1; j > -1; j--) {
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

	public void reinitialiserDeplacements() {
		for (int i = 0; i < taille; i++) {
			for (int j = 0; j < taille; j++) {
				this.grille[i][j].setNbDeplacementsRestants(1);
			}
		}
	}

	public void verifGagnee() {
		for (int i = 0; i < taille; i++) {
			for (int j = 0; j < taille; j++) {
				if (this.grille[i][j].getValeur() == 2048) {
					saPartie.setEstGagnee(true);
				}
			}
		}
		if (saPartie.getEstGagnee()) {
			javax.swing.JOptionPane.showMessageDialog(null,"Vous avez gagné! Continuez de jouer pour améliorer votre score!", "", JOptionPane.INFORMATION_MESSAGE);
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

	public void setGrille(int x, int y, int valeur) {
		this.grille[x][y].setValeur(valeur);
	}
}