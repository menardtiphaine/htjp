package princetonPlainsboro;

import java.util.Vector;

class FicheDeSoins {
    private Patient patient;
    private Medecin medecin;
    private Date date;
    private Vector<Acte> actes;       // contient des objets de classe 'Acte'
    
    public FicheDeSoins(Patient patient, Medecin medecin, Date date) {
        this.patient = patient;
        this.medecin = medecin;
        this.date = date;
        actes = new Vector<Acte>();   // liste vide
        }
    
    public Patient getPatient() { return patient; }
    public Medecin getMedecin() { return medecin; }
    public Date    getDate()    { return date; }
    
    public void ajouterActe(Acte acte) { // on ajoute un acte sans savoir code ni coeff
        actes.add(acte);// ajoute directement l'acte
        }
    
    public void ajouterActe(Code code, int coefficient) { // on ajoute un acte par le biais du code et du coeff
        Acte acte = new Acte(code, coefficient); // création de l'acte
        actes.add(acte);// ajout de l'acte
        }
    
    public void afficher() {// affiche tous les actes présents dans la liste
        System.out.println("Fiche de soins du " + date.toString());// affiche sur le terminal -> donc sera à modifier
        System.out.println("- medecin : " + medecin.toString());
        System.out.println("- patient : " + patient.toString());
        System.out.println("- actes medicaux :");
        for (int i=0; i<actes.size(); i++) { // parcours liste acte
            Acte a = actes.get(i); // nouvel acte a qui sera égale à l'acte à l'emplacement i  de la liste
            System.out.println("    > " + a.toString()); // Afficher l'acte a
            }
        }
    
    public double coutTotal() {
        double total = 0;
        for (int i=0; i<actes.size(); i++) {// parcours toute la liste
            Acte a = actes.get(i);//  nouvel acte a qui sera égale à l'acte à l'emplacement i  de la liste
            total += a.cout();// total de tous les coûts des actes présents dans la liste
            }
        return total;// retourne un double
        }
    }

