package projet_java;

public class Main {
	public static void main(String[] args) {
		Partie p = new Partie();
		Grille g = new Grille(4);
		g.setSaPartie(p);

		FrmAccueil fenetreA = new FrmAccueil("2048");
		fenetreA.setDefaultCloseOperation(FrmAccueil.EXIT_ON_CLOSE);
		fenetreA.setVisible(true);

		FrmJeu fenetreJ = new FrmJeu("2048", fenetreA, g);
		fenetreJ.setDefaultCloseOperation(FrmJeu.EXIT_ON_CLOSE);
		fenetreA.setSaFrmJeu(fenetreJ);

		p.setSaForme(fenetreJ);
	}
}
