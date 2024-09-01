package org.example;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;


public class Main {
    static void mostrar(List<Pelicula> peliculas, Consumer<Pelicula> c) {
        for (Pelicula pelicula : peliculas) {
            c.accept(pelicula);
        }
    }

    public static void main(String[] args) {
        List<Pelicula> peliculas = new ArrayList<>();
        peliculas.add(new Pelicula("E.T.", "Steven Spielberg", 1982));
        peliculas.add(new Pelicula("Avatar", "James Cameron", 2009));
        peliculas.add(new Pelicula("Salvar al soldado Ryan", "Steven Spielberg", 1998));
        peliculas.add(new Pelicula("Origen", "Christopher Nolan", 2010));
        peliculas.add(new Pelicula("L.A. Confidential", "Curtis Hanson", 1997));



        List peliculasEstrenadasSigloXXI = peliculas.stream()
                .filter(p -> p.getEstreno() >= 2000)
                .collect(Collectors.toList());
        System.out.println("Películas estrenadas en el siglo XXI (apartir del 2000):");
        peliculasEstrenadasSigloXXI.forEach(System.out::println);


        String titulosDeSpielberg = peliculas.stream()
                .filter(p -> "Steven Spielberg".equals(p.getDirector()))
                .map(p->p.getTitulo())
                .collect(Collectors.joining(", ","Títulos de películas de Steven Spielberg: ",""));
        System.out.println(titulosDeSpielberg);


        List titulosOrdenados = peliculas.stream()
                .map(p->p.getTitulo())
                .sorted()
                .collect(Collectors.toList());
        System.out.println("Títulos de películas ordenados alfabéticamente:");
        titulosOrdenados.forEach(System.out::println);




    }
}