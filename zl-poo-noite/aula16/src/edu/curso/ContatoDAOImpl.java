package edu.curso;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
// import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ContatoDAOImpl implements ContatoDAO {
    private final static String DB_URL = 
        "jdbc:mariadb://localhost:3307/fzl_poo_noite?allowPublicKeyRetrieval=true&allowMultiQueries=true";
    private final static String DB_USER = "root";
    private final static String DB_PASS = "alunofatec";
    // private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");


    private Connection con;

    public ContatoDAOImpl() { 
        try { 
            Class.forName("org.mariadb.jdbc.Driver");
            System.out.println("Driver carregado com sucesso");
            con = DriverManager
                        .getConnection(DB_URL, DB_USER, DB_PASS);
            System.out.println("Conectado no banco de dados com sucesso");
        } catch (Exception e) { 
            e.printStackTrace();
        }
    }

    @Override
    public void criar(Contato c) {
        try { 
            // String sql = String.format(
            //     "INSERT INTO contato (nome, telefone, email, nascimento) " + 
            //     "VALUES ('%s', '%s', '%s', '%s')",
            //     c.getNome(),
            //     c.getTelefone(),
            //     c.getEmail(),
            //     c.getNascimento().format( dtf )
            // ); 
            String sql =    "INSERT INTO contato (nome, telefone, email, nascimento) " + 
                            "VALUES (?, ?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, c.getNome() );
            pst.setString(2, c.getTelefone() );
            pst.setString(3, c.getEmail() );
            pst.setDate(4, java.sql.Date.valueOf(c.getNascimento()) );
            pst.executeUpdate();
        } catch (SQLException e) { 
            e.printStackTrace();
        }
    }

    @Override
    public List<Contato> lerTodos() {
        List<Contato> lista = new ArrayList<>();
        try { 
            String sql ="SELECT * FROM contato"; 
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while( rs.next() ) { 
                Contato c = new Contato();
                c.setId( rs.getLong("id") );
                c.setNome( rs.getString("nome") );
                c.setTelefone( rs.getString("telefone") );
                c.setEmail( rs.getString("email") );
                c.setNascimento( rs.getDate("nascimento").toLocalDate() );
                lista.add(c);
            }
        } catch (SQLException e) { 
            e.printStackTrace();
        }
        return lista;
    }

    @Override
    public void apagar(long id) {
        try { 
            // String sql = String.format(
            //     "DELETE FROM contato WHERE id = %d", id
            // ); 
            String sql = "DELETE FROM contato WHERE id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setLong(1, id);
            pst.executeUpdate();
        } catch (SQLException e) { 
            e.printStackTrace();
        }
    }

    @Override
    public void atualizar(long id, Contato c) {
        try { 
            // String sql = String.format(
            //     "UPDATE contato SET nome='%s', telefone='%s', email='%s', nascimento='%s' " + 
            //     "WHERE id=%d",
            //     c.getNome(),
            //     c.getTelefone(),
            //     c.getEmail(),
            //     c.getNascimento().format( dtf ),
            //     id
            // ); 
            String sql = "UPDATE contato SET nome=?, telefone=?, email=?, nascimento=? " + 
                "WHERE id=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, c.getNome() );
            pst.setString(2, c.getTelefone() );
            pst.setString(3, c.getEmail() );
            pst.setDate(4, java.sql.Date.valueOf(c.getNascimento()) );
            pst.setLong(5, id); 
            pst.executeUpdate();
        } catch (SQLException e) { 
            e.printStackTrace();
        }
    }
}