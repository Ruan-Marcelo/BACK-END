import java.util.Scanner;

public class Exercicio3 {

    public static double soma(double a, double b) {
        return a + b;
    }

    public static double subtracao(double a, double b) {
        return a - b;
    }

    public static double multiplicacao(double a, double b) {
        return a * b;
    }

    public static double divisao(double a, double b) {
        return a / b;
    }

    public static double potencia(double a, double b) {
        return Math.pow(a, b);
    }

    public static double resto(double a, double b) {
        return a % b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n1. Soma");
            System.out.println("2. Subtracao");
            System.out.println("3. Multiplicacao");
            System.out.println("4. Divisao");
            System.out.println("5. Potenciacao");
            System.out.println("6. Resto da divisao");
            System.out.println("7. Encerrar");
            System.out.print("Escolha uma opcao: ");

            opcao = sc.nextInt();

            if (opcao >= 1 && opcao <= 6) {
                System.out.print("Digite o primeiro valor: ");
                double a = sc.nextDouble();

                System.out.print("Digite o segundo valor: ");
                double b = sc.nextDouble();

                switch (opcao) {
                    case 1:
                        System.out.println("Resultado: " + soma(a, b));
                        break;
                    case 2:
                        System.out.println("Resultado: " + subtracao(a, b));
                        break;
                    case 3:
                        System.out.println("Resultado: " + multiplicacao(a, b));
                        break;
                    case 4:
                        if (b == 0) {
                            System.out.println("Nao e possivel dividir por zero.");
                        } else {
                            System.out.println("Resultado: " + divisao(a, b));
                        }
                        break;
                    case 5:
                        System.out.println("Resultado: " + potencia(a, b));
                        break;
                    case 6:
                        if (b == 0) {
                            System.out.println("Nao e possivel calcular o resto por zero.");
                        } else {
                            System.out.println("Resultado: " + resto(a, b));
                        }
                        break;
                }
            } else if (opcao != 7) {
                System.out.println("Opcao invalida.");
            }

        } while (opcao != 7);

        System.out.println("Programa encerrado.");
        sc.close();
    }
}