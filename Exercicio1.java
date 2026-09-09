import java.util.Locale;
import java.util.Scanner;

public class Exercicio1 {

    public static double calcularMedia(double n1, double n2, double n3) {
        return (n1 + n2 + n3) / 3.0;
    }

    public static String determinarSituacao(double media, double frequencia) {
        if (frequencia < 75.0) {
            return "Reprovado por frequência";
        } else if (media >= 7.0) {
            return "Aprovado";
        } else if (media >= 5.0 && media < 7.0) {
            return "Recuperação";
        } else {
            return "Reprovado por nota";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        System.out.println("avaliação academica ");

        System.out.print("Digite o nome do estudante: ");
        String nome = scanner.nextLine();

        System.out.print("Digite a primeira nota (0 a 10): ");
        double nota1 = scanner.nextDouble();

        System.out.print("Digite a segunda nota (0 a 10): ");
        double nota2 = scanner.nextDouble();

        System.out.print("Digite a terceira nota (0 a 10): ");
        double nota3 = scanner.nextDouble();

        System.out.print("Digite o percentual de frequência (0 a 100): ");
        double frequencia = scanner.nextDouble();

        double mediaFinal = calcularMedia(nota1, nota2, nota3);
        String situacaoFinal = determinarSituacao(mediaFinal, frequencia);

        System.out.println("      RESUMO DO ESTUDANTE      ");
        System.out.println("==============================");
        System.out.println("Nome: " + nome);
        System.out.printf("Média Final: %.2f\n", mediaFinal);
        System.out.printf("Frequência: %.1f%%\n", frequencia);
        System.out.println("Situação: " + situacaoFinal);
        System.out.println("==============================");

        scanner.close();
    }
}
