import java.util.ArrayList;
import java.util.Scanner;

public class Exercicio8 {

    public static int buscarProduto(ArrayList<String> nomes, String pesquisa) {
        pesquisa = pesquisa.toLowerCase();

        for (int i = 0; i < nomes.size(); i++) {
            if (nomes.get(i).toLowerCase().contains(pesquisa)) {
                return i;
            }
        }

        return -1;
    }

    public static double subtotal(int quantidade, double preco) {
        return quantidade * preco;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<String> nomes = new ArrayList<>();
        ArrayList<Integer> quantidades = new ArrayList<>();
        ArrayList<Double> precos = new ArrayList<>();

        int opcao;

        do {
            System.out.println("\n1. Adicionar produto");
            System.out.println("2. Alterar quantidade");
            System.out.println("3. Alterar preco");
            System.out.println("4. Remover produto");
            System.out.println("5. Pesquisar produto");
            System.out.println("6. Listar produtos");
            System.out.println("7. Calcular valor total");
            System.out.println("8. Identificar produto com maior subtotal");
            System.out.println("9. Encerrar");
            System.out.print("Escolha uma opcao: ");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {

                case 1:
                    System.out.print("Nome do produto: ");
                    String nome = sc.nextLine();

                    int posicao = buscarProduto(nomes, nome);

                    if (posicao != -1 && nomes.get(posicao).equalsIgnoreCase(nome)) {
                        System.out.println("Produto ja existe.");
                        System.out.print("Deseja atualizar a quantidade? (1-Sim / 2-Nao): ");
                        int atualizar = sc.nextInt();

                        if (atualizar == 1) {
                            System.out.print("Nova quantidade: ");
                            int quantidade = sc.nextInt();

                            if (quantidade > 0) {
                                quantidades.set(posicao, quantidade);
                            } else {
                                System.out.println("Quantidade invalida.");
                            }
                        }
                    } else {
                        System.out.print("Quantidade: ");
                        int quantidade = sc.nextInt();

                        System.out.print("Preco unitario: ");
                        double preco = sc.nextDouble();

                        if (quantidade <= 0 || preco < 0) {
                            System.out.println("Quantidade ou preco invalido.");
                        } else {
                            nomes.add(nome);
                            quantidades.add(quantidade);
                            precos.add(preco);
                            System.out.println("Produto adicionado.");
                        }
                    }
                    break;

                case 2:
                    System.out.print("Nome do produto: ");
                    nome = sc.nextLine();

                    posicao = buscarProduto(nomes, nome);

                    if (posicao == -1) {
                        System.out.println("Produto nao encontrado.");
                    } else {
                        System.out.print("Nova quantidade: ");
                        int quantidade = sc.nextInt();

                        if (quantidade > 0) {
                            quantidades.set(posicao, quantidade);
                            System.out.println("Quantidade alterada.");
                        } else {
                            System.out.println("Quantidade invalida.");
                        }
                    }
                    break;

                case 3:
                    System.out.print("Nome do produto: ");
                    nome = sc.nextLine();

                    posicao = buscarProduto(nomes, nome);

                    if (posicao == -1) {
                        System.out.println("Produto nao encontrado.");
                    } else {
                        System.out.print("Novo preco: ");
                        double preco = sc.nextDouble();

                        if (preco >= 0) {
                            precos.set(posicao, preco);
                            System.out.println("Preco alterado.");
                        } else {
                            System.out.println("Preco invalido.");
                        }
                    }
                    break;

                case 4:
                    System.out.print("Nome do produto: ");
                    nome = sc.nextLine();

                    posicao = buscarProduto(nomes, nome);

                    if (posicao == -1) {
                        System.out.println("Produto nao encontrado.");
                    } else {
                        nomes.remove(posicao);
                        quantidades.remove(posicao);
                        precos.remove(posicao);
                        System.out.println("Produto removido.");
                    }
                    break;

                case 5:
                    System.out.print("Digite o nome ou parte do nome: ");
                    String pesquisa = sc.nextLine();

                    boolean encontrado = false;

                    for (int i = 0; i < nomes.size(); i++) {
                        if (nomes.get(i).toLowerCase().contains(pesquisa.toLowerCase())) {
                            System.out.println(
                                nomes.get(i) + " | Quantidade: " +
                                quantidades.get(i) + " | Preco: R$ " +
                                String.format("%.2f", precos.get(i))
                            );
                            encontrado = true;
                        }
                    }

                    if (!encontrado) {
                        System.out.println("Nenhum produto encontrado.");
                    }
                    break;

                case 6:
                    if (nomes.isEmpty()) {
                        System.out.println("Lista vazia.");
                    } else {
                        for (int i = 0; i < nomes.size(); i++) {
                            System.out.println(
                                (i + 1) + ". " + nomes.get(i) +
                                " | Quantidade: " + quantidades.get(i) +
                                " | Preco: R$ " + String.format("%.2f", precos.get(i)) +
                                " | Subtotal: R$ " +
                                String.format("%.2f", subtotal(quantidades.get(i), precos.get(i)))
                            );
                        }
                    }
                    break;

                case 7:
                    double total = 0;

                    for (int i = 0; i < nomes.size(); i++) {
                        total += subtotal(quantidades.get(i), precos.get(i));
                    }

                    System.out.printf("Valor total da compra: R$ %.2f%n", total);
                    break;

                case 8:
                    if (nomes.isEmpty()) {
                        System.out.println("Lista vazia.");
                    } else {
                        int maior = 0;

                        for (int i = 1; i < nomes.size(); i++) {
                            if (subtotal(quantidades.get(i), precos.get(i)) >
                                subtotal(quantidades.get(maior), precos.get(maior))) {
                                maior = i;
                            }
                        }

                        System.out.println("Produto com maior subtotal:");
                        System.out.println("Nome: " + nomes.get(maior));
                        System.out.println("Quantidade: " + quantidades.get(maior));
                        System.out.printf("Preco: R$ %.2f%n", precos.get(maior));
                        System.out.printf("Subtotal: R$ %.2f%n",
                                subtotal(quantidades.get(maior), precos.get(maior)));
                    }
                    break;

                case 9:
                    System.out.println("Programa encerrado.");
                    break;

                default:
                    System.out.println("Opcao invalida.");
            }

        } while (opcao != 9);

        sc.close();
    }
}