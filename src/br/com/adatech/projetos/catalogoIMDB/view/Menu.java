package br.com.adatech.projetos.catalogoIMDB.view;

import br.com.adatech.projetos.catalogoIMDB.core.Catalogo;
import br.com.adatech.projetos.catalogoIMDB.model.*;
import br.com.adatech.projetos.catalogoIMDB.service.*;
import br.com.adatech.projetos.catalogoIMDB.util.Util;

import java.util.Scanner;


/**
 * Classe que representa um Menu
 * Contém construtores, parâmetros, getters e setters além de outros métodos
 */
public class Menu {
    public static Scanner sc = new Scanner(System.in);
    private static String titulo;
    private static final int tamanhoMoldura = 48;


    public static void iniciarPrograma() {
        dadosParaTeste();
        menuInicial();
        sc.close();
    }
    private static void dadosParaTeste() {
        String []dadosAtor = new String []{"Joao Gomes","65498732155","01/12/2000"};
        String []dadosDiretor = new String []{"Mateus Brito","12345678911","01/01/1990"};
        String []dadosRoterista = new String []{"Sabrina Prina","98765432122","15/09/1992"};

        ModelAtor ator1 = new ModelAtor(dadosAtor);
        Catalogo.getAtores().put(ator1, Catalogo.getCatalogo());

        ModelDiretor diretor1 = new ModelDiretor(dadosDiretor);
        Catalogo.getDiretores().put(diretor1, Catalogo.getCatalogo());

        ModelRoterista roterista1 = new ModelRoterista(dadosRoterista);
        Catalogo.getRoteristas().put(roterista1, Catalogo.getCatalogo());

        ModelFilme filme1 = new ModelFilme("Viva", Util.Genero.COMEDIA, Util.ClassificacaoIndicativa.DEZ);
        Catalogo.getCatalogo().add(filme1);
    }

    private static void menuInicial() {
        String[] opcoesMenu = new String[]{"Cadastrar Dados", "Consultar Catálogo",
                "Alterar Informações", "Sair"};
        titulo = "Menu Inicial";
        boolean continuarNoMenu = true;
        while (continuarNoMenu) {
            imprimirMenu(opcoesMenu);
            int escolher = Util.escolhaUsuario();
            switch (escolher) {
                case 1:
                    menuCadastrar();
                    break;
                case 2:
                    consultarCatalogo();
                    break;
                case 3:
                    alterarInformacoes();
                    break;
                case 4:
                    continuarNoMenu = false;
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Escolha uma opção válida!!\n");
                    break;
            }
        }
    }

    private static void menuCadastrar() {
        String[] opcoesMenu = new String[]{"Cadastrar Ator", "Cadastrar Diretor",
                "Cadastrar Roteirista", "Cadastrar Filme", "Voltar para o menu anterior"};
        titulo = "Menu Cadastro";
        boolean continuarNoMenu = true;

        while (continuarNoMenu) {
            imprimirMenu(opcoesMenu);
            int escolher = Util.escolhaUsuario();
            switch (escolher) {
                case 1:
                    ServiceAtor.adicionarAtor();
                    break;
                case 2:
                    ServiceDiretor.adicionarDiretor();
                    break;
                case 3:
                    ServiceRoterista.adicionarRoterista();
                    break;
                case 4:
                    ServiceFilme.adicionarFilme();
                    break;
                case 5:
                    continuarNoMenu = false;
                    titulo = "Menu Inicial";
                    break;
                default:
                    System.out.println("Escolha uma opção válida!!\n");
                    break;
            }
        }
    }

    private static void consultarCatalogo() {
        String[] opcoesMenu = new String[]{"Ficha Técnica", "Lista Completa",
                "Voltar para o menu anterior"};
        titulo = "Menu Catálogo";
        boolean continuarNoMenu = true;

        while (continuarNoMenu) {
            imprimirMenu(opcoesMenu);
            int escolher = Util.escolhaUsuario();
            switch (escolher) {
                case 1:
                    fichaTecnica();
                    break;
                case 2:
                    listagemColetiva();
                    break;
                case 3:
                    continuarNoMenu = false;
                    titulo = "Menu Inicial";
                    break;
                default:
                    System.out.println("Escolha uma opção válida!!\n");
                    break;
            }
        }
    }

    private static void fichaTecnica() {
        String[] opcoesMenu = new String[]{"Listar dados de um Ator", "Listar dados de um Diretor"
                , "Listar dados de um Roterista", "Listar dados de um Filme"
                , "Voltar para o menu anterior"};

        titulo = "Menu Ficha Técnica";
        boolean continuarNoMenu = true;

        while (continuarNoMenu) {
            imprimirMenu(opcoesMenu);
            int escolher = Util.escolhaUsuario();
            switch (escolher) {
                case 1:
                    ServiceAtor.fichaTecnicaAtor();
                    break;
                case 2:
                    ServiceDiretor.fichaTecnicaDiretor();
                    break;
                case 3:
                    ServiceRoterista.fichaTecnicaRoterista();
                    break;
                case 4:
                    ServiceFilme.fichaTecnicaFilme();
                    break;
                case 5:
                    continuarNoMenu = false;
                    titulo = "Menu Catálogo";
                    break;
                default:
                    System.out.println("Escolha uma opção válida!!\n");
                    break;
            }
        }
    }

    private static void listagemColetiva() {
        String[] opcoesMenu = new String[]{"Listar todos os Atores cadastrados"
                , "Listar todos os Diretores cadastrados"
                , "Listar todos os Roteristas cadastrados"
                , "Listar todos os Filmes cadastrados"
                , "Voltar para o menu anterior"};

        titulo = "Menu Catálogo";
        boolean continuarNoMenu = true;

        while (continuarNoMenu) {
            imprimirMenu(opcoesMenu);
            int escolher = Util.escolhaUsuario();
            switch (escolher) {
                case 1:
                    ServiceAtor.listarAtores();
                    break;
                case 2:
                    ServiceDiretor.listarDiretores();
                    break;
                case 3:
                    ServiceRoterista.listarRoteristas();
                    break;
                case 4:
                    ServiceFilme.listarFilmes();
                    break;
                case 5:
                    continuarNoMenu = false;
                    titulo = "Menu Catálogo";
                    break;
                default:
                    System.out.println("Escolha uma opção válida!!\n");
                    break;
            }
        }
    }
    private static void alterarInformacoes() {
        String[] opcoesMenu = new String[]{"Editar uma Informação"
                , "Remover uma Informação"
                , "Vincular uma Informação"
                , "Voltar para o Menu Anterior"};
        titulo = "Menu Escolha";
        boolean continuarNoMenu = true;

        while (continuarNoMenu) {
            imprimirMenu(opcoesMenu);
            int escolher = Util.escolhaUsuario();
            switch (escolher) {
                case 1:
                    editarInformacoes();
                    break;
                case 2:
                    removerInformacoes();
                    break;
                case 3:
                    vincularInformacoes();
                    break;
                case 4:
                    continuarNoMenu = false;
                    titulo = "Menu Inicial";
                    break;
                default:
                    System.out.println("Escolha uma opção válida!!\n");
                    break;
            }
        }
    }
    private static void editarInformacoes() {
        String[] opcoesMenu = new String[]{"Alterar informações de um Ator"
                , "Alterar informações de um Diretor"
                , "Alterar informações de um Roterista"
                , "Alterar informações de um Filme"
                , "Voltar para o menu anterior"};

        titulo = "Menu Alterar Informações";
        boolean continuarNoMenu = true;

        while (continuarNoMenu) {
            imprimirMenu(opcoesMenu);
            int escolher = Util.escolhaUsuario();
            switch (escolher) {
                case 1:
                    ServiceAtor.editarAtor();
                    break;
                case 2:
                    ServiceDiretor.editarDiretor();
                    break;
                case 3:
                    ServiceRoterista.editarRoterista();
                    break;
                case 4:
                    ServiceFilme.editarFilme();
                    break;
                case 5:
                    continuarNoMenu = false;
                    titulo = "Menu Escolha";
                    break;
                default:
                    System.out.println("Escolha uma opção válida!!\n");
                    break;
            }
        }
    }
    private static void removerInformacoes() {
        String[] opcoesMenu = new String[]{"Remover um Ator", "Remover um Diretor"
                , "Remover um Roterista", "Remover um Filme"
                , "Voltar para o Menu Anterior"};

        titulo = "Menu Remover Informações";
        boolean continuarNoMenu = true;

        while (continuarNoMenu) {
            imprimirMenu(opcoesMenu);
            int escolher = Util.escolhaUsuario();
            switch (escolher) {
                case 1:
                    ServiceAtor.removerAtor();
                    break;
                case 2:
                    ServiceDiretor.removerDiretor();
                    break;
                case 3:
                    ServiceRoterista.removerRoterista();
                    break;
                case 4:
                    ServiceFilme.removerFilme();
                    break;
                case 5:
                    continuarNoMenu = false;
                    titulo = "Menu Escolha";
                    break;
                default:
                    System.out.println("Escolha uma opção válida!!\n");
                    break;
            }
        }
    }
    private static void vincularInformacoes() {
        String[] opcoesMenu = new String[]{"Vincular pessoas aos filmes"
                , "Desvincular pessoas aos filmes"
                , "Voltar para o menu anterior"};

        titulo = "Menu Vincular Informações";
        boolean continuarNoMenu = true;

        while (continuarNoMenu) {
            imprimirMenu(opcoesMenu);
            int escolher = Util.escolhaUsuario();
            switch (escolher) {
                case 1:
                    Catalogo.associarFilme();
                    break;
                case 2:
                    Catalogo.desassociarFilme();
                    break;
                case 3:
                    continuarNoMenu = false;
                    titulo = "Menu Escolha";
                    break;
                default:
                    System.out.println("Escolha uma opção válida!!\n");
                    break;
            }
        }

    }
    private static void imprimirMenu(String[] opcoesMenu) {
        //Barra
        System.out.println("+" + "-".repeat(tamanhoMoldura) + "+");

        //Título
        int espacoTotal = tamanhoMoldura - titulo.length();
        int espacoEsquerda = espacoTotal / 2;
        int espacoDireita = espacoTotal - espacoEsquerda;
        System.out.printf("|%s%s%s|\n",
                " ".repeat(espacoEsquerda), titulo.toUpperCase(),
                " ".repeat(espacoDireita));

        //Barra
        System.out.println("+" + "-".repeat(tamanhoMoldura) + "+");

        //Opções
        for (int i = 0; i < opcoesMenu.length; i++) {
            System.out.printf("| (%d) - %-40s |\n", i + 1, opcoesMenu[i]);
        }

        //Barra
        System.out.println("+" + "-".repeat(tamanhoMoldura) + "+");
    }


}