package br.com.biblioteca;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArvoreBinaria arvore = new ArvoreBinaria();

        
        Livro livro1 = new Livro("Dom Casmurro", "Machado de Assis", 1899);
        Livro livro2 = new Livro("A Moreninha", "Joaquim Manuel de Macedo", 1844);
        Livro livro3 = new Livro("O Cortiço", "Aluísio Azevedo", 1890);

        arvore.adicionar(livro1);
        arvore.adicionar(livro2);
        arvore.adicionar(livro3);

        System.out.println("Três livros foram adicionados automaticamente à árvore.");

        
        while (true) {
            System.out.println("\n1. Adicionar livro");
            System.out.println("2. Listar todos os livros");
            System.out.println("3. Buscar livro por título");
            System.out.println("4. Recomendar livros por autor");
            System.out.println("5. Sair");

            int escolha = scanner.nextInt();
            scanner.nextLine(); 

            switch (escolha) {
                case 1:
                    System.out.print("Digite o título do livro: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Digite o autor do livro: ");
                    String autor = scanner.nextLine();
                    System.out.print("Digite o ano de publicação: ");
                    int ano = scanner.nextInt();
                    scanner.nextLine(); // Consumir nova linha

                    Livro novoLivro = new Livro(titulo, autor, ano);
                    arvore.adicionar(novoLivro);
                    System.out.println("Livro adicionado com sucesso!");
                    break;

                case 2:
                    System.out.println("Lista de livros:");
                    arvore.listarLivros();
                    break;

                case 3:
                    System.out.print("Digite o título do livro que deseja buscar: ");
                    String tituloBusca = scanner.nextLine();
                    Livro livroEncontrado = arvore.buscarLivro(tituloBusca);
                    if (livroEncontrado != null) {
                        System.out.println("Livro encontrado: " + livroEncontrado);
                    } else {
                        System.out.println("Livro não encontrado.");
                    }
                    break;

                case 4:
                    System.out.print("Digite o autor para recomendar livros: ");
                    String autorRecomendacao = scanner.nextLine();
                    arvore.recomendarPorAutor(autorRecomendacao);
                    break;

                case 5:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Escolha inválida. Tente novamente.");
            }
        }
    }
}
