package edu.curso;

import java.time.LocalDate;
import java.util.Objects;

public class Contato { 
    private long id = 0;
    private String nome = "";
    private String telefone = "";
    private String email = "";
    private LocalDate nascimento = LocalDate.now();

    public long getId() {
        return id;
    }
    public void setId(long id) {
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
    public int hashCode() { 
        return Objects.hash(    getId(), getNome(), getEmail(), 
                                getTelefone(), getNascimento());
    }

    @Override
    public String toString() { 
        StringBuffer sb = new StringBuffer();
        sb.append(getId() + " - ");
        sb.append(getNome() + " - ");
        sb.append(getEmail() + " - ");
        sb.append(getTelefone() + " - ");
        sb.append(getNascimento());
        return sb.toString();
    }

    @Override
    public boolean equals( Object o ) { 
        if ( o instanceof Contato ) {
            Contato obj = (Contato)o;
            return 
                getId() == obj.getId() && 
                getNome().equals( obj.getNome() ) &&
                getEmail().equals( obj.getEmail() ) &&
                getTelefone().equals(obj.getTelefone()) && 
                getNascimento().equals(obj.getNascimento());
        } else { 
            return false;
        }
    }
    
}