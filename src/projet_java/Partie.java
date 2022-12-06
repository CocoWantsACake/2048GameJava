package projet_java;

public class Partie {
	private int scoreCourant;
	private FrmJeu saForme;
	private boolean estPerdue;
	private boolean estGagnee;

	public Partie() {
		this.scoreCourant = 0;
	}

	public void initialiserPartieManu() {
		this.initialisationPartie();
	}

	public void initialisationPartie() {
		setScoreCourant(0);
		setEstGagnee(false);
		setEstPerdue(false);
		saForme.initialiserGrille();
	}

	public void augmenterScore(int score) {
		scoreCourant += score;
	}

	public void setEstGagnee(boolean b) {
		estGagnee = b;
	}

	public void setEstPerdue(boolean b) {
		estPerdue = b;
	}

	public void setSaForme(FrmJeu f) {
		saForme = f;
	}

	public void setScoreCourant(int score) {
		scoreCourant = score;
	}

	public boolean getEstGagnee() {
		return estGagnee;
	}

	public boolean getEstPerdue() {
		return estPerdue;
	}

	public FrmJeu getSaForme() {
		return saForme;
	}

	public int getScoreCourant() {
		return scoreCourant;
	}

}
