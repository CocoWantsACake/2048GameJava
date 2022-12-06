package projet_java;

public class Partie {

	// attributs
	private int scoreCourant;
	private FrmJeu saForme;
	private boolean estPerdue;
	private boolean estGagnee;

	// constructeur
	public Partie() {
		this.scoreCourant = 0;
	}

	// setters et getters
	public void setScoreCourant(int score) {
		scoreCourant = score;
	}

	public int getScoreCourant() {
		return scoreCourant;
	}

	public void setSaForme(FrmJeu f) {
		saForme = f;
	}

	public FrmJeu getSaForme() {
		return saForme;
	}

	public void setEstPerdue(boolean b) {
		estPerdue = b;
	}

	public boolean getEstPerdue() {
		return estPerdue;
	}

	public void setEstGagnee(boolean b) {
		estGagnee = b;
	}

	public boolean getEstGagnee() {
		return estGagnee;
	}

	// autres methodes
	public void initialisationPartie() {
		setScoreCourant(0);
		setEstGagnee(false);
		setEstPerdue(false);
		saForme.initialiserGrille();
	}

	public void initialiserPartieManu() {
		this.initialisationPartie();
	}

	public void augmenterScore(int score) {
		scoreCourant += score;
	}

}
