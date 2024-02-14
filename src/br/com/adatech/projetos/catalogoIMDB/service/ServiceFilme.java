package br.com.adatech.projetos.catalogoIMDB.service;

import br.com.adatech.projetos.catalogoIMDB.model.ModelFilme;
import br.com.adatech.projetos.catalogoIMDB.model.ModelRoterista;
import br.com.adatech.projetos.catalogoIMDB.util.Util;
import br.com.adatech.projetos.catalogoIMDB.view.Menu;
import br.com.adatech.projetos.catalogoIMDB.core.Catalogo;

import java.util.ArrayList;
import java.util.HashMap;


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
        listarGeneros();
        System.out.print("\nInforme o Genero do filme: ");
        Util.Genero generoEscolhido = Util.Genero.INDEFINIDO;
        Util.ClassificacaoIndicativa indicacao = Util.ClassificacaoIndicativa.INDEFINIDA;
        try {
            String generoInput = Menu.sc.nextLine();
            generoEscolhido = Util.Genero.valueOf(generoInput.toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.println("Genero inválido!");
        }
        listarClassificacaoIndicativa();
        System.out.print("\nInforme a classificação indicativa: ");
        try {
            String indicacaoInput = Menu.sc.nextLine();
            indicacao = Util.ClassificacaoIndicativa.fromString(indicacaoInput);
        } catch (IllegalArgumentException e) {
            System.out.println("Classificação Indicativa inválida!");
        }
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
     *
     * @param filme O objeto ModelFilme a ser removido.
     */
    public void removerFilme(ModelFilme filme) {
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
     *
     * @param filme O objeto ModelFilme cujos dados são necessários.
     */
    public void fichaTecnicaFilme(ModelFilme filme) {
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
}


