package princetonPlainsboro;

class ComparaisonFichesCouts implements ComparaisonFiches {
    public int comparer(FicheDeSoins fiche1, FicheDeSoins fiche2) {
        Double c1 = new Double(fiche1.coutTotal());// créer un double c1 qui va être égal au cout total de la fiche 1
        Double c2 = new Double(fiche2.coutTotal());
        return c1.compareTo(c2);// retourne 0 si c1 = c2 , retroune un int <0 si c1 plus petit que c2, et retourne un int>0 si c1>c2
        }
    }
