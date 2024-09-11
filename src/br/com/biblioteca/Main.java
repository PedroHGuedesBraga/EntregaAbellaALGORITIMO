package br.com.biblioteca;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BibliotecaSequencial biblioteca = new BibliotecaSequencial(100);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Adicionar Livro");
            System.out.println("2. Listar Livros");
            System.out.println("3. Ordenar por Título (Bubble Sort)");
            System.out.println("4. Ordenar por Autor (Quick Sort)");
            System.out.println("5. Sair");

            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    System.out.print("Digite o título do livro: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Digite o autor do livro: ");
                    String autor = scanner.nextLine();
                    System.out.print("Digite o ano de publicação: ");
                    int ano = scanner.nextInt();
                    scanner.nextLine(); 

                    Livro livro = new Livro(titulo, autor, ano);
                    biblioteca.adicionarLivro(livro);
                    break;
                case 2:
                    biblioteca.listarLivros();
                    break;
                case 3:
                    biblioteca.bubbleSortPorTitulo();
                    System.out.println("Livros ordenados por título.");
                    break;
                case 4:
                    biblioteca.quickSortPorAutor(0, biblioteca.getCount() - 1);
                    System.out.println("Livros ordenados por autor.");
                    break;
                case 5:
                    scanner.close();
                    System.out.println("Saindo...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
    }
}
