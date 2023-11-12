// LÓGICA:
// Se a lista tiver apenas um elemento, ela já está ordenada. Retorne a lista;
// Divide a lista ao meio;
// Ordena cada metade usando o próprio Merge Sort;
// Uma vez que as duas metades estão ordenadas, combina (ou "mescla") para formar uma única lista ordenada.

package com.mycompany.performance;

// trocas e iterações
public class MergeSort {
    private long trocas = 0;
    private long iteracoes = 0;

    // array para gerar o merge
    public int[] sort(int[] array, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            
            sort(array, left, middle);
            sort(array, middle + 1, right);
            
            merge(array, left, middle, right);
        }
        return array;
    }

    private void merge(int[] array, int left, int middle, int right) {
        int n1 = middle - left + 1;
        int n2 = right - middle;
        
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];
        
        for (int i = 0; i < n1; i++) {
            leftArray[i] = array[left + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArray[j] = array[middle + 1 + j];
        }
        
        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            iteracoes++;
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
                trocas++;
            }
            k++;
        }
        
        while (i < n1) {
            array[k] = leftArray[i];
            i++;
            k++;
            iteracoes++;
        }
        
        while (j < n2) {
            array[k] = rightArray[j];
            j++;
            k++;
            iteracoes++;
        }
    }

    public long getTrocas() {
        return trocas;
    }

    public long getIteracoes() {
        return iteracoes;
    }
}