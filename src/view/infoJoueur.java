package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Controller.ControllInfoJoueur;
import Model.Jeu;
import Model.Programmes;
import java.awt.Color;

/**
 * Class InfoJoueur, Page qui récupère le pseudo des deux joueurs ainsi que le programme
 * Donne accès à la page de règles.
 * @author Noe Lecointe
 * @author Wang Zezhong
 */
public class infoJoueur {
	
	private ControllInfoJoueur controller = new ControllInfoJoueur();

	private JFrame frame;
	private JTextField pseudoJ1;
	private JTextField pseudoJ2;
	private JComboBox<Programmes> progJ1;
	private JComboBox<Programmes> progJ2;
	private JTextArea txtErrorP2;
	private JTextArea txtErrorP1;
	private JTextArea txtrProgramme;
	private JTextArea txtrProgramme_1;
	private JTextArea txtErrorProg;

	/**
	 * Création la classe
	 * @param frame La Frame utilisé
	 */
	public infoJoueur(JFrame frame) {
		this.frame = frame;
		initialize();
	}

	/**
	 * Reprend la frame de la page d'avant, enlève tout et repaint la frame.
	 */
	private void initialize() {
		Jeu j = new Jeu();
		
		frame.getContentPane().removeAll();
		
		txtrProgramme = new JTextArea();
		txtrProgramme.setText("Programme");
		txtrProgramme.setEditable(false);
		txtrProgramme.setTabSize(10);
		txtrProgramme.setFont(new Font("Arial", Font.PLAIN, 15));
		txtrProgramme.setBounds(181, 224, 83, 22);
		frame.getContentPane().add(txtrProgramme);
		
		progJ1 = new JComboBox<Programmes>();
		progJ1.setFont(new Font("Arial", Font.PLAIN, 15));
		progJ1.setModel(new DefaultComboBoxModel<Programmes>(Programmes.values()));
		progJ1.setBounds(193, 250, 59, 22);
		frame.getContentPane().add(progJ1);
		
		txtrProgramme_1 = new JTextArea();
		txtrProgramme_1.setText("Programme");
		txtrProgramme_1.setEditable(false);
		txtrProgramme_1.setTabSize(10);
		txtrProgramme_1.setFont(new Font("Arial", Font.PLAIN, 15));
		txtrProgramme_1.setBounds(579, 224, 83, 22);
		frame.getContentPane().add(txtrProgramme_1);

		progJ2 = new JComboBox<Programmes>();
		progJ2.setModel(new DefaultComboBoxModel<Programmes>(Programmes.values()));
		progJ2.setFont(new Font("Arial", Font.PLAIN, 15));
		progJ2.setBounds(591, 250, 59, 22);
		frame.getContentPane().add(progJ2);
		
		txtErrorProg = new JTextArea();
		txtErrorProg.setBackground(new Color(255, 255, 255));
		txtErrorProg.setForeground(new Color(255, 0, 0));
		txtErrorProg.setEditable(false);
		txtErrorProg.setTabSize(10);
		txtErrorProg.setFont(new Font("Arial", Font.PLAIN, 12));
		txtErrorProg.setBounds(449, 328, 300, 18);
		frame.getContentPane().add(txtErrorProg);
		
		pseudoJ1 = new JTextField();
		pseudoJ1.setBounds(144, 158, 161, 30);
		pseudoJ1.setColumns(10);
		pseudoJ1.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(pseudoJ1);
		pseudoJ1.addKeyListener(new KeyAdapter() {
			/**
			 * Vérifie que le pseudo entré est valide.
			 * @param evt Récupère la touche appuyée
			 */
			public void keyTyped(KeyEvent evt) {
				controller.limit(evt, pseudoJ1.getText().length());
			};
		});
		
		txtErrorP1 = new JTextArea();
		txtErrorP1.setForeground(new Color(255, 0, 0));
		txtErrorP1.setEditable(false);
		txtErrorP1.setTabSize(10);
		txtErrorP1.setFont(new Font("Arial", Font.PLAIN, 12));
		txtErrorP1.setBounds(181, 195, 96, 18);
		frame.getContentPane().add(txtErrorP1);
		
		JTextArea txtrText = new JTextArea();
		txtrText.setTabSize(10);
		txtrText.setEditable(false);
		txtrText.setFont(new Font("Arial", Font.PLAIN, 15));
		txtrText.setText("Pseudo");
		txtrText.setBounds(196, 132, 54, 22);
		frame.getContentPane().add(txtrText);
		
		pseudoJ2 = new JTextField();
		pseudoJ2.setColumns(10);
		pseudoJ2.setBounds(542, 158, 161, 30);
		pseudoJ2.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(pseudoJ2);
		pseudoJ2.addKeyListener(new KeyAdapter() {
			/**
			 * Vérifie que le pseudo entré est valide
			 * @param evt Récupère la touche appuyée
			 */
			public void keyTyped(KeyEvent evt) {
				controller.limit(evt, pseudoJ2.getText().length());
			};
		});
		
		txtErrorP2 = new JTextArea();
		txtErrorP2.setForeground(new Color(255, 0, 0));
		txtErrorP2.setEditable(false);
		txtErrorP2.setTabSize(10);
		txtErrorP2.setFont(new Font("Arial", Font.PLAIN, 12));
		txtErrorP2.setBounds(579, 195, 96, 18);
		frame.getContentPane().add(txtErrorP2);		
		
		JTextArea txtrText_1 = new JTextArea();
		txtrText_1.setText("Pseudo");
		txtrText_1.setEditable(false);
		txtrText_1.setTabSize(10);
		txtrText_1.setFont(new Font("Arial", Font.PLAIN, 15));
		txtrText_1.setBounds(594, 132, 54, 22);
		frame.getContentPane().add(txtrText_1);
		
		JButton validButton = new JButton("Valider");
		validButton.setBounds(340, 380, 161, 67);
		frame.getContentPane().add(validButton);
		validButton.addActionListener(new ActionListener() {
			/**
			 * Appel la méthode "valid" du Controller "ControllInfoJoueur"
			 */
			public void actionPerformed(ActionEvent e) {
				controller.valid(progJ1, progJ2, pseudoJ1, pseudoJ2, txtErrorP1, txtErrorP2, txtErrorProg, j, frame);
			}
		});
		
		JButton regle = new JButton("Règles du jeu");
		regle.setToolTipText("");
		regle.setOpaque(false);
		regle.setBounds(150, 395, 150, 36);
		frame.getContentPane().add(regle);
		regle.addActionListener(new ActionListener() {
			/**
			 * Appel la classe Regles.
			 */
			public void actionPerformed(ActionEvent e) {
				new Regles(frame);
			}
		});
		
		JLabel label = new JLabel("New label");
		label.setIcon(new ImageIcon(infoJoueur.class.getResource("/img/infoJoueur.png")));				
		label.setBounds(0, 0, 826, 473);
		frame.getContentPane().add(label);
		
		frame.repaint();
	}

}
