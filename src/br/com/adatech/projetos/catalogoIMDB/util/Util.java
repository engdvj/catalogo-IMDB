package br.com.adatech.projetos.catalogoIMDB.util;

import java.util.Scanner;

/**
 * Classe de utilidades para o catálogo de filmes
 * Contém métodos específicos para todas as funcionalidades propostas
 */
public class Util {

    public enum Genero {
        COMEDIA,
        DRAMA,
        ROMANCE,
        TERROR
    }
    public enum AreaRoteirista {
        ADAPTACAO,
        CRIACAO,
        EDICAO,
        PESQUISA,
        REVISAO,
    }

    public static int escolhaUsuario(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Qual sua escolha -> ");
        return sc.nextInt();
    }
}
