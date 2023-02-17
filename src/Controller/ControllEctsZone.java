package Controller;

import Model.Jeu;
import Model.NomDeZone;

/**
 * Class Controlleur pour la View ectsZone
 * @author Noe Lecointe
 * @author Wang Zezhong
 */
public class ControllEctsZone {
	/**
	 * Renvoie le nom de la zone dont l'id est passee en parametre
	 * @param j Instance du Jeu actuellement en cours
	 * @param i Id de la zone dont on souhaite avoir le nom
	 * @return NomDeZone
	 */
	public NomDeZone txt(Jeu j, int i) {
		return j.listZone.get(i).getNomZone();
	}
	
	/**
	 * Renvoie la somme des ECTS de tout les etudiants present dans la zone
	 * @param j Instance du Jeu actuellement en cours
	 * @param i Id de la zone.
	 * @return Double
	 */
	public Double d(Jeu j, int i) {
		return j.listZone.get(i).getEcts1() + j.listZone.get(i).getEcts2();
	}
}
