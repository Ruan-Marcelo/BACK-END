import java.util.Scanner;

public class Exercicio5 {

    public static boolean positivo(int numero) {
        return numero > 0;
    }

    public static boolean negativo(int numero) {
        return numero < 0;
    }

    public static boolean par(int numero) {
        return numero % 2 == 0;
    }

    public static boolean multiploDeTres(int numero) {
        return numero % 3 == 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numero;
        int quantidade = 0;
        int positivos = 0;
        int negativos = 0;
        int pares = 0;
        int impares = 0;
        int multiplosDeTres = 0;
        int soma = 0;
        int maior = 0;
        int menor = 0;

        System.out.print("Digite um numero: ");
        numero = sc.nextInt();

        if (numero == 0) {
            System.out.println("Nenhum numero foi informado.");
        } else {
            maior = numero;
            menor = numero;

            while (numero != 0) {
                quantidade++;
                soma += numero;

                if (numero > maior) {
                    maior = numero;
                }

                if (numero < menor) {
                    menor = numero;
                }

                if (positivo(numero)) {
                    positivos++;
                }

                if (negativo(numero)) {
                    negativos++;
                }

                if (par(numero)) {
                    pares++;
                } else {
                    impares++;
                }

                if (multiploDeTres(numero)) {
                    multiplosDeTres++;
                }

                System.out.print("Digite um numero: ");
                numero = sc.nextInt();
            }

            double media = (double) soma / quantidade;

            System.out.println("Quantidade de numeros: " + quantidade);
            System.out.println("Soma: " + soma);
            System.out.println("Media: " + media);
            System.out.println("Maior valor: " + maior);
            System.out.println("Menor valor: " + menor);
            System.out.println("Positivos: " + positivos);
            System.out.println("Negativos: " + negativos);
            System.out.println("Pares: " + pares);
            System.out.println("Impares: " + impares);
            System.out.println("Multiplos de tres: " + multiplosDeTres);
        }

        sc.close();
    }
}