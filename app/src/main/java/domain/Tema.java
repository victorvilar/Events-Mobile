package domain;
import java.io.Serializable;

/**
 * Created by Cephas on 03/06/2015.
 */
public class Tema implements Serializable{

    public static String[] COLUNAS = new String[]{"ID", "DESCRICAO"};

    private int id;
    private String descricao;

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
}
