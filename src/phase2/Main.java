package phase2;
import phase1.models.Enseignant;
import phase1.models.Departement;
import phase1.services.DB;
import phase1.services.DepartementServices;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.util.List;
import static phase2.Gestion_Bd.*;

public class Main {

    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/testjava";
        String user = "root";
        String pwd = "";
        Connection cx = null;
        try {
            cx = DriverManager.getConnection(url, user, pwd);
            System.out.println("Good Connection");


        } catch (SQLException e) {
            System.out.println("Bad Connection");
            e.printStackTrace();

        }

        createTable1( cx) ;
        createTable2(cx);
     // insertDepartement(new Departement(4,"math",new Enseignant("hamdi","amine",
         //  "hamdi@gmail.com","grd", DepartementServices.getDeptById(DB.getDeptId()))),cx);
        List<Departement> departements = getAllDepartements(cx);
        for(Departement departement: departements){
            System.out.println("IdDept : "+departement.getIdDept());
            System.out.println("intitule : "+departement.getIntitule());
            System.out.println("chef : "+departement.getChef().getNom());
            System.out.println();
        }
       // Departement deptToUpdate = new Departement(4,"Math",new Enseignant("hafdi","Essadia",
        // "bah@gmail.com","grade4", DepartementServices.getDeptById(4)));
       // UpdateDepartement(deptToUpdate,cx);


       deleteDepartement(4,cx);



    }
}