package phase1.models;
import java.util.ArrayList;
public class Enseignant{
    private int id;
    private static String nom;
    private static String prenom;
    private static String email;
    private static String grade;
    private Departement dept;
    ArrayList<Module> modules = new ArrayList<Module>();
    public Enseignant(){

    }
    public Enseignant(String nom,String prenom,String email,String grade,Departement dept){
        this.nom=nom;
        this.prenom=prenom;
        this.email=email;
        this.grade=grade;
        this.dept=dept;
    }

    public static int getIdDept() {
        return 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public static String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public static String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public ArrayList<Module> getModules() {
        return modules;
    }

    public void setModules(ArrayList<Module> modules) {
        this.modules = modules;
    }

    public Departement getDept() {
        return dept;
    }

    public void setDept(Departement dept) {
        this.dept = dept;
    }
}
