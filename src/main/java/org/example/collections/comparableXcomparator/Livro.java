package org.example.collections.comparableXcomparator;

import java.util.Comparator;

class Livro implements Comparable<Livro>{
    private String titulo;
    private String autor;
    private int ano;

    public Livro(String titulo, String autor, int ano) {
        this.titulo = titulo;
        this.autor = autor;
        this.ano = ano;
    }

    @Override
    public int compareTo(Livro o) {
        return titulo.compareTo(o.titulo);
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getAno() {
        return ano;
    }
}

class  CompararAutor implements Comparator<Livro> {
    @Override
    public int compare(Livro o1, Livro o2) {
        return o1.getAutor().compareTo(o2.getAutor());
    }
}

class CompararAno implements Comparator<Livro>{
    @Override
    public int compare(Livro o1, Livro o2) {
        return Integer.compare(o1.getAno(), o2.getAno());
    }
}

class CompararAnoAutorTitulo implements Comparator<Livro>{

    @Override
    public int compare(Livro o1, Livro o2) {
        int ano = Integer.compare(o1.getAno(), o2.getAno());
        if(ano != 0)
            return ano;
        int autor = o1.getAutor().compareTo(o2.getAutor());
        if(autor != 0)
            return autor;
        return o1.getTitulo().compareTo(o2.getTitulo());
    }
}