package Model;

import java.util.*;

/**
 * Classe Jeu, contient toute les informations en rapport avec le Jeu
 * @author Noe Lecointe
 * @author Wang Zezhong
 */
public class Jeu {

	/** Definition des variables de la classe Player */
	public Player player1;
	public Player player2;
	public ArrayList<Zone> listZone = new ArrayList<>();

	/** Constructeur de la classe Player */
	public Jeu() {
		createZone();
	}


	/**
	 * Creation du joueur 1
	 * @param name Nom du Joueur
	 * @param prog Programme du Joueur
	 */
	public void creatPlayer1(String name, Programmes prog) {
		Player p = new Player(name, prog);
		this.player1 = p;
	}
	
	/**
	 * Creation du joueur 2
	 * @param name Nom du Joueur
	 * @param prog Programme du Joueur
	 */
	public void creatPlayer2(String name, Programmes prog) {
		Player p = new Player(name, prog);
		this.player2 = p;
	}


	/**
	 * Creation des zones de combats
	 */
	public void createZone() {
		for (int n = 0; n < 5; n++) {
			Zone Z = new Zone(n);
			this.listZone.add(Z);
		}
	}
	
	/**
	 * positionne chaque etudiants de chaque joueur dans la zone a laquel ils appartiennent
	 * @param j Id du joueur (1 ou 2)
	 */
	public void setZone(int j) {
		for(int n = 0; n < this.listZone.size(); n++) {		
			if(j == 1) {
				this.listZone.get(n).listS1 = new ArrayList<>();
				this.listZone.get(n).setListStu1(this.player1.listS);
			} else if (j == 2) {
				this.listZone.get(n).listS2 = new ArrayList<>();
				this.listZone.get(n).listAct = new ArrayList<>();
				this.listZone.get(n).setListStu2(this.player2.listS);
				this.listZone.get(n).setListAct();				
			}
		}
	}

	/**
	 * Code qui permet de faire un tour de combat pour une zone en particulier
	 * @param z Id de la zone ou le combat se deroule
	 */
	public void oneRound(int z) {
		Zone Z = this.listZone.get(z);
		if(Z.getStatus() == false) {
			Z.fight();
		} else {
			return;
		}
	}

	/**
	 * Methode qui lance le combat, continue tant que la methode truce() ne retourne pas true.
	 */
	public void battle() {
		while (true) {
			for (int i = 0; i < this.listZone.size(); i++) {
				if (this.Truce()) {
					break;
				}
				this.oneRound(i);
			}
			if(this.Truce()) { 
				return;
			}
		}
	}

	/**
	 * Methode qui verifie si le combat dans une zone est termine ou non.
	 * @return boolean
	 */
	public boolean Truce() {
		boolean aTruce = false;
		for (int i = 0; i < this.listZone.size(); i++) {
			Zone Z = this.listZone.get(i);
			if(Z.getStatus()) {
				aTruce = true;
			}
		}		
		return aTruce;
	}
}

