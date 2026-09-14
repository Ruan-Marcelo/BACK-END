import java.util.Scanner;

public class Exercicio2 {

    public static boolean bissexto(int ano) {
        return (ano % 400 == 0) || (ano % 4 == 0 && ano % 100 != 0);
    }

    public static int diasMes(int mes, int ano) {
        switch (mes) {
            case 2:
                return bissexto(ano) ? 29 : 28;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            default:
                return 31;
        }
    }

    public static boolean dataValida(int dia, int mes, int ano) {
        if (ano <= 0 || mes < 1 || mes > 12 || dia < 1) {
            return false;
        }

        return dia <= diasMes(mes, ano);
    }

    public static int trimestre(int mes) {
        return (mes - 1) / 3 + 1;
    }

    public static int posicaoNoAno(int dia, int mes, int ano) {
        int total = dia;

        for (int i = 1; i < mes; i++) {
            total += diasMes(i, ano);
        }

        return total;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Dia: ");
        int dia = sc.nextInt();

        System.out.print("Mes: ");
        int mes = sc.nextInt();

        System.out.print("Ano: ");
        int ano = sc.nextInt();

        if (dataValida(dia, mes, ano)) {
            System.out.println("Data valida");
            System.out.println("Trimestre: " + trimestre(mes));
            System.out.println("Posicao no ano: " + posicaoNoAno(dia, mes, ano));
        } else {
            System.out.println("Data invalida");
        }

        sc.close();
    }
}