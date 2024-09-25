package br.com.biblioteca;

public class No {
    Livro livro;
    No esquerda, direita;

    public No(Livro livro) {
        this.livro = livro;
        esquerda = direita = null;
    }
}
