package edu.curso;

public class TesteSobreCarga { 

    /**
     * Metodo de Ordenação 1
     * @param lista1
     * @param crescente
     */
    public void ordenar(int[] lista1, boolean crescente ) { 
        float[] lista2 = new float[lista1.length];
        int indice = 0;
        for( int valor : lista1) { 
            lista2[indice++] = valor;
        }
        this.ordenar(lista2, crescente);
        indice = 0;
        for( float valor : lista2) { 
            lista1[indice++] = (int)valor;
        }
    }


    /**
     * Metodo de Ordenação 2
     * @param lista1
     * @param crescente
     */
    public void ordenar(int[] lista1) { 
       this.ordenar(lista1, true);
    }


    /**
     * Metodo de Ordenação 3
     * @param lista1
     * @param crescente
     */
    public void ordenar(float[] lista1, boolean crescente ) { 
        boolean ordenado = false;
        while (!ordenado) { 
            ordenado = true;
            for(int i = 0; i < lista1.length - 1; i++) {
                boolean trocar = lista1[i] > lista1[i + 1];
                if (!crescente) {
                    trocar = lista1[i] < lista1[i + 1];
                }
                if (trocar) { 
                    float temp = lista1[i];
                    lista1[i] = lista1[i + 1];
                    lista1[i + 1] = temp;
                    ordenado = false;
                }
            }
        }
    }

    public void imprimirLista(float[] lista1) { 
        for(int i = 0; i < lista1.length; i++){
            float valor = lista1[i];
            System.out.print(valor);
            if (i < lista1.length - 1) { 
                System.out.print(", ");
            }
        }
        System.out.println();
    }

    public void imprimirLista(int[] lista1) { 
        for(int i = 0; i < lista1.length; i++){
            int valor = lista1[i];
            System.out.print(valor);
            if (i < lista1.length - 1) { 
                System.out.print(", ");
            }
        }
        System.out.println();
    }


    public static void main(String[] args) {
        TesteSobreCarga ts = new TesteSobreCarga();
        float[] listaNumeros1 = new float[]{10.0f, 50.0f, 60.0f, 20.0f, 30.0f};
        int[] listaNumeros2 = new int[]{1, 5, 60, 20, 3};

        // ts.ordenar(new int[]{10, 50, 60, 20, 30});
        // ts.ordenar(new int[]{10, 50, 60, 20, 30}, false);
        System.out.println("Antes de Ordenar");
        ts.imprimirLista(listaNumeros1);
        ts.ordenar(listaNumeros1, false);
        System.out.println("Depois de Ordenar");
        ts.imprimirLista(listaNumeros1);

        System.out.println("Antes de Ordenar");
        ts.imprimirLista(listaNumeros2);
        ts.ordenar(listaNumeros2, false);
        System.out.println("Depois de Ordenar");
        ts.imprimirLista(listaNumeros2);        
    }

}