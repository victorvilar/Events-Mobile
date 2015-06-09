package domain;
import java.io.Serializable;
import java.io.Serializable;

/**
 * Created by Cephas on 02/06/2015.
 */
public class Localidade implements Serializable{

    public static String[] COLUNAS = new String[]{"ID", "TIPO", "IDLOCAL"};
    private int id;

    private int tipo;
    private int idLocal;

    private Pais pais;
    private Estado estado;
    private Cidade cidade;
    private Bairro bairro;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public int getIdLocal() {
        return idLocal;
    }

    public void setIdLocal(int idLocal) {
        this.idLocal = idLocal;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public Bairro getBairro() {
        return bairro;
    }

    public void setBairro(Bairro bairro) {
        this.bairro = bairro;
    }
}

