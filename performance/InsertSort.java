// LÓGICA:
// Começa do segundo elemento (índice 1, considerando que a indexação começa em 0);
// Compara o elemento atual com o anterior;
// Se o elemento atual for menor do que o anterior, compara ainda com os elementos antes do anterior;
// Faz isso até inserir o elemento atual na posição correta, de modo que a "sublista" à esquerda do elemento atual esteja sempre ordenada;
// Continua para o próximo elemento e repete o processo até o final da lista.

package com.mycompany.performance;

// trocas e iterações
public class InsertSort {
    private long trocas = 0;
    private long iteracoes = 0;

    // array para gerar o insert
    public int[] sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;
            iteracoes++;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
                trocas++;
                iteracoes++;
            }
            array[j + 1] = key;
        }
        return array;
    }

    // retornar o número de trocas feitas
    public long getTrocas() {
        return trocas;
    }

    // retornar o número de iterações feitas
    public long getIteracoes() {
        return iteracoes;
    }
}

