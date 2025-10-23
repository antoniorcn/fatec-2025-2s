package edu.curso;

import java.time.LocalDate;
import java.util.Objects;

public class Contato {

    private Long id;
    private String nome;
    private String telefone;
    private String email;
    private LocalDate nascimento;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }
    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }

    @Override
    public String toString() { 
        StringBuffer sb = new StringBuffer();
        sb.append( this.getId() + " - " );
        sb.append( this.getNome() + " - " );
        sb.append( this.getTelefone() + " - " );
        sb.append( this.getEmail() + " - " );
        sb.append( this.getNascimento());
        return sb.toString();
    }

    @Override
    public int hashCode() {
       return Objects.hash( getId(), getNome(), getTelefone(), 
                            getEmail(), getNascimento().toString() );
    }

    @Override
    public boolean equals( Object o ) {
        if (o instanceof Contato) { 
            Contato outro = (Contato)o;
            if (
                getId().equals(outro.getId()) &&
                getNome().equals(outro.getNome()) &&
                getTelefone().equals(outro.getTelefone()) &&
                getEmail().equals(outro.getEmail()) &&
                getNascimento().isEqual(outro.getNascimento())
            ) {
                return true;
            } else { 
                return false;
            }
        } else { 
            return false;
        }
    }
    
}
