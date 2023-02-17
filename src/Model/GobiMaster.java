package Model;

/**
 * Classe GobiMaster, herite de la classe Student et donc de toute ses
 * fonctions.
 * @author Noe Lecointe
 * @author Wang Zezhong
 */
public class GobiMaster extends Student {

	/** Constructeur de la classe GobiMaster */
	public GobiMaster() {
		super();
		this.setForce(2);
		this.setDexterite(2);
		this.setResistance(2);
		this.setConstitution(10);
		this.setInitiative(2);
	}
}
