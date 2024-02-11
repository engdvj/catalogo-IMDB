package br.com.adatech.projetos.catalogoIMDB.model;

/**
 * Classe que representa um Menu
 * Contém construtores, parâmetros, além de getters e setters
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ModelMenu {
    private String titulo = "Menu";
    private List<String> opcoesMenu = new ArrayList<>();

     public ModelMenu() {
        opcoesMenu.add("Escolher Filme");
        opcoesMenu.add("Registrar Filme");
        opcoesMenu.add("Sair");

        //construtor para adicionar parâmetros na lista

     }

    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List getOpcoesMenu() {
        return opcoesMenu;
    }

    public void setOpcoesMenu(List opcoesMenu) {
        this.opcoesMenu = opcoesMenu;
    }

    public void tituloMenu(int tamanhoMoldura){
         System.out.printf("|%s%s%s|\n", " ".repeat((tamanhoMoldura - getTitulo().length() ) /2), getTitulo().toUpperCase(), " ".repeat((tamanhoMoldura - getTitulo().length() )/2));
        /**
         * Esse mêtodo é responsavel por imprimir o título do menu
         * criando espaços em branco ao redor do título
         * é divido por 2 para dar a simetria ao menu
         */
     }

    public void barraMenu(int tamanhoMoldura){
        System.out.println("+" + "-".repeat(tamanhoMoldura) + "+");
        /**
         * Barra para estilização da interface do menu
         * recebendo o tamanho da moldura para definir o tamanho da barra
         */
    }

    public int escolhaUsuario( ){
        Scanner sc = new Scanner(System.in);
        System.out.print("Qual sua escolha -> ");
        return sc.nextInt();
        //método para captar a escolha do usuário no menu
    }

    public void retornoUsuario(int escolheu){
         //método de retorno para retornar a seleção de menu
        switch (escolheu){
            case 1:
                /**
                 * Seção de escolha caso o úsuario
                 */
                break;

            case 2:
                /**
                 * Seção de escolha caso o úsuario
                 */
                break;

            case 3:
                System.out.println("Saindo...");
                System.exit(0);
                //retorno caso o úsuario dejese sair
                break;

            default:
                System.out.println("Escolha uma opção valida!!\n");
                break;
        }
    }
}