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

        ModelAtor ator1 = new ModelAtor(new String []{"Joao","65498732155","01/12/2000"});
        ModelAtor ator2 = new ModelAtor(new String []{"Maria","65498732155","01/12/2000"});
        Catalogo.getCatalogoAtores().add(ator1);
        Catalogo.getCatalogoAtores().add(ator2);

        ModelDiretor diretor1 = new ModelDiretor(new String []{"Mateus","12345678911","01/01/1990"});
        ModelDiretor diretor2 = new ModelDiretor(new String []{"Joana","12345678911","01/01/1990"});
        Catalogo.getCatalogoDiretores().add(diretor1);
        Catalogo.getCatalogoDiretores().add(diretor2);


        ModelRoteirista roterista1 = new ModelRoteirista(new String []{"Sabrina","98765432122","15/09/1992"});
        ModelRoteirista roterista2 = new ModelRoteirista(new String []{"Bruno","98765432122","15/09/1992"});
        Catalogo.getCatalogoRoteiristas().add(roterista1);
        Catalogo.getCatalogoRoteiristas().add(roterista2);


        ModelFilme filme1 = new ModelFilme("Viva","Filme familiar", Util.Genero.COMEDIA
                , Util.ClassificacaoIndicativa.DEZ,"01/10/2023","PT1H30M"
                ,300.000,7.5);
        ModelFilme filme2 = new ModelFilme("Procurando Nemo","Filme da Pixar", Util.Genero.DRAMA
                , Util.ClassificacaoIndicativa.DOZE,"01/12/2000","PT2H15M"
                ,350.000,8.5);
        Catalogo.getCatalogoFilmes().add(filme1);
        Catalogo.getCatalogoFilmes().add(filme2);
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
                    ServiceRoteirista.adicionarRoterista();
                    break;
                case 4:
                    ServiceFilme.adicionarFilme();
                    break;
                case 5:
                    continuarNoMenu = false;
                    System.out.println("Voltando ao menu anterior..");
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
                    System.out.println("Voltando ao menu anterior..");
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
                    ServiceRoteirista.fichaTecnicaRoterista();
                    break;
                case 4:
                    ServiceFilme.fichaTecnicaFilme();
                    break;
                case 5:
                    continuarNoMenu = false;
                    System.out.println("Voltando ao menu anterior..");
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
                    ServiceRoteirista.listarRoteiristas();
                    break;
                case 4:
                    ServiceFilme.listarFilmes();
                    break;
                case 5:
                    continuarNoMenu = false;
                    System.out.println("Voltando ao menu anterior..");
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
                , "Alterar Relações de Vínculo"
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
                    System.out.println("Voltando ao menu anterior..");
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
                    ServiceRoteirista.editarRoterista();
                    break;
                case 4:
                    ServiceFilme.editarFilme();
                    break;
                case 5:
                    continuarNoMenu = false;
                    System.out.println("Voltando ao menu anterior..");
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
                    ServiceRoteirista.removerRoterista();
                    break;
                case 4:
                    ServiceFilme.removerFilme();
                    break;
                case 5:
                    continuarNoMenu = false;
                    System.out.println("Voltando ao menu anterior..");
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
                    System.out.println("Voltando ao menu anterior..");
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