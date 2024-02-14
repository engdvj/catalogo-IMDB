package br.com.adatech.projetos.catalogoIMDB.util;

import java.util.Scanner;

/**
 * Classe de utilidades para o catálogo de filmes
 * Contém métodos específicos para todas as funcionalidades propostas
 */
public class Util {

    private String valor;

    public enum ClassificacaoIndicativa {
        LIVRE("Livre"),
        R("R"),
        DEZ("10"),
        DOZE("12"),
        QUATORZE("14"),
        DEZESSEIS("16"),
        DEZOITO("18"),
        INDEFINIDA("Indefinida");
        private final String valor;
        ClassificacaoIndicativa(String valor) {
            this.valor = valor;
        }
        public String getValor() {
            return valor;
        }
        public static ClassificacaoIndicativa fromString(String valor) {
            for (ClassificacaoIndicativa ci : ClassificacaoIndicativa.values()) {
                if (ci.getValor().equalsIgnoreCase(valor)) {
                    return ci;
                }
            }
            return INDEFINIDA;
        }
    }


    public enum Genero {
        COMEDIA,
        DRAMA,
        ROMANCE,
        TERROR,
        INDEFINIDO
    }

    public enum AreaRoteirista {
        ADAPTACAO,
        CRIACAO,
        EDICAO,
        PESQUISA,
        REVISAO,
        INDEFINIDO
    }

    public static int escolhaUsuario(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Qual sua escolha -> ");
        int escolha = sc.nextInt();
        sc.nextLine();
        return escolha;
    }
}
