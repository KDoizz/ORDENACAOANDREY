// TONHO, SE NÃO LER ISSO AQUI, É OTÁRIO <3
// Essa classe performance é o nosso main!! Coloca para rodar as suas classes aqui!!
// Dá para fazer mais duas classes com os seus algoritmos iguais às que já tem
// Dá para pedir ao chat GPT fazer na mesma estrutura, fiz com o GPT 4 (sim, eu paguei essa merda)
// Está tudo comentado
// Seria legal comparar com o trabalho dos outros quando acabar, só para garantir se está tudo certo

package com.mycompany.performance;

public class Performance {

    public static void main(String[] args) {
        int[] tamanhos = {50, 500, 1000, 5000, 10000}; // tamanho dos vetores
        int rodadas = 5; // número de rodadas

        // mostrar o tamanho do vetor
        for (int tamanho : tamanhos) {
            System.out.println("Tamanho do vetor: " + tamanho);
            
            // requisitos do insert
            long tempoTotalInsertion = 0;
            long trocasTotalInsertion = 0;
            long iteracoesTotalInsertion = 0;

            // requisitos do merge
            long tempoTotalMerge = 0;
            long trocasTotalMerge = 0;
            long iteracoesTotalMerge = 0;

            // gerar tamanho aleatório dos vetores
            for (int i = 0; i < rodadas; i++) {
                int[] vetorAleatorio = new int[tamanho];
                for (int j = 0; j < tamanho; j++) {
                    vetorAleatorio[j] = (int) (Math.random() * 1000);
                }
                
                int[] vetorParaMerge = vetorAleatorio.clone();

                // calcular requisitos do insert
                InsertSort insertionSort = new InsertSort();
                long inicioInsertion = System.nanoTime();
                insertionSort.sort(vetorAleatorio);
                long fimInsertion = System.nanoTime();
                
                tempoTotalInsertion += (fimInsertion - inicioInsertion);
                trocasTotalInsertion += insertionSort.getTrocas();
                iteracoesTotalInsertion += insertionSort.getIteracoes();

                // calcular requisitos do merge
                MergeSort mergeSort = new MergeSort();
                long inicioMerge = System.nanoTime();
                mergeSort.sort(vetorParaMerge, 0, vetorParaMerge.length - 1);
                long fimMerge = System.nanoTime();
                
                tempoTotalMerge += (fimMerge - inicioMerge);
                trocasTotalMerge += mergeSort.getTrocas();
                iteracoesTotalMerge += mergeSort.getIteracoes();
            }
            
            // exibir no terminal os resultados dos requisitos
            System.out.println("Médias para Insert Sort:"); 
            System.out.println("Tempo: " + ((double)tempoTotalInsertion / rodadas) / 1_000_000_000 + " segundos"); // + conversão de nano para segundos
            System.out.println("Trocas: " + (trocasTotalInsertion / rodadas));
            System.out.println("Iterações: " + (iteracoesTotalInsertion / rodadas));
            
            System.out.println("\nMédias para Merge Sort:");
            System.out.println("Tempo: " + ((double)tempoTotalInsertion / rodadas) / 1_000_000_000 + " segundos"); // + conversão de nano para segundos
            System.out.println("Trocas: " + (trocasTotalMerge / rodadas));
            System.out.println("Iterações: " + (iteracoesTotalMerge / rodadas));
            
            System.out.println("\n----------------------\n");
        }
    }
}
