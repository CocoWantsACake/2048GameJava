package projet_java;

public class Partie {
	
	private int scoreCourant;
	private UserInteractions userInterface;
	private boolean estPerdue;
	private boolean estGagnee;
	
	public Partie() {
		this.scoreCourant = 0;
	}
	
	public void setScoreCourant(int score) {
		scoreCourant = score;
	}
	
	public int getScoreCourant() {
		return scoreCourant;
	}
	
	public void setUserInterface(UserInteractions f) {
		userInterface = f;
	}
	
	public UserInteractions getUserInterface() {
		return userInterface;
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
	
	public void augmenterScore(int score) {
		scoreCourant += score;
	}
	
}
