package phase1.models;
import java.util.ArrayList;
public class Departement {
   private int idDept;
   private String intitule;
   private Enseignant chef;
    ArrayList<Filiere> filieres = new ArrayList<Filiere>();
    public Departement(){

    }
    public Departement(int idDept, String intitule, Enseignant chef) {
        this. idDept=idDept;
        this. intitule= intitule;
        this.chef = chef;
    }


    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public ArrayList<Filiere> getFilieres() {
        return filieres;
    }

    public void setFilieres(ArrayList<Filiere> filieres) {
        this.filieres = filieres;
    }

    public Enseignant getChef() {
        return chef;
    }

    public void setChef(Enseignant chef) {
        this.chef = chef;
    }

    public int getIdDept() {
        return idDept;
    }

    public void setIdDept(int idDept) {
        this.idDept = idDept;
    }

    public void ajouterFiliere(Filiere filiere) {
        filieres.add(filiere);
    }
}
