package edu.curso;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TesteDB {

    private final static String DB_URL = "jdbc:mariadb://localhost:3306/fzl_poo_tarde";
    private final static String DB_USER = "root";
    private final static String DB_PASS = "";

    public static void main(String[] args) {
        try { 
            Class.forName("org.mariadb.jdbc.Driver");
            System.out.println("Driver carregado com sucesso");
            Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            System.out.println("Conexão feita com o banco de dados");
            String sql = "INSERT INTO contato (nome, telefone, email, nascimento) " + 
                         "VALUES ('Joao Silva', '(11) 1111-1111', 'joao@teste.com', '2004-07-19')";

            PreparedStatement pst = con.prepareStatement( sql );
            pst.executeUpdate();
            System.out.println( sql );
        } catch( ClassNotFoundException e ) { 
            e.printStackTrace();
        } catch( SQLException e ) { 
            e.printStackTrace();
        }

    }
    
}
