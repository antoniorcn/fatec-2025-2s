package edu.curso;

public class Imprimir<T> {

    T valor;

    public void imprimir( T valor ) { 
        System.out.println(valor);
    }

    public void setValor( T valor ) { 
        this.valor = valor;
    }

    public T getValor() { 
        return valor;
    }
    
}
