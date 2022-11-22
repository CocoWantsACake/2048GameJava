package projet_tuteure;

/* ####################################
 * ###   structure de la classe :   ###
 * ####################################
 * import necessaire
 * declaration des attributs
 * constructeur ImageTuile()
 * constructeur ImageTuile(String)
 * constructeur ImageTuile(ImageIcon)
 * ### ---------------------------- ###
 * ###      getters et setters      ###
 * ### ---------------------------- ###
 * fonction getListeTuile() [return ArrayList<URL>]
 * ### ---------------------------- ###
 * ###       autres methodes        ###
 * ### ---------------------------- ###
 * procedure remplirListe()
 * fonction majIcon(int) [return ImageIcon]
 * fonction getIndiceVal(int) [return int]
 */

import java.net.URL;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

class ImageTuile extends JLabel { // clase permettant de definir une image pour une tuile

	// declaration des attributs
	private static final long serialVersionUID = 1L;
	
	private static ArrayList<URL> listeTuile = new ArrayList<>();
	private static int[] listeNum = new int[15];
		
	// constructeurs
	public ImageTuile() {
		if (listeTuile.isEmpty()) {
			remplirListe();
		}
	}
	
	public ImageTuile(String img) {
		this(new ImageIcon(img));
	}

	public ImageTuile(ImageIcon icon) {
	    setIcon(icon);
	    setIconTextGap(0); // permet de ne pas avoir d'espace entre le texte et l'icone (meme si le texte est null)
	    setBorder(null);
	    setText(null);
	    setSize(icon.getImage().getWidth(null), icon.getImage().getHeight(null));
	}
	
	// setters et getters
	public ArrayList<URL> getListeTuile() {
		return listeTuile;
	}
	
	// autres methodes
	private void remplirListe() {
        String chemin;
        String cheminAbsolu = "/images_tuiles/tuile_"; // permet de recuperer le chemin des ressources

        final int NBMUL = 2; // pour multiplier par 2 le nombre present dans l'image
        int nbResul = 2;
        
        // ajout du 0, car on ne peut pas le recuperer avec une puissance de 2
        listeTuile.add(ImageTuile.class.getResource(cheminAbsolu + "0.png"));
        listeNum[0] = 0;
        
        // ajout des autres tuiles
        for (int i = 0; i<13; i++) {
            chemin = cheminAbsolu + nbResul + ".png"; // on ajoute la fin du nom du fichier en fonction de la puissance de 2
            listeTuile.add(ImageTuile.class.getResource(chemin));
            listeNum[i+1] = nbResul;
            nbResul *= NBMUL;
        }
    }

	// met a jour l'image de la tuile
	public ImageIcon majIcon(int val) {
		ImageIcon img = new ImageIcon(listeTuile.get(getIndiceVal(val)));
		return img;
	}
	
	// recupere l'indice du nom de l'image dans la liste listeTuile
	public int getIndiceVal(int i) {
		int ind = 0;
		boolean trouve = false;
		
		while (!trouve && ind<listeNum.length - 1) {
			trouve = listeNum[ind] == i;
			ind++;
		}
		return ind-1;
	}

}
