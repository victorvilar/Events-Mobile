package daos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import domain.Pais;
import helpers.PaisDbHelper;

/**
 * Created by Cephas on 03/06/2015.
 */
public class PaisDao {

    private SQLiteDatabase bd;

    public PaisDao(Context contexto) {
        PaisDbHelper paisDbHelper = new PaisDbHelper(contexto);
        bd = paisDbHelper.getWritableDatabase();
    }

    public void inserirOuAtualizar(Pais c) {
        ContentValues valores=new ContentValues(2);
        valores.put("NOME", c.getNome());
        if(c.getId() > 0) {
            bd.update("PAIS", valores, "id = ?",
                    new String[] { "" + c.getId()});
        }
        else {
            bd.insert("PAIS", null, valores);
        }
    }

    public void remover(Pais c) {
        String[] id = {String.valueOf(c.getId())};
        bd.delete("PAIS", "ID=?", id);
    }

    public List<Pais> listar(){
        List<Pais> paiss = new ArrayList<Pais>();
        Cursor c = bd.query("PAIS", Pais.COLUNAS,
                null, null, null, null, "NOME");
        if (c.moveToFirst()){
            do{
                Pais pais = new Pais();
                pais.setId(c.getInt(0));
                pais.setNome(c.getString(1));
                paiss.add(pais);
            }
            while(c.moveToNext());
        }
        c.close();
        return paiss;
    }

    public Pais buscarPorChavePrimaria(int id){
        Pais pais = new Pais();

        Cursor cursor = bd.query("PAIS", Pais.COLUNAS,
                "id="+id, null, null, null, null);

        if (cursor.moveToFirst()){
            pais.setId(cursor.getInt(0));
            pais.setNome(cursor.getString(1));
        }
        cursor.close();
        return pais;
    }

}