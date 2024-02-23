package br.com.adatech.projetos.catalogoIMDB.model;

import br.com.adatech.projetos.catalogoIMDB.util.Util;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * Classe abstrata que representa uma Pessoa
 * Contém construtores, parâmetros, e métodos que serão herdados
 */
public abstract class ModelPessoa {

    protected String nome;
    protected String cpf;
    protected LocalDate dataDeNascimento;
    protected ArrayList<ModelFilme> participacoes = new ArrayList<>();
    protected final HashMap<ModelFilme, Enum<?>> area = new HashMap<>();

    public ModelPessoa() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(String dataNascimento) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.dataDeNascimento = LocalDate.parse(dataNascimento, formatter);
    }
    public String formatoCPF() {
        StringBuilder sb = new StringBuilder(cpf);

        sb.insert(3, '.');
        sb.insert(7, '.');
        sb.insert(11, '-');

        return sb.toString();
    }
    public int compareTo(ModelPessoa pessoa) {
        return this.getNome().compareTo(pessoa.getNome());
    }
    public abstract void novaParticipacao(Enum<?> variavel, ModelFilme filme);
    public abstract void removeParticipacao(Enum<?> papel, ModelFilme filme);

    public String toString() {
        StringBuilder filmesStr = new StringBuilder();

        if (participacoes.isEmpty()) {
            filmesStr.append(centerString("N/A", 50));
        } else {
            // Ordenando a lista de filmes baseada no título
            List<Map.Entry<ModelFilme, Enum<?>>> sortedEntries = Util.getSortedCopy(area.entrySet(),
                    Map.Entry.comparingByKey(Comparator.comparing(ModelFilme::getTitulo)));

            for (Map.Entry<ModelFilme, Enum<?>> entry : sortedEntries) {
                String line = "Filme: " + entry.getKey().getTitulo() + " / Papel: " + entry.getValue();
                filmesStr.append(centerString(line, 50));
            }
        }

        // Construindo o restante da string
        String topBottomBorder = "*".repeat(50);
        String middleBar = "-".repeat(50);
        String title = centerString("INFORMAÇÕES DO ROTERISTA", 50);

        return topBottomBorder + "\n" +
                title +
                topBottomBorder + "\n" +
                formatLine("DADOS PESSOAIS", "*") +
                middleBar + "\n" +
                formatLine("- Nome -", nome) +
                formatLine("- CPF -", formatoCPF()) +
                formatLine("- Data de Nascimento -", Util.dataFormatada(dataDeNascimento)) +
                middleBar + "\n" +
                formatLine("PARTICIPAÇÕES", "*") +
                middleBar + "\n" +
                filmesStr +
                topBottomBorder + "\n";
    }

    private String centerString(String text, int width) {
        if (text == null || text.trim().isEmpty()) {
            text = "N/A";
        }
        else if(text.equals("*")){
            return "";
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
}
