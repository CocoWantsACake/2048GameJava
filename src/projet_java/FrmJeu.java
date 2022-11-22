package projet_java;

/* ####################################
 * ###   structure de la classe :   ###
 * ####################################
 * imports necessaires
 * declaration des attributs et des composants
 * constructeur FrmJeu(String, FrmAccueil, Grille)
 * constructeur FrmJeu(String)
 * ### ---------------------------- ###
 * ###      getters et setters      ###
 * ### ---------------------------- ###
 * procedure setSaFrmAccueil(FrmAccueil)
 * procedure setIspartie(Boolean)
 * fonction getIspartie() [return boolean]
 * fonction getSaPartie() [return Partie]
 * fonction getSaGrille() [return Grille]
 * procedure setTimer(Timer)
 * fonction getTimer() [return Timer]
 * procedure setTheme(String)
 * ### ---------------------------- ###
 * ###       autres methodes        ###
 * ### ---------------------------- ###
 * procedure initComponents()
 * procedure actionPerformed(ActionEvent) // action du timer
 * procedure creerTuiles()
 * procedure initialiserGrille()
 * procedure mettreAJour()
 * fonction listeTuilesDisponibles(String) [return ArrayList<Integer>]
 * procedure ajoutDeuxHasard()
 * procedure btnMenuActionPerformed(java.awt.event.ActionEvent)
 * procedure btnQuitterActionPerformed(java.awt.event.ActionEvent)
 * procedure btnRejouerActionPerformed(java.awt.event.ActionEvent)
 * procedure btnModeActionPerformed(java.awt.event.ActionEvent)
 * procedure btnThemeActionPerformed(java.awt.event.ActionEvent)
 * procedure keyPressed(KeyEvent)
 * procedure keyReleased(KeyEvent) // inutile 
 * procedure keyTyped(KeyEvent) // inutile
 */

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.Timer;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class FrmJeu extends javax.swing.JFrame implements KeyListener, ActionListener {
	
	// declaration des attributs
	private static final long serialVersionUID = 1L; // oblige car la classe extends javax.swing.JFrame
	
	private static final int TAILLE_GRILLE = 4;
	private ImageTuile[][] grille; // tableau contenant toutes les tuiles graphiques
	private Grille saGrille; // grille en version non graphique
	private Partie saPartie;
	private FrmAccueil saFrmAccueil; 
    private Boolean ispartie = false;
    private Boolean themeClair = true;
    private Timer timer; // permet les deplacements de l'algorithme d'automatisation
	
    // declaration des composants
    private javax.swing.JButton btnMenu;
    private javax.swing.JButton btnMode;
    private javax.swing.JButton btnQuitter;
    private javax.swing.JButton btnRejouer;
    private javax.swing.JButton btnTheme;
    private javax.swing.JPanel pnlGrille;
    private javax.swing.JLabel lblScore;
    private javax.swing.JLabel lblScore2;
	
	// Constructeurs
    public FrmJeu(String nom, FrmAccueil frm, Grille grille) {
        initComponents();
        this.setName(nom);
        this.setTitle(nom);
        this.saFrmAccueil = frm;
        this.saGrille = grille;
        setTheme("clair");
        this.creerTuiles();
        this.saPartie = saGrille.getSaPartie();
        this.timer = new Timer(1000, this);
    }
    
    public FrmJeu(String nom) {
        initComponents();
        this.setName(nom);
      }
    
    //setters et getters
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
    
    public void setTimer(Timer timer) {
    	this.timer = timer;
    }
    
    public Timer getTimer() {
    	return timer;
    }
    
    //changer le theme - couleurs
    private void setTheme(String s) {
    	Color fond;
    	Color bouton;
    	Color text;
    	if (s == "clair") {
    		fond = Color.LIGHT_GRAY;
    		bouton = new Color(0x34495E);
    		themeClair = true;
    		text = Color.white;
    	}
    	else {
    		fond = new Color(0x34495E);
    		bouton = Color.LIGHT_GRAY;
    		themeClair = false;
    		text = Color.black;
    	}
    	this.getContentPane().setBackground(fond);
    	pnlGrille.setBackground(bouton);
    	btnMenu.setBackground(bouton);
    	btnMenu.setForeground(text);
    	btnMode.setBackground(bouton);
    	btnMode.setForeground(text);
    	btnRejouer.setBackground(bouton);
    	btnRejouer.setForeground(text);
    	btnTheme.setBackground(bouton);
    	btnTheme.setForeground(text);
    	lblScore.setForeground(bouton);
    	lblScore2.setForeground(bouton);
    }
    
    // autres methodes
    private void initComponents() { // procedure appelee par le constructeur pour initialiser la form

    	// initialisation de tous les composants 
        btnRejouer = new javax.swing.JButton();
        btnMode = new javax.swing.JButton();
        btnTheme = new javax.swing.JButton();
        lblScore = new javax.swing.JLabel();
        lblScore2 = new javax.swing.JLabel();
        btnQuitter = new javax.swing.JButton();
        btnMenu = new javax.swing.JButton();
        pnlGrille = new javax.swing.JPanel();

        // defini l'operation qui permet la fermeture de l'application
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        
        // defini une taille pour la fenetre
        setPreferredSize(new java.awt.Dimension(545, 415));
        setResizable(false);
        
        // mise en forme des differents composants
        btnRejouer.setText("Rejouer");
        btnRejouer.setName("btnRejouer"); 

        btnMode.setFont(new java.awt.Font("DejaVu Sans", 0, 10)); 
        btnMode.setText("Changer de mode");
        btnMode.setToolTipText("");
        btnMode.setName("btnMode"); 

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
        
        // permet de ne jamais perdre le focus lors de l'appui sur une fleche
        btnRejouer.addKeyListener(this);
        btnMode.addKeyListener(this);
        btnTheme.addKeyListener(this);
        btnMenu.addKeyListener(this);
        btnQuitter.addKeyListener(this);
        
        // ajout de listener sur les boutons 
        btnMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuActionPerformed(evt);
            }
        });
        
        btnQuitter.addActionListener(new java.awt.event.ActionListener() {
	        public void actionPerformed(java.awt.event.ActionEvent evt) {
	            btnQuitterActionPerformed(evt);
	        }
        });
        
        btnRejouer.addActionListener(new java.awt.event.ActionListener() {
	        public void actionPerformed(java.awt.event.ActionEvent evt) {
					btnRejouerActionPerformed(evt);
	        }
        });
        
        btnMode.addActionListener(new java.awt.event.ActionListener() {
	        public void actionPerformed(java.awt.event.ActionEvent evt) {
					btnModeActionPerformed(evt);
	        }
        });
        
        btnTheme.addActionListener(new java.awt.event.ActionListener() {
	        public void actionPerformed(java.awt.event.ActionEvent evt) {
	            btnThemeActionPerformed(evt);
	        }
        });
        
        //Le code ci-dessous a ete genere automatiquement grace au concepteur d'interface Java NetBeans
        javax.swing.GroupLayout pnlGrilleLayout = new javax.swing.GroupLayout(pnlGrille);
        pnlGrille.setLayout(pnlGrilleLayout);
        pnlGrilleLayout.setHorizontalGroup(
        		pnlGrilleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 360, Short.MAX_VALUE)
        );
        pnlGrilleLayout.setVerticalGroup(
        		pnlGrilleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 360, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblScore)
                            .addComponent(lblScore2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnQuitter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnTheme, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnMode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRejouer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(pnlGrille, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
		layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnRejouer)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnMode)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnTheme)
                        .addGap(37, 37, 37)
                        .addComponent(lblScore)
                        .addGap(18, 18, 18)
                        .addComponent(lblScore2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnMenu)
                        .addGap(10, 10, 10)
                        .addComponent(btnQuitter))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pnlGrille, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                )
        );

        pack(); // fait partie de la classe mere, permet de laisser les elements de la form choisir leur taille.
    }
    
    // methode qui initialise toutes les tuiles graphiques
    private void creerTuiles() {
    	pnlGrille.setLayout(new GridLayout(4, 4));
    	this.grille = new ImageTuile[TAILLE_GRILLE][TAILLE_GRILLE];
		ImageTuile tuileTmp = new ImageTuile(); // creation d'une ImageTuile temporaire pour recuperer les images
    	
		// affectation de l'image de la tuile vide sur a toutes les tuiles de la grille
		for (int i = 0; i<TAILLE_GRILLE; i++) {
    		for (int j = 0; j<TAILLE_GRILLE; j++) {
    			ImageTuile tuile = new ImageTuile(new ImageIcon(tuileTmp.getListeTuile().get(0)));
    			pnlGrille.add(tuile);
                grille[i][j] = tuile;
    		}
    	}
    }
    
    // methode qui initialise les tuiles de la grille non graphique
    public void initialiserGrille() {
    	for (int i = 0; i<TAILLE_GRILLE; i++) {
    		for (int j = 0; j<TAILLE_GRILLE; j++) {
        		saGrille.setGrille(i, j, 0);
    		}
    	}
    	this.ajoutDeuxHasard();
    	saPartie.setScoreCourant(0);
    	this.mettreAJour();
    }
    
 // met a jour la grille graphique en fonction de la grille non graphique appele dans le fichier Grille.java
    public void mettreAJour() {
    	for (int i = 0; i<TAILLE_GRILLE; i++) {
    		for (int j = 0; j<TAILLE_GRILLE; j++) {
    			grille[i][j].setIcon(grille[i][j].majIcon(saGrille.getTuile(i, j).getValeur()));
    			lblScore2.setText(String.valueOf(saPartie.getScoreCourant())); // mise a jour du score version graphique
    		}
    	}
    }
    
    public ArrayList<Integer> listeTuilesDisponibles(String choix) {
    	
    	ArrayList<Integer> listeI = new ArrayList<>(); // liste contenant les coordonnees x de toutes les tuiles vides
    	ArrayList<Integer> listeJ = new ArrayList<>(); // listes contenant les coordonnees y de toutes les tuiles vides
    	
    	for (int i=0; i<TAILLE_GRILLE; i++) {
    		for (int j=0; j<TAILLE_GRILLE; j++) {
        		if (saGrille.getTuile(i, j).getValeur() == 0){
        			listeI.add(i);
        			listeJ.add(j);
        		}
        	}
    	}
    	if (choix == "i") {
    		return listeI;
    	}
    	else {
    		return listeJ;
    	}	
    }
    
    public void ajoutDeuxHasard() { // ajoute un 2 au hasard dans la grille
    	// on ajoute dans les deux listes ci-dessous toutes les coordonnees des cases disponibles
    	ArrayList<Integer> iDispo = listeTuilesDisponibles("i"); // liste contenant les coordonnees x de toutes les tuiles vides
    	ArrayList<Integer> jDispo = listeTuilesDisponibles("j"); // listes contenant les coordonnees y de toutes les tuiles vides
    	
    	int Max = iDispo.size();
    	int Min = 0;
    	
    	if (! iDispo.isEmpty()) { // on verifie qu'il reste des tuiles vides
        	int nbAleatoire = (int)(Math.random() * (Max - Min));
        	saGrille.getTuile(iDispo.get(nbAleatoire), jDispo.get(nbAleatoire)).setValeur(2);
    	}
    	else { // la partie est perdue, on le signal au joueur qui doit retourner a l'accueil
    		if(saPartie.getEstGagnee()) {
        		javax.swing.JOptionPane.showMessageDialog(null,"Vous ne pouvez plus deplacer de tuiles\nVous allez etre redirige vers l'accueil", "Fin de la partie", JOptionPane.OK_OPTION);
    		}
    		else {
        		javax.swing.JOptionPane.showMessageDialog(null,"Vous avez perdu !\nVous allez etre redirige vers l'accueil", "Perdu", JOptionPane.OK_OPTION);
    		}
    		
    		// on change le meilleur score s'il est meilleur que le precedent
        	if (saPartie.getScoreCourant() > saFrmAccueil.getScoreMax()) {
        		saFrmAccueil.setScoreMax(saPartie.getScoreCourant());
        		saFrmAccueil.setMeilleurScore();
        	}
    		saPartie.setEstPerdue(true);
    		saPartie.setScoreCourant(0);
        	saFrmAccueil.setVisible(true);
            this.setVisible(false);
            timer.stop();		
    	}
    	this.mettreAJour();
    }
    
    // fonction/procedures pour la gestion des actions 
    private void btnMenuActionPerformed(java.awt.event.ActionEvent evt) {
    	timer.stop();
    	if (javax.swing.JOptionPane.showConfirmDialog(null,"Etes-vous sur de vouloir revenir au menu ? \nLa progression de la partie en cours sera perdue.", "Retour au menu", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
    		
    		// on change le meilleur score s'il est meilleur que le precedent
    		if (saPartie.getScoreCourant() > saFrmAccueil.getScoreMax()) {
    			saFrmAccueil.setScoreMax(saPartie.getScoreCourant());
    			saFrmAccueil.setMeilleurScore();
    		}
    		saFrmAccueil.setVisible(true);
    		this.setVisible(false);
    	}
    	else {
    		if (!ispartie) timer.start();
    	}
    }
    
    private void btnQuitterActionPerformed(java.awt.event.ActionEvent evt) {
    	timer.stop();
    	if (javax.swing.JOptionPane.showConfirmDialog(null,"Etes-vous sur de vouloir quitter le jeu ? \nToute progression sera perdue.", "Quitter le jeu", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
    		saFrmAccueil.dispose();
    		this.dispose();
    	}
    	else {
    		if (!ispartie) timer.start();
    	}
    }
    
    private void btnRejouerActionPerformed(java.awt.event.ActionEvent evt) {
    	timer.stop();
    	if (javax.swing.JOptionPane.showConfirmDialog(null,"Etes-vous sur de vouloir recommencer la partie ? \nLa progression de la partie en cours sera perdue.", "Recommencer la partie", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
    		if (ispartie) {
    			saPartie.initialiserPartieManu();
    		}
    		else {
    			timer.start();
    		}
		}
    	else {
    		if (!ispartie) timer.start();
    	}
    }
    
    private void btnModeActionPerformed(java.awt.event.ActionEvent evt) {
		if (ispartie) {
			ispartie = false;
			timer.start();
		}
		else {
			ispartie = true;
			timer.stop();
		}
    }
    
    private void btnThemeActionPerformed(java.awt.event.ActionEvent evt) {
		if (themeClair) {
			setTheme("sombre");
		}
		else setTheme("clair");
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (ispartie) {
			if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				saGrille.deplacerTuiles("bas");
			}
			else if (e.getKeyCode() == KeyEvent.VK_UP) {
				saGrille.deplacerTuiles("haut");
			}
			else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				saGrille.deplacerTuiles("gauche");
			}
			else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
				saGrille.deplacerTuiles("droite");
			}
			this.ajoutDeuxHasard();	
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
