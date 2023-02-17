package Model;

import java.util.*;

/**
 * Classe Student, contient toute les informations des etudiants qui composent
 * les equipes des joueurs.
 * @author Noe Lecointe
 * @author Wang Zezhong
 */
public class Student {

    /** Definition des variables de la classe Student */
	public double ects;
    public String name;
    public int team;
    public int force;
    public int dexterite;
    public int resistance;
    public int constitution;
    public int initiative;
    public int points;
    private Strategie strategie = Strategie.aleatoire;
    private Strategie strategiePrecedent;
    private int zoneDeCombat;
    private Boolean reserviste = false;
    public int id;
    private double maxEcts;
    private double looseEcts;

    public static int num;
    {
        num++;
    }

    /**
     * Constructeur de la classe Student
     */
    public Student() {
        this.force = 0;
        this.dexterite = 0;
        this.resistance = 0;
        this.constitution = 0;
        this.initiative = 0;
        this.ects = 30;
        this.id = num;
        this.name = Nom.values()[num - 1].name();
    }

/** -------------------------- Getters -------------------------- */
    /**
     * Renvoie le nom du Student
     * @return String
     */
    public String getname() {
        return this.name;
    }

    /**
     * Renvoie le numero de l'equipe du Student
     * @return int
     */
    public int getTeam() {
        return this.team;
    }

    /**
     * Renvoie la Dexterite du Student
     * @return int
     */
    public int getDexterite() {
        return this.dexterite;
    }

    /**
     * Revoie la force du Student
     * @return int
     */
    public int getForce() {
        return this.force;
    }

    /**
     * Renvoie la resistance du Student
     * @return int
     */
    public int getResistance() {
        return this.resistance;
    }

    /**
     * Renvoie la constitution du Student
     * @return int
     */
    public int getConstitution() {
        return this.constitution;
    }

    /**
     * Renvoie l'initiative du Student
     * @return int
     */
    public int getInitiative() {
        return this.initiative;
    }

    /**
     * Renvoie le nombre de credit ECTS du Student
     * @return double
     */
    public double getCreditECTS() {
        return this.ects;
    }

    /**
     * Renvoie la strategie du Student
     * @return Strategie
     */
    public Strategie getStrategie() {
        return this.strategie;
    }

    /**
     * Renvoie le nom de la zone ou le Student est present
     * @return NomDeZone
     */
    public NomDeZone getNomZoneDeCombat() {
        return NomDeZone.values()[this.zoneDeCombat];
    }

    /**
     * Renvoie l'id de la zone ou le Student est present
     * @return int
     */
    public int getZoneDeCombat() {
        return this.zoneDeCombat;
    }

    /**
     * Renvoie l'id du Student
     * @return int
     */
    public int getId() {
        return this.id;
    }

    /**
     * Renvoie True ou False en fonction de si le Student est reserviste ou non
     * @return boolean
     */
    public boolean getReserviste() {
        return this.reserviste;
    }

    /**
     * Renvoie le nombre de credit ECTS perdu par le Student
     * @return double
     */
    public double getLooseEcts() {
        this.looseEcts = this.maxEcts - this.ects;
        return this.looseEcts;
    }

    /**
     * Renvoie le nombre de credit ECTS max du Student (credit de base)
     * @return double
     */
    public double getMaxEcts() {
        return this.maxEcts;
    }

/** -------------------------- Setters -------------------------- */
    /**
     * Definie l'equipe du Student
     * @param troupe Id du joueur
     */
    public void setTroupe(int troupe) {
        this.team = troupe;
    }


    /**
     * Definie la dexterite de l'etudiant en fonction des points entree par
     * l'utilisateur (la dexterite ne peut pas depasser 10)
     * @param dext Valeur de la dexterite a ajouter
     */
    public void setDexterite(int dext) {
        int n = this.dexterite + dext;
        if (n >= 0 && n <= 10) {
            this.dexterite = n;
        }
    }

    /**
     * Definie la force du Student en fonction des points entree par 
     * l'utilisateur (la force ne peut pas depasser 10)
     * @param force Valeur de la force a ajouter
     */
    public void setForce(int force) {
        int n = this.force + force;
        if (n >= 0 && n <= 10) {
            this.force = n;
        }
    }

    /**
     * Definie la resistance du Student en fonction des points entree par 
     * l'utilisateur (la resistance ne peut pas depasser 10)
     * @param resistance Valeur de la resistance a ajouter
     */
    public void setResistance(int resistance) {
        int n = this.resistance + resistance;
        if (n >= 0 && n <= 10) {
            this.resistance = n;
        }
    }

    /**
     * Definie la constitution du Student en fonction des points entree par 
     * l'utilisateur (la constitution ne peut pas depasser 30)
     * @param constitution Valeur de la Constitution a ajouter
     */
    public void setConstitution(int constitution) {
        int n = this.constitution + constitution;
        if(n == this.constitution) {
        	return;
        }
        if (n >= 0 && n <= 30) {
        	setCreditECTS(constitution);
            this.constitution = n;
        }
    }
    

    /**     
     * Definie l'initiative du Student en fonction des points entree par 
     * l'utilisateur (l'initiative ne peut pas depasser 10)
     * @param initiative Valeur de l'initiative a ajouter
     */
    public void setInitiative(int initiative) {
        int n = this.initiative + initiative;
        if (n >= 0 && n <= 10) {
            this.initiative = n;
        }
    }
    
    /**
     * @param p ?
     */
    public void setPoints(int p) {
    	this.points += p;
    }

    /**
     * Permet de redefinir les credits ECTS d'un Student en fonction de la valeur passee en parametre
     * @param d ECTS soignee ou perdu
     */
    public void reSetCreditECTS(double d) {
        if (d <= 30 + this.getConstitution()) {
            if (d > 0) {
                this.ects = d;
            } else {
                this.ects = 0;
            }
        } else {
            if (d > 0) {
                this.ects = 30 + this.getConstitution();
            } else {
                this.ects = 0;
            }
        }
    }

    /**
     * Definie les ects du Student (base de 30)
     * @param d Dexterite du joueur
     */
    public void setCreditECTS(double d) {
        this.ects = d + this.ects;
    }

    /**
     * Definie la strategie du Student
     * @param i Id de la strategie
     */
    public void setStrategie(int i) {
        if (i >= 0 && i <= 5) {
            this.strategie = Strategie.values()[i];
        }
    }

    /**
     * Definie l'id du Student
     * @param id Id du student
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Definie si le Student est reserviste ou non
     * @param re 0 si reserviste, 1 si pas reserviste
     */
    public void setReserviste(int re) {
    	this.reserviste = false;
    	if(re == 0) {
    		this.reserviste = true;
    	}
    }

    /**
     * Definie la zone ou le Student est envoyee.
     * @param i Id de la zone
     */
    public void setZoneDeCombat(int i) {
        if (i >= 0 & i <= 5) {
            this.zoneDeCombat = i;
        }
    }

    /**
     * Definie le nombre de credit ECTS max du Student (credit de base)
     * @param ects Ects de base du Student
     */
    public void setMaxEcts(double ects) {
        this.maxEcts = ects;
    }

/** -------------------------- Functions -------------------------- */
    /**
     * Verifie si le Student a encore des credits ECTS et est donc encore vivant
     * @return boolean
     */
    public boolean estVivant() {
        return this.ects >= 0;
    }

    /**
     * Verifie si l'etudiant n'as plus de credits ECTS et est donc mort
     * @return boolean
     */
    public boolean estMorts() {
        return this.ects <= 0;
    }

    /**
     * Renvoie un nombre aleatoire
     * @param b ?
     * @return double
     */
    public double ObtenirNombreAleatoire(double b) {
        Random r = new Random(System.currentTimeMillis());
        return r.nextDouble() * b;
    }

    /**
     * Function soigner, rend des credits ECTS au Student passe en parametre.
     * @param s Le student soigne
     * @return boolean
     */
    public boolean SoignerAllie(Student s) {
        double x = this.ObtenirNombreAleatoire(100.0);
        double y = this.ObtenirNombreAleatoire(0.6);
        if (x >= 0.0 && x <= (double) (20 + 6 * this.getDexterite())) {
            int e = (int) Math.floor(y * (double) (10 + this.constitution));
            s.reSetCreditECTS(s.getCreditECTS() + e);
            this.strategiePrecedent = Strategie.defensive;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Function attaquer, enleve des credits ECTS au Student passe en parametre.
     * @param s Le student attaque
     * @return boolean
     */
    public boolean Attaquer(Student s) {
        double x = this.ObtenirNombreAleatoire(100.0);
        double y = this.ObtenirNombreAleatoire(1.0);
        int DegatDeReference = 10;
        double CoefficienceDegat = Math.max(0.0,
                Math.min(1.0, 0.1 * (double) this.getForce() - 0.05 * (double) s.getResistance()));
        if (x >= 0.0 && x <= (double) (40 + 3 * this.getDexterite())) {
            int e = (int) Math.floor(y * (1.0 + CoefficienceDegat) * (double) DegatDeReference);
            s.reSetCreditECTS(s.getCreditECTS() - e);
            this.strategiePrecedent = Strategie.offensive;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Exectue la strategie du Student (attaquer / soigne / aleatoire)
     */
    public void ExecuterStrategie() {
        if (this.strategie == Strategie.aleatoire) {
            if (this.strategiePrecedent == null) {
                double z = this.ObtenirNombreAleatoire(100.0);
                if (z < 50.0) {
                    this.strategie = Strategie.values()[0];
                }
                this.strategie = Strategie.values()[1];
            }
            if (this.strategiePrecedent == Strategie.offensive) {
                this.strategie = Strategie.values()[0];
            }
            if (this.strategiePrecedent == Strategie.defensive) {
                this.strategie = Strategie.values()[1];
            }
        }
    }

    /**
     * @return int
     */

    public int hashCode() {
        return Objects.hash(new Object[] { this.team, this.dexterite, this.force, this.resistance, this.constitution,
                this.initiative, this.ects, this.strategie, this.zoneDeCombat, this.reserviste, this.name });
    }

    /**
     * Function toString, renvoie toute les informations du Student au format String
     * @return String
     */
    public String toString() {
        StringBuffer str = new StringBuffer();

        str.append("+++++++++++++++++++++++++++++++++++++++++++++ \n");
        str.append("id " + getname() + "\n");
        str.append("ECTS " + getCreditECTS() + "\n");
        str.append("Force " + getForce() + "\n");
        str.append("Dexterite " + getDexterite() + "\n");
        str.append("Resistance " + getResistance() + "\n");
        str.append("Constitution " + getConstitution() + "\n");
        str.append("Initiative " + getInitiative() + "\n");
        str.append("StrategieIndex " + getStrategie() + "\n");
        str.append("Reserviste " + getReserviste() + "\n");
        str.append("Zone " + getNomZoneDeCombat() + "\n");
        str.append("++++++++++++++++++++++++++++++++++++++++++++++ \n");

        return str.toString();
    }
}
