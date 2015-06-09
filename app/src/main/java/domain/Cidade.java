package domain;
import java.io.Serializable;
/**
 * Created by Cephas on 03/06/2015.
 */
public class Cidade implements Serializable {

    public static String[] COLUNAS = new String[]{"ID", "NOME"};

    private int id;
    private String nome;
    private Estado estado;

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

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
}

