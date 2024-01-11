package phase2;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import phase1.models.Enseignant;
import phase1.services.DB;
import phase1.services.DepartementServices;
import phase1.models.Departement;

public class Gestion_Bd {
    public static void createTable1(Connection cx) throws SQLException {
        String query = "CREATE TABLE IF NOT EXISTS Departement(\n" +
                "                                       idDept int primary key auto_increment,\n" +
                "                                       intitule nvarchar(255),\n" +
                 "                                      chef varchar(250) charset utf8 null,\n" +
                "                                       foreign key (chef) references Enseignant(nom)\n" +


                ");";

        Statement st = cx.createStatement();

        st.execute(query);
        System.out.println("votre nouvelle table a été créé");


    }
    public static void createTable2(Connection cx) throws SQLException {
        String query = "CREATE TABLE IF NOT EXISTS Enseignant(\n" +
                "                                       idEns int primary key auto_increment,\n" +
                "                                      nom nvarchar(255),\n" +
                "                                      prenom nvarchar(255),\n" +
                "                                      email nvarchar(255),\n" +
                "                                      grade nvarchar(255)\n" +
                ");";
        Statement st = cx.createStatement();
        st.execute(query);
        System.out.println("votre nouvelle table a été créé");

    }

       public static void insertDepartement(Departement dept, Connection cx) throws SQLException {
           String query = "INSERT INTO Departement (idDept,intitule,chef) values (?,?,?)";

           PreparedStatement ps = cx.prepareStatement(query);

           ps.setInt(1, dept.getIdDept());
           ps.setString(2, dept.getIntitule());
           ps.setString(3, dept.getChef().getNom());
           ps.executeUpdate();
           System.out.println("votre nouvelle table a été remplis");
       }
    public static void deleteDepartement(int IdDept , Connection cx) throws SQLException {
        String query = "DELETE  from testjava.departement where IdDept = ?";
        PreparedStatement ps = cx.prepareStatement(query);
        ps.setInt(1, IdDept);
        ps.execute();
        System.out.println("la suppression de departement " +IdDept+ " est effectuée");
    }
    public static List<Departement> getAllDepartements(Connection cx) throws SQLException{
        String query = "SELECT * from departement";
        List<Departement> departements = new ArrayList<>();
        Statement st = cx.createStatement();
        ResultSet r = st.executeQuery(query);

        while (r.next()) {
            Departement dep = new Departement();
            dep.setIdDept(r.getInt("IdDept"));
            dep.setIntitule(r.getString("intitule"));
            Enseignant ens = new Enseignant();
            ens.setNom(r.getString("chef"));
            dep.setChef(ens);
            departements.add(dep);
        }
        return departements;
    }
    public static void UpdateDepartement(Departement dept, Connection cx) throws SQLException {
        String sql = "UPDATE departement SET intitule=? , chef =? WHERE IdDept=? ";
        PreparedStatement ps = cx.prepareStatement(sql);
        ps.setString(1, dept.getIntitule());
        ps.setString(2, dept.getChef().getNom());
        ps.setInt(3, dept.getIdDept());

        int rowsInserted = ps.executeUpdate();
        if (rowsInserted > 0) {
            System.out.println("la table departement a été mise à jour ");
        } else {
            System.out.println("Aucun mise à jour effectuée . Vérifiez l'ID de departement.");
     }
    }







    }




