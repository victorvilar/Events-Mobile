package daos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import domain.Cidade;
import helpers.CidadeDbHelper;

/**
 * Created by Cephas on 03/06/2015.
 */
public class CidadeDao {

    private SQLiteDatabase bd;

    public CidadeDao(Context contexto) {
        CidadeDbHelper cidadeDbHelper = new CidadeDbHelper(contexto);
        bd = cidadeDbHelper.getWritableDatabase();
    }

    public void inserirOuAtualizar(Cidade c) {
        ContentValues valores=new ContentValues(2);
        valores.put("NOME", c.getNome());
        valores.put("IDESTADO", c.getEstado().getId());
        if(c.getId() > 0) {
            bd.update("CIDADE", valores, "id = ?",
                    new String[] { "" + c.getId()});
        }
        else {
            bd.insert("CIDADE", null, valores);
        }
    }

    public void remover(Cidade c) {
        String[] id = {String.valueOf(c.getId())};
        bd.delete("CIDADE", "ID=?", id);
    }

    public List<Cidade> listar(){
        List<Cidade> cidades = new ArrayList<Cidade>();
        Cursor c = bd.query("CIDADE", Cidade.COLUNAS,
                null, null, null, null, "NOME");
        if (c.moveToFirst()){
            do{
                Cidade cidade = new Cidade();
                cidade.setId(c.getInt(0));
                cidade.setNome(c.getString(1));
                cidade.getEstado().setId(c.getInt(2));
                cidades.add(cidade);
            }
            while(c.moveToNext());
        }
        c.close();
        return cidades;
    }

    public Cidade buscarPorChavePrimaria(int id){
        Cidade cidade = new Cidade();

        Cursor cursor = bd.query("CIDADE", Cidade.COLUNAS,
                "id="+id, null, null, null, null);

        if (cursor.moveToFirst()){
            cidade.setId(cursor.getInt(0));
            cidade.setNome(cursor.getString(1));
            cidade.getEstado().setId(cursor.getInt(2));
        }
        cursor.close();
        return cidade;
    }

}