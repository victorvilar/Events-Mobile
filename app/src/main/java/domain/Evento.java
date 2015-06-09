package domain;

import java.util.Date;
import java.io.Serializable;

/**
 * Created by Cephas on 02/06/2015.
 */
public class Evento implements Serializable{

public static String[] COLUNAS = new String[]{"ID", "NOME", "DESCRICAO","HORA", "DATAINICIO",  "DATAFIM", "TIPO"};

    private int id;
    private String nome;
    private String descricao;
    private String hora;
    private String dataInicio;
    private String dataFim;
    private int tipo;

    private Pessoa pessoa;
    private Tema tema;
    private Localidade localidade;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataFim() {
        return dataFim;
    }

    public void setDataFim(String dataFim) {
        this.dataFim = dataFim;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public Pessoa getPessoa() { return pessoa;}

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Tema getTema() {
        return tema;
    }

    public void setTema(Tema tema) {
        this.tema = tema;
    }

    public Localidade getLocalidade() {
        return localidade;
    }

    public void setLocalidade(Localidade localidade) {
        this.localidade = localidade;
    }
}
