package Controller;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextPane;

/**
 * Class Controlleur pour la View Regle
 * @author Noe Lecointe
 * @author Wang Zezhong
 */
public class ControllRegle {

	/**
	 * box
	 * @param id Id de ce que l'on souhaite voir
	 * @param txtRegle TextPane a modifier en fonction de l'id
	 * @param test Permet de voir dans quelle partie des regles nous sommes
	 */
	public void box(int id, JTextPane txtRegle, String test) {

		if(test == "Crédits ECTS") {
			if(id == 0) {
				txtRegle.setText("- Crédits ECTS : ce nombre de crédits est initialement de 30. Lorsque la valeur atteint 0 ou moins, l’étudiant sort définitivement de la bataille.\r\n");
			} else if (id == 1) {
				txtRegle.setText("- Dextérité : la dextérité initialement affectée à 0 est comprise entre 0 et 10. Elle augmente les chances de \"toucher\" son adversaire en lançant son gobelet (dit le gobi) lors d’une attaque, ou d’esquiver lorsqu’il est attaqué. Un point correspond à 3% de chance supplémentaire d’atteindre sa cible ou d’esquiver une attaque. La dextérité sert également à la réussite d’un soin porté à un frère d’arme. Un point correspond à 6% de chance supplémentaire de réussir le soin.");
			} else if (id == 2) {
				txtRegle.setText("- Force : la force initialement affectée à 0 est comprise entre 0 et 10. Elle augmente les dégâts que peut infliger un étudiant à son adversaire de 10% par point affecté. Ainsi, un étudiant avec une force de 2 \"frappera\" avec 20% de force en plus. Il fera 20% de dégâts en plus.");
			} else if (id == 3) {
				txtRegle.setText("- Résistance : la résistance initialement affectée à 0 est comprise entre 0 et 10. Elle permet de diminuer les dégâts reçus de 5% par point affecté. Ainsi, un étudiant avec une résistance de 2 \"absorbera\" 10% des dégâts infligés.");
			} else if (id == 4) {
				txtRegle.setText("- Constitution : la constitution initialement à 0 est comprise entre 0 et 30. Elle permet d’augmenter la constitution d’un étudiant en lui donnant des crédits ECTS supplémentaires. Ainsi, 10 points de constitution font augmenter les crédits ECTS initiaux à 40 (au lieu de 30).");
			} else if (id == 5) {
				txtRegle.setText("- Initiative : l’initiative initialement affectée à 0 est comprise entre 0 et 10. Sur une zone de combat, l’étudiant qui a la plus forte initiative effectue son action, puis c’est au tour de l’étudiant qui a la seconde meilleure initiative etc… A titre d’exemple, les trois premiers étudiants à effectuer leur action peuvent appartenir à la même équipe.");
			} else {
				txtRegle.setText("- Stratégie : Chaque étudiant possède une stratégie qui peut être défensive, offensive ou aléatoire.");
			}
		}
		if(test == "Paramétrage") {
			if (id == 0) {
				txtRegle.setText("En début de partie, chaque joueur possède 400 points à distribuer à chacun de ses 20 combattants en les affectant aux caractéristiques Force, Dextérité, Résistance, Constitution, Initiative. Le joueur choisit également 5 combattants qui seront des réservistes (un réserviste peut être un étudiant, un étudiant d’élite ou le maître du gobi), les 15 autres se retrouveront donc sur le champ de bataille dès le début des hostilités. Cette étape est bien entendue cachée pour l’adversaire. Chaque étudiant aura également une stratégie de combat)");
			} else if (id == 1) {
				txtRegle.setText("A cette étape, chaque joueur décide de répartir ses 15 combattants sur les 5 zones de combat. Il répartit à sa convenance ses troupes : il peut par exemple choisir de ne mettre qu’un seul combattant sur une zone (un sacrifice) et d’en mettre 5 sur une autre zone. Cette étape est bien entendue cachée pour l’adversaire)\nChaque joueur doit affecter au moins un combattant à chaque zone.");
			} else if (id == 2) {
				txtRegle.setText("La bataille est lancée et les 5 zones de combats font rage. Au fur et à mesure, les crédits ECTS des étudiants peuvent augmenter ou diminuer. \nUne mêlée s’achève avec le contrôle d’une des zones par un des joueurs (les adversaires ont été terrassés sur cette zone). \nUne trêve est donc déclarée et tous les combats sur les 5 zones sont arrêtés. Trêve pendant laquelle chaque joueur peutsournoisement faire certains mouvements de troupes à l’insu de son adversaire)");
			} else if (id == 3) {
				txtRegle.setText("A cette étape les 2 joueurs peuvent faire les actions suivantes de manière cachée :\n\n"
					+ "- Affecter 1 ou plusieurs réservistes sur les zones de combats non contrôlées\n\n"
					+ "- Si un joueur contrôle déjà une zone de combat, il peut redéployer ses combattant valides qui se trouvent sur cette zone vers d’autres zones de combats. Mais, un combattant doit rester sur la zone contrôlée pour maintenir l’ordre et l’influence du programme. Attention, un combattant qui est redéployé ne regagne pas de crédits ECTS. Il repart au combat avec ses blessures. Un combattant redéployé peut se voir attribuer une nouvelle stratégie.\n\n"
					+ "- On ne peut pas redéployer de combattants d’une zone dont le combat n’est pas fini.\n\n"
					+ "- Le joueur peut connaître le nombre de crédits ECTS par zone de combat.)");
			} else {
				txtRegle.setText("Les étapes 3 et 4 se répètent jusqu’à ce qu’un joueur contrôle au moins 3 zones et est donc déclaré vainqueur");
			}
		}
	}

	/**
	 * Regle
	 * @param id Id de ce que l'on souhaite voir
	 * @param txtRegle TextPane que l'on modifie en fonction du menu deroulant
	 * @param panel Panel de ce qui est affiche
	 * @param box Menu deroulant qui s'affiche selon certaines partie des regles
	 */
	public void regle(int id, JTextPane txtRegle, JPanel panel, JComboBox<String> box) {
		if(id == 0) {
			txtRegle.setText("Le jeu C’est du brutal ! se joue à deux joueurs et a pour décor l’université de technologie de Montauban. Chaque joueur représente un des sept programmes de l’UTM (ISI, RT, A2I, GI, GM, MTE, MM) et possède un effectif de 20 étudiants. A l’aide de son équipe, chaque joueur devra essayer de contrôler une majorité de zones d’influence.");
			panel.remove(box);
		} else if (id == 1) {
			txtRegle.setText("Ces zones d’influence sont\r\n"
					+ "1. La bibliothèque\r\n"
					+ "2. Le Bureau des Etudiants\r\n"
					+ "3. Le Quartier Administratif\r\n"
					+ "4. Les Halles industrielles\r\n"
					+ "5. La Halle Sportive");
			panel.remove(box);
		} else if (id == 2) {
			txtRegle.setText("- Crédits ECTS : ce nombre de crédits est initialement de 30. Lorsque la valeur atteint 0 ou moins, l’étudiant sort définitivement de la bataille.");
			box.setModel(new DefaultComboBoxModel<String>(new String[] {"Crédits ECTS", "Dextérité", "Force", "Résistance", "Constitution", "Initiative", "Stratégie"}));
			panel.add(box);
		} else if (id == 3) {
			txtRegle.setText(" Soigner un combattant allié. Cela consiste à choisir un allié sur la même zone de combat ayant le moins de crédits ECTS. Pour le soigné, le nombre de crédits gagnés dépend de la dextérité du soignant et de la constitution du soigné \n \n"
					+ "- Attaquer frontalement. Sur sa zone de combat, l’étudiant lance son gobi à l’ennemi qui a le moins de crédits ECTS.\n \n"
					+  "Soigner un partenaire constitue une stratégie défensive alors qu’attaquer frontalement est une stratégie offensive. Une stratégie aléatoire consiste pour un étudiant à évoluer d’une stratégie à une autre de manière aléatoire.");
			panel.remove(box);
		} else if (id == 4) {
			txtRegle.setText("Les 20 protagonistes de chaque équipe sont hiérarchisés de la manière suivante : \n \n" 
					+ "- 15 étudiants avec les caractéristiques initiales présentées précédemment. \n \n"
					+ "- 4 étudiants d’élite avec des caractéristiques initiales augmentées (Force +1, Dextérité +1, Résistance +1, Constitution +5, Initiative +1)\n \n"
					+ "- 1 Maitre du gobi avec des caractéristiques initiales augmentées (Force +2, Dextérité +2, Résistance +2, Constitution +10, Initiative +2)");
			panel.remove(box);
		} else {
			txtRegle.setText("En début de partie, chaque joueur possède 400 points à distribuer à chacun de ses 20 combattants en les affectant aux caractéristiques Force, Dextérité, Résistance, Constitution, Initiative. Le joueur choisit également 5 combattants qui seront des réservistes (un réserviste peut être un étudiant, un étudiant d’élite ou le maître du gobi), les 15 autres se retrouveront donc sur le champ de bataille dès le début des hostilités. Cette étape est bien entendue cachée pour l’adversaire. Chaque étudiant aura également une stratégie de combat)");
			box.setModel(new DefaultComboBoxModel<String>(new String[] {"Paramétrage", "Affectation", "Mêlée", "Trève et mouvement", "Cycle"}));
			panel.add(box);
		}
	}
}

