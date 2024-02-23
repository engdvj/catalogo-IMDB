package br.com.adatech.projetos.catalogoIMDB.model;

import br.com.adatech.projetos.catalogoIMDB.util.Util;
import br.com.adatech.projetos.catalogoIMDB.util.Util.*;

import java.text.NumberFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;

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
    private double orcamento;
    private double avaliacao;
    private ModelDiretor diretor;
    private final ArrayList<ModelAtor> artistas = new ArrayList<>();
    private final ArrayList<ModelRoteirista> roteiristas = new ArrayList<>();

    public ModelFilme(String titulo, String descricao, Genero genero
            , ClassificacaoIndicativa classificacaoIndicativa
            , String dataDeLancamento, String duracao
            , double orcamento, double avaliacao) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.genero = genero;
        this.classificacaoIndicativa = classificacaoIndicativa;
        setDataDeLancamento(String.valueOf(dataDeLancamento));
        setDuracao(String.valueOf(duracao));
        this.orcamento = orcamento;
        this.avaliacao = avaliacao;
    }

    public String getTitulo() {
        return titulo;
    }

    public ModelDiretor getDiretor() {
        return diretor;
    }

    public ArrayList<ModelAtor> getArtistas() {
        return artistas;
    }

    public ArrayList<ModelRoteirista> getRoteiristas() {
        return roteiristas;
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
        this.duracao = Duration.parse(duracao);
    }

    public void setOrcamento(double orcamento) {
        this.orcamento = orcamento;
    }

    public void setAvaliacao(double avaliacao) {
        this.avaliacao = avaliacao;
    }

    public void addPessoa(ModelPessoa pessoa, Enum<?> papel, ModelFilme filme){
        if(pessoa instanceof ModelAtor) {
            this.artistas.add((ModelAtor) pessoa);
            pessoa.novaParticipacao(papel, filme);
        }
        else if(pessoa instanceof ModelDiretor){
            this.diretor = (ModelDiretor) pessoa;
            diretor.novaParticipacao(papel,filme);
        }else{
            this.roteiristas.add((ModelRoteirista) pessoa);
            pessoa.novaParticipacao(papel,filme);
        }
    }
    public void removePessoa(ModelPessoa pessoa, Enum<?> papel, ModelFilme filme) {
        if(pessoa instanceof ModelAtor) {
            this.artistas.remove((ModelAtor) pessoa);
            pessoa.removeParticipacao(papel, filme);
        }
        else if(pessoa instanceof ModelDiretor){
            diretor.removeParticipacao(papel,filme);
            this.diretor = null;
        }else{
            this.roteiristas.remove((ModelRoteirista) pessoa);
            pessoa.removeParticipacao(papel,filme);
        }
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
                formatLine("- Data de Lançamento -", Util.dataFormatada(dataDeLancamento)) +
                formatLine("- Duração -", formatDuracao()) +
                formatLine("- Orçamento -", formatarOrcamento()) +
                formatLine("- Avaliação -", avaliacao+"/10") +
                formatLine("- Diretor -", getDadosDiretor()) +
                formatLine("- Artistas -", getDadosArtistas()) +
                formatLine("- Roteiristas -", getDadosRoteiristas()) +
                topBottomBorder + "\n";

    }


    private String centerString(String text, int width) {
        if (text == null) {
            return "N/A";
        } else {
            int paddingSize = (width - text.length()) / 2;
            String padding = " ".repeat(Math.max(0, paddingSize));
            return padding + text + padding + (text.length() % 2 == 1 ? " " : "") + "\n";
        }
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
    private String getDadosDiretor() {
        if (diretor == null) {
            return "N/A";
        } else {
            StringBuilder nomes = new StringBuilder();
            String infoDiretor = "Nome: " + diretor.getNome() + " / Area: " + diretor.getAreaDiretor(titulo);
            nomes.append(centerString(infoDiretor, 50));
            if (!nomes.isEmpty() && nomes.charAt(nomes.length() - 1) == '\n') {
                nomes.deleteCharAt(nomes.length() - 1);
            }
            return nomes.toString();
        }
    }
    private String getDadosArtistas() {
        if (artistas.isEmpty()) {
            return "N/A";
        }else {
            StringBuilder nomes = new StringBuilder();
            for (ModelAtor ator : artistas) {
                String infoArtista = "Nome: " + ator.getNome() + " / Papel: " + ator.getPapelAtor(titulo);
                nomes.append(centerString(infoArtista, 50));
            }
            if (!nomes.isEmpty() && nomes.charAt(nomes.length() - 1) == '\n') {
                nomes.deleteCharAt(nomes.length() - 1);
            }
            return nomes.toString();
        }
    }
    private String getDadosRoteiristas() {
        if (roteiristas.isEmpty()) {
            return "N/A";
        } else {
            StringBuilder nomes = new StringBuilder();
            for (ModelRoteirista roteirista : roteiristas) {
                String infoRoteirista = "Nome: " + roteirista.getNome() + " / Area: " + roteirista.getAreaRoteirista(titulo);
                nomes.append(centerString(infoRoteirista, 50));
            }
            if (!nomes.isEmpty() && nomes.charAt(nomes.length() - 1) == '\n') {
                nomes.deleteCharAt(nomes.length() - 1);
            }
            return nomes.toString();
        }
    }
    private String formatarOrcamento() {
        NumberFormat formatter = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        return formatter.format(orcamento);
    }
}
