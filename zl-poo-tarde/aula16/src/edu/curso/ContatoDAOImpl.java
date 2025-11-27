package edu.curso;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ContatoDAOImpl implements ContatoDAO {
    private static final String DB_CLASS = "org.mariadb.jdbc.Driver";
    // private static final String DB_URL = "jdbc:mariadb://localhost:3306/fzl_poo_tarde?integratedSecurity=true&authenticationScheme=NativeAuthentication";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "123456";
    private static final String DB_URL = String.format(
        "jdbc:mariadb://127.0.0.1:3306/fzl_poo_tarde?useSSL=false&user=%s&password=%s", DB_USER, DB_PASS );    

    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private Connection con; 
    
    public ContatoDAOImpl() { 
        try { 
            Class.forName(DB_CLASS);
            System.out.println("Driver carregado com sucesso");
            con = DriverManager.getConnection(DB_URL);
            System.out.println("Conexão feita com o banco de dados");
        } catch (Exception e) { 
            e.printStackTrace();
        }
    }


    @Override
    public void criar(Contato contato) {
        String sql = String.format("INSERT INTO contato (nome, telefone, email, nascimento) " + 
                    "VALUES ('%s', '%s', '%s', '%s')", 
                    contato.getNome(),
                    contato.getTelefone(), 
                    contato.getEmail(),
                    contato.getNascimento().format(dtf));
        System.out.println(sql);
        try { 
            PreparedStatement pst = this.con.prepareStatement( sql );
            pst.executeUpdate();
        } catch( SQLException e ) { 
            e.printStackTrace();
        }
    }

    @Override
    public Contato procurarPorId(long id) {
        String sql = "SELECT * FROM contato WHERE id=" + id;
        System.out.println(sql);
        Contato c = null;
        try { 
            PreparedStatement pst = this.con.prepareStatement( sql );
            ResultSet rs = pst.executeQuery();
            if (rs.next()) { 
                c = new Contato();
                c.setId( rs.getLong("id") );
                c.setNome( rs.getString("nome") );
                c.setTelefone( rs.getString("telefone") );
                c.setEmail( rs.getString("email") );
                c.setNascimento( rs.getDate("nascimento").toLocalDate() );
            }
        } catch( SQLException e ) { 
            e.printStackTrace();
        }
        return c;
    }

    @Override
    public List<Contato> lerTodos() {
        String sql = "SELECT * FROM contato";
        System.out.println(sql);
        List<Contato> lista = new ArrayList<>();
        try { 
            PreparedStatement pst = this.con.prepareStatement( sql );
            ResultSet rs = pst.executeQuery();
            while (rs.next()) { 
                Contato c = new Contato();
                c.setId( rs.getLong("id") );
                c.setNome( rs.getString("nome") );
                c.setTelefone( rs.getString("telefone") );
                c.setEmail( rs.getString("email") );
                c.setNascimento( rs.getDate("nascimento").toLocalDate() );
                lista.add(c);
            }
        } catch( SQLException e ) { 
            e.printStackTrace();
        }
        return lista;
    }

    @Override
    public void atualizar(long id, Contato contato) {
        String sql = String.format("UPDATE SET nome='%s', telefone='%s', email='%s', " + 
        "nascimento='%s' WHERE id=%d", 
                    contato.getNome(),
                    contato.getTelefone(), 
                    contato.getEmail(),
                    contato.getNascimento().format(dtf),
                    id);
        System.out.println(sql);
        try { 
            PreparedStatement pst = this.con.prepareStatement( sql );
            pst.executeUpdate();
        } catch( SQLException e ) { 
            e.printStackTrace();
        }
    }

    @Override
    public void deletar(long id) {
        String sql = String.format("DELETE FROM contato WHERE id = %d", id);
        System.out.println(sql);
        try { 
            PreparedStatement pst = this.con.prepareStatement( sql );
            pst.executeUpdate();
        } catch( SQLException e ) { 
            e.printStackTrace();
        }
    }
    
}
