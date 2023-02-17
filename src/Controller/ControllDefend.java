package Controller;

import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JFrame;

import Model.Jeu;
import Model.Student;
import Model.Zone;
import view.ReParam;

/**
 * Class Controlleur pour la View Defend
 * @author Noe Lecointe
 * @author Wang Zezhong
 */
public class ControllDefend {
	
	/**
	 * Renvoie un tableau de String contenant le nom des etudiants present dans 
	 * l'ArrayList passe en parametre
	 * @param s Liste des Etudiants
	 * @return str
	 */
	public String [] tab(ArrayList<Student> s) {
		String[] str = new String[s.size()];
		for (int i = 0; i < s.size(); i++) {
			str[i] = s.get(i).getname();
		}
		return str;
	}

	/**
	 * Met les etudiants autre que celui choisi pour defendre en reserviste
	 * Enleve la zone qui vient d'etre gagne de la liste de zone du Jeu
	 * Affiche la page ReParam
	 * @param z Zone qui vient d'etre gagnee et defendu
	 * @param s Liste des etudiants
	 * @param student Etudiant choisi pour defendre la zone gagnee
	 * @param j L'instance du Jeu actuellement en cours
	 * @param frame La frame utilisee
	 */
	public void next(Zone z, ArrayList<Student> s, JComboBox<String> student, Jeu j, JFrame frame) {
		z.returnStudent(s, student.getSelectedIndex());
		j.listZone.remove(z);
		new ReParam(frame, j, j.player1);
	}
}
