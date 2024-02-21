package br.com.adatech.projetos.catalogoIMDB.util;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * Classe de utilidades para o catálogo de filmes
 * Contém métodos específicos para todas as funcionalidades propostas
 */
public class Util {
     public static <T> List<T> getSortedCopy(List<T> originalList, Comparator<T> comparator) {
         List<T> copy = new ArrayList<>(originalList);
         Collections.sort(copy, comparator);
         return copy;
     }
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
    public enum AreaDiretor {
        GERAL,
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
    public enum PapelAtor {
        COADJUVANTE,
        PRINCIPAL,
        DUBLE,
        INDEFINIDO
    }
    public static int escolhaUsuario() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Qual sua escolha -> ");
        int escolha = sc.nextInt();
        sc.nextLine();
        return escolha;
    }
    public static String validarCPF(){
        Scanner sc = new Scanner(System.in);
        String cpf = sc.nextLine();
        while (cpf.length() != 11){
            System.out.println("O CPF é inválido! Digite novamente.");
            cpf = sc.nextLine();
        }
        return cpf;
    }
    public static String validarData(){

        LocalDate dataNascimento = null;
        Scanner sc = new Scanner(System.in);
        boolean entradaValida = false;

        while (!entradaValida) {
            String validacao = sc.nextLine();

            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                dataNascimento = LocalDate.parse(validacao, formatter);
                entradaValida = true;
            } catch (DateTimeException e){
                System.out.println("Formato de data inválido. Por favor, tente novamente.");
            }
        }
        return dataNascimento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }
}
