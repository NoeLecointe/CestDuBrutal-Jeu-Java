package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Controller.ControllWin;
import Model.Jeu;
import Model.NomDeZone;
import Model.Player;
import Model.Zone;

/**
 * Class Win, affiche le joueur qui a gagné la zone
 * Dans le cas où 3 zones ont été conquise, affiche le joueur qui à gagner la partie.
 * @author Noe Lecointe
 * @author Wang Zezhong
 */
public class Win {
	
	private Jeu j;
	private Player p;
	private NomDeZone z;
	private int gagner;
	private Zone zone;
	private JTextField txtZoneGagne;
	private JTextField nomZone;
	private JTextField joueur;

	private JFrame frame;
	
	private ControllWin controller = new ControllWin();

	
	/**
	 * Initialisation de la classe.
	 * @param f La Frame utilisée
	 * @param j L'instance de jeu en cours
	 * @param p Le Joueur actuel
	 * @param z La zone où le combat est terminé
	 * @param g Si 1 : partie fini, si 0 partie encore en cours
	 */
	public Win(JFrame f, Jeu j,Player p, Zone z, int g) {
		this.frame = f;
		this.j = j;
		this.p = p;
		this.zone = z;
		this.gagner = g;
		this.z = z.getNomZone();
		initialize();
	}

	/**
	 * Reprend la frame de la page d'avant, enlève tout et repaint la frame.
	 */
	private void initialize() {
		frame.getContentPane().removeAll();
		
		if (this.gagner == 0) {			
			JButton nextButton = new JButton("Suivant");
			nextButton.setFont(new Font("Arial", Font.PLAIN, 17));
			nextButton.setBounds(352, 301, 121, 54);
			frame.getContentPane().add(nextButton);
			nextButton.addActionListener(new ActionListener() {
				/**
				 * Appel la méthode "next" de la class "ControllWin"
				 */
				public void actionPerformed(ActionEvent e) {
					controller.next(frame, j, p, zone);
				}
			});
			
			nomZone = new JTextField();
			nomZone.setEditable(false);
			nomZone.setHorizontalAlignment(SwingConstants.CENTER);
			nomZone.setForeground(Color.BLACK);
			nomZone.setText(this.z.toString());
			nomZone.setFont(new Font("Arial", Font.BOLD, 20));
			nomZone.setDisabledTextColor(Color.WHITE);
			nomZone.setColumns(10);
			nomZone.setBorder(null);
			nomZone.setBackground(Color.WHITE);
			nomZone.setBounds(215, 182, 398, 46);
			frame.getContentPane().add(nomZone);
		}
		
		txtZoneGagne = new JTextField();
		txtZoneGagne.setEditable(false);
		txtZoneGagne.setBackground(new Color(255, 255, 255));
		txtZoneGagne.setForeground(new Color(0, 0, 0));
		txtZoneGagne.setDisabledTextColor(new Color(255, 255, 255));
		txtZoneGagne.setFont(new Font("Arial", Font.BOLD, 25));
		txtZoneGagne.setHorizontalAlignment(SwingConstants.CENTER);
		txtZoneGagne.setText("Zone gagnée");
		if (this.gagner == 1) {
			txtZoneGagne.setText("Partie Terminée");
		}
		txtZoneGagne.setBounds(293, 119, 239, 46);
		frame.getContentPane().add(txtZoneGagne);
		txtZoneGagne.setColumns(10);
		
		joueur = new JTextField();
		joueur.setEditable(false);
		joueur.setHorizontalAlignment(SwingConstants.CENTER);
		joueur.setForeground(Color.BLACK);
		joueur.setText("par " + p.getName());
		joueur.setFont(new Font("Arial", Font.BOLD, 20));
		joueur.setDisabledTextColor(Color.WHITE);
		joueur.setColumns(10);
		joueur.setBorder(null);
		joueur.setBackground(Color.WHITE);
		joueur.setBounds(215, 229, 398, 46);
		frame.getContentPane().add(joueur);
		
		if(this.gagner == 1) {
			joueur.setText(p.getName()+" est le vainqueur");
			joueur.setFont(new Font("Arial", Font.BOLD, 25));
			joueur.setBounds(226, 213, 398, 46);

			
			JButton closeButton = new JButton("Fermer");
			closeButton.setFont(new Font("Arial", Font.PLAIN, 17));
			closeButton.setBounds(352, 301, 121, 54);
			frame.getContentPane().add(closeButton);
			closeButton.addActionListener(new ActionListener() {
				/**
				 * Ferme la frame (le jeu est fini)
				 */
				public void actionPerformed(ActionEvent e) {
					frame.dispose();
				}
			});
		}
		
		
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setBorder(null);
		lblNewLabel.setIcon(new ImageIcon(Param.class.getResource("/img/gagne.png")));
		lblNewLabel.setBounds(0, 0, 826, 473);
		frame.getContentPane().add(lblNewLabel);
		
		frame.repaint();
	}

}
