package phase1.controller;

import phase1.Main;
import phase1.models.Enseignant;
import phase1.models.Etudiant;
import phase1.services.DB;
import phase1.services.DepartementServices;
import phase1.services.EnseignantServices;
import phase1.services.EtudiantServices;

public class EtudiantController {

    public static void showMenu(){
        System.out.println("-------------------------[ Etudiants ]---------------------------");


        System.out.println("1: Pour ajouter un etudiant");
        System.out.println("2: Pour afficher les etudiants");
        System.out.println("3: Pour modifier un etudiant");
        System.out.println("4: Pour supprimer un etudiant");
        System.out.println("0: Pour retourner au menu principal");

        //"Veuillez sélectionner une option : ")
        int option = EtudiantController.getIntInput("Veuillez sélectionner une option : ");
        switch(option) {
            case 1:
                createEtudiant();
                break;
            case 2:
                showEtudiant();
                break;
            case 3:
                editEtudiant();
                break;
            case 4:
                deleteEtudiant();
                break;
            default:
                EtudiantController.showPrincipalMenu();
        }

    }

    private static int getIntInput(String s) {
        return 0;
    }

    public static void showEtudiant(){
        for (Etudiant etudiant : DB.etudiants) {
            System.out.print("Id : " + etudiant.getId());
            System.out.print(" | Nom : " + etudiant.getNom() + " " + etudiant.getPrenom());
            System.out.print(" | Email : " + etudiant.getEmail() );
            System.out.print(" | apogee: " + etudiant.getApogee() );
            System.out.print(" | filiere: " + etudiant.getFiliere() );
            System.out.print(" | notes: " + etudiant.getNotes() );
            System.out.println("");
        }
    }
    private static void showPrincipalMenu() {
    }
    public static void createEtudiant(){
        String nom = Main.getStringInput("Entrez le nom:");
        String prenom;Main.getStringInput("Entrez le prenom:");
        String email;Main.getStringInput("Entrez l'email:");
        String apogee;Main.getStringInput("Entrez apogee:");
        String filiere;Main.getStringInput("Entrez filiere:");
        EtudiantController.showEtudiant();
        showEtudiant();

    }
    public static void editEtudiant(){
        showEtudiant();
        int id = Main.getIntInput("Sélecionnez un etudiant par id :");
        String nom = Main.getStringInput("Entrez le nom :");
        String prenom = Main.getStringInput("Entrez le prenom :");
        EtudiantController.showEtudiant();

        int idEtd = Main.getIntInput("Sélecionnez un etudiant par id :");

        EtudiantServices.updateEtd(id, nom, EtudiantServices.getEtdById(idEtd));

        showEtudiant();
        showPrincipalMenu();
    }
    public static void deleteEtudiant(){
        showEtudiant();
        int id;
        id = Main.getIntInput("Sélecionnez un etudiant par id :");
        EtudiantServices.deleteEtdById(id);
        showEtudiant();

    }


}
