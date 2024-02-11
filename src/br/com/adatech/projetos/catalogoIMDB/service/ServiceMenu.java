package br.com.adatech.projetos.catalogoIMDB.service;

import br.com.adatech.projetos.catalogoIMDB.model.*;

import java.time.LocalDate;
import java.util.Scanner;

/**
 * Classe que representa as operações realizadas por um objeto da classe Menu
 * Contém métodos específicos para todas as funcionalidades propostas
 */
public class ServiceMenu {
    public static ModelMenu menu = new ModelMenu();
    public static Scanner scanner = new Scanner(System.in);

    /**
     * Inicia o programa exibindo opções de menu e permitindo ao usuário escolher ações.
     */
    public static void iniciarPrograma(){
        menuInicial();
        scanner.close();
    }
    public static void menuInicial(){
        int escolha = 0;
        do {
            System.out.println("""
                    Opções do programa:
                    1- Cadastrar dados
                    2- Consultar catálogo
                    3- Alterar informações 
                    4- Sair
                    """);
            escolha = scanner.nextInt();
            switch (escolha){
                case 1:
                    System.out.println("Oq vc quer cadastrar?");
                    break;
                case 2:
                    System.out.println("Oq vc quer consultar?");
                    break;
                case 3:
                    System.out.println("Oq vc quer alterar?");
                    break;
            }

        }while(escolha != 4);
        System.out.println("Fim do programa!");

    }
}
