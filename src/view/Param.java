package view;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.border.LineBorder;
import javax.swing.text.AbstractDocument;

import Controller.ControllParam;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;

import Model.Jeu;
import Model.Nom;
import Model.NomDeZone;
import Model.Player;
import Model.Strategie;
import Model.Student;


/**
 * Classe Param, permet de définir les différentes caractéristiques des étudiants, 
 * la zone dans laquel ils seront et leur stratégie.
 * @author Noe Lecointe
 * @author Wang Zezhong
 */
public class Param {

	private JFrame frame;
	private JTextField pointsRestant;
	private JLabel imgStudent;
	private JTextArea txtForce;
	private JTextField valForce;
	private JTextArea txtDext;
	private JTextField valDext;
	private JTextArea txtRes;
	private JTextField valRes;
	private JTextField valIni;
	private JTextArea txtIni;
	private JTextArea txtConst;
	private JTextField valConst;
	private JTextArea txtStrat;
	private JTextArea playerPseudo;
	private JComboBox<Strategie> strat;
	private JComboBox<String> typeS;
	private JComboBox<Nom> nomStudent;
	private JCheckBox reserviste;
	private JTextField txtForceVal;
	private JTextField txtDextVal;
	private JTextField txtResVal;
	private JTextField txtConstVal;
	private JTextField txtIniVal;
	private JTextField txtErrorIni;
	private JTextField txtErrorConst;
	private JTextField txtErrorForce;
	private JTextField txtErrorDext;
	private JTextField txtErrorRes;
	private JTextField txtErrorPtnRestant;
	private JComboBox<NomDeZone> affectZone;
	
	private ControllParam controller;

	
	private String pseudo;
	private Player p;
	private Jeu j;
	

	
	

	/**
	 * Création la classe
	 * @param frame La frame utilisée
	 * @param jeu L'instance de Jeu actuellement en cours
	 * @param idJ L'id du joueur actuel.
	 */
	public Param(JFrame frame, Jeu jeu, int idJ) {
		this.j = jeu;		
		if(idJ == 1) {
			this.p = this.j.player1;
		} else if (idJ == 2) {
			this.p = this.j.player2;
		}
		
		if(this.p.listS.size() == 0) {			
			this.p.creerStudents();
		}

		this.pseudo = this.p.getName();
		
		this.frame = frame;
		initialize();
	}

	
	/**
	 * Reprend la frame de la page d'avant, enlève tout et repaint la frame.
	 */
	private void initialize() {
		frame.getContentPane().removeAll();
		
		Student s = p.getStudent("Jack");
		if (this.p == this.j.player2) {
			s = p.getStudent("Hippolyte");
		}
		
		JTextArea txtrPointsRestant = new JTextArea();
		txtrPointsRestant.setEditable(false);
		txtrPointsRestant.setText("Points restant :");
		txtrPointsRestant.setFont(new Font("Arial", Font.PLAIN, 15));
		txtrPointsRestant.setBounds(227, 136, 102, 22);
		frame.getContentPane().add(txtrPointsRestant);
		
		pointsRestant = new JTextField();
		pointsRestant.setHorizontalAlignment(SwingConstants.CENTER);
		pointsRestant.setText(String.valueOf(this.p.getPoints()));
		pointsRestant.setFont(new Font("Arial", Font.PLAIN, 15));
		pointsRestant.setEditable(false);
		pointsRestant.setBounds(328, 137, 62, 20);
		frame.getContentPane().add(pointsRestant);
		pointsRestant.setColumns(10);
		
		txtErrorPtnRestant = new JTextField();
		txtErrorPtnRestant.setForeground(new Color(255, 0, 0));
		txtErrorPtnRestant.setBorder(null);
		txtErrorPtnRestant.setBackground(new Color(255, 255, 255));
		txtErrorPtnRestant.setEditable(false);
		txtErrorPtnRestant.setFont(new Font("Arial", Font.PLAIN, 12));
		txtErrorPtnRestant.setHorizontalAlignment(SwingConstants.LEFT);
		txtErrorPtnRestant.setBounds(400, 136, 150, 20);
		frame.getContentPane().add(txtErrorPtnRestant);
		txtErrorPtnRestant.setColumns(10);
		
		txtForce = new JTextArea();
		txtForce.setText("Force");
		txtForce.setFont(new Font("Arial", Font.PLAIN, 15));
		txtForce.setEditable(false);
		txtForce.setBounds(289, 187, 43, 22);
		frame.getContentPane().add(txtForce);
		
		txtForceVal = new JTextField();
		txtForceVal.setHorizontalAlignment(SwingConstants.CENTER);
		txtForceVal.setText(String.valueOf(s.getForce()));
		txtForceVal.setFont(new Font("Arial", Font.PLAIN, 15));
		txtForceVal.setEditable(false);
		txtForceVal.setBounds(333, 187, 25, 20);
		frame.getContentPane().add(txtForceVal);
		
		valForce = new JTextField();
		valForce.addKeyListener(new KeyAdapter() {
			/**
			 * Appel la méthode "verifDigit" de la classe ControllParam.
			 * @param evt Récupère la touche appuyée
			 */
			public void keyTyped(KeyEvent evt) {
				controller.verifDigit(evt, valForce.getText().length());
			};
		});
		valForce.setHorizontalAlignment(SwingConstants.CENTER);
		valForce.setFont(new Font("Arial", Font.PLAIN, 15));
		valForce.setColumns(10);
		valForce.setText("0");
		((AbstractDocument) valForce.getDocument()).setDocumentFilter(null);
		valForce.setBounds(362, 187, 62, 20);
		frame.getContentPane().add(valForce);
		
		txtErrorForce = new JTextField();
		txtErrorForce.setForeground(new Color(255, 0, 0));
		txtErrorForce.setBorder(null);
		txtErrorForce.setBackground(new Color(255, 255, 255));
		txtErrorForce.setEditable(false);
		txtErrorForce.setFont(new Font("Arial", Font.PLAIN, 12));
		txtErrorForce.setHorizontalAlignment(SwingConstants.LEFT);
		txtErrorForce.setBounds(333, 212, 70, 20);
		frame.getContentPane().add(txtErrorForce);
		txtErrorForce.setColumns(10);
		
		txtDext = new JTextArea();
		txtDext.setText("Dextérité");
		txtDext.setFont(new Font("Arial", Font.PLAIN, 15));
		txtDext.setEditable(false);
		txtDext.setBounds(270, 235, 62, 22);
		frame.getContentPane().add(txtDext);
		
		txtDextVal = new JTextField();
		txtDextVal.setHorizontalAlignment(SwingConstants.CENTER);
		txtDextVal.setText(String.valueOf(s.getDexterite()));
		txtDextVal.setFont(new Font("Arial", Font.PLAIN, 15));
		txtDextVal.setEditable(false);
		txtDextVal.setBounds(333, 235, 25, 20);
		frame.getContentPane().add(txtDextVal);
		
		valDext = new JTextField();
		valDext.addKeyListener(new KeyAdapter() {
			/**
			 * Appel la méthode "verifDigit" de la classe ControllParam.
			 * @param evt Récupère la touche appuyée
			 */
			public void keyTyped(KeyEvent evt) {
				controller.verifDigit(evt, valDext.getText().length());
			};
		});
		valDext.setHorizontalAlignment(SwingConstants.CENTER);
		valDext.setFont(new Font("Arial", Font.PLAIN, 15));
		valDext.setColumns(10);
		valDext.setText("0");
		valDext.setBounds(362, 235, 62, 20);
		frame.getContentPane().add(valDext);
		
		txtErrorDext = new JTextField();
		txtErrorDext.setForeground(new Color(255, 0, 0));
		txtErrorDext.setBorder(null);
		txtErrorDext.setBackground(new Color(255, 255, 255));
		txtErrorDext.setEditable(false);
		txtErrorDext.setFont(new Font("Arial", Font.PLAIN, 12));
		txtErrorDext.setHorizontalAlignment(SwingConstants.LEFT);
		txtErrorDext.setColumns(10);
		txtErrorDext.setBounds(333, 260, 70, 20);
		frame.getContentPane().add(txtErrorDext);
		
		txtRes = new JTextArea();
		txtRes.setText("Résistance");
		txtRes.setFont(new Font("Arial", Font.PLAIN, 15));
		txtRes.setEditable(false);
		txtRes.setBounds(254, 285, 78, 22);
		frame.getContentPane().add(txtRes);
		
		txtResVal = new JTextField();
		txtResVal.setHorizontalAlignment(SwingConstants.CENTER);
		txtResVal.setText(String.valueOf(s.getResistance()));
		txtResVal.setFont(new Font("Arial", Font.PLAIN, 15));
		txtResVal.setEditable(false);
		txtResVal.setBounds(333, 285, 25, 20);
		frame.getContentPane().add(txtResVal);
		
		valRes = new JTextField();
		valRes.addKeyListener(new KeyAdapter() {
			/**
			 * Appel la méthode "verifDigit" de la classe ControllParam.
			 * @param evt Récupère la touche appuyée
			 */
			public void keyTyped(KeyEvent evt) {
				controller.verifDigit(evt, valRes.getText().length());
			};
		});
		valRes.setHorizontalAlignment(SwingConstants.CENTER);
		valRes.setFont(new Font("Arial", Font.PLAIN, 15));
		valRes.setColumns(10);
		valRes.setText("0");
		valRes.setBounds(362, 285, 62, 20);
		frame.getContentPane().add(valRes);
		
		txtErrorRes = new JTextField();
		txtErrorRes.setForeground(new Color(255, 0, 0));
		txtErrorRes.setBorder(null);
		txtErrorRes.setBackground(new Color(255, 255, 255));
		txtErrorRes.setEditable(false);
		txtErrorRes.setFont(new Font("Arial", Font.PLAIN, 12));
		txtErrorRes.setHorizontalAlignment(SwingConstants.LEFT);
		txtErrorRes.setColumns(10);
		txtErrorRes.setBounds(333, 310, 70, 20);
		frame.getContentPane().add(txtErrorRes);
		
		txtConst = new JTextArea();
		txtConst.setText("Constitution");
		txtConst.setFont(new Font("Arial", Font.PLAIN, 15));
		txtConst.setEditable(false);
		txtConst.setBounds(250, 337, 82, 22);
		frame.getContentPane().add(txtConst);
		
		txtConstVal = new JTextField();
		txtConstVal.setHorizontalAlignment(SwingConstants.CENTER);
		txtConstVal.setText(String.valueOf(s.getConstitution()));
		txtConstVal.setFont(new Font("Arial", Font.PLAIN, 15));
		txtConstVal.setEditable(false);
		txtConstVal.setBounds(333, 337, 25, 20);
		frame.getContentPane().add(txtConstVal);
		
		valConst = new JTextField();
		valConst.addKeyListener(new KeyAdapter() {
			/**
			 * Appel la méthode "verifDigit" de la classe ControllParam.
			 * @param evt Récupère la touche appuyée
			 */
			public void keyTyped(KeyEvent evt) {
				controller.verifDigit(evt, valConst.getText().length());
			};
		});
		valConst.setHorizontalAlignment(SwingConstants.CENTER);
		valConst.setFont(new Font("Arial", Font.PLAIN, 15));
		valConst.setColumns(10);
		valConst.setText("0");
		valConst.setBounds(362, 337, 62, 20);
		frame.getContentPane().add(valConst);
		
		txtErrorConst = new JTextField();
		txtErrorConst.setForeground(new Color(255, 0, 0));
		txtErrorConst.setBorder(null);
		txtErrorConst.setBackground(new Color(255, 255, 255));
		txtErrorConst.setEditable(false);
		txtErrorConst.setFont(new Font("Arial", Font.PLAIN, 12));
		txtErrorConst.setHorizontalAlignment(SwingConstants.LEFT);
		txtErrorConst.setColumns(10);
		txtErrorConst.setBounds(333, 362, 70, 20);
		frame.getContentPane().add(txtErrorConst);
		
		txtIni = new JTextArea();
		txtIni.setText("Initiative");
		txtIni.setFont(new Font("Arial", Font.PLAIN, 15));
		txtIni.setEditable(false);
		txtIni.setBounds(274, 386, 58, 22);
		frame.getContentPane().add(txtIni);
		
		txtIniVal = new JTextField();
		txtIniVal.setHorizontalAlignment(SwingConstants.CENTER);
		txtIniVal.setText(String.valueOf(s.getInitiative()));
		txtIniVal.setFont(new Font("Arial", Font.PLAIN, 15));
		txtIniVal.setEditable(false);
		txtIniVal.setBounds(333, 386, 25, 20);
		frame.getContentPane().add(txtIniVal);
		
		valIni = new JTextField();
		valIni.addKeyListener(new KeyAdapter() {
			/**
			 * Appel la méthode "verifDigit" de la classe ControllParam.
			 * @param evt Récupère la touche appuyée
			 */
			public void keyTyped(KeyEvent evt) {
				controller.verifDigit(evt, valIni.getText().length());
			};
		});
		valIni.setHorizontalAlignment(SwingConstants.CENTER);
		valIni.setFont(new Font("Arial", Font.PLAIN, 15));
		valIni.setColumns(10);
		valIni.setText("0");
		valIni.setBounds(362, 386, 62, 20);
		frame.getContentPane().add(valIni);
		
		txtErrorIni = new JTextField();
		txtErrorIni.setForeground(new Color(255, 0, 0));
		txtErrorIni.setBorder(null);
		txtErrorIni.setBackground(new Color(255, 255, 255));
		txtErrorIni.setEditable(false);
		txtErrorIni.setFont(new Font("Arial", Font.PLAIN, 12));
		txtErrorIni.setHorizontalAlignment(SwingConstants.LEFT);
		txtErrorIni.setColumns(10);
		txtErrorIni.setBounds(333, 411, 70, 20);
		frame.getContentPane().add(txtErrorIni);
		
		JTextArea txtZone = new JTextArea();
		txtZone.setText("Affectation");
		txtZone.setEditable(false);
		txtZone.setTabSize(10);
		txtZone.setFont(new Font("Arial", Font.BOLD, 15));
		txtZone.setBounds(550, 185, 83, 22);
		frame.getContentPane().add(txtZone);
		
		affectZone = new JComboBox<NomDeZone>();
		affectZone.setFont(new Font("Arial", Font.PLAIN, 15));
		affectZone.setModel(new DefaultComboBoxModel<NomDeZone>(NomDeZone.Zone()));
		NomDeZone nomZ = s.getNomZoneDeCombat();
		affectZone.setSelectedItem(nomZ);
		affectZone.setBounds(516, 209, 150, 22);
		frame.getContentPane().add(affectZone);
		
		strat = new JComboBox<Strategie>();
		strat.setModel(new DefaultComboBoxModel<Strategie>(Strategie.values()));
		strat.setFont(new Font("Arial", Font.PLAIN, 15));
		Strategie strategie = s.getStrategie();
		strat.setSelectedItem(strategie);
		strat.setBounds(540, 268, 109, 22);
		frame.getContentPane().add(strat);
		
		txtStrat = new JTextArea();
		txtStrat.setText("Stratégie");
		txtStrat.setTabSize(10);
		txtStrat.setFont(new Font("Arial", Font.BOLD, 15));
		txtStrat.setEditable(false);
		txtStrat.setBounds(559, 243, 68, 22);
		frame.getContentPane().add(txtStrat);
		
		playerPseudo = new JTextArea();
		playerPseudo.setText(this.pseudo);
		playerPseudo.setFont(new Font("Arial", Font.BOLD, 30));
		playerPseudo.setEditable(false);
		playerPseudo.setBounds(59, 47, 239, 46);
		frame.getContentPane().add(playerPseudo);
		
		JButton validButton = new JButton("Valider");
		validButton.setFont(new Font("Arial", Font.PLAIN, 17));
		validButton.setBounds(623, 104, 121, 54);
		frame.getContentPane().add(validButton);
		validButton.addActionListener(new ActionListener() {
			/**
			 * Appel la méthode "valid" de la classe ControllParam.
			 */
			public void actionPerformed(ActionEvent e) {
				controller.valid(j, p, frame);
			}
		});
		
		JButton nextButton = new JButton("Enregistrer");
		nextButton.setFont(new Font("Arial", Font.PLAIN, 15));
		nextButton.setBounds(600, 337, 121, 54);
		frame.getContentPane().add(nextButton);
		nextButton.addActionListener(new ActionListener() {
			/**
			 * Appel la méthode "next" de la classe ControllParam.
			 */
			public void actionPerformed(ActionEvent e) {
				controller.next(nomStudent, p, pointsRestant, txtErrorPtnRestant, txtErrorForce, txtErrorRes, txtErrorDext, txtErrorConst, txtErrorIni, reserviste, affectZone, strat);
			}
		});
		
		JButton buttonAuto = new JButton("Automatique");
		buttonAuto.setFont(new Font("Arial", Font.PLAIN, 15));
		buttonAuto.setBounds(465, 337, 121, 54);
		frame.getContentPane().add(buttonAuto);
		buttonAuto.addActionListener(new ActionListener() {
			/**
			 * Appel la méthode "auto" de la classe ControllParam.
			 */
			public void actionPerformed(ActionEvent e) {
				controller.auto(nomStudent, p, pointsRestant, reserviste, affectZone, strat);
			}
		});
		
		JButton buttonReini = new JButton("Réinitialiser");
		buttonReini.setFont(new Font("Arial", Font.PLAIN, 15));
		buttonReini.setBounds(530, 400, 121, 30);
		frame.getContentPane().add(buttonReini);
		buttonReini.addActionListener(new ActionListener() {
			/**
			 * Appel la méthode "reIni" de la classe ControllParam.
			 */
			public void actionPerformed(ActionEvent e) {
				controller.reIni(nomStudent, p, pointsRestant, reserviste, affectZone, strat);
			}
		});
		
		
		
		reserviste = new JCheckBox("Réserviste");
		reserviste.setBorder(new LineBorder(new Color(0, 0, 0)));
		reserviste.setBackground(Color.WHITE);
		reserviste.setFont(new Font("Arial", Font.PLAIN, 15));
		reserviste.setBounds(550, 305, 99, 23);
		frame.getContentPane().add(reserviste);
		reserviste.addActionListener(new ActionListener() {
			/**
			 * Appel la méthode "reserviste" de la classe ControllParam.
			 */
			public void actionPerformed(ActionEvent e) {
				controller.reserviste(reserviste, affectZone);
			}
		});
		
		typeS = new JComboBox<String>();
		typeS.setModel(new DefaultComboBoxModel<String>(new String[] {"GobiMaster", "EliteStudent", "Student"}));
		typeS.setFont(new Font("Arial", Font.PLAIN, 15));
		typeS.setBounds(362, 85, 109, 22);
		frame.getContentPane().add(typeS);
		typeS.addActionListener(new ActionListener () {
			/**
			 * Appel la méthode "typeS" de la classe ControllParam.
			 */
			public void actionPerformed(ActionEvent e) {
				controller.typeS(typeS, nomStudent, p, j, pointsRestant, reserviste, affectZone, strat, imgStudent);
			}
		});
		
		
		nomStudent = new JComboBox<Nom>();
		if (p == j.player1) {						
			nomStudent.setModel(new DefaultComboBoxModel<Nom>(Nom.GobiMaster1()));
		} else if (p == j.player2) {
			nomStudent.setModel(new DefaultComboBoxModel<Nom>(Nom.GobiMaster2()));		
		}
		nomStudent.setBorder(null);
		nomStudent.setBackground(Color.WHITE);
		nomStudent.setFont(new Font("Arial", Font.PLAIN, 15));
		nomStudent.setEditable(false);
		nomStudent.setBounds(60, 138, 150, 20);
		frame.getContentPane().add(nomStudent);
		nomStudent.addActionListener(new ActionListener() {
			/**
			 * Appel la méthode "nomStud" de la classe ControllParam.
			 */
			public void actionPerformed(ActionEvent e) {
				controller.nomStud(nomStudent, p, pointsRestant, reserviste, affectZone, strat);
			}
		});
		
		
		imgStudent = new JLabel("New label");
		imgStudent.setIcon(new ImageIcon(Param.class.getResource("/img/maitre.png")));
		imgStudent.setBounds(60, 159, 150, 275);
		frame.getContentPane().add(imgStudent);
		
		JTextArea txtrValiderLeParamtrage = new JTextArea();
		txtrValiderLeParamtrage.setText("Valider le paramétrage");
		txtrValiderLeParamtrage.setTabSize(10);
		txtrValiderLeParamtrage.setFont(new Font("Arial", Font.BOLD, 15));
		txtrValiderLeParamtrage.setEditable(false);
		txtrValiderLeParamtrage.setBounds(602, 71, 164, 22);
		frame.getContentPane().add(txtrValiderLeParamtrage);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Param.class.getResource("/img/paramVierge.png")));
		lblNewLabel.setBounds(0, 0, 826, 473);
		frame.getContentPane().add(lblNewLabel);
		
		controller = new ControllParam(valForce, valRes, valDext, valConst, valIni, txtForceVal, txtResVal, txtDextVal, txtConstVal, txtIniVal);

		
		frame.repaint();
	}
}
