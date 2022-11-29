package projet_java;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);  
		Partie p = new Partie();
		Grille g = new Grille(4);
		UserInteractions um = new UserInteractions(g);
		String input;
		p.setUserInterface(um);
		g.setSaPartie(p);
		
		while(true) {
			System.out.println("Give a direction such as haut, gauche, bas, droite.");
			input = s.nextLine();
			boolean res = p.getUserInterface().checkKey(input);
			System.out.println("did it go good?" + res);
			if(p.getEstPerdue() || p.getEstGagnee()) {
				break;
			}
		}
		s.close();
	}
}
