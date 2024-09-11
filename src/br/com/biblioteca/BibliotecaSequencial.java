package br.com.biblioteca;

public class BibliotecaSequencial {
    private Livro[] livros;
    private int count;

    public BibliotecaSequencial(int capacidade) {
        livros = new Livro[capacidade];
        count = 0;
    }

    public void adicionarLivro(Livro livro) {
        if (count < livros.length) {
            livros[count++] = livro;
        } else {
            System.out.println("Biblioteca cheia. Não é possível adicionar mais livros.");
        }
    }

    public void listarLivros() {
        for (int i = 0; i < count; i++) {
            System.out.println(livros[i]);
        }
    }

    public void bubbleSortPorTitulo() {
        for (int i = 0; i < count - 1; i++) {
            for (int j = 0; j < count - 1 - i; j++) {
                if (livros[j].getTitulo().compareTo(livros[j + 1].getTitulo()) > 0) {
                    Livro temp = livros[j];
                    livros[j] = livros[j + 1];
                    livros[j + 1] = temp;
                }
            }
        }
    }
    
    public void quickSortPorAutor(int inicio, int fim) {
        if (inicio < fim) {
            int pIndex = particionar(livros, inicio, fim);
            quickSortPorAutor(inicio, pIndex - 1);
            quickSortPorAutor(pIndex + 1, fim);
        }
    }

    private int particionar(Livro[] livros, int inicio, int fim) {
        Livro pivot = livros[fim];
        int i = inicio - 1;
        for (int j = inicio; j < fim; j++) {
            if (livros[j].getAutor().compareTo(pivot.getAutor()) < 0) {
                i++;
                Livro temp = livros[i];
                livros[i] = livros[j];
                livros[j] = temp;
            }
        }
        Livro temp = livros[i + 1];
        livros[i + 1] = livros[fim];
        livros[fim] = temp;
        return i + 1;
    }

    public int getCount() {  
        return count;
    }
}
