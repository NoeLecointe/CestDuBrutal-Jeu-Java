package Model;

/**
 * Enumerateur de toute les zones de combats
 * @author Noe Lecointe
 * @author Wang Zezhong
 */
public enum NomDeZone {
	Bibliotheque, BureauDesEtudiants, QuartierAdministratif, HallesIndustrielle, HalleSportive, Reserve;

	/**
	 * Renvoie toute les zones de combat présente dans le jeu.
	 * @return NomDeZone[]
	 */
	public static NomDeZone[] Zone() {
		NomDeZone [] n = {NomDeZone.Bibliotheque, NomDeZone.BureauDesEtudiants, NomDeZone.QuartierAdministratif, NomDeZone.HallesIndustrielle, NomDeZone.HalleSportive};
		return n;
	};
	
	/**
	 * Renvoie la zone de Reserve
	 * @return NomDeZone[];
	 */
	public static NomDeZone[] Reserve() {
		NomDeZone [] n = {NomDeZone.Reserve};
		return n;
	}
	
	
	/**
	 * renvoie la position du nom de la zone passe en argument
	 * @param n Nom de la zone que l'on recherche
	 * @return int
	 */
	public static int numZone(NomDeZone n) {
		if (n == NomDeZone.Bibliotheque) {
			return 0;
		} else if (n == NomDeZone.BureauDesEtudiants) {
			return 1;
		} else if (n == NomDeZone.QuartierAdministratif) {
			return 2;
		} else if (n == NomDeZone.HallesIndustrielle) {
			return 3;
		} else {
			return 4;
		}
	}
	
};

