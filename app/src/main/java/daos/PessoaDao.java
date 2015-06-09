package daos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import domain.Pessoa;
import helpers.PessoaDbHelper;

/**
 * Created by Cephas on 03/06/2015.
 */
public class PessoaDao {

    private SQLiteDatabase bd;

    public PessoaDao(Context contexto) {
        PessoaDbHelper pessoaDbHelper = new PessoaDbHelper(contexto);
        bd = pessoaDbHelper.getWritableDatabase();
    }

    public void inserirOuAtualizar(Pessoa c) {
        ContentValues valores=new ContentValues(6);
        valores.put("NOME", c.getNome());
        valores.put("DATANASC", c.getDataNasc());
        valores.put("TELEFONE", c.getTelefone());
        valores.put("EMAIL", c.getEmail());
        valores.put("SENHA", c.getSenha());

        if(c.getId() > 0) {
            bd.update("PESSOA", valores, "id = ?",
                    new String[] { "" + c.getId()});
        }
        else {
            bd.insert("PESSOA", null, valores);
        }
    }

    public void remover(Pessoa c) {
        String[] id = {String.valueOf(c.getId())};
        bd.delete("PESSOA", "ID=?", id);
    }

    public List<Pessoa> listar(){
        List<Pessoa> pessoas = new ArrayList<Pessoa>();
        Cursor c = bd.query("PESSOA", Pessoa.COLUNAS,
                null, null, null, null, "NOME");
        if (c.moveToFirst()){
            do{
                Pessoa pessoa = new Pessoa();

                pessoa.setId(c.getInt(0));
                pessoa.setNome(c.getString(1));
                pessoa.setDataNasc(c.getString(2));
                pessoa.setTelefone(c.getString(3));
                pessoa.setEmail(c.getString(4));
                pessoa.setSenha(c.getString(5));

                pessoas.add(pessoa);
            }
            while(c.moveToNext());
        }
        c.close();
        return pessoas;
    }

    public Pessoa buscarPorChavePrimaria(int id){
        Pessoa pessoa = new Pessoa();

        Cursor cursor = bd.query("PESSOA", Pessoa.COLUNAS,
                "id="+id, null, null, null, null);

        if (cursor.moveToFirst()){
            pessoa.setId(cursor.getInt(0));
            pessoa.setNome(cursor.getString(1));
            pessoa.setDataNasc(cursor.getString(2));
            pessoa.setTelefone(cursor.getString(3));
            pessoa.setEmail(cursor.getString(4));
            pessoa.setSenha(cursor.getString(5));
        }
        cursor.close();
        return pessoa;
    }

}


