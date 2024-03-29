package phase1.models;
import java.util.ArrayList;
public class Filiere {
    private int id;
    private String intitule;
    private Enseignant chef;
    private Departement dept;
    ArrayList<Module> modules = new ArrayList<Module>();

    public Filiere(){

    }
    public Filiere(String intitule,Enseignant chef,Departement dept){
        this.intitule=intitule;
        this.chef=chef;
        this.dept=dept;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public Enseignant getChef() {
        return chef;
    }

    public void setChef(Enseignant chef) {
        this.chef = chef;
    }

    public Departement getDept() {
        return dept;
    }

    public void setDept(Departement dept) {
        this.dept = dept;
    }

    public ArrayList<Module> getModules() {
        return modules;
    }

    public void setModules(ArrayList<Module> modules) {
        this.modules = modules;
    }

    public String getId() {
        return null;
    }
    public void ajouterModule(Module module) {
        if (modules.size() < 12) {
            modules.add(module);
        } else {
            System.out.println("Une filière ne peut contenir que 12 modules au maximum.");
        }
}
}
