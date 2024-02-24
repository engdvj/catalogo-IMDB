package br.com.adatech.projetos.catalogoIMDB.util;

import br.com.adatech.projetos.catalogoIMDB.model.ModelFilme;

import java.time.DateTimeException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * Classe de utilidades para o catálogo de filmes
 * Contém métodos específicos para todas as funcionalidades propostas
 */
public class Util {
    public static <T> List<T> getSortedCopy(Set<Map.Entry<ModelFilme, Enum<?>>> originalSet,
                                            Comparator<Map.Entry<ModelFilme, Enum<?>>> comparator) {
        List<Map.Entry<ModelFilme, Enum<?>>> copy = new ArrayList<>(originalSet);
        copy.sort(comparator);
        return (List<T>) copy;
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

    public static String validarCPF() {
        Scanner sc = new Scanner(System.in);
        String cpf = sc.nextLine().replaceAll("[.-]","");
        while (cpf.length() != 11) {
            System.out.println("O CPF é inválido! Digite novamente.");
            cpf = sc.nextLine().replaceAll("[.-]","");
        }
        return cpf;
    }

    public static String validarData() {

        LocalDate dataNascimento = null;
        Scanner sc = new Scanner(System.in);
        boolean entradaValida = false;

        while (!entradaValida) {
            String validacao = sc.nextLine();

            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                dataNascimento = LocalDate.parse(validacao, formatter);
                entradaValida = true;
            } catch (DateTimeException e) {
                System.out.println("Formato de data inválido. Insira no formato DD/MM/YYYY.");
            }
        }
        return dataNascimento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public static String dataFormatada(LocalDate data) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return data.format(formatter);
    }

    public static String validarDuracao() {
        Duration duracao = null;
        Scanner sc = new Scanner(System.in);
        boolean entradaValida = false;
        while (!entradaValida) {
            String validacao = sc.nextLine().trim();
            try {
                duracao = Duration.parse("PT" + validacao);
                entradaValida = true;
            } catch (DateTimeException e) {
                System.out.println("Formato de duração inválido! Insira no formato 0h00m!");
            }
        }
        return String.valueOf(duracao);
    }

    public static String validarAvaliacao() {
        String avaliacao = "";
        boolean entradaValida = false;
        Scanner sc = new Scanner(System.in);
        while (!entradaValida) {
            String avaliacaoInput = sc.nextLine().replace(',','.').trim();

            if (avaliacaoInput.isEmpty()) {
                avaliacao = "0.0"; // Valor padrão
                entradaValida = true;
            } else if (Double.parseDouble(avaliacaoInput) >= 0 && Double.parseDouble(avaliacaoInput) <= 10) {
                avaliacao = avaliacaoInput;
                entradaValida = true;
            } else {
                System.out.println("Valor da avaliação inválido. Insira novamente !");
            }
        }
        return avaliacao;
    }
}
