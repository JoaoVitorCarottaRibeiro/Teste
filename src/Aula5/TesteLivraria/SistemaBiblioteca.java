package Aula4.TesteLivraria;

import java.util.Scanner;

public class SistemaBiblioteca {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        Scanner scanner = new Scanner(System.in);

        try {
            while (true) {
                System.out.print("Digite uma ação (adicionar, remover, registrar, emprestar, devolver, sair): ");
                String acao = scanner.nextLine().toLowerCase();

                if (acao.equals("adicionar")) {
                    System.out.print("Título: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Autor: ");
                    String autor = scanner.nextLine();
                    System.out.print("ISBN: ");
                    String isbn = scanner.nextLine();
                    biblioteca.adicionarLivro(new Livro(titulo, autor, isbn));
                } else if (acao.equals("remover")) {
                    System.out.print("ISBN do livro a remover: ");
                    String isbnRemover = scanner.nextLine();
                    biblioteca.getLivros().removeIf(livro -> livro.getIsbn().equals(isbnRemover));
                    System.out.println("Livro removido.");
                } else if (acao.equals("registrar")) {
                    System.out.print("Nome do Membro: ");
                    String nome = scanner.nextLine();
                    System.out.print("ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Email: ");
                    String email = scanner.nextLine();
                    biblioteca.registrarMembro(new Membro(nome, id, email));
                } else if (acao.equals("emprestar")) {
                    System.out.print("ISBN do Livro para empréstimo: ");
                    String isbnEmprestimo = scanner.nextLine();
                    System.out.print("ID do Membro: ");
                    int idMembroEmprestimo = scanner.nextInt();
                    scanner.nextLine();
                    Livro livroEmprestimo = biblioteca.getLivros().stream()
                            .filter(livro -> livro.getIsbn().equals(isbnEmprestimo))
                            .findFirst().orElse(null);
                    Membro membroEmprestimo = biblioteca.getMembros().stream()
                            .filter(membro -> membro.getId() == idMembroEmprestimo)
                            .findFirst().orElse(null);
                    if (livroEmprestimo != null && membroEmprestimo != null) {
                        biblioteca.registrarEmprestimo(livroEmprestimo, membroEmprestimo);
                    } else {
                        System.out.println("Livro ou Membro não encontrado.");
                    }
                } else if (acao.equals("devolver")) {
                    System.out.print("ISBN do Livro a devolver: ");
                    String isbnDevolver = scanner.nextLine();
                    Emprestimo emprestimo = biblioteca.getEmprestimos().stream()
                            .filter(e -> e.getLivro().getIsbn().equals(isbnDevolver))
                            .findFirst().orElse(null);
                    if (emprestimo != null) {
                        biblioteca.devolverLivro(emprestimo);
                    } else {
                        System.out.println("Empréstimo não encontrado.");
                    }
                } else if (acao.equals("sair")) {
                    biblioteca.salvarDadosEmArquivo("biblioteca.txt");
                    System.out.println("Dados salvos. Saindo...");
                    break;
                } else {
                    System.out.println("Ação inválida.");
                }
            }
        } catch (Exception e) {
            System.out.println("Ocorreu um erro: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
