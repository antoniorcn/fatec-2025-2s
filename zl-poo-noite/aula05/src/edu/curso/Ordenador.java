package edu.curso;

public class Ordenador<T extends Number> {

    public void ordenar(T[] lista) { 
        ordenar(lista, true);
    }  

    public void ordenar(T[] lista, boolean crescente){ 
        boolean ordenado = false;
        while (!ordenado) {
            ordenado = true;
            for (int i = 0; i < lista.length - 1; i++) {
                boolean trocar = lista[i].doubleValue() > 
                                            lista[i + 1].doubleValue();
                if (!crescente) { 
                    trocar = lista[i].doubleValue() < lista[i + 1].doubleValue();
                }
                if (trocar) { 
                    T temp = lista[i + 1];
                    lista[i + 1] = lista[i];
                    lista[i] = temp;
                    ordenado = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        Impressora<Integer> imp1 = new Impressora<>();
        Integer[] lista1 = new Integer[]{30, 45, 15, 10, 5, 29};
        imp1.imprimir( lista1 );
        Ordenador<Integer> ord = new Ordenador<>();
        ord.ordenar(lista1, false);
        imp1.imprimir( lista1 );

        Impressora<Float> imp2 = new Impressora<>();
        Float[] lista2 = new Float[]{30.0f, 45.0f, 15.0f, 10.0f, 5.0f, 29.0f};
        Ordenador<Float> ord2 = new Ordenador<>();
        imp2.imprimir( lista2 );
        ord2.ordenar(lista2, false);
        imp2.imprimir( lista2 );
    }
}
