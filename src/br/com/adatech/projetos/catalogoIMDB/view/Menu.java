package br.com.adatech.projetos.catalogoIMDB.view;

import java.util.Scanner;

/**
 * Classe que representa um Menu
 * Contém construtores, parâmetros, getters e setters além de outros métodos
 */
public class Menu {
    public static Scanner sc = new Scanner(System.in);
    private static String titulo;
    private static final int tamanhoMoldura = 48;
    public static void iniciarPrograma(){
         menuInicial();
         sc.close();
    }
    private static void menuInicial() {
        String[] opcoesMenu = new String[]{"Cadastrar dados", "Consultar catálogo",
                "Alterar informações", "Sair"};
        titulo = "Menu Inicial";
        boolean continuarNoMenu = true;
        while (continuarNoMenu) {
            imprimirMenu(opcoesMenu);
            int escolheu = escolhaUsuario();
            switch (escolheu) {
                case 1:
                    menuCadastrar();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    continuarNoMenu = false;
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Escolha uma opção valida!!\n");
                    break;
            }
        }
    }

    private static void menuCadastrar() {
        String[] opcoesMenu = new String[] {"Cadastrar Ator", "Cadastrar Diretor",
                "Cadastrar Roteirista", "Cadastrar Filme", "Voltar para o menu anterior"};
        titulo = "Menu Cadastro";
        boolean continuarNoMenu = true;

        while (continuarNoMenu) {
            imprimirMenu(opcoesMenu);
            int escolheu = escolhaUsuario();

            switch (escolheu) {
                case 1:
                    System.out.println("Ator Cadastrado");
                    break;
                case 2:
                    System.out.println("Diretor Cadastrado");;
                    break;
                case 3:
                    System.out.println("Roteirista Cadastrado");
                    break;
                case 4:
                    System.out.println("Filme Cadastrado");
                    break;
                case 5:
                    continuarNoMenu = false;
                    break;
                default:
                    System.out.println("Escolha uma opção valida!!\n");
                    break;
            }
        }
}
    private static void imprimirMenu(String[] opcoesMenu) {
        barraMenu();
        tituloMenu();
        barraMenu();
        imprimirOpcoes(opcoesMenu);
        barraMenu();
    }
    private static void imprimirOpcoes(String[] opcoesMenu) {
        for (int i = 0; i < opcoesMenu.length; i++) {
            System.out.printf("| (%d) - %-40s |\n", i + 1, opcoesMenu[i]);
        }
    }
    public static void tituloMenu() {
        int espacoTotal = tamanhoMoldura - titulo.length();
        int espacoEsquerda = espacoTotal / 2;
        int espacoDireita = espacoTotal - espacoEsquerda;

        System.out.printf("|%s%s%s|\n",
                " ".repeat(espacoEsquerda),
                titulo.toUpperCase(),
                " ".repeat(espacoDireita));
    }
    public static void barraMenu(){
        System.out.println("+" + "-".repeat(tamanhoMoldura) + "+");
    }
    public static int escolhaUsuario(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Qual sua escolha -> ");
        return sc.nextInt();
    }

}