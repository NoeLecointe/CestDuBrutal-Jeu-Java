package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Controller.ControllDefend;
import Model.Jeu;
import Model.Player;
import Model.Student;
import Model.Zone;

/**
 * class Defend, permet de choisir l'étudiant que l'on laisse en défence dans la zone
 * que l'on vient de gagner
 * @author Noe Lecointe
 * @author Wang Zezhong
 */
public class Defend {

	private JFrame frame;
	
	private Jeu j;
	private ArrayList<Student> s;
	private Player p;
	private Zone z;
	
	private String[] str;
	
	private JTextField txtProtecteur;
	private JTextField txtExp;
	JComboBox<String> student;
	
	private ControllDefend controller = new ControllDefend();
	


	/**
	 * Création la classe
	 * @param f La Frame utilisé
	 * @param j L'instance du Jeu actuellement en cours
	 * @param p Le Joueur actuel
	 * @param z La zone où le combat est terminé
	 */
	public Defend(JFrame f, Jeu j, Player p, Zone z) {
		this.frame = f;
		this.j = j;
		this.p = p;
		this.z = z;
		this.s = p.listr;
		if (this.p == j.player1) {
			this.str = controller.tab(z.listS1);
		} else {
			this.str = controller.tab(z.listS2);
		}
		
		initialize();
	}


	
	/**
	 * Reprend la frame de la page d'avant, enlève tout et repaint la frame.
	 */
	private void initialize() {
		frame.getContentPane().removeAll();

		
		JButton nextButton = new JButton("Suivant");
		nextButton.setFont(new Font("Arial", Font.PLAIN, 17));
		nextButton.setBounds(352, 301, 121, 54);
		frame.getContentPane().add(nextButton);
		nextButton.addActionListener(new ActionListener() {
			/**
			 * Lors du clique sur le bouton "Suivant"
			 */
			public void actionPerformed(ActionEvent e) {
				controller.next(z, s, student, j, frame);
			}
		});
		
		txtProtecteur = new JTextField();
		txtProtecteur.setEditable(false);
		txtProtecteur.setBackground(new Color(255, 255, 255));
		txtProtecteur.setForeground(new Color(0, 0, 0));
		txtProtecteur.setDisabledTextColor(new Color(255, 255, 255));
		txtProtecteur.setFont(new Font("Arial", Font.BOLD, 25));
		txtProtecteur.setHorizontalAlignment(SwingConstants.CENTER);
		txtProtecteur.setText("Protecteur");
		txtProtecteur.setBounds(293, 119, 239, 46);
		frame.getContentPane().add(txtProtecteur);
		txtProtecteur.setColumns(10);
		
		txtExp = new JTextField();
		txtExp.setEditable(false);
		txtExp.setHorizontalAlignment(SwingConstants.CENTER);
		txtExp.setForeground(Color.BLACK);
		txtExp.setText("Définir l'étudiant qui protège la zone gagnée");
		txtExp.setFont(new Font("Arial", Font.PLAIN, 15));
		txtExp.setDisabledTextColor(Color.WHITE);
		txtExp.setColumns(10);
		txtExp.setBorder(null);
		txtExp.setBackground(Color.WHITE);
		txtExp.setBounds(215, 164, 398, 46);
		frame.getContentPane().add(txtExp);
		
		student = new JComboBox<String>();
		student.setFont(new Font("Arial", Font.PLAIN, 15));
		student.setModel(new DefaultComboBoxModel<String>(this.str));
		student.setBounds(345, 231, 135, 37);
		frame.getContentPane().add(student);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setBorder(null);
		lblNewLabel.setIcon(new ImageIcon(Param.class.getResource("/img/gagne.png")));
		lblNewLabel.setBounds(0, 0, 826, 473);
		frame.getContentPane().add(lblNewLabel);
		
		frame.repaint();
	}

}
