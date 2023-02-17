package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Controller.ControllErreur;
import Model.Jeu;

import javax.swing.JTextPane;

/**
 * Class Erreur, affiche les erreurs si il y en a lors de la validation des paramètres
 * (classe Param)
 * @author Noe Lecointe
 * @author Wang Zezhong
 */
public class Erreur {
	
	private int idJ;
	private Jeu j;
	

	private JFrame frame;
	private int Terror;
	private ArrayList<String> list = new ArrayList<String>();
	private JTextPane textPane;
	
	private ControllErreur controller = new ControllErreur();

	/**
	 * Création la classe
	 * @param f La Frame utilisé
	 * @param j L'instance du Jeu actuellement en cours
	 * @param idJ L'Id du joueur qui vient d'avoir une erreur
	 * @param error L'Id qui indique quel type d'erreur c'est
	 * @param list La liste avec le nom des zones ou étudiants en fonction de l'erreur.
	 */
	public Erreur(JFrame f, Jeu j, int idJ, int error, ArrayList<String> list) {
		this.frame = f;
		this.j = j;
		this.idJ = idJ;
		Terror = error;
		this.list = list;
		initialize();
	}

	/**
	 * Reprend la frame de la page d'avant, enlève tout et repaint la frame.
	 */
	private void initialize() {
	
		frame.getContentPane().removeAll();

		textPane = new JTextPane();
		textPane.setFont(new Font("Arial", Font.PLAIN, 15));
		textPane.setEditable(false);
		textPane.setBounds(232, 184, 361, 137);
		frame.getContentPane().add(textPane);
		
		JTextField txtErreur = new JTextField();
		txtErreur.setEditable(false);
		txtErreur.setBackground(new Color(255, 255, 255));
		txtErreur.setForeground(new Color(0, 0, 0));
		txtErreur.setDisabledTextColor(new Color(255, 255, 255));
		txtErreur.setFont(new Font("Arial", Font.BOLD, 25));
		txtErreur.setHorizontalAlignment(SwingConstants.CENTER);
		txtErreur.setText("Erreur");
		txtErreur.setBounds(293, 119, 239, 46);
		frame.getContentPane().add(txtErreur);
		txtErreur.setColumns(10);
		
		controller.typeError(Terror, list, textPane);		
		
		JButton exit = new JButton("Retour");
		exit.setFont(new Font("Arial", Font.PLAIN, 15));
		exit.setToolTipText("");
		exit.setOpaque(false);
		exit.setBounds(314, 332, 197, 36);
		frame.getContentPane().add(exit);
		exit.addActionListener(new ActionListener() {
			/**
			 * Créer la classe Param lors du clique sur le bouton "Retour";
			 */
			public void actionPerformed(ActionEvent e) {
				new Param(frame, j, idJ);
			}
		});
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setBorder(null);
		lblNewLabel.setIcon(new ImageIcon(Param.class.getResource("/img/gagne.png")));
		lblNewLabel.setBounds(0, 0, 826, 473);
		frame.getContentPane().add(lblNewLabel);
	
		frame.repaint();

	}
}
