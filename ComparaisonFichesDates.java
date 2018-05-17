package princetonPlainsboro;

class ComparaisonFichesDates implements ComparaisonFiches {
    public int comparer(FicheDeSoins fiche1, FicheDeSoins fiche2) {// l'int retourné sera la différence des années des 2 fiches si elles sont d'années diff, la différence des mois si elles sont d'années égales, et la différence des jours si elles sont de même année et de même mois
        return fiche1.getDate().compareTo(fiche2.getDate());
        }
    }
