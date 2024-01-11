package phase1.controller;

import phase1.Main;
import phase1.models.Enseignant;
import phase1.services.DB;
import phase1.services.DepartementServices;
import phase1.services.EnseignantServices;

public class EnseignantsController {

    public static void showMenu(){
        System.out.println("-------------------------[ Enseignants ]---------------------------");


        System.out.println("1: Pour ajouter un enseignant");
        System.out.println("2: Pour afficher les enseignants");
        System.out.println("3: Pour modifier un enseignant");
        System.out.println("4: Pour supprimer un enseignant");
        System.out.println("0: Pour retourner au menu principal");

        //"Veuillez sélectionner une option : ")
        int option = EnseignantsController.getIntInput("Veuillez sélectionner une option : ");
        switch(option) {
            case 1:
                createEnseignant();
                break;
            case 2:
                showEnseignants();
                break;
            case 3:
                editEnseignant();
                break;
            case 4:
                deleteEnseignant();
                break;
            default:
                EnseignantsController.showPrincipalMenu();
        }
    }

    private static int getIntInput(String s) {
        return 0;
    }
    public static void showEnseignants(){
        for (Enseignant enseignant : DB.enseignants) {
            System.out.print("Id : " + enseignant.getId());
            System.out.print(" | Nom : " + enseignant.getNom() + " " + enseignant.getPrenom());
            System.out.print(" | Email : " + enseignant.getEmail() );
            System.out.print(" | Grade: " + enseignant.getGrade() );
            System.out.print(" | Dept : " + enseignant.getDept() );
            System.out.println("");
        }
    }
    private static void showPrincipalMenu() {
    }
    public static void createEnseignant(){
        String nom = Main.getStringInput("Entrez le nom:");

        String prenom;Main.getStringInput("Entrez le prenom:");

        String email;Main.getStringInput("Entrez l'email:");

        String grade;Main.getStringInput("Entrez le grade:");

        String dept;Main.getStringInput("Entrez le dept:");
        showEnseignants();
        showMenu();

    }
    public static void editEnseignant(){
        showEnseignants();
        int id = Main.getIntInput("Sélecionnez un enseignant par id :");
        String nom = Main.getStringInput("Entrez le nom :");

        String prenom = Main.getStringInput("Entrez le prenom :");
        EnseignantsController.showEnseignants();

        int idEns = Main.getIntInput("Sélecionnez un enseignant par id :");

        EnseignantServices.updateEns(id, nom,EnseignantServices.getEnsById(idEns));

        showEnseignants();
        showMenu();
    }
    public static void deleteEnseignant(){
        showEnseignants();
        int id;
        id = Main.getIntInput("Sélecionnez un enseignant par id :");
        EnseignantServices.deleteEnsById(id);
        showEnseignants();

    }
}
