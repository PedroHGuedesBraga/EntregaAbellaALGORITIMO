package br.com.biblioteca;

public class ArvoreBinaria {
    private No raiz;

    // Método para adicionar livro na árvore
    public void adicionar(Livro livro) {
        raiz = adicionarRecursivo(raiz, livro);
    }

    private No adicionarRecursivo(No atual, Livro livro) {
        if (atual == null) {
            return new No(livro);
        }
        if (livro.getTitulo().compareTo(atual.livro.getTitulo()) < 0) {
            atual.esquerda = adicionarRecursivo(atual.esquerda, livro);
        } else if (livro.getTitulo().compareTo(atual.livro.getTitulo()) > 0) {
            atual.direita = adicionarRecursivo(atual.direita, livro);
        }
        return atual;
    }

    // Método para listar todos os livros em ordem alfabética (in-order traversal)
    public void listarLivros() {
        listarRecursivo(raiz);
    }

    private void listarRecursivo(No atual) {
        if (atual != null) {
            listarRecursivo(atual.esquerda);
            System.out.println(atual.livro);
            listarRecursivo(atual.direita);
        }
    }

    // Método para buscar um livro específico pelo título
    public Livro buscarLivro(String titulo) {
        return buscarRecursivo(raiz, titulo);
    }

    private Livro buscarRecursivo(No atual, String titulo) {
        if (atual == null) {
            return null;  // Livro não encontrado
        }
        if (titulo.equals(atual.livro.getTitulo())) {
            return atual.livro;
        }
        if (titulo.compareTo(atual.livro.getTitulo()) < 0) {
            return buscarRecursivo(atual.esquerda, titulo);
        }
        return buscarRecursivo(atual.direita, titulo);
    }

    // Método para recomendar livros baseados no autor
    public void recomendarPorAutor(String autor) {
        System.out.println("Recomendações para o autor " + autor + ":");
        recomendarRecursivo(raiz, autor);
    }

    private void recomendarRecursivo(No atual, String autor) {
        if (atual != null) {
            recomendarRecursivo(atual.esquerda, autor);
            if (atual.livro.getAutor().equals(autor)) {
                System.out.println(atual.livro);
            }
            recomendarRecursivo(atual.direita, autor);
        }
    }
}
