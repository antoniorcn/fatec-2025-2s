package edu.curso;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;

public class TesteDB {
    private final static String DB_URL = 
        "jdbc:mariadb://localhost:3307/fzl_poo_noite?allowPublicKeyRetrieval=true";
    private final static String DB_USER = "root";
    private final static String DB_PASS = "alunofatec";

    public static void main(String[] args) {
        try { 
            Class.forName("org.mariadb.jdbc.Driver");
            System.out.println("Driver carregado com sucesso");

            Connection con = DriverManager
                        .getConnection(DB_URL, DB_USER, DB_PASS);
            System.out.println("Conectado no banco de dados com sucesso");

            String sql = "INSERT INTO contato (nome, telefone, email, nascimento) " + 
            " VALUES ('Joao Silva', '(11) 1111-1111', 'joao@teste.com', '2003-09-12')";

            Statement stm = con.createStatement();
            stm.executeUpdate( sql );

            System.out.println("Contato inserido com sucesso");
            con.close();
        } catch (ClassNotFoundException e ) { 
            System.out.println("Driver não carregado");
            e.printStackTrace();
        } catch (SQLException e ) { 
            System.out.println("Erro ao acessar o banco de dados");
            e.printStackTrace();
        }
    }
}
