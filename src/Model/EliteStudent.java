package Model;

/**
 * Classe EliteStudent, herite de la classe Student et donc de toute ses
 * fonctions.
 * @author Noe Lecointe
 * @author Wang Zezhong
 */
public class EliteStudent extends Student {

	/** Constructeur de la classe EliteStudent */
	public EliteStudent() {
		super();
		this.setForce(1);
		this.setDexterite(1);
		this.setResistance(1);
		this.setConstitution(5);
		this.setInitiative(1);
	}
}
