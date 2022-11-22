package projet_tuteure;

/* ####################################
 * ###   structure de la classe :   ###
 * ####################################
 * import necessaire
 * declaration des attributs
 * constructeur Grille(int)
 * ### ---------------------------- ###
 * ###      getters et setters      ###
 * ### ---------------------------- ###
 * procedure setSaForme(FrmJeu)
 * fonction getSaForme() [return FrmJeu]
 * fonction getTuile(int, int) [return Tuile]
 * procedure setGrille(int, int, int)
 * fonction getTaille() [return int]
 * procedure setSaPartie(Partie)
 * fonction getSaPartie() [return Partie]
 * ### ---------------------------- ###
 * ###       autres methodes        ###
 * ### ---------------------------- ###
 * procedure initialiser()
 * fonction grilleModifiable(String)
 * procedure reinitialiserDeplacements()
 * procedure verifGagnee()
 * procedure deplacerTuiles(String)
 */

import javax.swing.JOptionPane;

public class Grille {
	
	private int taille; // taille de la grille 
	private Tuile[][] grille; // tableau contenant toutes les tuiles
	private FrmJeu saForme; // FrmJeu associee a la grille
	private Partie saPartie; // partie associee a la grille
	
	// Constructeur
	public Grille(int taille) {
		super();
		this.taille = taille;
		this.grille = new Tuile[taille][taille];
		this.initialiser();
	}
	
	// getters et setters
	public void setSaForme(FrmJeu f) {
		saForme = f;
	}
	
	public FrmJeu getSaForme() {
		return saForme;
	}
	
	public Tuile getTuile(int x, int y) {
		return grille[x][y];
	}
	
	public void setGrille(int x, int y, int valeur) {
		this.grille[x][y].setValeur(valeur);
	}
		
	public int getTaille() {
		return taille;
	}
	
	public void setSaPartie(Partie p) {
		saPartie = p;
	}
	
	public Partie getSaPartie() {
		return saPartie;
	}
	
	// autres methodes
	public void initialiser() { // initialise la grille et la remplie de tuiles avec pour valeur 0
		for (int i = 0; i<grille.length; i++) {
			for (int j = 0; j < grille[i].length; j++) {
				this.grille[i][j] = new Tuile(i, j, 0, this);
				grille[i][j].setValeur(0);
			}
		}
	}
	
	// retourne true s'il y a des tuiles qui peuvent etre deplacees
	public boolean grilleModifiable(String direction) {
		boolean result = false;
		boolean res = false;
		
		for (int i=0; i<taille; i++) {
			for (int j=0; j<taille; j++) {
				this.getTuile(i, j).setEstDeplacable(direction);
				result = grille[i][j].getEstDeplacable();
				if (result) res = true;
			}
		}	
		result = res;
		return result;
	}
	
	// permet de remettre le nombre de deplacements possibles pour une tuile a 1
	public void reinitialiserDeplacements() {
		for (int i=0; i<taille; i++) {
			for (int j=0; j<taille; j++) {	
				this.getTuile(i, j).setNbDeplacementsRestants(1);
			}
		}
	}
	
	// verifie si le joueur a atteint la tuile 2048
	public void verifGagnee() {
		for (int i=0; i<taille; i++) {
			for (int j=0; j<taille; j++) {	
				if (this.getTuile(i, j).getValeur() == 2048) {
					saPartie.setEstGagnee(true);
				}
			}
		}
		if(saPartie.getEstGagnee()) {
    		javax.swing.JOptionPane.showMessageDialog(null,"Vous avez atteint la tuile 2048 !\nVous avez gagne !\nContinuez pour obtenir le meilleur score possible !", "Felicitations !!", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	public void deplacerTuiles(String direction) {
		while(grilleModifiable(direction)) {
			// si le deplacement est vers la gauche ou le haut, on parcours la grille dans le sens normal
			if (direction == "gauche" || direction == "haut") {
				for (int i=0; i<taille; i++) {
					for (int j=0; j<taille; j++) {
						this.getTuile(i, j).deplacer(direction);	
					}
				}
			}
			// sinon, on la parcours a l'envers, pour permettre de faire les additions de tuiles dans le bon ordre
			else {
				for (int i=taille-1; i>-1; i--) {
					for (int j=taille-1; j>-1; j--) {
						this.getTuile(i, j).deplacer(direction);		
					}
				}
			}
			saForme.mettreAJour();
		}
		// une fois toutes les tuiles deplacees, on remet leur nombre de deplacement a 1
		this.reinitialiserDeplacements();
		
		if (! saPartie.getEstGagnee()) {
			this.verifGagnee();
		}
	}

}
