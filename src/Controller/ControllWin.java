package Controller;

import javax.swing.JFrame;

import Model.Jeu;
import Model.Player;
import Model.Zone;
import view.Defend;
import view.Win;

/**
 * Class Controlleur pour la View Win
 * @author Noe Lecointe
 * @author Wang Zezhong
 */
public class ControllWin {

	/**
	 * Si le jeu est termine (3 zones gagnees par 1 joueur) affiche la page Win (fin de jeu)
	 * Sinon, affiche la page Defend.
	 * @param frame La Frame utilisé
	 * @param j Instance de Jeu en cours
	 * @param p Joueur ayant gagne la zone
	 * @param zone Zone gagne
	 */
	public void next(JFrame frame, Jeu j, Player p, Zone zone) {
		if (p.testwin()) {
			new Win(frame, j, p, zone, 1);
		} else {														
			new Defend(frame, j, p, zone);
		}
	}
}
