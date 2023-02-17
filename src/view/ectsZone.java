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
import javax.swing.border.MatteBorder;

import Controller.ControllEctsZone;
import Model.Jeu;
import Model.NomDeZone;
import Model.Player;

/**
 * class ectsZone, permet d'afficher la sommes des ects des étudiants présent dans une zone
 * accessible sur la page ReParam (class ReParam)
 * @author Noe Lecointe
 * @author Wang Zezhong
 */
public class ectsZone {

	private JFrame frame;
	private JTextField txtBibli;
	private JTextField txtBureau;
	private JTextField txtQuartier;
	private JTextField txtIndus;
	private JTextField txtSport;
	private JTextField ectsBibli;
	private JTextField ectsBureau;
	private JTextField ectsQuartier;
	private JTextField ectsIndus;
	private JTextField ectsSport;
	
	private Jeu j;
	private Player p;
	
	private ControllEctsZone controller = new ControllEctsZone();


	/**
	 * Création la classe
	 * @param f La Frame utilisé
	 * @param j L'instance du Jeu actuellement en cours
	 * @param p Le Joueur actuel
	 */
	public ectsZone(JFrame f, Jeu j, Player p) {
		this.frame = f;
		this.j = j;
		this.p = p;
		initialize();
	}

	/**
	 *  Reprend la frame de la page d'avant, enlève tout et repaint la frame.
	 */
	private void initialize() {
		frame.getContentPane().removeAll();
		
		JTextField txtECTS = new JTextField();
		txtECTS.setEditable(false);
		txtECTS.setBackground(new Color(255, 255, 255));
		txtECTS.setForeground(new Color(0, 0, 0));
		txtECTS.setDisabledTextColor(new Color(255, 255, 255));
		txtECTS.setFont(new Font("Arial", Font.BOLD, 25));
		txtECTS.setHorizontalAlignment(SwingConstants.CENTER);
		txtECTS.setText("ECTS totale dans chaque zone");
		txtECTS.setBounds(230, 107, 389, 46);
		frame.getContentPane().add(txtECTS);
		txtECTS.setColumns(10);
				
		for(int i = 0; i < j.listZone.size(); i++) {
			
			if (controller.txt(j, i) == NomDeZone.Bibliotheque) {
				txtBibli = new JTextField();
				txtBibli.setBackground(new Color(255, 255, 255));
				txtBibli.setDisabledTextColor(new Color(255, 255, 255));
				txtBibli.setEditable(false);
				txtBibli.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
				txtBibli.setFont(new Font("Arial", Font.PLAIN, 15));
				txtBibli.setText("Bibliothèque");
				txtBibli.setHorizontalAlignment(SwingConstants.CENTER);
				txtBibli.setBounds(292, 164, 162, 20);
				frame.getContentPane().add(txtBibli);
				txtBibli.setColumns(10);
				
				ectsBibli = new JTextField();
				ectsBibli.setHorizontalAlignment(SwingConstants.CENTER);
				ectsBibli.setText(String.valueOf(controller.d(j, i)));
				ectsBibli.setFont(new Font("Arial", Font.PLAIN, 15));
				ectsBibli.setEditable(false);
				ectsBibli.setBounds(468, 164, 62, 20);
				frame.getContentPane().add(ectsBibli);
				ectsBibli.setColumns(10);
			}
			if (controller.txt(j, i) == NomDeZone.BureauDesEtudiants) {
				txtBureau = new JTextField();
				txtBureau.setBackground(new Color(255, 255, 255));
				txtBureau.setDisabledTextColor(new Color(255, 255, 255));
				txtBureau.setEditable(false);
				txtBureau.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
				txtBureau.setText("Bureau des étudiants");
				txtBureau.setHorizontalAlignment(SwingConstants.CENTER);
				txtBureau.setFont(new Font("Arial", Font.PLAIN, 15));
				txtBureau.setColumns(10);
				txtBureau.setBounds(292, 195, 162, 20);
				frame.getContentPane().add(txtBureau);
				
				ectsBureau = new JTextField();
				ectsBureau.setHorizontalAlignment(SwingConstants.CENTER);
				ectsBureau.setText(String.valueOf(controller.d(j, i)));
				ectsBureau.setFont(new Font("Arial", Font.PLAIN, 15));
				ectsBureau.setEditable(false);
				ectsBureau.setColumns(10);
				ectsBureau.setBounds(468, 195, 62, 20);
				frame.getContentPane().add(ectsBureau);				
			}
			if (controller.txt(j, i) == NomDeZone.QuartierAdministratif) {
				txtQuartier = new JTextField();
				txtQuartier.setBackground(new Color(255, 255, 255));
				txtQuartier.setDisabledTextColor(new Color(255, 255, 255));
				txtQuartier.setEditable(false);
				txtQuartier.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
				txtQuartier.setText("Quartier Administratif");
				txtQuartier.setHorizontalAlignment(SwingConstants.CENTER);
				txtQuartier.setFont(new Font("Arial", Font.PLAIN, 15));
				txtQuartier.setColumns(10);
				txtQuartier.setBounds(292, 226, 162, 20);
				frame.getContentPane().add(txtQuartier);
				
				ectsQuartier = new JTextField();
				ectsQuartier.setHorizontalAlignment(SwingConstants.CENTER);
				ectsQuartier.setText(String.valueOf(controller.d(j, i)));
				ectsQuartier.setFont(new Font("Arial", Font.PLAIN, 15));
				ectsQuartier.setEditable(false);
				ectsQuartier.setColumns(10);
				ectsQuartier.setBounds(468, 226, 62, 20);
				frame.getContentPane().add(ectsQuartier);
			}
			if (controller.txt(j, i) == NomDeZone.HallesIndustrielle) {
				txtIndus = new JTextField();
				txtIndus.setBackground(new Color(255, 255, 255));
				txtIndus.setDisabledTextColor(new Color(255, 255, 255));
				txtIndus.setEditable(false);
				txtIndus.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
				txtIndus.setText("Halles Industrielle");
				txtIndus.setHorizontalAlignment(SwingConstants.CENTER);
				txtIndus.setFont(new Font("Arial", Font.PLAIN, 15));
				txtIndus.setColumns(10);
				txtIndus.setBounds(292, 257, 162, 20);
				frame.getContentPane().add(txtIndus);
				
				ectsIndus = new JTextField();
				ectsIndus.setHorizontalAlignment(SwingConstants.CENTER);
				ectsIndus.setText(String.valueOf(controller.d(j, i)));
				ectsIndus.setFont(new Font("Arial", Font.PLAIN, 15));
				ectsIndus.setEditable(false);
				ectsIndus.setColumns(10);
				ectsIndus.setBounds(468, 257, 62, 20);
				frame.getContentPane().add(ectsIndus);
			}
			if (controller.txt(j, i) == NomDeZone.HalleSportive) {
				txtSport = new JTextField();
				txtSport.setBackground(new Color(255, 255, 255));
				txtSport.setDisabledTextColor(new Color(255, 255, 255));
				txtSport.setEditable(false);
				txtSport.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
				txtSport.setText("Halle Sportive");
				txtSport.setHorizontalAlignment(SwingConstants.CENTER);
				txtSport.setFont(new Font("Arial", Font.PLAIN, 15));
				txtSport.setColumns(10);
				txtSport.setBounds(292, 288, 162, 20);
				frame.getContentPane().add(txtSport);
				
				ectsSport = new JTextField();
				ectsSport.setHorizontalAlignment(SwingConstants.CENTER);
				ectsSport.setText(String.valueOf(controller.d(j, i)));
				ectsSport.setFont(new Font("Arial", Font.PLAIN, 15));
				ectsSport.setEditable(false);
				ectsSport.setColumns(10);
				ectsSport.setBounds(468, 288, 62, 20);
				frame.getContentPane().add(ectsSport);
			}
		}
		
		
		JButton retour = new JButton("Retour");
		retour.setHorizontalTextPosition(SwingConstants.CENTER);
		retour.setFont(new Font("Arial", Font.PLAIN, 17));
		retour.setBounds(358, 319, 113, 46);
		frame.getContentPane().add(retour);
		retour.addActionListener(new ActionListener() {
			/**
			 * Lors du clique sur le bouton "Retour"
			 */
			public void actionPerformed(ActionEvent e) {				
				new ReParam(frame, j, p);
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
