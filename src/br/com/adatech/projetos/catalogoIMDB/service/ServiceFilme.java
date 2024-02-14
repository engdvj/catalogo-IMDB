package br.com.adatech.projetos.catalogoIMDB.service;

import br.com.adatech.projetos.catalogoIMDB.model.ModelFilme;
import br.com.adatech.projetos.catalogoIMDB.util.Util;
import br.com.adatech.projetos.catalogoIMDB.view.Menu;
import br.com.adatech.projetos.catalogoIMDB.core.Catalogo;

import java.util.NoSuchElementException;


/**
 * Classe que representa as operações realizadas por um objeto da classe Filme
 * Contém métodos específicos para todas as funcionalidades propostas
 */
public class ServiceFilme {

    /**
     * Adiciona um filme ao sistema.
     */
    public static void adicionarFilme() {
        System.out.print("Informe o titulo do filme: ");
        String titulo = Menu.sc.nextLine();

        Util.Genero generoEscolhido;
        do {
            listarGeneros();
            System.out.print("\nInforme o Genero do filme: ");
            try {
                String generoInput = Menu.sc.nextLine();
                generoEscolhido = Util.Genero.valueOf(generoInput.toUpperCase());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Genero inválido! Tente novamente.");
            }
        } while (true);

        Util.ClassificacaoIndicativa indicacao;
        do {
            listarClassificacaoIndicativa();
            System.out.print("\nInforme a classificação indicativa: ");
            try {
                String indicacaoInput = Menu.sc.nextLine();
                indicacao = Util.ClassificacaoIndicativa.fromString(indicacaoInput);
                if (indicacao != Util.ClassificacaoIndicativa.INDEFINIDA) {
                    break;
                } else {
                    System.out.println("Classificação Indicativa inválida! Tente novamente.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Classificação Indicativa inválida! Tente novamente.");
            }
        } while (true);

        ModelFilme filme = new ModelFilme(titulo, generoEscolhido, indicacao);
        Catalogo.getCatalogo().add(filme);
        System.out.println("Filme " + filme.getTitulo() + " Cadastrado");
    }

    /**
     * Edita os detalhes de um filme existente no sistema.
     *
     * @param filme O objeto ModelFilme com as informações atualizadas.
     */
    public void editarFilme(ModelFilme filme) {
    }

    /**
     * Remove um diretor do sistema.
     */
    public static void removerFilme() {
        listarFilmes();
        System.out.println("Digite o titulo que gostaria de remover:");
        String titulo = Menu.sc.nextLine();

        if (titulo != null && Catalogo.getCatalogo().remove(titulo)) {
            System.out.println("Filme " + titulo + " Removido!");
        } else {
            System.out.println("Filme não encontrado ou não pode ser removido.");
        }
    }

    /**
     * Lista todos os filmes cadastrados no sistema.
     */
    public static void listarFilmes() {
        System.out.println("Filmes Cadastrados:");
        for (ModelFilme catalogo : Catalogo.getCatalogo()) {
            System.out.println(" - " + catalogo.getTitulo());
        }
    }


    /**
     * Fornece os dados de um diretor específico.
     */
    public static void fichaTecnicaFilme() {
        listarFilmes();
        System.out.println("Digite o titulo do Filme:");
        String titulo = Menu.sc.nextLine();
        System.out.println(getFilmeByTitulo(titulo));
    }

    public static void listarGeneros() {
        System.out.println("\nGeneros disponíveis:");
        Util.Genero[] valores = Util.Genero.values();
        for (int i = 0; i < valores.length; i++) {
            if (valores[i] != Util.Genero.INDEFINIDO) {
                String nome = valores[i].name().toLowerCase();
                nome = Character.toUpperCase(nome.charAt(0)) + nome.substring(1);
                System.out.print(nome);
                if (i < valores.length - 2) {
                    System.out.print(" - ");
                }
            }
        }
        System.out.println("");
    }

    public static void listarClassificacaoIndicativa() {
        System.out.println("\nClassificações Indicativas disponíveis:");
        for (Util.ClassificacaoIndicativa ci : Util.ClassificacaoIndicativa.values()) {
            if (ci != Util.ClassificacaoIndicativa.INDEFINIDA) {
                System.out.print(ci.getValor());
                if (ci != Util.ClassificacaoIndicativa.values()[Util.ClassificacaoIndicativa.values().length - 2]) {
                    System.out.print(" - ");
                }
            }
        }
        System.out.println("");
    }

    private static ModelFilme getFilmeByTitulo(String titulo) {
        try {
            for (ModelFilme catalogo : Catalogo.getCatalogo()) {
                if (catalogo.getTitulo().equals(titulo)) {
                    return catalogo;
                }
            }
            throw new NoSuchElementException("Filme com o titulo '" + titulo + "' não encontrado.");
        } catch (NoSuchElementException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }
}


