package daos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import domain.Tema;
import helpers.TemaDbHelper;

/**
 * Created by Cephas on 03/06/2015.
 */
public class TemaDao {

    private SQLiteDatabase bd;

    public TemaDao(Context contexto) {
        TemaDbHelper temaDbHelper = new TemaDbHelper(contexto);
        bd = temaDbHelper.getWritableDatabase();
    }

    public void inserirOuAtualizar(Tema c) {
        ContentValues valores = new ContentValues(2);
        valores.put("DESCRICAO", c.getDescricao());

        if(c.getId() > 0) {
            bd.update("TEMA", valores, "id = ?",
                    new String[] { "" + c.getId()});
        }
        else {
            bd.insert("TEMA", null, valores);
        }
    }

    public void remover(Tema c) {
        String[] id = {String.valueOf(c.getId())};
        bd.delete("TEMA", "ID=?", id);
    }

    public List<Tema> listar(){
        List<Tema> temas = new ArrayList<Tema>();
        Cursor c = bd.query("TEMA", Tema.COLUNAS,
                null, null, null, null, "DESCRICAO");
        if (c.moveToFirst()){
            do{
                Tema tema = new Tema();
                tema.setId(c.getInt(0));
                tema.setDescricao(c.getString(1));
                temas.add(tema);
            }
            while(c.moveToNext());
        }
        c.close();
        return temas;
    }

    public Tema buscarPorChavePrimaria(int id){
        Tema tema = new Tema();

        Cursor cursor = bd.query("TEMA", Tema.COLUNAS,
                "id="+id, null, null, null, null);

        if (cursor.moveToFirst()){
            tema.setId(cursor.getInt(0));
            tema.setDescricao(cursor.getString(1));
        }
        cursor.close();
        return tema;
    }

}



