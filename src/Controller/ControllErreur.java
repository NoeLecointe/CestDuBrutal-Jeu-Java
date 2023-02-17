package Controller;

import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JTextPane;

/**
 * Class Controlleur pour la View Erreur
 * @author Noe Lecointe
 * @author Wang Zezhong
 */
public class ControllErreur {
	/**
	 * Change l'affichage de la page Erreur en fonction du type d'erreur 
	 * (Pas assez de reserviste / Aucun etudiant dans certaines zones)
	 * @param Terror Type d'erreur
	 * @param list Liste des informations passee en parametre en fonction de l'erreur
	 * (liste de zone ou liste d'etudiant)
	 * @param textPane Zone de text a modifie en fonction de l'erreur.
	 */
	public void typeError(int Terror, ArrayList<String> list, JTextPane textPane) {
		if (Terror == 0) {
			String s = "Il n'y a pas d'étudiants dans la / les zones suivante(s)\n\n";
			for (Iterator<String> zone = list.iterator(); zone.hasNext();) {
				s += "- "+ zone.next() + "\n";
			}
			textPane.setText(s);
		} else if (Terror == 1) {
			String s = "Il n'y a pas assez d'étudiants reservistes.\nLes étudiants actuellement reservistes sont :\n";
			for (Iterator<String> e = list.iterator(); e.hasNext();) {
				s += "- " + e.next() + "\n";
 			}
			s += "Ils vous faut au minimum 5 étudiants réservistes.";
			textPane.setText(s);
		}
	}
}
