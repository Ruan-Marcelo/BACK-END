import java.util.Scanner;

public class Exercicio4 {

    public static int quantidadeCaracteres(String frase) {
        return frase.length();
    }

    public static int quantidadeLetras(String frase) {
        int total = 0;

        for (int i = 0; i < frase.length(); i++) {
            if (Character.isLetter(frase.charAt(i))) {
                total++;
            }
        }

        return total;
    }

    public static int quantidadeVogais(String frase) {
        int total = 0;

        for (int i = 0; i < frase.length(); i++) {
            char c = Character.toLowerCase(frase.charAt(i));

            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                total++;
            }
        }

        return total;
    }

    public static int quantidadeConsoantes(String frase) {
        int total = 0;

        for (int i = 0; i < frase.length(); i++) {
            char c = Character.toLowerCase(frase.charAt(i));

            if (Character.isLetter(c) &&
                c != 'a' && c != 'e' && c != 'i' && c != 'o' && c != 'u') {
                total++;
            }
        }

        return total;
    }

    public static int quantidadeAlgarismos(String frase) {
        int total = 0;

        for (int i = 0; i < frase.length(); i++) {
            if (Character.isDigit(frase.charAt(i))) {
                total++;
            }
        }

        return total;
    }

    public static int quantidadeEspacos(String frase) {
        int total = 0;

        for (int i = 0; i < frase.length(); i++) {
            if (frase.charAt(i) == ' ') {
                total++;
            }
        }

        return total;
    }

    public static int quantidadeOutrosCaracteres(String frase) {
        int total = 0;

        for (int i = 0; i < frase.length(); i++) {
            char c = frase.charAt(i);

            if (!Character.isLetterOrDigit(c) && c != ' ') {
                total++;
            }
        }

        return total;
    }

    public static int quantidadePalavras(String frase) {
        String texto = frase.trim();

        if (texto.isEmpty()) {
            return 0;
        }

        return texto.split("\\s+").length;
    }

    public static String maiorPalavra(String frase) {
        String[] palavras = frase.trim().split("\\s+");
        String maior = "";

        for (String palavra : palavras) {
            if (palavra.length() > maior.length()) {
                maior = palavra;
            }
        }

        return maior;
    }

    public static int frequenciaLetra(String frase, char letra) {
        int total = 0;

        letra = Character.toLowerCase(letra);

        for (int i = 0; i < frase.length(); i++) {
            if (Character.toLowerCase(frase.charAt(i)) == letra) {
                total++;
            }
        }

        return total;
    }

    public static boolean palindromo(String frase) {
        String texto = "";

        for (int i = 0; i < frase.length(); i++) {
            char c = frase.charAt(i);

            if (Character.isLetterOrDigit(c)) {
                texto += Character.toLowerCase(c);
            }
        }

        int inicio = 0;
        int fim = texto.length() - 1;

        while (inicio < fim) {
            if (texto.charAt(inicio) != texto.charAt(fim)) {
                return false;
            }

            inicio++;
            fim--;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite uma frase: ");
        String frase = sc.nextLine();

        System.out.print("Digite uma letra: ");
        char letra = sc.nextLine().charAt(0);

        System.out.println("Quantidade de caracteres: " + quantidadeCaracteres(frase));
        System.out.println("Quantidade de letras: " + quantidadeLetras(frase));
        System.out.println("Quantidade de vogais: " + quantidadeVogais(frase));
        System.out.println("Quantidade de consoantes: " + quantidadeConsoantes(frase));
        System.out.println("Quantidade de algarismos: " + quantidadeAlgarismos(frase));
        System.out.println("Quantidade de espacos: " + quantidadeEspacos(frase));
        System.out.println("Quantidade de outros caracteres: " + quantidadeOutrosCaracteres(frase));
        System.out.println("Quantidade de palavras: " + quantidadePalavras(frase));
        System.out.println("Maior palavra: " + maiorPalavra(frase));
        System.out.println("Frequencia da letra: " + frequenciaLetra(frase, letra));

        if (palindromo(frase)) {
            System.out.println("A frase e um palindromo.");
        } else {
            System.out.println("A frase nao e um palindromo.");
        }

        sc.close();
    }
}