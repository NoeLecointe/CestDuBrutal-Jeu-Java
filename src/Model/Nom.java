package Model;

/**
 * Enumerateur de tous les noms des etudiants present dans le jeu.
 * @author Noe Lecointe
 * @author Wang Zezhong
 */
public enum Nom {
	Jack, Rose, Bill, Chris, Isa, James, Robert, John, Michael, Mary, Patricia, Jennifer, William, Richard,
	Fred, Thomas, Sarah, Karen, Lisa, Daniel,
	Hippolyte, Célestine, Tom, Joseph, Léopold, Caroline, Charlotte, Grace, Damien, Elise, Pierrick, David, Marine,
	Annabelle, Manon, Odile, Marwan, Bixente, Anas, Danielle;
	
	
	/**
	 * renvoie le nom du GobiMaster du joueur 1
	 * @return Nom[]
	 */
	public static Nom[] GobiMaster1() {
		Nom [] n = {Nom.Jack};
		return n;
	};
	
	/**
	 * renvoie la liste des noms des EliteStudent du joueur 1
	 * @return Nom[]
	 */
	public static Nom[] EliteStudent1() {
		Nom[] n = {Nom.Rose, Nom.Bill, Nom.Chris, Nom.Isa};
		return n;
	};
	
	/**
	 * renvoie la listes des noms des Student du joueur 1
	 * @return Nom[]
	 */
	public static Nom[] Student1() {
		Nom[] n = {Nom.James, Nom.Robert, Nom.John, Nom.Michael, Nom.Mary, Nom.Patricia, Nom.Jennifer, Nom.William, Nom.Richard, Nom.Fred, Nom.Thomas, Nom.Sarah, Nom.Karen, Nom.Lisa, Nom.Daniel};
		return n;
	};

	/**
	 * renvoie le nom du GobiMaster du joueur 2
	 * @return Nom[]
	 */
	public static Nom[] GobiMaster2() {
		Nom [] n = {Nom.Hippolyte};
		return n;
	};
	
	/**
	 * renvoie la liste des noms des EliteStudent du joueur 2
	 * @return Nom[]
	 */
	public static Nom[] EliteStudent2() {
		Nom[] n = {Nom.Célestine, Nom.Tom, Nom.Joseph, Nom.Léopold};
		return n;
	};
	
	/**
	 * renvoie la listes des noms des Student du joueur 2
	 * @return Nom[]
	 */
	public static Nom[] Student2() {
		Nom[] n = {Nom.Caroline, Nom.Charlotte, Nom.Grace, Nom.Damien, Nom.Elise, Nom.Pierrick, Nom.David, Nom.Marine, 
				Nom.Annabelle, Nom.Manon, Nom.Odile, Nom.Marwan, Nom.Bixente, Nom.Anas, Nom.Danielle};
		return n;
	};
}
	


