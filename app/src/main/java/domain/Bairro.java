package domain;
import java.io.Serializable;
/**
 * Created by Cephas on 03/06/2015.
 */
public class Bairro implements Serializable{

    public static String[] COLUNAS = new String[]{"ID", "NOME"};

    private int id;
    private String nome;
    private Cidade cidade;

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

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
}
