import java.util.Random;

public class BubbleSort {
    public static void main(String[] args) {
        int[] tamanhosVetor = {50, 500, 1000, 5000, 10000};
        int numExecucoes = 5;

        for (int tamanho : tamanhosVetor) {
            long tempoTotalExecucao = 0;
            long totalTrocas = 0;
            long totalIteracoes = 0;

            for (int execucao = 0; execucao < numExecucoes; execucao++) {
                int[] arr = gerarVetorAleatorio(tamanho);
                long tempoInicio = System.nanoTime();

                for (int i = 0; i < arr.length - 1; i++) {
                    for (int j = 0; j < arr.length - i - 1; j++) {
                        totalIteracoes++;
                        if (arr[j] > arr[j + 1]) {
                            int temp = arr[j];
                            arr[j] = arr[j + 1];
                            arr[j + 1] = temp;
                            totalTrocas++;
                        }
                    }
                }

                long tempoFim = System.nanoTime();
                tempoTotalExecucao += tempoFim - tempoInicio;
            }

            double mediaTempoExecucao = (double) tempoTotalExecucao / numExecucoes / 1e9; // em segundos
            double mediaTrocas = (double) totalTrocas / numExecucoes;
            double mediaIteracoes = (double) totalIteracoes / numExecucoes;

            System.out.println("Tamanho do vetor: " + tamanho);
            System.out.println("Tempo Médio de Execução: " + mediaTempoExecucao + " segundos");
            System.out.println("Trocas Médias: " + mediaTrocas);
            System.out.println("Iterações Médias: " + mediaIteracoes);
            System.out.println();
        }
    }

    public static int[] gerarVetorAleatorio(int tamanho) {
        int[] arr = new int[tamanho];
        Random rand = new Random();
        for (int i = 0; i < tamanho; i++) {
            arr[i] = rand.nextInt(1000); // Ajuste o intervalo conforme necessário
        }
        return arr;
    }
}
