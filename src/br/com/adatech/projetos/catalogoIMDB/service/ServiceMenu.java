package br.com.adatech.projetos.catalogoIMDB.service;

import br.com.adatech.projetos.catalogoIMDB.model.ModelMenu;

/**
 * Classe que representa as operações realizadas por um objeto da classe Menu
 * Contém métodos específicos para todas as funcionalidades propostas
 */
public class ServiceMenu {
    public static ModelMenu menu = new ModelMenu();

    /**
     * Inicia o programa exibindo opções de menu e permitindo ao usuário escolher ações.
     */
    public static void iniciarPrograma(){

        do {
            // Tamanho da moldura
            int tamanhoMoldura = 26;

            menu.barraMenu(tamanhoMoldura);

            menu.tituloMenu(tamanhoMoldura);

            menu.barraMenu(tamanhoMoldura);

            for (int i = 0; i < menu.getOpcoesMenu().size(); i++) {
                System.out.printf("| (%d) - %-18s |\n", i + 1, menu.getOpcoesMenu().get(i));
            }

            menu.barraMenu(tamanhoMoldura);
            int escolheu = menu.escolhaUsuario();
            menu.retornoUsuario(escolheu);

        } while (true);

    }
}
