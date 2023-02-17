package Controller;

import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Model.EliteStudent;
import Model.GobiMaster;
import Model.Jeu;
import Model.NomDeZone;
import Model.Player;
import Model.Strategie;
import Model.Student;
import Model.Zone;
import view.Param;
import view.ReParam;
import view.Win;

/**
 * Class Controlleur pour la View ReParam
 * @author Noe Lecointe
 * @author Wang Zezhong
 */
public class ControllReParam {
	
	private JTextField txtF;
	private JTextField txtR;
	private JTextField txtD;
	private JTextField txtC;
	private JTextField txtI;
	
	/**
	 * Création la classe
	 * @param txtForceVal TextField avec les valeurs de force de l'etudiant
	 * @param txtDextVal TextField avec les valeurs de dexterite de l'etudiant
	 * @param txtResVal TextField avec les valeurs de resistance de l'etudiant
	 * @param txtConstVal TextField avec les valeurs de constitution de l'etudiant
	 * @param txtIniVal TextField avec les valeurs d'initiative de l'etudiant
	 */
	public ControllReParam(JTextField txtForceVal, JTextField txtDextVal, JTextField txtResVal, JTextField txtConstVal, JTextField txtIniVal) {
		this.txtF = txtForceVal;
		this.txtR = txtResVal;
		this.txtD = txtDextVal;
		this.txtC = txtConstVal;
		this.txtI = txtIniVal;
	}
	
	
	/**
	 * Renvoie un tableau contenant les NomDeZone en fonctions de l'ArrayList de zone passee
	 * en parametre
	 * @param z ArraList contenant les zones
	 * @return NomDeZone[]
	 */
	public NomDeZone [] tabZ(ArrayList<Zone> z) {
		NomDeZone [] str = new NomDeZone[z.size()];
		for (int i = 0; i < z.size(); i++) {
			str[i] = z.get(i).getNomZone();
		}
		return str;
	};
	
	/**
	 * Renvoie un tableau contenant le nom des Student passe en parametre
	 * @param s ArrayList contenant les Student
	 * @return String[]
	 */
	public String [] tabS(ArrayList<Student> s) {
		String[] str = new String[s.size()];
		for (int i = 0; i < s.size(); i++) {
			str[i] = s.get(i).getname();
		}
		return str;
	}

	/**
	 * Methode qui si le joueur en parametre est le premier, affiche la page ReParam pour le joueur 2
	 * Sinon, lance le combat, si le joueur 1 gagne une zone, affiche la page Win pour le joueur 1
	 * Si le joueur 2 gagne une zone, affiche la page Win pour le joueur 2.
	 * @param p Le joueur qu'on est en train de reparametrer.
	 * @param j Instance du Jeu en cours
	 * @param frame La Frame utilisés
	 */
	public void valid(Player p, Jeu j, JFrame frame) {
		if (p == j.player1) {	
			j.setZone(1);
			new ReParam(frame, j, j.player2);
		} else if (p == j.player2) {
			j.setZone(2);
			j.battle();
			
			Iterator<Zone> zone = j.listZone.iterator();
			Zone z;
			int controlled;
			while(zone.hasNext()) {
				
				Zone Z = zone.next();
				if (Z.getStatus() == true) {
					z = Z;
					controlled = Z.getControlPlayer();
					
					if(controlled == 1) {
						j.player1.zoneControlled();
						new Win(frame, j, j.player1 ,z, 0);						
					} else {
						j.player2.zoneControlled();
						new Win(frame, j, j.player2, z, 0);
					}	
				};
			};
		}
	}

	/**
	 * Redefinie l'etudiant selectionner dans le menu deroulant nomStudent du joueur passe en parametre
	 * en fontion de la strat selectionner, de la zone et de si il la case reserviste est coche ou non
	 * @param nomStudent Menu deroulant contenant le nom des etudiants
	 * @param p Le joueur qui est en train de reParam
	 * @param strat Menu deroulant contenant les strategie
	 * @param reserviste Check box de reserviste
	 * @param affectZone Menu deroulant contenant les zones du jeu
	 */
	public void next(JComboBox<String> nomStudent, Player p, JComboBox<Strategie> strat, JCheckBox reserviste, JComboBox<NomDeZone> affectZone) {
		int stud = nomStudent.getSelectedIndex();
		String nom = nomStudent.getItemAt(stud);
		Student s = p.getStudent(nom);
		
		int strategie = strat.getSelectedIndex();
		boolean re = reserviste.isSelected();
		int reserv = 0;
		int zone = 5;
		if (re == false) {
			reserv = 1;
			zone = affectZone.getSelectedIndex();
			NomDeZone z = affectZone.getItemAt(zone);
			zone = NomDeZone.numZone(z);
		};

		p.reSetStudent(s, strategie, reserv, zone);
	}

	/**
	 * Si le joueur coche la case reserviste, le menu deroulant affectZone est desactive
	 * et la zone est automatiquement definie sur la Reserve
	 * @param reserviste CheckBox reserviste
	 * @param affectZone Menu deroulant avec les NomDeZone
	 * @param nomZone Tableau de NomDeZone
	 */
	public void reserviste(JCheckBox reserviste, JComboBox<NomDeZone> affectZone, NomDeZone[] nomZone) {
		if (reserviste.isSelected()) {
			affectZone.setEnabled(false);
			affectZone.setModel(new DefaultComboBoxModel<NomDeZone>(NomDeZone.Reserve()));
		} else {
			affectZone.setEnabled(true);
			affectZone.setModel(new DefaultComboBoxModel<NomDeZone>(nomZone));
		}
	}

	/**
	 * Permet de changer tout les informations affichees sur l'ecrant en fonction de l'etudiant selectionner.s
	 * @param nomStudent Menu deroulant avec le nom des etudiants
	 * @param p Le joueur qui reParam
	 * @param reserviste Check Box reserviste
	 * @param affectZone Menu deroulant avec tous les NomDeZone
	 * @param nomZone Tableau contenant tous les NomDeZone
	 * @param strat Menu deroulant de strategie
	 * @param vieRestant TextField avec la vie restante du student selectionne
	 * @param typeStudent TextField avec le type de etudiant (GobyMaster, EliteStudent, Student)
	 * @param imgStudent Label contenant l'image de l'etudiant en fonction de son type
	 */
	public void nomStud(JComboBox<String> nomStudent, Player p, JCheckBox reserviste, JComboBox<NomDeZone> affectZone, NomDeZone[] nomZone, JComboBox<Strategie> strat, JTextField vieRestant, JTextField typeStudent, JLabel imgStudent) {
		int i = nomStudent.getSelectedIndex();
		String n = nomStudent.getItemAt(i); 
		Student s = p.getStudent(n);				
		
		reserviste.setSelected(false);
		affectZone.setEnabled(true);
		affectZone.setModel(new DefaultComboBoxModel<NomDeZone>(nomZone));
		if (s.getReserviste() == true) {
			reserviste.setSelected(true);
			affectZone.setEnabled(false);
			affectZone.setModel(new DefaultComboBoxModel<NomDeZone>(NomDeZone.Reserve()));

		}
		
		vieRestant.setText(String.valueOf(s.getCreditECTS()));

		this.txtF.setText(String.valueOf(s.getForce()));
		this.txtD.setText(String.valueOf(s.getDexterite()));
		this.txtR.setText(String.valueOf(s.getResistance()));
		this.txtC.setText(String.valueOf(s.getConstitution()));
		this.txtI.setText(String.valueOf(s.getInitiative()));
		
		NomDeZone nomZ = s.getNomZoneDeCombat();
		affectZone.setSelectedItem(nomZ);
		Strategie strategie = s.getStrategie();
		strat.setSelectedItem(strategie);
		
		img(s, typeStudent, imgStudent);
	}
	
	/**
	 * Change l'image affiche en fonction de l'etudiant selectionne.
	 * @param s Student selectionne
	 * @param typeStudent TextField qui montre le type d'etudiant
	 * @param imgStudent Label contenant une image en fonction du type d'etudiant
	 */
	public void img(Student s, JTextField typeStudent, JLabel imgStudent) {
		if(s instanceof GobiMaster) {			
			imgStudent.setIcon(new ImageIcon(Param.class.getResource("/img/maitre.png")));
			typeStudent.setText("GobiMaster");
		} else if (s instanceof EliteStudent) {
			imgStudent.setIcon(new ImageIcon(Param.class.getResource("/img/elite.png")));			
			typeStudent.setText("EliteStudent");
		} else {
			imgStudent.setIcon(new ImageIcon(Param.class.getResource("/img/student.png")));						
			typeStudent.setText("Student");
		}
	}
}
