package domain;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Cephas on 02/06/2015.
 */
public class Convite implements Serializable{

    public static String[] COLUNAS = new String[]{"ID", "DESCRICAO", "DATAENVIO"};

    private int id;
    private String descricao;
    private String dataEnvio;

    private Evento evento;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDataEnvio() {
        return dataEnvio;
    }

    public void setDataEnvio(String dataEnvio) {
        this.dataEnvio = dataEnvio;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

}
