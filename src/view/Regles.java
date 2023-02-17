package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

import Controller.ControllRegle;

/**
 * Class Regles, accessible via la page InfoJoueur, affiche les différentes règles du jeu.
 * @author Noe Lecointe
 * @author Wang Zezhong
 */
public class Regles {

	private JFrame frame;
	private ControllRegle controller;
	private JComboBox<String> box;
	private JComboBox<String> Regle;
	private JTextPane txtRegle;
	private JTextField txtRglesDuJeu;
	private JButton exit;
	
	/**
	 * Création la classe
	 * @param f La frame utilisée
	 */
	public Regles(JFrame f) {
		this.frame = f;
		initialize();
	}

	/**
	 * Reprend la frame de la page d'avant, enlève tout et repaint la frame.
	 */
	private void initialize() {	
		frame.getContentPane().removeAll();
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(52, 22, 722, 440);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
	
		
		txtRglesDuJeu = new JTextField();
		txtRglesDuJeu.setEditable(false);
		txtRglesDuJeu.setText("Règles du jeu");
		txtRglesDuJeu.setHorizontalAlignment(SwingConstants.CENTER);
		txtRglesDuJeu.setFont(new Font("Arial", Font.BOLD, 20));
		txtRglesDuJeu.setBounds(215, 40, 292, 62);
		panel.add(txtRglesDuJeu);
		txtRglesDuJeu.setColumns(10);
		
		txtRegle = new JTextPane();
		txtRegle.setText("Le jeu C’est du brutal ! se joue à deux joueurs et a pour décor l’université de technologie de Montauban. Chaque joueur représente un des sept programmes de l’UTM (ISI, RT, A2I, GI, GM, MTE, MM) et possède un effectif de 20 étudiants. A l’aide de son équipe, chaque joueur devra essayer de contrôler une majorité de zones d’influence.");
		txtRegle.setFont(new Font("Arial", Font.PLAIN, 15));
		txtRegle.setEditable(false);
		txtRegle.setBounds(72, 154, 577, 218);
		panel.add(txtRegle);
		
		box = new JComboBox<String>();
		box.setFont(new Font("Arial", Font.PLAIN, 15));
		box.setBounds(70, 107, 141, 22);
		box.addActionListener(new ActionListener() {
			/**
			 * Appel la méthode "box" de la classe ControllRegle.
			 */
			public void actionPerformed(ActionEvent e) {
				controller.box(box.getSelectedIndex(), txtRegle, box.getItemAt(0));
			}
		});
		
		Regle = new JComboBox<String>();
		Regle.setModel(new DefaultComboBoxModel<String>(new String[] {"Règles", "Zone d'Influences", "Caractéristiques", "Actions disponibles", "Type d'étudiants", "Déroulement du jeu"}));
		Regle.setFont(new Font("Arial", Font.PLAIN, 15));
		Regle.setBounds(290, 107, 141, 22);
		Regle.addActionListener(new ActionListener() {
			/**
			 * Appel la méthode "regle" de la classe ControllRegle.
			 */
			public void actionPerformed(ActionEvent e) {
				controller.regle(Regle.getSelectedIndex(), txtRegle, panel, box);
			}
		});
		panel.add(Regle);
		
		exit = new JButton("Revenir aux joueurs");
		exit.setFont(new Font("Arial", Font.PLAIN, 15));
		exit.setToolTipText("");
		exit.setOpaque(false);
		exit.setBounds(262, 391, 197, 36);
		panel.add(exit);
		exit.addActionListener(new ActionListener() {
			/**
			 * Lors du clique sur le bouton "Revenir aux joueurs" lance la classe infoJoueur
			 */
			public void actionPerformed(ActionEvent e) {
				new infoJoueur(frame);
			}
		});
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Regles.class.getResource("/img/gagne.png")));
		lblNewLabel.setBounds(0, 0, 826, 473);
		frame.getContentPane().add(lblNewLabel);
		
		controller = new ControllRegle();

		frame.repaint();
	}

}
