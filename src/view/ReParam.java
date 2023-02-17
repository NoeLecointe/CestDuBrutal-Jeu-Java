package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import Controller.ControllReParam;
import Model.Jeu;
import Model.NomDeZone;
import Model.Player;
import Model.Strategie;
import Model.Student;
/**
 * Class ReParam, permet de reparamétrer les étudiants lors de la trève
 * On peut modifier la zone, la stratégie et si l'étudiant est réserviste ou non
 * Donne accès à la classe ectsZone qui montre les ects Totaux de chaque Zone.
 * @author Noe Lecointe
 * @author Wang Zezhong
 */
public class ReParam {

	private JFrame frame;
	private Jeu j;
	private Player p;
	
	private String[] str;
	private NomDeZone[] nomZone;
	
	private JLabel imgStudent;
	private JComboBox<String> nomStudent;
	private JCheckBox reserviste;
	private JTextField typeStudent;
	private JTextArea playerPseudo;
	
	private JTextField txtForceVal;
	private JTextField txtDextVal;
	private JTextField txtResVal;
	private JTextField txtConstVal;
	private JTextField txtIniVal;
	
	private ControllReParam controller = new ControllReParam(txtForceVal, txtResVal, txtDextVal, txtConstVal, txtIniVal);
	

	/**
	 * Création la classe
	 * @param f La frame utilisée
	 * @param j L'instance de Jeu en cours
	 * @param p Le Joueur actuel
	 */
	public ReParam(JFrame f, Jeu j, Player p) {
		this.frame = f;
		this.j = j;
		this.p = p;
		this.str = controller.tabS(p.listr);
		this.nomZone = controller.tabZ(j.listZone);
		initialize();
	}


	
	/**
	 * Reprend la frame de la page d'avant, enlève tout et repaint la frame.
	 */
	private void initialize() {
		frame.getContentPane().removeAll();
		
		Student s = this.p.listr.get(0);
		
		playerPseudo = new JTextArea();
		playerPseudo.setText(p.getName());
		playerPseudo.setFont(new Font("Arial", Font.BOLD, 30));
		playerPseudo.setEditable(false);
		playerPseudo.setBounds(59, 47, 239, 46);
		frame.getContentPane().add(playerPseudo);
		
		JTextField vieRestant = new JTextField();
		vieRestant.setHorizontalAlignment(SwingConstants.CENTER);
		vieRestant.setText(String.valueOf(s.getCreditECTS()));
		vieRestant.setFont(new Font("Arial", Font.PLAIN, 15));
		vieRestant.setEditable(false);
		vieRestant.setBounds(328,145, 62, 20);
		frame.getContentPane().add(vieRestant);
		vieRestant.setColumns(10);
		
		JTextArea txtVieRestant = new JTextArea();
		txtVieRestant.setEditable(false);
		txtVieRestant.setText("ECTS restant :");
		txtVieRestant.setFont(new Font("Arial", Font.PLAIN, 15));
		txtVieRestant.setBounds(227, 145, 102, 22);
		frame.getContentPane().add(txtVieRestant);
		
		JTextArea txtForce = new JTextArea();
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

		
		JTextArea txtDext = new JTextArea();
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
		
		JTextArea txtRes = new JTextArea();
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
		
		JTextArea txtConst = new JTextArea();
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
		
		JTextArea txtIni = new JTextArea();
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
		
		JTextArea txtZone = new JTextArea();
		txtZone.setText("Affectation");
		txtZone.setEditable(false);
		txtZone.setTabSize(10);
		txtZone.setFont(new Font("Arial", Font.BOLD, 15));
		txtZone.setBounds(550, 185, 83, 22);
		frame.getContentPane().add(txtZone);
		
		JComboBox<NomDeZone> affectZone = new JComboBox<NomDeZone>();
		affectZone.setFont(new Font("Arial", Font.PLAIN, 15));
		affectZone.setEnabled(false);
		affectZone.setModel(new DefaultComboBoxModel<NomDeZone>(NomDeZone.Reserve()));
		affectZone.setBounds(516, 209, 150, 22);
		frame.getContentPane().add(affectZone);
		
		JComboBox<Strategie> strat = new JComboBox<Strategie>();
		strat.setModel(new DefaultComboBoxModel<Strategie>(Strategie.values()));
		strat.setFont(new Font("Arial", Font.PLAIN, 15));
		Strategie strategie = s.getStrategie();
		strat.setSelectedItem(strategie);
		strat.setBounds(540, 268, 109, 22);
		frame.getContentPane().add(strat);
		
		JTextArea txtStrat = new JTextArea();
		txtStrat.setText("Stratégie");
		txtStrat.setTabSize(10);
		txtStrat.setFont(new Font("Arial", Font.BOLD, 15));
		txtStrat.setEditable(false);
		txtStrat.setBounds(559, 243, 68, 22);
		frame.getContentPane().add(txtStrat);
		
		JButton validButton = new JButton("Valider");
		validButton.setFont(new Font("Arial", Font.PLAIN, 17));
		validButton.setBounds(623, 104, 121, 54);
		frame.getContentPane().add(validButton);
		validButton.addActionListener(new ActionListener() {
			/**
			 * Appel la methode "valid" de la class "ControllReParam".
			 */
			public void actionPerformed(ActionEvent e) {
				controller.valid(p, j, frame);
			}
		});
		
		JButton nextButton = new JButton("Enregistrer");
		nextButton.setFont(new Font("Arial", Font.PLAIN, 17));
		nextButton.setBounds(600, 337, 121, 54);
		frame.getContentPane().add(nextButton);
		nextButton.addActionListener(new ActionListener() {
			/**
			 * Appel la méthode "next" de la class "ControllReParam"
			 */
			public void actionPerformed(ActionEvent e) {
				controller.next(nomStudent, p, strat, reserviste, affectZone);
				
			};
		});
		
		JButton ectsZone = new JButton("ECTS / Zone");
		ectsZone.setFont(new Font("Arial", Font.PLAIN, 15));
		ectsZone.setBounds(465, 337, 121, 54);
		frame.getContentPane().add(ectsZone);
		ectsZone.addActionListener(new ActionListener() {
			/**
			 * Lors du clique sur le bouton "ECTS / Zone", lance la classe ectsZone qui
			 * affiche les ECTS totaux dans chaque zone.
			 */
			public void actionPerformed(ActionEvent e) {
				new ectsZone(frame, j, p);
			}
		});
		
		reserviste = new JCheckBox("Réserviste");
		reserviste.setBorder(new LineBorder(new Color(0, 0, 0)));
		reserviste.setBackground(Color.WHITE);
		reserviste.setFont(new Font("Arial", Font.PLAIN, 15));
		reserviste.setBounds(550, 305, 99, 23);
		reserviste.setSelected(true);
		frame.getContentPane().add(reserviste);

		reserviste.addActionListener(new ActionListener() {
			/**
			 * Appel la méthode "reserviste" de la class "ControllReParam"
			 */
			public void actionPerformed(ActionEvent e) {
				controller.reserviste(reserviste, affectZone, nomZone);
			}
		});
		
		
		nomStudent = new JComboBox<String>();
		nomStudent.setModel(new DefaultComboBoxModel<String>(this.str));
		nomStudent.setBorder(null);
		nomStudent.setBackground(Color.WHITE);
		nomStudent.setFont(new Font("Arial", Font.PLAIN, 15));
		nomStudent.setEditable(false);
		nomStudent.setBounds(60, 138, 150, 20);
		frame.getContentPane().add(nomStudent);
		nomStudent.addActionListener(new ActionListener() {
			/**
			 * Appel la méthode "nomStud" de la class "ControllReParam"
			 */
			public void actionPerformed(ActionEvent e) {
				controller.nomStud(nomStudent, p, reserviste, affectZone, nomZone, strat, txtIniVal, txtIniVal, imgStudent);
			}
		});
		
		imgStudent = new JLabel("New label");
		imgStudent.setBounds(60, 159, 150, 275);
		frame.getContentPane().add(imgStudent);
		
		JTextArea txtrValiderLeParamtrage = new JTextArea();
		txtrValiderLeParamtrage.setText("Valider le paramétrage");
		txtrValiderLeParamtrage.setTabSize(10);
		txtrValiderLeParamtrage.setFont(new Font("Arial", Font.BOLD, 15));
		txtrValiderLeParamtrage.setEditable(false);
		txtrValiderLeParamtrage.setBounds(602, 71, 164, 22);
		frame.getContentPane().add(txtrValiderLeParamtrage);
		
		typeStudent = new JTextField();
		typeStudent.setText("GobiMaster");
		typeStudent.setEditable(false);
		typeStudent.setHorizontalAlignment(SwingConstants.CENTER);
		typeStudent.setFont(new Font("Arial", Font.PLAIN, 20));
		typeStudent.setBounds(322, 90, 181, 45);
		frame.getContentPane().add(typeStudent);
		typeStudent.setColumns(10);
		
		
		controller.img(s, txtIniVal, imgStudent);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(ReParam.class.getResource("/img/reParam.png")));
		lblNewLabel.setBounds(0, 0, 826, 473);
		frame.getContentPane().add(lblNewLabel);
		
		controller = new ControllReParam(txtForceVal, txtResVal, txtDextVal, txtConstVal, txtIniVal);
		
		frame.repaint();
	}

}
