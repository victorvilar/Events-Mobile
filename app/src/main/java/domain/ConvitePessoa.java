package domain;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Cephas on 03/06/2015.
 */
public class ConvitePessoa implements Serializable{

    public static String[] COLUNAS = new String[]{"ID", "STATUS", "JUSTIFICATIVA", "DATARECEBIMENTO"};

    private int id;

    // sim / nao / talvez
    private String status;
    private String justificativa;
    private String dataRecebimento;

    private Convite convite;
    private Pessoa convidado;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getJustificativa() {
        return justificativa;
    }

    public void setJustificativa(String justificativa) {
        this.justificativa = justificativa;
    }

    public String getDataRecebimento() {
        return dataRecebimento;
    }

    public void setDataRecebimento(String dataRecebimento) {
        this.dataRecebimento = dataRecebimento;
    }

    public Convite getConvite() {
        return convite;
    }

    public void setConvite(Convite convite) {
        this.convite = convite;
    }

    public Pessoa getConvidado() {
        return convidado;
    }

    public void setConvidado(Pessoa convidado) {
        this.convidado = convidado;
    }
}
