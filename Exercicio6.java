import java.util.Scanner;
import java.util.Arrays;

public class Exercicio6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o tamanho do array: ");
        int quantidadeP = Integer.parseInt(scanner.nextLine());

        String[] nomes = new String[quantidadeP];
        int[] tempo = new int[quantidadeP];
        int soma = 0;

        for (int r = 0; r < quantidadeP; r++) {
            System.out.print("Digite o nome do participante " + (r + 1) + ": ");
            nomes[r] = scanner.nextLine();

            System.out.print("Digite o tempo do participante " + (r + 1) + ": ");
            tempo[r] = Integer.parseInt(scanner.nextLine());
            soma += tempo[r];
        }

        double media = mediaTempo(soma, quantidadeP);

        abaixoDaMedia(quantidadeP, nomes, tempo, media);
        menosMais(quantidadeP, nomes, tempo);
        ordemRanking(tempo, nomes);
        double mediana = calcularMediana(tempo);
        System.out.println("a mediana dos tempos é: " + mediana);
        double desvioPadrao = calcularDesvioPadrao(tempo, media);
        System.out.println("o desvio padrão dos tempos é: " + desvioPadrao);

        scanner.close();
    }

    public static double mediaTempo(int soma, int quantidadeP) {
        double media = (double) soma / quantidadeP;
        System.out.println("a media de tempo dos participantes é: " + media);
        return media;
    }

    public static void abaixoDaMedia(int quantidadeP, String[] nomes, int[] tempo, double media) {
        int quantidadeAbaixo = 0;
        for (int r = 0; r < quantidadeP; r++) {
            if (tempo[r] < media) {
                System.out.println("O participante " + nomes[r] + " ficou abaixo da média com o tempo de: ");
                quantidadeAbaixo++;
            }
        }
        System.out.println("quantidade de participantes abaixo da media: " + quantidadeAbaixo);
    }

    public static void menosMais(int quantidadeP, String[] nomes, int[] tempo) {
        int menorTempo = tempo[0];
        int maiorTempo = tempo[0];
        String nomeLento = nomes[0];
        String nomeRapido = nomes[0];

        for (int r = 1; r < quantidadeP; r++) {
            if (tempo[r] < menorTempo) {
                menorTempo = tempo[r];
                nomeLento = nomes[r];
            }
            if (tempo[r] > maiorTempo) {
                maiorTempo = tempo[r];
                nomeRapido = nomes[r];
            }
        }

        System.out.println("O participante com o menor tempo é: " + nomeLento + " com o tempo de: " + menorTempo);
        System.out.println("O participante com o maior tempo é: " + nomeRapido + " com o tempo de: " + maiorTempo);
    }

    public static void ordemRanking(int[] tempo, String[] nomes) {
        int n = tempo.length;

        for (int r = 0; r < n - 1; r++) {
            for (int j = 0; j < n - r - 1; j++) {
                if (tempo[j] > tempo[j + 1]) {
                    int tempTempo = tempo[j];
                    tempo[j] = tempo[j + 1];
                    tempo[j + 1] = tempTempo;

                    String tempNome = nomes[j];
                    nomes[j] = nomes[j + 1];
                    nomes[j + 1] = tempNome;
                }
            }
        }

        System.out.println("Ranking dos participantes (do menor para o maior tempo):");
        for (int r = 0; r < n; r++) {
            System.out.println((r + 1) + "º lugar: " + nomes[r] + " com o tempo de: " + tempo[r]);
        }
    }

    public static double calcularMediana(int[] tempo) {

        int[] temposOrdenados = Arrays.copyOf(tempo, tempo.length);

        Arrays.sort(temposOrdenados);

        int tamanho = temposOrdenados.length;

        if (tamanho % 2 == 0) {

            int meio1 = temposOrdenados[tamanho / 2 - 1];
            int meio2 = temposOrdenados[tamanho / 2];

            return (meio1 + meio2) / 2.0;

        } else {

            return temposOrdenados[tamanho / 2];
        }
    }

    public static double calcularDesvioPadrao(int[] tempo, double media) {

        double somaDiferencas = 0;

        for (int r = 0; r < tempo.length; r++) {

            double diferenca = tempo[r] - media;

            somaDiferencas += diferenca * diferenca;
        }

        double variancia = somaDiferencas / tempo.length;

        return Math.sqrt(variancia);
    }
}