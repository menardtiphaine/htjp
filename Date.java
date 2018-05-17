package princetonPlainsboro;

class Date implements Comparable {
    private int jour;
    private int mois;
    private int annee;
    
    public Date(int jour, int mois, int annee) {
        this.jour = jour;
        this.mois = mois;
        this.annee = annee;
        }
    
    public String toString() {
        return jour + "/" + mois + "/" + annee;
        }
    
    public boolean equals(Object o) {
        if (o instanceof Date) { // si l'objet o est une instance de Date
            Date d = (Date)o;// crée une variable d égale à l'objet
            return (annee == d.annee) && (mois == d.mois) && (jour == d.jour);// retourne true si c'est la même date, false si c'est pas la même date
            }
        else
            return false;// si l'objet n'est pas une date, on retourne false
        }
    
    // precondition : 'o' est une instance de 'Date' : 
    public int compareTo(Object o) {
        Date d = (Date)o;// variable d prend les valeurs de l'objet
        if (annee != d.annee)// si c'est pas la même année
            return annee - d.annee;// renvoie la différence des années
        // ici on a forcement annee == d.annee :
        if (mois != d.mois) //si passe a ce deuxieme if annee égale
            return mois  - d.mois;// renvoie la différence des mois
        // ici on a forcement annee == d.annee et mois == d.mois :
        return jour - d.jour;// différence des jours
        }
    
    }
