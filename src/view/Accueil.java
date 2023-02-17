package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 * class Accueil, affiche la première page du jeu.
 * @author Noe Lecointe
 * @author Wang Zezhong
 */
public class Accueil {

	private JFrame frame;
	private JButton Commencer;
	private JLabel lblNewLabel;

	/**
	 * Lancement du jeu
	 * @param args String []
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Accueil window = new Accueil();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Création de l'application
	 */
	public Accueil() {
		initialize();
	}

	/**
	 * Initialisation du contenue de la frame
	 */
	private void initialize() {			
		frame = new JFrame();
		frame.setTitle("C'est du Brutal");
		frame.setResizable(false);
		frame.setBounds(100, 100, 840, 510);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
	
		
		Commencer = new JButton("Commencer");
		Commencer.setToolTipText("");
		Commencer.setOpaque(false);
		Commencer.addActionListener(new ActionListener() {
			/**
			 * Lors du clique sur le bouton "Commencer" lance la classe infoJoueur
			 */
			public void actionPerformed(ActionEvent e) {
				new infoJoueur(frame);
			}
		});
		Commencer.setBounds(306, 216, 232, 81);
		frame.getContentPane().add(Commencer);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setIcon(new ImageIcon(Accueil.class.getResource("/img/accueil.png")));
		lblNewLabel.setBounds(0, 0, 826, 473);
		frame.getContentPane().add(lblNewLabel);
	}
}
