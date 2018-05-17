package princetonPlainsboro;

import java.util.List;
import java.util.Vector;

class DossierMedical {

    private List<FicheDeSoins> fiches;     // contient des objets de classe 'FicheDeSoins'


    public DossierMedical() {
        fiches = new Vector<FicheDeSoins>();  // liste vide
    }

    public void ajouterFiche(FicheDeSoins fiche) {
        fiches.add(fiche);
    }

    public void afficher() {// affiche sur le terminal de l'appli
        System.out.println("Dossier medical informatise :");
        System.out.println("-----------------------------");
        for (int i = 0; i < fiches.size(); i++) {// parcours la liste de fiches de soins
            FicheDeSoins f = fiches.get(i);// creation d'une variable ficheDeSoins qui est égale à la fiche de soins en i de la liste
            f.afficher();// va afficher toutes les fiches de soins contenant elles même la liste de leurs actes
            // pour separer chaque  fiches de soins du vecteur:
            System.out.println("--------------------------------------");
        }
    }

    public double coutPatient(Patient p) {
        double cout = 0;
        for (int i = 0; i < fiches.size(); i++) {// parcours du vecteur de fiche de soins
            FicheDeSoins f = fiches.get(i); // creation d'une variable ficheDeSoins qui est égale à la fiche de soins en i de la liste
            if (p.equals(f.getPatient())) { // on va considérer les fiches du patient qu'on a en paramètre
                cout += f.coutTotal();// addition de tous les coûts des fiches de soins relatif au patient
            }
        }
        return cout;
    }

    public double coutMedecin(Medecin m) {
        double cout = 0;
        for (int i = 0; i < fiches.size(); i++) {
            FicheDeSoins f = fiches.get(i);
            if (m.equals(f.getMedecin())) {
                cout += f.coutTotal();
            }
        }
        return cout;
    }

    public double coutSpecialite(String specialite) {
        double cout = 0;
        for (int i = 0; i < fiches.size(); i++) {
            FicheDeSoins f = fiches.get(i);
            if (specialite.equals(f.getMedecin().getSpecialite())) {
                cout += f.coutTotal();
            }
        }
        return cout;
    }

    public void afficherListePatients(Medecin m) {// va afficher dans le terminal la liste des patients pour un médecin m
        System.out.println("> liste des patients du " + m.toString() + " :");
        Vector<Patient> liste = new Vector<Patient>();// crée un vecteur contenant des patients
        // 'liste' contient tous les patients deja affiches
        // --> ceci permet de ne pas reafficher un patient deja affiche
        for (int i = 0; i < fiches.size(); i++) {// on parcours la liste des fiches de soins
            FicheDeSoins f = fiches.get(i);// crée un variable de fichDeSoins égale à la fiche de soins en i
            if (m.equals(f.getMedecin())) {// on regarde les fiches de soins du médecin m
                Patient p = f.getPatient();//création d'une variable patient qui va être égale au patient de la fiche i ayant comme médecin m
                if (!liste.contains(p)) {// vérification si le patient est contenu dans la liste de patient, c'est à dire si on l'a déjaà affiché. Si déjà affiché, on passe à une autre fichhe
                    System.out.println(" - " + p.toString());//si le patient est nouveau (pas dans la liste) on affiche ses attributs
                    liste.add(p);// on l'ajoute à la liste de patients car on vient de l'afficher. Plus besoin de le réafficher
                }
            }
        }
    }

    public int nombreFichesIntervalle(Date d1, Date d2) {
        int n = 0;
        for (int i = 0; i < fiches.size(); i++) {// parcours le fiches de soin
            FicheDeSoins f = fiches.get(i);
            Date d = f.getDate();// création d'une variable qui prend la date de la fiche i
            if (d.compareTo(d1) >= 0 && d.compareTo(d2) <= 0) {// si la date de la fiche i est comprise entre d1 et la dte d2, on incrémente n
                n++;// incrémentation de n
            }
        }
        return n;//retourner le nombre de fiches de soins dont les dates sont comprises dans cet intervalle
    }

    public void trierDates() {
        Vector<FicheDeSoins> copieFiches = new Vector<FicheDeSoins>(fiches);

        while (!copieFiches.isEmpty()) {
            // on cherche la fiche de soins de date minimale :
            int imin = 0;
            FicheDeSoins f1 = copieFiches.get(imin);
            for (int i = 1; i < copieFiches.size(); i++) {
                FicheDeSoins f2 = copieFiches.get(i);
                if (f2.getDate().compareTo(f1.getDate()) < 0) {
                    imin = i;
                    f1 = f2;
                }
            }
            // on affiche la fiche de soins trouvee :
            f1.afficher();
            System.out.println("------------------------");
            //on la supprime de la liste :
            copieFiches.remove(imin);
        }
    }

    // tri generique :
    public void trier(ComparaisonFiches c) {
        Vector<FicheDeSoins> copieFiches = new Vector<FicheDeSoins>(fiches);

        while (!copieFiches.isEmpty()) {
            // on cherche la fiche de soins minimale :
            int imin = 0;
            FicheDeSoins f1 = copieFiches.get(imin);
            for (int i = 1; i < copieFiches.size(); i++) {
                FicheDeSoins f2 = copieFiches.get(i);
                if (c.comparer(f2, f1) < 0) {
                    imin = i;
                    f1 = f2;
                }
            }
            // on affiche la fiche de soins trouvee :
            f1.afficher();
            System.out.println("------------------------");
            //on la supprime de la liste :
            copieFiches.remove(imin);
        }
    }
}

