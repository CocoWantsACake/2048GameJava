package projet_java;

public class UserInteractions {

	private Grille grille;
	
    public UserInteractions(Grille grille) {
        this.grille = grille;
    }

    public boolean checkKey(String direction){
		if(direction.equals("haut") || direction.equals("bas") || direction.equals("gauche") || direction.equals("droite")) {
			this.grille.deplacerTuiles(direction);
			this.grille.ajoutDeuxHasard();
			this.grille.afficherGrille();
			return true;
		} else {
			System.out.println("wrong key input, please either enter 'bas', 'haut', 'gauche', 'droite'.");
			return false;
		}
		
	}
}