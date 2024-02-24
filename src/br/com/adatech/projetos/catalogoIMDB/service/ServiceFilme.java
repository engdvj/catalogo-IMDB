package br.com.adatech.projetos.catalogoIMDB.service;

import br.com.adatech.projetos.catalogoIMDB.model.ModelFilme;
import br.com.adatech.projetos.catalogoIMDB.util.Util;
import br.com.adatech.projetos.catalogoIMDB.util.Util.*;
import br.com.adatech.projetos.catalogoIMDB.view.Menu;
import br.com.adatech.projetos.catalogoIMDB.core.Catalogo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


/**
 * Classe que representa as operações realizadas por um objeto da classe Filme
 * Contém métodos específicos para todas as funcionalidades propostas
 */
public class ServiceFilme {

    /**
     * Adiciona um filme ao sistema.
     */
    public static void adicionarFilme() {
        String titulo;

        titulo = verificaTituloFilme();

        System.out.print("Informe a descrição do filme: ");
        String descricao = Menu.sc.nextLine().trim();
        descricao = descricao.isEmpty() ? "N/A" : descricao;

        Genero generoEscolhido = escolherGenero(); // Supondo que escolherGenero pode lidar com escolhas inválidas

        ClassificacaoIndicativa indicacao = escolherClassificacaoIndicativa(); // Supondo que escolherClassificacaoIndicativa pode lidar com escolhas inválidas

        System.out.print("Informe a data de lançamento (DD/MM/YYYY): ");
        String data = Util.validarData(); // Supondo que validarData retorna "N/A" para datas inválidas

        System.out.print("Informe a duração do filme (Ex. 1h30m): ");
        String duracao = Util.validarDuracao();
        duracao = duracao.isEmpty() ? "PT00H00M" : duracao.toUpperCase();

        System.out.print("Informe o orçamento do filme: ");
        String orcamentoInput = Menu.sc.nextLine().replaceAll("[.,]","").trim();
        double orcamento;
        if (orcamentoInput.isEmpty()) {
            orcamento = 0.0; // Valor padrão
        } else {
            try {
                orcamento = Double.parseDouble(orcamentoInput);
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Orçamento definido como 0.");
                orcamento = 0.0;
            }
        }

        System.out.print("Informe a avaliacao do filme: ");
        double avaliacao = Double.parseDouble(Util.validarAvaliacao());

        ModelFilme filme = new ModelFilme(titulo, descricao, generoEscolhido, indicacao, data, duracao, orcamento, avaliacao);
        Catalogo.getCatalogoFilmes().add(filme);
        System.out.println("Filme " + filme.getTitulo() + " Cadastrado");
    }


    private static String verificaTituloFilme() {
        String titulo;
        boolean tituloUnico;
        do {
            System.out.print("Informe o titulo do filme: ");
            titulo = Menu.sc.nextLine().trim();
            tituloUnico = true;

            for (ModelFilme filme : Catalogo.getCatalogoFilmes()) {
                if (filme.getTitulo().equalsIgnoreCase(titulo)) {
                    tituloUnico = false; // Define como falso se encontrar um filme existente com o mesmo título
                    System.out.println("Já existe um filme com esse título! Por favor, insira um título diferente.");
                    break; // Sai do loop for se encontrar um título existente
                }
            }

            if (titulo.isEmpty()) {
                System.out.println("O título do filme é obrigatório. Por favor, insira um título.");
            }
        } while (titulo.isEmpty() || !tituloUnico);

        return titulo;
    }

    /**
     * Edita os detalhes de um filme existente no sistema.
     */
        public static void editarFilme() {
        listarFilmes();
        System.out.print("Digite o titulo do filme que gostaria de alterar: ");
        String informacao = Menu.sc.nextLine();
        ModelFilme filme = getFilmeByTitulo(informacao);
        if (filme != null) {
            System.out.println("Qual informação gostaria de editar?");
            System.out.println("""
                    (1) - Titulo
                    (2) - Descrição
                    (3) - Gênero
                    (4) - Classificação Indicativa
                    (5) - Data de lançamento
                    (6) - Duração
                    (7) - Orçamento
                    (8) - Avaliação""");
            System.out.print("-> ");
            int escolha = Menu.sc.nextInt();
            Menu.sc.nextLine();
            switch (escolha) {
                case 1:
                    System.out.println("Digite o novo titulo:");
                    informacao = verificaTituloFilme();
                    filme.setTitulo(informacao);
                    System.out.println("Titulo alterado!");
                    break;
                case 2:
                    System.out.println("Digite a nova descrição:");
                    informacao = Menu.sc.nextLine();
                    filme.setDescricao(informacao);
                    System.out.println("Descrição do filme alterada!");
                    break;
                case 3:
                    Genero generoEscolhido = escolherGenero();
                    filme.setGenero(generoEscolhido);
                    System.out.println("Genero do filme alterado!");
                    break;
                case 4:
                    ClassificacaoIndicativa indicacao = escolherClassificacaoIndicativa();
                    filme.setClassificacaoIndicativa(indicacao);
                    System.out.println("Classificação Indicativa do filme alterada!");
                    break;
                case 5:
                    System.out.println("Digite a nova data de lançamento:");
                    informacao = Menu.sc.nextLine();
                    filme.setDataDeLancamento(informacao);
                    System.out.println("Data de lançamento do filme alterada!");
                    break;
                case 6:
                    System.out.println("Digite a nova duração do filme: (Ex. 1h30m)");
                    informacao = Util.validarDuracao();
                    filme.setDuracao(informacao);
                    System.out.println("Data de lançamento do filme alterada!");
                    break;
                case 7:
                    System.out.println("Digite o novo orçamento do filme: ");
                    informacao = Menu.sc.nextLine().replaceAll("[.,]","").trim();
                    filme.setOrcamento(Double.parseDouble(informacao));
                    System.out.println("Orçamento do filme alterado!");
                    break;
                case 8:
                    System.out.println("Digite a nova avaliação do filme (Ex 8.3):  ");
                    informacao = Util.validarAvaliacao();
                    filme.setAvaliacao(Double.parseDouble(informacao));
                    System.out.println("Avaliação do filme alterada!");
                    break;
                default:
                    System.out.println("Escolha uma opção valida!!\n");
                    break;
            }
        } else {
            System.out.println("Filme não encontrado!");
        }
    }

    /**
     * Remove um filme do sistema.
     */
    public static void removerFilme() {
        listarFilmes();
        System.out.println("Digite o titulo que gostaria de remover:");
        String titulo = Menu.sc.nextLine();
        if (titulo != null && Catalogo.getCatalogoFilmes().remove(getFilmeByTitulo(titulo))) {
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

        List<ModelFilme> filmes = new ArrayList<>(Catalogo.getCatalogoFilmes());
        filmes.sort(Comparator.comparing(ModelFilme::getTitulo));

        for (ModelFilme catalogo : filmes) {
            System.out.println(" - " + catalogo.getTitulo());
        }
    }


    /**
     * Fornece a ficha técnica de um filme específico.
     */
    public static void fichaTecnicaFilme() {
        listarFilmes();
        System.out.println("Digite o titulo do Filme:");
        String titulo = Menu.sc.nextLine();
        if (getFilmeByTitulo(titulo) != null) {
            System.out.print(getFilmeByTitulo(titulo));
        } else {
            System.out.println("Filme não encontrado.");
        }
    }

    public static void listarGeneros() {
        System.out.println("\nGeneros disponíveis:");
        Genero[] valores = Genero.values();
        for (int i = 0; i < valores.length; i++) {
            if (valores[i] != Genero.INDEFINIDO) {
                String nome = valores[i].name().toLowerCase();
                nome = Character.toUpperCase(nome.charAt(0)) + nome.substring(1);
                System.out.print(nome);
                if (i < valores.length - 2) {
                    System.out.print(" - ");
                }
            }
        }
        System.out.println();
    }

    public static void listarClassificacaoIndicativa() {
        System.out.println("\nClassificações Indicativas disponíveis:");
        for (ClassificacaoIndicativa ci : ClassificacaoIndicativa.values()) {
            if (ci != ClassificacaoIndicativa.INDEFINIDA) {
                System.out.print(ci.getValor());
                if (ci != ClassificacaoIndicativa.values()[ClassificacaoIndicativa.values().length - 2]) {
                    System.out.print(" - ");
                }
            }
        }
        System.out.println();
    }

    public static ModelFilme getFilmeByTitulo(String titulo) {
        for (ModelFilme catalogo : Catalogo.getCatalogoFilmes()) {
            if (catalogo.getTitulo().equalsIgnoreCase(titulo)) {
                return catalogo;
            }
        }
        return null;
    }

    private static Genero escolherGenero() {
        Genero generoEscolhido;
        do {
            listarGeneros();
            System.out.print("Escolha o Genero principal do filme: ");
            try {
                String generoInput = Menu.sc.nextLine();
                generoEscolhido = Genero.valueOf(generoInput.toUpperCase());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Genero inválido! Tente novamente.");
            }
        } while (true);
        return generoEscolhido;
    }

    private static ClassificacaoIndicativa escolherClassificacaoIndicativa() {
        ClassificacaoIndicativa indicacao;
        do {
            listarClassificacaoIndicativa();
            System.out.print("Informe a Classificação Indicativa: ");
            try {
                String indicacaoInput = Menu.sc.nextLine();
                indicacao = ClassificacaoIndicativa.fromString(indicacaoInput);
                if (indicacao != ClassificacaoIndicativa.INDEFINIDA) {
                    break;
                } else {
                    System.out.println("Classificação Indicativa inválida! Tente novamente.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Classificação Indicativa inválida! Tente novamente.");
            }
        } while (true);
        return indicacao;
    }

}


