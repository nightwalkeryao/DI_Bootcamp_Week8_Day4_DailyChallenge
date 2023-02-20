import database.DBConnection;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Main().callBuiltInFunction("essaie de transformer cette phrase"));
    }

    private String callBuiltInFunction(String chaine) {
        String resultat = chaine;
        final String SQL = "{ ? = call initcap( ? ) }";

        try {
            Connection connection = new DBConnection().getDBConnection();
            CallableStatement statement = connection.prepareCall(SQL);
            statement.registerOutParameter(1, Types.VARCHAR);
            statement.setString(2, chaine);
            statement.execute();

            resultat = statement.getString(1);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return resultat;
    }
}