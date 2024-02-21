package br.com.adatech.projetos.catalogoIMDB.model;

import br.com.adatech.projetos.catalogoIMDB.util.Util.*;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 * Classe que representa um Filme
 * Contém construtores, parâmetros, além de getters e setters
 */
public class ModelFilme {

    //Dei uma olhada no site do IMDb e esses são os principais parametros de filme que aparecem
    // no primeiro bloco. Teria os streaming tbm, mas achei sem necessidade.
    private String titulo;
    private String descricao;
    private Genero genero;
    private ClassificacaoIndicativa classificacaoIndicativa;
    private LocalDate dataDeLancamento;
    private Duration duracao;
    private ModelDiretor diretor;
    private ArrayList<ModelAtor> artistas = new ArrayList<>();
    private ArrayList<ModelRoteirista> roteiristas = new ArrayList<>();
    private double orcamento;
    private double avaliacao;

    public ModelFilme(String titulo, Genero genero, ClassificacaoIndicativa ci) {
        this.titulo = titulo;
        this.genero = genero;
        this.classificacaoIndicativa = ci;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public void setClassificacaoIndicativa(ClassificacaoIndicativa classificacaoIndicativa) {
        this.classificacaoIndicativa = classificacaoIndicativa;
    }

    public void setDataDeLancamento(String dataDeLancamento) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.dataDeLancamento = LocalDate.parse(dataDeLancamento, formatter);
    }

    public void setDuracao(String duracao) {
        Duration fromString = Duration.parse(duracao);
        this.duracao = fromString;
    }

    public void setOrcamento(double orcamento) {
        this.orcamento = orcamento;
    }

    public void setAvaliacao(double avaliacao) {
        this.avaliacao = avaliacao;
    }

    public void addPessoa(ModelAtor ator, PapelAtor papelAtor, ModelFilme filme){
        this.artistas.add(ator);
        ator.novoPapel(papelAtor,filme);
    }
    public void addPessoa(ModelDiretor diretor,ModelFilme filme){
        this.diretor = diretor;
        diretor.novoFilme(filme);
    }
    public void addPessoa(ModelRoteirista roterista, AreaRoteirista area, ModelFilme filme){
        this.roteiristas.add(roterista);
        roterista.novoRoteiro(area,filme);
    }
    @Override
    public String toString() {
        String topBottomBorder = "*".repeat(50);
        String title = centerString("DADOS DO FILME", 50);

        return topBottomBorder + "\n" +
                title +
                topBottomBorder + "\n" +
                formatLine("- Título -", titulo) +
                formatLine("- Descrição -", descricao) +
                formatLine("- Gênero -", genero != null ? genero.toString() : "N/A") +
                formatLine("- Classificação Indicativa -", classificacaoIndicativa != null ? classificacaoIndicativa.getValor() : "N/A") +
                formatLine("- Data de Lançamento -", String.valueOf(dataDeLancamento)) +
                formatLine("- Duração -", formatDuracao()) +
                formatLine("- Orçamento -", String.valueOf(orcamento)) +
                formatLine("- Avaliação -", String.valueOf(avaliacao)+"/10") +
                formatLine("- Diretor -", String.valueOf(diretor.getNome())) +
                formatLine("- Artistas -", getDadosArtistas()) +
                formatLine("- Roteiristas -", getDadosRoteiristas()) +
                topBottomBorder + "\n";

    }

    private String centerString(String text, int width) {
        if (text == null) {
            text = "N/A";
        }
        int paddingSize = (width - text.length()) / 2;
        String padding = " ".repeat(Math.max(0, paddingSize));
        return padding + text + padding + (text.length() % 2 == 1 ? " " : "") + "\n";
    }

    private String formatLine(String label, String content) {
        String centeredLabel = centerString(label, 50);
        String centeredContent = centerString(content != null ? content : "N/A", 50);
        return centeredLabel + centeredContent;
    }

    public String formatDuracao() {
        if (duracao == null) {
            return "00h:00m";
        }
        long horas = duracao.toHours();
        int minutos = duracao.toMinutesPart();
        return String.format("%02dh:%02dm", horas, minutos);
    }
    private String getDadosArtistas() {
        StringBuilder nomes = new StringBuilder();
        for (ModelAtor ator : artistas) {
            if (nomes.length() > 0) {
                nomes.append(", ");
            }
            nomes.append(ator.getNome()).append(" - Papel: ");
            nomes.append(ator.getPapelAtor(titulo));
        }
        return nomes.toString();
    }

    private String getDadosRoteiristas() {
        StringBuilder nomes = new StringBuilder();
        for (ModelRoteirista roteirista : roteiristas) {
            if (nomes.length() > 0) {
                nomes.append(", ");
            }
            nomes.append(roteirista.getNome()).append(" - Area: ");
            nomes.append(roteirista.getAreaRoteirista(titulo));
        }
        return nomes.toString();
    }
}
