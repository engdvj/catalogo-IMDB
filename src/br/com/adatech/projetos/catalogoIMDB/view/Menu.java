package br.com.adatech.projetos.catalogoIMDB.view;

import java.util.Scanner;

/**
 * Classe que representa um Menu
 * Contém construtores, parâmetros, getters e setters além de outros métodos
 */
public class Menu {
    public static Scanner sc = new Scanner(System.in);
    private static String titulo = "Menu";
    private static final int tamanhoMoldura = 40;
    public static void iniciarPrograma(){
         menuInicial();
         sc.close();
    }
    private static void menuInicial(){
        String [] opcoesMenu = new String[] {"Cadastrar dados","Consultar catálogo",
                "Alterar informações","Sair"};
        do{
        imprimirMenu(opcoesMenu);
        int escolheu = escolhaUsuario();
            switch (escolheu){
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    System.out.println("Saindo...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Escolha uma opção valida!!\n");
                    break;
            }
        }while (true);
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
            System.out.printf("| (%d) - %-32s |\n", i + 1, opcoesMenu[i]);
        }
    }
    public static void tituloMenu(){
        System.out.printf("|%s%s%s|\n", " ".repeat((tamanhoMoldura - titulo.length() ) /2),
                titulo.toUpperCase(), " ".repeat((tamanhoMoldura - titulo.length() )/2));
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