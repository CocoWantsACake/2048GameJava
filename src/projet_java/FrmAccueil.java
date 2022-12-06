package projet_java;

import javax.swing.JOptionPane;

public class FrmAccueil extends javax.swing.JFrame {
	private static final long serialVersionUID = 1L;

	private FrmJeu saFrmJeu;
	private int scoreMax = 0;

	private javax.swing.JButton btnpartie;
	private javax.swing.JButton btnQuitter;
	private javax.swing.JLabel lblMeilleurScore;
	private javax.swing.JLabel lblScore;

	public FrmAccueil(String nom, FrmJeu fJ) {
		initComponents();
		this.setName(nom);
		this.setTitle(nom);
		saFrmJeu = fJ;
	}

	public FrmAccueil(String nom) {
		initComponents();
		this.setName(nom);
		this.setTitle(nom);
	}

	public void setScoreMax(int scoreMax) {
		this.scoreMax = scoreMax;
	}

	public int getScoreMax() {
		return scoreMax;
	}

	public void setSaFrmJeu(FrmJeu fJ) {
		saFrmJeu = fJ;
	}

	public void setMeilleurScore() {
		lblScore.setText("" + scoreMax);
	}

	private void initComponents() {
		lblMeilleurScore = new javax.swing.JLabel();
		btnpartie = new javax.swing.JButton();
		btnQuitter = new javax.swing.JButton();
		lblScore = new javax.swing.JLabel();

		setResizable(false);
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		lblMeilleurScore.setFont(new java.awt.Font("DejaVu Sans", 0, 24));
		lblMeilleurScore.setText("Meilleur Score :");
		lblMeilleurScore.setName("lblMeilleurScore");

		btnpartie.setText("Commencer une partie");
		btnpartie.setName("btnpartie");

		btnQuitter.setText("Quitter");
		btnQuitter.setName("btnQuitter");

		lblScore.setFont(new java.awt.Font("DejaVu Sans", 0, 24));
		lblScore.setText("0");
		lblScore.setName("lblScore");

		btnQuitter.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnQuitterActionPerformed(evt);
			}
		});

		btnpartie.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnpartieActionPerformed(evt);
			}
		});

		// Le code ci-dessous a ete genere automatiquement grace au concepteur
		// d'interfaces Java NetBeans
		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup()
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup().addGap(40, 40, 40).addComponent(lblMeilleurScore)
								.addGap(18, 18, 18).addComponent(lblScore))
						.addGroup(layout.createSequentialGroup().addGap(146, 146, 146)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
										.addComponent(btnpartie, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(btnQuitter, javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
				.addContainerGap(25, Short.MAX_VALUE)));

		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(48, 48, 48)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(lblMeilleurScore).addComponent(lblScore))
						.addGap(68, 68, 68).addGap(62, 62, 62).addComponent(btnpartie)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
						.addComponent(btnQuitter).addGap(38, 38, 38)));
		pack();
	}

	private void btnQuitterActionPerformed(java.awt.event.ActionEvent evt) {
		if (javax.swing.JOptionPane.showConfirmDialog(null,
				"Etes-vous sur de vouloir quitter le jeu ? \nToute progression sera perdue.", "Quitter le jeu",
				JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
			saFrmJeu.dispose();
			this.dispose();
		}
	}

	private void btnpartieActionPerformed(java.awt.event.ActionEvent evt) {
		saFrmJeu.setVisible(true);
		this.setVisible(false);
		saFrmJeu.setIspartie(true);
		saFrmJeu.getSaPartie().initialiserPartieManu();
	}

}
