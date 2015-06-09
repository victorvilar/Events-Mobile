package daos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import domain.Estado;
import helpers.EstadoDbHelper;

/**
 * Created by Cephas on 03/06/2015.
 */

public class EstadoDao {

    private SQLiteDatabase bd;

    public EstadoDao(Context contexto) {
        EstadoDbHelper estadoDbHelper = new EstadoDbHelper(contexto);
        bd = estadoDbHelper.getWritableDatabase();
    }

    public void inserirOuAtualizar(Estado c) {
        ContentValues valores=new ContentValues(2);
        valores.put("NOME", c.getNome());
        valores.put("IDPAIS", c.getPais().getId());
        if(c.getId() > 0) {
            bd.update("ESTADO", valores, "id = ?",
                    new String[] { "" + c.getId()});
        }
        else {
            bd.insert("ESTADO", null, valores);
        }
    }

    public void remover(Estado c) {
        String[] id = {String.valueOf(c.getId())};
        bd.delete("ESTADO", "ID=?", id);
    }

    public List<Estado> listar(){
        List<Estado> estados = new ArrayList<Estado>();
        Cursor c = bd.query("ESTADO", Estado.COLUNAS,
                null, null, null, null, "NOME");
        if (c.moveToFirst()){
            do{
                Estado estado = new Estado();
                estado.setId(c.getInt(0));
                estado.setNome(c.getString(1));
                estado.getPais().setId(c.getInt(2));
                estados.add(estado);
            }
            while(c.moveToNext());
        }
        c.close();
        return estados;
    }

    public Estado buscarPorChavePrimaria(int id){
        Estado estado = new Estado();

        Cursor cursor = bd.query("ESTADO", Estado.COLUNAS,
                "id="+id, null, null, null, null);

        if (cursor.moveToFirst()){
            estado.setId(cursor.getInt(0));
            estado.setNome(cursor.getString(1));
            estado.getPais().setId(cursor.getInt(2));
        }
        cursor.close();
        return estado;
    }

}