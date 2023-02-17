package Model;

import java.util.*;


/** 
 * Classe Player, contient toute les informations en rapport avec les Players
 * @author Noe Lecointe
 * @author Wang Zezhong
 */
public class Player {

	/** Definition des variables de la classe Player */
	public Programmes programmes;
	public String nickname;
	private int points;
	public int controlledZone;
	public ArrayList<Student> listS = new ArrayList<>();
	public ArrayList<Student> listr = new ArrayList<>();

	/**
	 * Contructeur de la classe Player
	 * @param name Nom du joueur
	 * @param p Programme du joueur
	 */
	public Player(String name, Programmes p) {
		setName(name);
		setProgrammes(p);
		this.points = 400;
		this.controlledZone = 0;
	}

/** -------------------------- Getters -------------------------- */
	/**
	 * Renvoie le pseudo de l'utilisateur
	 * @return String
	 */
	public String getName() {
		return this.nickname;
	}
	
	/**
	 * Renvoie un Student en fonction de son nom.
	 * @param name Nom de l'etudiant que l'on souhaite
	 * @return Student
	 */
	public Student getStudent(String name) {
		Iterator<Student> iter = listS.iterator();
		while (iter.hasNext()) {
			Student s = iter.next();
			if (s.getname() == name) {
				return s;
			} 
		}
		return null;
	}

	/**
	 * Renvoie le nombre de points de caracteristique en stock du Player
	 * @return int
	 */
	public int getPoints() {
		return this.points;
	}

/** -------------------------- Setters -------------------------- */
	/**
	 * Definie le pseudo de l'utilisateur
	 * @param name Nom du Joueur
	 */
	public void setName(String name) {
		this.nickname = name;
	}

	/**
	 * Definie le programme du joueur
	 * @param p Programme
	 */
	public void setProgrammes(Programmes p) {
		this.programmes = p;
	}

	/**
	 * Redefinie un etudiant (sa strategie, reserviste ou non et sa zone.
	 * @param S L'etudiant que l'on souhaite redefinir
	 * @param strat La nouvelle strategie
	 * @param re Reserviste ou non
	 * @param zone La nouvelle zone
	 */
	public void reSetStudent(Student S,int strat, int re, int zone) {
		S.setStrategie(strat);
		S.setReserviste(re);
		S.setZoneDeCombat(zone);
		if (S.getReserviste() == false) {
			listr.remove(S);
		}
		
	}

	/**
	 * Definie les caracteristique d'un Etudiant en fonction des donnees entree en parametre
	 * @param S L'etudiant a definir
	 * @param force La force a ajouter
	 * @param dext La dexterite a ajouter
	 * @param res La resistance a ajouter
	 * @param constitution La constitution a ajouter
	 * @param ini L'initiative a ajouter
	 * @param strat La strategie mise en place
	 * @param re Reserviste ou non
	 * @param zone La zone ou l'etudiant est envoye
	 */
	public void setStudent(Student S, int force, int dext, int res, int constitution, int ini, int strat, int re, int zone) {

		int p = this.points - (force + dext + constitution + res + ini);
		if (testPoints(p) == true) {
			this.points = p;
		} else {
			return;
		}
		S.setPoints(force + dext + constitution + res + ini);
		S.setForce(force);
		S.setDexterite(dext);
		S.setResistance(res);
		S.setConstitution(constitution);
		S.setInitiative(ini);
		S.setMaxEcts(S.getCreditECTS());
		S.setStrategie(strat);
		S.setReserviste(re);
		S.setZoneDeCombat(zone);
		if (S.getReserviste()) {
			listr.add(S);
		} else {
			listr.remove(S);
		}
	}
	
	/**
	 * Permet de reinitialiser l'etudiant en parametre
	 * @param S L'etudiant a reset
	 */
	public void resetS(Student S) {
		
		int re = S.force + S.dexterite + S.resistance + S.constitution + S.initiative;

		if (S instanceof GobiMaster) {
			S.force = 2;
	        S.dexterite = 2;
	        S.resistance = 2;
	        S.constitution = 10;
	        S.initiative = 2;
	        S.points = 0;
	        re -= 18;
		} else if (S instanceof EliteStudent) {
			S.force = 1;
	        S.dexterite = 1;
	        S.resistance = 1;
	        S.constitution = 5;
	        S.initiative = 1;
	        S.points = 0;
	        re -= 9;
		} else {
			S.force = 0;
			S.dexterite = 0;
			S.resistance = 0;
			S.constitution = 0;
			S.initiative = 0;
	        S.points = 0;
		}
		
		this.points += re;
		S.ects = 30;
        S.setStrategie(2);
        S.setReserviste(1);
        S.setZoneDeCombat(0);
        
        listr.remove(S);
	}

/** -------------------------- Function -------------------------- */
	/**
	 * Test qui verifie si la partie est gagnee.
	 * @return boolean
	 */
	public boolean testwin() {
		if (this.controlledZone >= 3) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Lorsque l'utilisateur prend le contrôle d'une zone, augmente le nombre de zone controllee
	 */
	public void zoneControlled() {
		this.controlledZone++;
	}

	/**
	 * Function qui creer tout les étudiants que possèdent le Player
	 */
	public void creerStudents() {
		Student S = new GobiMaster();
		this.listS.add(S);
		for (int n = 0; n < 4; n++) {
			Student S1 = new EliteStudent();
			this.listS.add(S1);
		}
		for (int n =0 ; n<15 ; n++) {
		 	Student S1 = new Student();
		    this.listS.add(S1);
		  }
	}

	/**
	 * Vérifie si il reste des points de caractéristique à utiliser.
	 * @param points Les points restant du joueur
	 * @return boolean
	 */
	public boolean testPoints(int points) {
		if (points >= 0) {
			return true;
		} else {
			return false;
		}
	}
}
