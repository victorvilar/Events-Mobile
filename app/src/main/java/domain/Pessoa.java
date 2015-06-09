package domain;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Cephas on 02/06/2015.
 */
public class Pessoa implements Serializable{

    public static String[] COLUNAS = new String[]{"ID", "NOME", "DATANASC", "TELEFONE", "EMAIL", "SENHA"};

    private int id;
    private String nome;
    private String dataNasc;
    private String telefone;
    private String email;
    private String senha;

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

    public String getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
