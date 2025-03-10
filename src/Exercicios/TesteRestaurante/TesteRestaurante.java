package Exercicios.TesteRestaurante;

import java.util.*;

public class TesteRestaurante {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pedido pedido = null;
        List<Prato> cardapio = new ArrayList<>();

        try {
            while (true) {
                System.out.print("Escolha uma opção (criar, adicionar, remover, visualizar, sair): ");
                String acao = scanner.nextLine().toLowerCase();

                if (acao.equals("criar")) {
                    System.out.print("Digite o número do pedido: ");
                    int numero = Integer.parseInt(scanner.nextLine());
                    System.out.print("Digite o nome do cliente: ");
                    String cliente = scanner.nextLine();
                    pedido = new Pedido(numero, cliente);
                    System.out.println("Pedido criado com sucesso!");
                } else if (acao.equals("adicionar")) {
                    if (pedido == null) {
                        System.out.println("Crie um pedido primeiro!");
                        continue;
                    }
                    System.out.print("Nome do prato: ");
                    String nome = scanner.nextLine();
                    System.out.print("Preço do prato: ");
                    double preco = Double.parseDouble(scanner.nextLine());
                    System.out.print("Descrição do prato: ");
                    String descricao = scanner.nextLine();
                    Prato prato = new Prato(nome, preco, descricao);
                    pedido.adicionarPrato(prato);
                    System.out.println("Prato adicionado ao pedido!");
                } else if (acao.equals("remover")) {
                    System.out.print("Nome do prato a remover: ");
                    String nome = scanner.nextLine();
                    cardapio.removeIf(prato -> prato.getNome().equalsIgnoreCase(nome));
                    System.out.println("Prato removido do cardápio!");
                } else if (acao.equals("visualizar")) {
                    if (pedido == null) {
                        System.out.println("Crie um pedido primeiro!");
                        continue;
                    }
                    pedido.visualizarPedido();
                } else if (acao.equals("sair")) {
                    System.out.println("Saindo...");
                    break;
                } else {
                    System.out.println("Ação inválida! Tente novamente.");
                }
            }
        } catch (Exception e) {
            System.out.println("Ocorreu um erro: " + e.getMessage());
        } finally {
            scanner.close();
            System.out.println("Programa encerrado.");
        }
    }
}
