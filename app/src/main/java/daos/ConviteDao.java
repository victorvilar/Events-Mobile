package daos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import domain.Convite;
import helpers.ConviteDbHelper;

/**
 * Created by Cephas on 03/06/2015.
 */
public class ConviteDao {

    private SQLiteDatabase bd;

    public ConviteDao(Context contexto) {
        ConviteDbHelper conviteDbHelper = new ConviteDbHelper(contexto);
        bd = conviteDbHelper.getWritableDatabase();
    }

    public void inserirOuAtualizar(Convite c) {
        ContentValues valores = new ContentValues(3);
        valores.put("DESCRICAO", c.getDescricao());
        valores.put("DATAENVIO", c.getDataEnvio());
        valores.put("IDEVENTO", c.getEvento().getId());
        if(c.getId() > 0) {
            bd.update("CONVITE", valores, "id = ?",
                    new String[] { "" + c.getId()});
        }
        else {
            bd.insert("CONVITE", null, valores);
        }
    }

    public void remover(Convite c) {
        String[] id = {String.valueOf(c.getId())};
        bd.delete("CONVITE", "ID=?", id);
    }

    public List<Convite> listar(){
        List<Convite> convites = new ArrayList<Convite>();
        Cursor c = bd.query("CONVITE", Convite.COLUNAS,
                null, null, null, null, "IDEVENTO");
        if (c.moveToFirst()){
            do{
                Convite convite = new Convite();
                convite.setId(c.getInt(0));
                convite.setDescricao(c.getString(1));
                convite.setDataEnvio(c.getString(2));
                convite.getEvento().setId(c.getInt(3));
                convites.add(convite);
            }
            while(c.moveToNext());
        }
        c.close();
        return convites;
    }

    public Convite buscarPorChavePrimaria(int id){
        Convite convite = new Convite();

        Cursor cursor = bd.query("CONVITE", Convite.COLUNAS,
                "id="+id, null, null, null, null);

        if (cursor.moveToFirst()){
            convite.setId(cursor.getInt(0));
            convite.setDescricao(cursor.getString(1));
            convite.setDataEnvio(cursor.getString(2));
            convite.getEvento().setId(cursor.getInt(3));
        }
        cursor.close();
        return convite;
    }

}



