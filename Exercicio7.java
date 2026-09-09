import java.util.Scanner;

public class Exercicio7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite uma quantidade?");
        int n = scanner.nextInt();

        int[] numeros = new int[n];

        for(int i=0; i<numeros.length; i++){
            System.out.println("Informe o número da posição" + (i+1) + ":");
            numeros[i] = scanner.nextInt();
        }

        System.out.println("Qual sera o valor alvo?");
        int alvo = scanner.nextInt();

        scanner.close();
        verificaPares(numeros, alvo);
    }

    public static void verificaPares(int[] numeros, int alvo){
        int quantidadePares = 0;
        for (int i = 0; i < numeros.length; i++) {
            for (int j = i + 1; j < numeros.length; j++) {
                if (numeros[i] + numeros[j] == alvo) {
                    System.out.println("Par encontrado: " + numeros[i] + " e " + numeros[j]);   
                    
                    System.out.println("A soma dos números " + (numeros[i] + numeros[j]));

                    quantidadePares++;
                }
            }
        }
        if (quantidadePares == 0) {
            System.out.println("Nenhum par encontrado.");
        } 
        System.out.println("Quantidade de pares encontrados: " + quantidadePares);
    }
}