import oracle.jdbc.pool.*;

import java.sql.*;


/**
 * Created by 201250541 on 2015-04-09.
 */
public class Exercice3 {
    public static void main(String[] args) {
        Connection conn = MakeConnection();
       Insert(conn,"","","",42000);



        try
        {
            if (conn!=null)
                conn.close();
            System.out.println("connexion fermée");
        }
        catch(SQLException se){}


    }
    private static Connection MakeConnection()
    {
        Connection conn = null;
        String user="lemairef";
        String mapasse = "ORACLE1";
        String url = "jdbc:oracle:thin:@205.237.244.251:1521:orcl";
        try {
            OracleDataSource ods = new OracleDataSource();
            ods.setURL(url);
            ods.setUser(user);
            ods.setPassword(mapasse);
            conn = ods.getConnection();
            System.out.println("vous etes connectés ");
        }
        catch(SQLException sqlods)
        {
            System.out.println("connexion impossible");
            System.exit(0);
        }
        return conn;
    }
    private static int Insert(Connection conn, String nom, String prenom, String emploi, int salaire )
    {
        try {
            String sql="insert into EMPLOYESBIDON (NOMEMP,PRENOMEMP,EMPLOI,SALAIRE) values(?,?,?,?)";
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1,nom);
            stm.setString(2,prenom);
            stm.setString(3,emploi);
            stm.setInt(4,salaire);
            return stm.executeUpdate();

        }catch (SQLException sqlinsert)
        {
            System.out.println(sqlinsert.getMessage());
            return -1;
        }

    }

    private static int Update()
    {
        ///à implémenter
        return 0;
    }
}
