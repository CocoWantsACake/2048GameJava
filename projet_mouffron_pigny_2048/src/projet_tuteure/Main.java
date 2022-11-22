package projet_tuteure;

public class Main {

	public static void main(String[] args) {
		
		// declaration et initialisation de la partie
		Partie p = new Partie();
		
		// declaration et initialisation de la grille du jeu
		Grille g = new Grille(4);
		g.setSaPartie(p);
		
		// declaration et initialisation de la fenetre d'accueil
        FrmAccueil fenetreA = new FrmAccueil ("2048");
        fenetreA.setDefaultCloseOperation(FrmAccueil.EXIT_ON_CLOSE);
        fenetreA.setVisible(true);
        
        // declaration et initialisation de la fenetre de jeu
        FrmJeu fenetreJ = new FrmJeu ("2048", fenetreA, g);
        fenetreJ.setDefaultCloseOperation(FrmJeu.EXIT_ON_CLOSE);
        fenetreA.setSaFrmJeu(fenetreJ);
        
        // attribution de la FrmJeu aux classes qui en ont besoin
        g.setSaForme(fenetreJ);
        p.setSaForme(fenetreJ);
        
	}
}
