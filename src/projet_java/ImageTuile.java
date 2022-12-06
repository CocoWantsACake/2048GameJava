package projet_java;

import java.net.URL;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

class ImageTuile extends JLabel {
	private static final long serialVersionUID = 1L;

	private static ArrayList<URL> listeTuile = new ArrayList<>();
	private static int[] listeNum = new int[15];

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
		setIconTextGap(0);
		setBorder(null);
		setText(null);
		setSize(icon.getImage().getWidth(null), icon.getImage().getHeight(null));
	}

	public ArrayList<URL> getListeTuile() {
		return listeTuile;
	}

	private void remplirListe() {
		String chemin;
		String cheminAbsolu = "/projet_java/images_tuiles/tuile_";

		final int NBMUL = 2;
		int nbResul = 2;

		listeTuile.add(ImageTuile.class.getResource(cheminAbsolu + "0.png"));
		listeNum[0] = 0;

		for (int i = 0; i < 13; i++) {
			chemin = cheminAbsolu + nbResul + ".png";
			listeTuile.add(ImageTuile.class.getResource(chemin));
			listeNum[i + 1] = nbResul;
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

		while (!trouve && ind < listeNum.length - 1) {
			trouve = listeNum[ind] == i;
			ind++;
		}
		return ind - 1;
	}

}
