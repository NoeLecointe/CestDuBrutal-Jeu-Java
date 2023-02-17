package Controller;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Model.Jeu;
import Model.Nom;
import Model.NomDeZone;
import Model.Player;
import Model.Strategie;
import Model.Student;
import Model.Zone;
import view.Erreur;
import view.Param;
import view.Win;

/**
 * Class Controlleur pour la View Param
 * @author Noe Lecointe
 * @author Wang Zezhong
 */
public class ControllParam {
	private JTextField f;
	private JTextField r;
	private JTextField d;
	private JTextField c;
	private JTextField i;
	
	private JTextField txtF;
	private JTextField txtR;
	private JTextField txtD;
	private JTextField txtC;
	private JTextField txtI;
	
	/**
	 * Contructeur de la class ControllParam
	 * @param valForce TextField ou le joueur entre la force a ajouter
	 * @param valRes TextField ou le joueur entre la resistance a ajouter
	 * @param valDext TextField ou le joueur entre la dexterite a ajouter
	 * @param valConst TextField ou le joueur entre la constitution a ajouter
	 * @param valIni TextField ou le joueur entre l'initiative a ajouter
	 * @param txtForceVal TextField ou est affiche la force de l'etudiant selectionner
	 * @param txtDextVal TextField ou est affiche la dexterite de l'etudiant selectionner
	 * @param txtResVal TextField ou est affiche la resistance de l'etudiant selectionner
	 * @param txtConstVal TextField ou est affiche la constitution de l'etudiant selectionner
	 * @param txtIniVal TextField ou est affiche l'initiative de l'etudiant selectionner
	 */
	public ControllParam(JTextField valForce, JTextField valRes, JTextField valDext, JTextField valConst, JTextField valIni, JTextField txtForceVal, JTextField txtDextVal, JTextField txtResVal, JTextField txtConstVal, JTextField txtIniVal) {
		this.f = valForce;
		this.r = valRes;
		this.d = valDext;
		this.c = valConst;
		this.i = valIni;
		
		this.txtF = txtForceVal;
		this.txtR = txtResVal;
		this.txtD = txtDextVal;
		this.txtC = txtConstVal;
		this.txtI = txtIniVal;
	}
	
	
	/**
	 * Permet de limiter ce qu'entre le joueur dans la zone pour ajouter des points de caracteristique
	 * (que des Digit et pas plus de 2)
	 * @param evt Id correspondant à la touche entree
	 * @param s Nombre de caractere entre dans la zone
	 */
	public void verifDigit(KeyEvent evt, int s) {
		char c = evt.getKeyChar();
		if(!Character.isDigit(c) || s > 1) {
			evt.consume();
		}
	}
	
	/**
	 * Remet la valeur a 0 des textes ou le joueur ajoute les caracteristique
	 */
	public void resetTxtCarac(){
		this.f.setText("0");
		this.r.setText("0");
		this.d.setText("0");
		this.c.setText("0");
		this.i.setText("0");
	}
	
	/**
	 * Affiche sur la page toute les informations relative a l'etudiant selectionne
	 * @param s Student a definir
	 * @param p Le joueur qui fait les parametre
	 * @param pointsRestant Points de caracteristique restant au joueur
	 * @param reserviste CheckBox reserviste
	 * @param affectZone Menu deroulant avec toute les zones du jeu
	 * @param strat Menu deroulant avec les differentes strategie disponible
	 */
	public void setInfo(Student s, Player p, JTextField pointsRestant, JCheckBox reserviste, JComboBox<NomDeZone> affectZone, JComboBox<Strategie> strat) {
		this.txtF.setText(String.valueOf(s.getForce()));
		this.txtD.setText(String.valueOf(s.getResistance()));
		this.txtR.setText(String.valueOf(s.getDexterite()));
		this.txtC.setText(String.valueOf(s.getConstitution()));
		this.txtI.setText(String.valueOf(s.getInitiative()));
		pointsRestant.setText(String.valueOf(p.getPoints()));
		
		reserviste.setSelected(false);
		affectZone.setEnabled(true);
		affectZone.setModel(new DefaultComboBoxModel<NomDeZone>(NomDeZone.Zone()));
		if (s.getReserviste() == true) {
			reserviste.setSelected(true);
			affectZone.setEnabled(false);
			affectZone.setModel(new DefaultComboBoxModel<NomDeZone>(NomDeZone.Reserve()));
		}
		
		NomDeZone nomZ = s.getNomZoneDeCombat();
		affectZone.setSelectedItem(nomZ);
		Strategie strategie = s.getStrategie();
		strat.setSelectedItem(strategie);
	}

	
	/**
	 * Si le joueur qui param est le premier, verifie si il n'y a pas d'erreur
	 * Si il y en a, ouvre la page erreur, sinon ouvre une nouvelle page Param pour le joueur 2
	 * Si le joueur qui param est le second, lance le combat, puis lors de la treve, affiche 
	 * la page Win pour le joueur qui a remportee la zone
	 * @param j Instance de Jeu en cours
	 * @param p Joueur qui fait les parametre
	 * @param frame La frame utilisee
	 */
	public void valid(Jeu j, Player p, JFrame frame) {
		if (p == j.player1) {
			j.setZone(1);
			
			boolean y = true;
			int error = 0;				
			ArrayList<String> list = new ArrayList<String>();
			if (p.listr.size() < 5) {
				y = false;
				error = 1;
				for(int i = 0; i < p.listr.size(); i++) {
					list.add(p.listr.get(i).getname());
				}
			}
			
			for (Iterator<Zone> zone = j.listZone.iterator(); zone.hasNext();) {
				Zone z = zone.next();
				if(z.listS1.size() == 0) {
					y = false;
					list.add(""+z.getNomZone());
					error = 0;
				} 
			}
			
			if (y == true) {
				new Param(frame, j, 2);						
			} else {
				new Erreur(frame, j, 1, error,list);
			}
			
		} else if (p == j.player2) {
			j.setZone(2);

			boolean y = true;
			int error = 0;				
			ArrayList<String> list = new ArrayList<String>();

			if (p.listr.size() < 5) {
				y = false;
				error = 1;
				for(int i = 0; i < p.listr.size(); i++) {
					list.add(p.listr.get(i).getname());
				}
			}
			
			for (Iterator<Zone> zone = j.listZone.iterator(); zone.hasNext();) {
				Zone z = zone.next();
				if(z.listS2.size() == 0) {
					y = false;
					list.add(""+z.getNomZone());
					error = 0;
				} 
			}
			
			if (y == false) {
				new Erreur(frame, j, 2, error,list);
			} else {
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
	}

	
	/**
	 * Definie l'etudiant selectionner en fonction des informations entrees par le joueur
	 * Affiche une erreur si les informations entrees ne sont pas valide
	 * @param nomStudent Menu Deroulant des etudiants
	 * @param p Joueur qui est en train de parametrer
	 * @param pointsRestant TextField avec les points de caracteristique restant
	 * @param txtErrorPtnRestant TextField d'erreur pour les points restant
	 * @param txtErrorForce TextField d'erreur pour la force
	 * @param txtErrorRes TextField d'erreur pour la resistance
	 * @param txtErrorDext TextField d'erreur pour la dexterite
	 * @param txtErrorConst TextField d'erreur pour la constitution
	 * @param txtErrorIni TextField d'erreur pour l'initiative
	 * @param reserviste Check Box reserviste
	 * @param affectZone Menu deroulant des zones
	 * @param strat Menu deroulant des strategies
	 */
	public void next(JComboBox<Nom> nomStudent, Player p, JTextField pointsRestant, JTextField txtErrorPtnRestant, JTextField txtErrorForce, JTextField txtErrorRes, JTextField txtErrorDext, JTextField txtErrorConst, JTextField txtErrorIni, JCheckBox reserviste, JComboBox<NomDeZone> affectZone, JComboBox<Strategie> strat) {
		int i = nomStudent.getSelectedIndex();
		Nom n = nomStudent.getItemAt(i);
		String nom = n.toString(); 
		Student s = p.getStudent(nom);

		if(this.f.getText().isEmpty()) {					
			this.f.setText("0");
		}
		if(this.r.getText().isEmpty()) {						
			this.r.setText("0");
		}
		if(this.d.getText().isEmpty()) {						
			this.d.setText("0");
		}
		if(this.c.getText().isEmpty()) {						
			this.c.setText("0");
		}
		if(this.i.getText().isEmpty()) {						
			this.i.setText("0");
		}
		
		
		int f = Integer.parseInt(this.f.getText());
		int r = Integer.parseInt(this.r.getText());
		int d = Integer.parseInt(this.d.getText());
		int c = Integer.parseInt(this.c.getText());
		int ini = Integer.parseInt(this.i.getText());
		int t = f + r + d + c + ini;
		
		int sF = f + Integer.parseInt(this.txtF.getText());
		int sR = r + Integer.parseInt(this.txtR.getText());
		int sD = d + Integer.parseInt(this.txtD.getText());
		int sC = c + Integer.parseInt(this.txtC.getText());
		int sIni = ini + Integer.parseInt(this.txtI.getText());
		
		if(p.getPoints() == 0 && t != 0) {
			txtErrorPtnRestant.setText("Aucun points restant");
			resetTxtCarac();
			return;
		} else {
			txtErrorPtnRestant.setText("");
		}
		
		
		if (sF > 10 || sR > 10 || sD > 10 || sC > 30 || sIni > 10) {
			if (sF > 10) {
				txtErrorForce.setText("⚠️ max 10");
			} else {
				txtErrorForce.setText("");
			}
			if (sR > 10) {
				txtErrorRes.setText("⚠️ max 10");
			} else {
				txtErrorRes.setText("");
			}
			if (sD > 10) {
				txtErrorDext.setText("⚠️ max 10");
			} else {
				txtErrorDext.setText("");
			}
			if (sC > 30) {
				txtErrorConst.setText("⚠️ max 30");
			} else {
				txtErrorConst.setText("");				
			}
			if (sIni > 10) {
				txtErrorIni.setText("⚠️ max 10");
			} else {
				txtErrorIni.setText("");				
			}
			
			resetTxtCarac();
			
			return;
		}
		
		int strategie = strat.getSelectedIndex();
		boolean re = reserviste.isSelected();
		int reserv = 0;
		int zone = 5;
		if (re == false) {
			reserv = 1;
			zone = affectZone.getSelectedIndex();
		};
			
		
		p.setStudent(s, f, d, r, c, ini, strategie, reserv, zone);
		
		resetTxtCarac();
		
		txtErrorForce.setText("");
		txtErrorRes.setText("");
		txtErrorDext.setText("");
		txtErrorConst.setText("");
		txtErrorIni.setText("");
		
		setInfo(s, p, pointsRestant, reserviste, affectZone, strat);
	}

	/**
	 * Definie les caracteristiques de tout les etudiants du joueurs automatiquement
	 * @param nomStudent Menu deroulant des etudiants
	 * @param p Joueur qui param
	 * @param pointsRestant TextField avec les points restant
	 * @param reserviste Check Box reserviste
	 * @param affectZone Menu deroulant avec les zones
	 * @param strat Menu deroulant des strategies
	 */
	public void auto(JComboBox<Nom> nomStudent, Player p, JTextField pointsRestant, JCheckBox reserviste, JComboBox<NomDeZone> affectZone, JComboBox<Strategie> strat) {
		int id = nomStudent.getSelectedIndex();
		Nom nom = nomStudent.getItemAt(id);
		String no = nom.toString(); 
		Student stud = p.getStudent(no);

		int n = 0;
		int re = 1;
		for(int i = 0; i < p.listS.size(); i++) {
			Student s = p.listS.get(i);
			if (s.points != 20) {						
				if (i == 5 || i == 10) {
					n = 0;
				} else if (i <= 14) {
					n += 1;
				} else if (i == 15) {
					n = 5;
					re = 0;
				}
				int strategie = 2;
				int zone = n;	
				p.setStudent(s, 3, 3, 3, 8, 3, strategie, re, zone);
			}
			
			 if (i >= 15) {
				s.setZoneDeCombat(5);
			}
		}
		
		resetTxtCarac();
		setInfo(stud, p, pointsRestant, reserviste, affectZone, strat);
	
	}

	/**
	 * Reinitialise l'etudiant selectionner avec ses caracteristique de base
	 * @param nomStudent Menu deroulant des etudiants
	 * @param p Joueur qui param
	 * @param pointsRestant TextField avec les points restant
	 * @param reserviste Check Box reserviste
	 * @param affectZone Menu deroulant avec les zones
	 * @param strat Menu deroulant des strategies
	 */
	public void reIni(JComboBox<Nom> nomStudent, Player p, JTextField pointsRestant, JCheckBox reserviste, JComboBox<NomDeZone> affectZone, JComboBox<Strategie> strat) {
		int id = nomStudent.getSelectedIndex();
		Nom nom = nomStudent.getItemAt(id);
		String no = nom.toString(); 
		Student stud = p.getStudent(no);	
		
		p.resetS(stud);
		
		resetTxtCarac();
		
		setInfo(stud, p, pointsRestant, reserviste, affectZone, strat);
	}

	/**
	 * Si le joueur coche la case reserviste, desactive le menu deroulant des zones et 
	 * definie la zone sur reserve.
	 * Si le joueur decoche la case, active le menu deroulant et remet le model avec
	 * les zones du jeu
	 * @param reserviste Check Box reserviste
	 * @param affectZone Menu deroulant des zones
	 */
	public void reserviste(JCheckBox reserviste, JComboBox<NomDeZone> affectZone) {
		if (reserviste.isSelected()) {
			affectZone.setEnabled(false);
			affectZone.setModel(new DefaultComboBoxModel<NomDeZone>(NomDeZone.Reserve()));
		} else {
			affectZone.setEnabled(true);
			affectZone.setModel(new DefaultComboBoxModel<NomDeZone>(NomDeZone.Zone()));
		}
	}

	/**
	 * Change la le mendu deroulant des nom d'etudiants en fonctione du type d'etudiant
	 * selectionne, change egalement toute les informations affichees sur la page
	 * @param typeS Menu deroulant avec le type d'etudiant
	 * @param nomStudent Menu deroulant des etudiants
	 * @param p Le Joueur qui param
	 * @param j Instance de jeu en cours
	 * @param pointsRestant Text field des points restant
	 * @param reserviste Check Box reserviste
	 * @param affectZone Menu deroulant des zones
	 * @param strat Menu deroulant des strategies
	 * @param imgStudent Panel avec l'image du type d'etudiant
	 */
	public void typeS(JComboBox<String> typeS, JComboBox<Nom> nomStudent, Player p, Jeu j, JTextField pointsRestant, JCheckBox reserviste, JComboBox<NomDeZone> affectZone, JComboBox<Strategie> strat, JLabel imgStudent) {
		int sel = typeS.getSelectedIndex();
		if(sel == 0) {					
			nomStudent.setModel(new DefaultComboBoxModel<Nom>(Nom.GobiMaster1()));
			Student s = p.getStudent("Jack"); 				
			if (p == j.player2) {
				nomStudent.setModel(new DefaultComboBoxModel<Nom>(Nom.GobiMaster2()));
				s = p.getStudent("Hippolyte"); 				
			}
			
			setInfo(s, p, pointsRestant, reserviste, affectZone, strat);

			imgStudent.setIcon(new ImageIcon(ControllParam.class.getResource("/img/maitre.png")));

			
		} else if (sel == 1) {

			nomStudent.setModel(new DefaultComboBoxModel<Nom>(Nom.EliteStudent1()));
			Student s = p.getStudent("Rose");
			if (p == j.player2) {
				nomStudent.setModel(new DefaultComboBoxModel<Nom>(Nom.EliteStudent2()));
				s = p.getStudent("Célestine");
				
			}
			
			setInfo(s, p, pointsRestant, reserviste, affectZone, strat);
			
			imgStudent.setIcon(new ImageIcon(Param.class.getResource("/img/elite.png")));

		} else if (sel == 2) {
			nomStudent.setModel(new DefaultComboBoxModel<Nom>(Nom.Student1()));
			Student s = p.getStudent("James");
			if (p == j.player2) {						
				nomStudent.setModel(new DefaultComboBoxModel<Nom>(Nom.Student2()));
				s = p.getStudent("Caroline"); 
			}			
			
			setInfo(s, p, pointsRestant, reserviste, affectZone, strat);
			imgStudent.setIcon(new ImageIcon(Param.class.getResource("/img/student.png")));

		}
	}

	/**
	 * Change les informations affichees sur la page en fonction de l'etudiant selectionne
	 * @param nomStudent Menu deroulant des etudiants
	 * @param p Joueur qui param
	 * @param pointsRestant Text field des points restant
	 * @param reserviste Check Box reserviste
	 * @param affectZone Menu deroulant des zones
	 * @param strat Menu deroulant des strategies
	 */
	public void nomStud(JComboBox<Nom> nomStudent, Player p, JTextField pointsRestant, JCheckBox reserviste, JComboBox<NomDeZone> affectZone, JComboBox<Strategie> strat) {
		int i = nomStudent.getSelectedIndex();
		Nom n = nomStudent.getItemAt(i);
		String nom = n.toString(); 
		Student s = p.getStudent(nom);				
		
		setInfo(s, p, pointsRestant, reserviste, affectZone, strat);
	}
}
