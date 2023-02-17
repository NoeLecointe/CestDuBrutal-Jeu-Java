package Model;

import java.util.*;

/**
 * Classe Zone, contient toute les informations en rapport avec les Zones
 * @author Noe Lecointe
 * @author Wang Zezhong
 */
public class Zone {

	/** Definition des variables de la classe Zone */
	private int numZone;
	private NomDeZone nom;
	private int controlPlayer;
	private boolean status;
	public ArrayList<Student> listS1 = new ArrayList<>();
	public ArrayList<Student> listS2 = new ArrayList<>();
	public ArrayList<Student> listAct = new ArrayList<>();
	private double Ects1;
	private double Ects2;
	
	/**
	 * Constructeur de la classe Zone
	 * @param i Id de la zone
	 */
	public Zone(int i) {
		this.nom = NomDeZone.values()[i];
		this.status = false;
		this.controlPlayer = 0;
		this.numZone = i;
	}


/** -------------------------- Getters -------------------------- */
	/**
	 * Renvoie le status de la zone (controllee ou non)
	 * @return boolean
	 */
	public boolean getStatus() {
		return this.status;
	}

	/**
	 * Renvoie la quantite de Student present dans la zone
	 * @param list Liste des etudiants
	 * @return int
	 */
	public int getNumStudent(ArrayList<Student> list) {
		return list.size();
	}

	/**
	 * Renvoie l'id du Player qui controlle la Zone
	 * @return int
	 */
	public int getControlPlayer() {
		return this.controlPlayer;
	}

	/**
	 * Renvoie le numero (id) de la Zone
	 * @return int
	 */
	public int getNumZone() {
		return this.numZone;
	}

	/**
	 * Renvoie le nom de la Zone
	 * @return NomDeZone
	 */
	public NomDeZone getNomZone() {
		return this.nom;
	}

	/**
	 * Renvoie la somme des credit ECTS de tout les Students du Player 1
	 * @return Double
	 */
	public Double getEcts1() {
		Iterator<Student> iter = this.listS1.iterator();
		int ect = 0;
		while (iter.hasNext()) {
			Student S = (Student) iter.next();
			ect += S.getCreditECTS();
		}
		this.Ects1 = ect;
		return this.Ects1;
	}


	/**	 
	 * Renvoie la somme des credits ECTS de tout les Students du Player 2
	 * @return Double
	 */
	public Double getEcts2() {
		Iterator<Student> iter = this.listS2.iterator();
		int ect = 0;
		while (iter.hasNext()) {
			Student S = (Student) iter.next();
			ect += S.getCreditECTS();
		}
		this.Ects2 = ect;
		return this.Ects2;
	}
	
/** -------------------------- Setters -------------------------- */

	/**
	 * Remplie la list des etudiants de la zone avec ceux du joueur 1
	 * @param ListAll Liste des STudent du joueur 1
	 */
	public void setListStu1(ArrayList<Student> ListAll) {
		ArrayList<Student> list = new ArrayList<>();
		for (int n = 0; n < ListAll.size(); n++) {
			Student S = ListAll.get(n);
			if (S.getZoneDeCombat() == numZone) {
				list.add(S);
			}
		}
		this.listS1 = list;
		Collections.sort(this.listS1, Comparator.comparingDouble(Student::getCreditECTS));
	}

	/**
	 * Remplie la list des etudiants de la zone avec ceux du joueur 2
	 * @param ListAll Liste des Student du joueur 2
	 */
	public void setListStu2(ArrayList<Student> ListAll) {
		ArrayList<Student> list = new ArrayList<>();
		for (int n = 0; n < ListAll.size(); n++) {
			Student S = ListAll.get(n);
			if (S.getZoneDeCombat() == numZone) {
				list.add(S);
			}
		}
		this.listS2 = list;
		Collections.sort(this.listS2, Comparator.comparingDouble(Student::getCreditECTS));
	}

	/**
	 * Definie l'ordre de la liste contenant les joueurs pour avoir l'ordre de jeu
	 */
	public void setListAct() {
		for (int n = 0; n < this.listS1.size(); n++) {
			Object S = this.listS1.get(n);
			this.listAct.add((Student) S);
		}
		for (int n = 0; n < this.listS2.size(); n++) {
			Object S = this.listS2.get(n);
			this.listAct.add((Student) S);
		}
		Comparator.naturalOrder();
		Collections.sort(this.listAct, Comparator.comparingDouble(Student::getInitiative).reversed());
	}

/** -------------------------- Functions -------------------------- */
	/**
	 * Enleve le Student si ce dernier n'as plus de Credit ECTS
	 * @param List Liste des Student
	 */
	public void removeStudent(ArrayList<Student> List) {
		Student S = (Student) List.get(0);
		if (S.estMorts()) {
			List.remove(S);
			this.listAct.remove(S);
		}
	}

	/**
	 * Verifie si la zone est controlee
	 * @param list1 Liste des Student du Joueur 1
	 * @param list2 Liste des Student du Joueur 2
	 */
	public void zoneControlled(ArrayList<Student> list1, ArrayList<Student> list2) {
		if (getNumStudent(list1) == 0) {
			this.controlPlayer = 2;
			this.status = true;
		} else {
			if (getNumStudent(list2) == 0) {
				this.controlPlayer = 1;
				this.status = true;
			}
		}
	}
	
	
	/**
	 * Renvoie tout les etudiants qui ne correspondent pas a l'id passe en parametre 
	 * (pour le joueur possedant la zone)
	 * @param list Liste des etudiants present dans la zone
	 * @param id ID de l'etudiant qui reste dans la zone
	 */
	public void returnStudent(ArrayList<Student> list, int id) {
		if(this.getControlPlayer()==1) {
			listS1.remove(id);
			Iterator<Student> iter1 = this.listS1.iterator();
			while (iter1.hasNext()) {
				Student S = iter1.next();
				S.setReserviste(0);
				list.add(S);
			}
		} else if(this.getControlPlayer()==2) {
			listS2.remove(id);
			Iterator<Student> iter2 = this.listS2.iterator();
			while (iter2.hasNext()) {
				Student S = iter2.next();
				S.setReserviste(0);
				list.add(S);
			}
		}	
	}

	/**
	 * Methode que le combat se deroule dans la zone
	 */
	public void fight() {
		for (int n = 0; n < getNumStudent(listAct); n++) {
			Student S = this.listAct.get(n);
			S.ExecuterStrategie();
			if (S.getStrategie().ordinal() == 0) {
				if (this.listS1.contains(S)) {

					Collections.sort(this.listS1, Comparator.comparingDouble(Student::getLooseEcts));
					Student s = this.listS1.get(0);
					int x = this.listS1.indexOf(s);
					int y = this.listAct.indexOf(s);
					this.listS1.remove(s);
					this.listAct.remove(s);
					S.SoignerAllie(s);
					this.listS1.add(x, s);
					this.listAct.add(y, s);
				} else {

					Collections.sort(this.listS2, Comparator.comparingDouble(Student::getLooseEcts));
					Student s = this.listS2.get(0);
					int x = this.listS2.indexOf(s);
					int y = this.listAct.indexOf(s);
					this.listS2.remove(s);
					this.listAct.remove(s);
					S.SoignerAllie(s);
					this.listS2.add(x, s);
					this.listAct.add(y, s);
				}
			} else {
				if (this.listS1.contains(S)) {

					Collections.sort(this.listS2, Comparator.comparingDouble(Student::getLooseEcts));
					Student s = this.listS2.get(0);
					int x = this.listS2.indexOf(s);
					int y = this.listAct.indexOf(s);
					this.listS2.remove(s);
					this.listAct.remove(s);
					S.SoignerAllie(s);
					this.listS2.add(x, s);
					this.listAct.add(y, s);
					S.Attaquer(s);
					removeStudent(this.listS2);
				} else {
					Collections.sort(this.listS1, Comparator.comparingDouble(Student::getLooseEcts));
					Student s = this.listS1.get(0);
					int x = this.listS1.indexOf(s);
					int y = this.listAct.indexOf(s);
					this.listS1.remove(s);
					this.listAct.remove(s);
					S.SoignerAllie(s);
					this.listS1.add(x, s);
					this.listAct.add(y, s);
					S.Attaquer(s);
					removeStudent(this.listS1);
				}
			}
			zoneControlled(this.listS1, this.listS2);
			if (this.status == true) {
				break;
			}
		}
	}

	/**
	 * Function toString, renvoie toute les informations de la Zone au format String
	 * @return String
	 */
	public String toString() {
		StringBuffer str = new StringBuffer();

		str.append("+++++++++++++++++++++++++++++++++++++++++++++ \n");
		str.append("number of the zone " + getNumZone() + "\n");
		str.append("name of the zone " + getNomZone() + "\n");
		str.append("Number of students on the zone "+ this.listAct.size()+ "\n");
		str.append("status " + getStatus() + "\n");
		str.append("control player " + getControlPlayer() + "\n");
		str.append("++++++++++++++++++++++++++++++++++++++++++++++ \n");

		return str.toString();
	}
}
