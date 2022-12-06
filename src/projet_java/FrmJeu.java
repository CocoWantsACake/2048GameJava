package projet_java;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class FrmJeu extends javax.swing.JFrame implements KeyListener, ActionListener {
	private static final long serialVersionUID = 1L; // oblige car la classe extends javax.swing.JFrame

	private static final int TAILLE_GRILLE = 4;
	private ImageTuile[][] grille; // tableau contenant toutes les tuiles graphiques
	private Grille saGrille; // grille en version non graphique
	private Partie saPartie;
	private FrmAccueil saFrmAccueil;
	private Boolean ispartie = false;
	private Boolean themeClair = true;

	private javax.swing.JButton btnMenu;
	private javax.swing.JButton btnQuitter;
	private javax.swing.JButton btnRejouer;
	private javax.swing.JButton btnTheme;
	private javax.swing.JPanel pnlGrille;
	private javax.swing.JLabel lblScore;
	private javax.swing.JLabel lblScore2;

	public FrmJeu(String nom, FrmAccueil frm, Grille grille) {
		initComponents();
		this.setName(nom);
		this.setTitle(nom);
		this.saFrmAccueil = frm;
		this.saGrille = grille;
		setTheme("clair");
		this.creerTuiles();
		this.saPartie = saGrille.getSaPartie();
	}

	public FrmJeu(String nom) {
		initComponents();
		this.setName(nom);
	}

	private void setTheme(String s) {
		Color fond;
		Color bouton;
		Color text;
		if (s == "clair") {
			fond = Color.LIGHT_GRAY;
			bouton = new Color(0x34495E);
			themeClair = true;
			text = Color.white;
		} else {
			fond = new Color(0x34495E);
			bouton = Color.LIGHT_GRAY;
			themeClair = false;
			text = Color.black;
		}
		this.getContentPane().setBackground(fond);
		pnlGrille.setBackground(bouton);
		btnMenu.setBackground(bouton);
		btnMenu.setForeground(text);
		btnRejouer.setBackground(bouton);
		btnRejouer.setForeground(text);
		btnTheme.setBackground(bouton);
		btnTheme.setForeground(text);
		lblScore.setForeground(bouton);
		lblScore2.setForeground(bouton);
	}

	private void initComponents() {
		btnRejouer = new javax.swing.JButton();
		btnTheme = new javax.swing.JButton();
		lblScore = new javax.swing.JLabel();
		lblScore2 = new javax.swing.JLabel();
		btnQuitter = new javax.swing.JButton();
		btnMenu = new javax.swing.JButton();
		pnlGrille = new javax.swing.JPanel();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setPreferredSize(new java.awt.Dimension(545, 415));
		setResizable(false);

		btnRejouer.setText("Rejouer");
		btnRejouer.setName("btnRejouer");

		btnTheme.setFont(new java.awt.Font("DejaVu Sans", 0, 10));
		btnTheme.setText("Changer le theme");
		btnTheme.setName("btnTheme");

		lblScore.setFont(new java.awt.Font("DejaVu Sans", 0, 18));
		lblScore.setText("Score :");
		lblScore.setName("lblScore");

		lblScore2.setFont(new java.awt.Font("DejaVu Sans", 0, 18));
		lblScore2.setText("0");
		lblScore2.setName("lblScore2");

		btnQuitter.setText("Quitter");
		btnQuitter.setName("btnQuitter");
		btnQuitter.setForeground(Color.white);
		btnQuitter.setBackground(Color.red);

		btnMenu.setFont(new java.awt.Font("DejaVu Sans", 0, 10));
		btnMenu.setText("Retourner au menu");
		btnMenu.setName("btnMenu");

		btnRejouer.addKeyListener(this);
		btnTheme.addKeyListener(this);
		btnMenu.addKeyListener(this);
		btnQuitter.addKeyListener(this);

		btnMenu.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnMenuActionPerformed(evt);
			}
		});

		btnQuitter.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnQuitterActionPerformed(evt);
			}
		});

		btnRejouer.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnRejouerActionPerformed(evt);
			}
		});

		btnTheme.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnThemeActionPerformed(evt);
			}
		});

		// Le code ci-dessous a ete genere automatiquement grace au concepteur
		// d'interface Java NetBeans
		javax.swing.GroupLayout pnlGrilleLayout = new javax.swing.GroupLayout(pnlGrille);
		pnlGrille.setLayout(pnlGrilleLayout);
		pnlGrilleLayout.setHorizontalGroup(pnlGrilleLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 360, Short.MAX_VALUE));
		pnlGrilleLayout.setVerticalGroup(pnlGrilleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 360, Short.MAX_VALUE));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup()
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
						.createSequentialGroup().addContainerGap()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(lblScore).addComponent(lblScore2, javax.swing.GroupLayout.PREFERRED_SIZE,
										44, javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addComponent(btnMenu, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnQuitter, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnTheme, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnRejouer, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
				.addGap(18, 18, 18).addComponent(pnlGrille, javax.swing.GroupLayout.DEFAULT_SIZE,
						javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addContainerGap()));

		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup().addComponent(btnRejouer)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(btnTheme).addGap(37, 37, 37).addComponent(lblScore)
										.addGap(18, 18, 18).addComponent(lblScore2)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(btnMenu).addGap(10, 10, 10).addComponent(btnQuitter))
								.addGroup(layout.createSequentialGroup().addContainerGap().addComponent(pnlGrille,
										javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)));
		pack();
	}

	private void creerTuiles() {
		pnlGrille.setLayout(new GridLayout(4, 4));
		this.grille = new ImageTuile[TAILLE_GRILLE][TAILLE_GRILLE];
		ImageTuile tuileTmp = new ImageTuile();

		for (int i = 0; i < TAILLE_GRILLE; i++) {
			for (int j = 0; j < TAILLE_GRILLE; j++) {
				ImageTuile tuile = new ImageTuile(new ImageIcon(tuileTmp.getListeTuile().get(0)));
				pnlGrille.add(tuile);
				grille[i][j] = tuile;
			}
		}
	}

	public void initialiserGrille() {
		for (int i = 0; i < TAILLE_GRILLE; i++) {
			for (int j = 0; j < TAILLE_GRILLE; j++) {
				saGrille.setGrille(i, j, 0);
			}
		}
		this.ajoutDeuxHasard();
		saPartie.setScoreCourant(0);
		this.mettreAJour();
	}

	public void mettreAJour() {
		for (int i = 0; i < TAILLE_GRILLE; i++) {
			for (int j = 0; j < TAILLE_GRILLE; j++) {
				grille[i][j].setIcon(grille[i][j].majIcon(saGrille.getTuile(i, j).getValeur()));
				lblScore2.setText(String.valueOf(saPartie.getScoreCourant())); // mise a jour du score version graphique
			}
		}
	}

	static int cont = 0;

	public void ajoutDeuxHasard() {
		if (!saGrille.ajoutDeuxHasard()) {
			if (saPartie.getEstGagnee()) {
				javax.swing.JOptionPane.showMessageDialog(null,
						"Vous ne pouvez plus deplacer de tuiles\nVous allez etre redirige vers l'accueil",
						"Fin de la partie", JOptionPane.OK_OPTION);
			} else {
				javax.swing.JOptionPane.showMessageDialog(null,
						"Vous avez perdu !\nVous allez etre redirige vers l'accueil", "Perdu", JOptionPane.OK_OPTION);
			}

			if (saPartie.getScoreCourant() > saFrmAccueil.getScoreMax()) {
				saFrmAccueil.setScoreMax(saPartie.getScoreCourant());
				saFrmAccueil.setMeilleurScore();
			}
			saPartie.setEstPerdue(true);
			saPartie.setScoreCourant(0);
			saFrmAccueil.setVisible(true);
			setVisible(false);
		}
		cont++;
		this.mettreAJour();
	}

	private void btnMenuActionPerformed(java.awt.event.ActionEvent evt) {
		if (javax.swing.JOptionPane.showConfirmDialog(null,
				"Etes-vous sur de vouloir revenir au menu ? \nLa progression de la partie en cours sera perdue.",
				"Retour au menu", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

			if (saPartie.getScoreCourant() > saFrmAccueil.getScoreMax()) {
				saFrmAccueil.setScoreMax(saPartie.getScoreCourant());
				saFrmAccueil.setMeilleurScore();
			}
			saFrmAccueil.setVisible(true);
			this.setVisible(false);
		}
	}

	private void btnQuitterActionPerformed(java.awt.event.ActionEvent evt) {
		if (javax.swing.JOptionPane.showConfirmDialog(null,
				"Etes-vous sur de vouloir quitter le jeu ? \nToute progression sera perdue.", "Quitter le jeu",
				JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
			saFrmAccueil.dispose();
			this.dispose();
		}
	}

	private void btnRejouerActionPerformed(java.awt.event.ActionEvent evt) {
		if (javax.swing.JOptionPane.showConfirmDialog(null,
				"Etes-vous sur de vouloir recommencer la partie ? \nLa progression de la partie en cours sera perdue.",
				"Recommencer la partie", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
			if (ispartie) {
				saPartie.initialiserPartieManu();
			}
		}
	}

	private void btnThemeActionPerformed(java.awt.event.ActionEvent evt) {
		if (themeClair) {
			setTheme("sombre");
		} else
			setTheme("clair");
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (ispartie) {
			if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				saGrille.deplacerTuiles("bas");
			} else if (e.getKeyCode() == KeyEvent.VK_UP) {
				saGrille.deplacerTuiles("haut");
			} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				saGrille.deplacerTuiles("gauche");
			} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
				saGrille.deplacerTuiles("droite");
			}
			this.ajoutDeuxHasard();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	}

	public void setSaFrmAccueil(FrmAccueil fA) {
		saFrmAccueil = fA;
	}

	public void setIspartie(Boolean b) {
		ispartie = b;
	}

	public boolean getIspartie() {
		return ispartie;
	}

	public Partie getSaPartie() {
		return saPartie;
	}

	public Grille getSaGrille() {
		return saGrille;
	}
}
