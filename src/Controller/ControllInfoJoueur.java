package Controller;

import java.awt.event.KeyEvent;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Model.Jeu;
import Model.Programmes;
import view.Param;

/**
 * Class Controlleur pour la View InfoJoueur
 * @author Noe Lecointe
 * @author Wang Zezhong
 */
public class ControllInfoJoueur {
	
	/**
	 * Permet de limiter ce qu'entre les joueurs dans la zone pour le pseudo
	 * @param evt Evenement (id de la touche appuyee sur le clavier)
	 * @param p Nombre de caractere max pour le pseudo des joueur
	 */
	public void limit(KeyEvent evt, int p) {
		char c = evt.getKeyChar();
		if(!Character.isLetterOrDigit(c) || p > 10) {
			evt.consume();
		}
	}
	
	/**
	 * Methode qui valide le pseudo des joueurs ainsi que leur programme
	 * Si il y a une erreur, envoie un message d'erreur
	 * Sinon affiche la page Param
	 * @param progJ1 Programme du Joueur 1
	 * @param progJ2 Programme du Joueur 2
	 * @param pseudoJ1 Pseudo du Joueur 1
	 * @param pseudoJ2 Pseudo du Joueur 2
	 * @param txtErrorP1 TextField d'erreur pour le pseudo du Joueur 1
	 * @param txtErrorP2 TextField d'erreur pour le pseudo du Joueur 2
	 * @param txtErrorProg TextFuekd d'erreur en cas de programme similaire
	 * @param j Instance de Jeu en cours
	 * @param frame La Frame utilisee
	 */
	public void valid(JComboBox<Programmes> progJ1, JComboBox<Programmes> progJ2, JTextField pseudoJ1, JTextField pseudoJ2, JTextArea txtErrorP1, JTextArea txtErrorP2, JTextArea txtErrorProg, Jeu j,JFrame frame ) {
		int id1 = progJ1.getSelectedIndex();	
		int id2 = progJ2.getSelectedIndex();
		String P1 = pseudoJ1.getText();
		String P2 = pseudoJ2.getText();
		if(P1.isEmpty() || P2.isEmpty() || progJ1.getItemAt(id1) == progJ2.getItemAt(id2)) {
			if(P1.isEmpty()) {
				txtErrorP1.setText("Entrer un pseudo !");
			} else {
				txtErrorP1.setText("");
			}
			if (P2.isEmpty()) {
				txtErrorP2.setText("Entrer un pseudo !");
			} else {
				txtErrorP2.setText("");						
			}
			if(progJ1.getItemAt(id1) == progJ2.getItemAt(id2)) {
				txtErrorProg.setText("Rentrer un programme différent pour les deux joueurs");
			} else {
				txtErrorProg.setText("");
			}
			return;
		}	
		
		j.creatPlayer1(P1, progJ1.getItemAt(id1));
		j.creatPlayer2(P2, progJ2.getItemAt(id2));

		
		new Param(frame, j, 1);
	}
	
}
