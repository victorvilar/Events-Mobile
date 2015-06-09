package daos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import domain.Bairro;
import helpers.BairroDbHelper;

/**
 * Created by Cephas on 03/06/2015.
 */
public class BairroDao {

    private SQLiteDatabase bd;

    public BairroDao(Context contexto) {
        BairroDbHelper bairroDbHelper = new BairroDbHelper(contexto);
        bd = bairroDbHelper.getWritableDatabase();
    }

    public void inserirOuAtualizar(Bairro c) {
        ContentValues valores=new ContentValues(2);
        valores.put("NOME", c.getNome());
        valores.put("IDCIDADE", c.getCidade().getId());
        if(c.getId() > 0) {
            bd.update("BAIRRO", valores, "id = ?",
                    new String[] { "" + c.getId()});
        }
        else {
            bd.insert("BAIRRO", null, valores);
        }
    }

    public void remover(Bairro c) {
        String[] id = {String.valueOf(c.getId())};
        bd.delete("BAIRRO", "ID=?", id);
    }

    public List<Bairro> listar(){
        List<Bairro> bairros = new ArrayList<Bairro>();
        Cursor c = bd.query("BAIRRO", Bairro.COLUNAS,
                null, null, null, null, "NOME");
        if (c.moveToFirst()){
            do{
                Bairro bairro = new Bairro();
                bairro.setId(c.getInt(0));
                bairro.setNome(c.getString(1));
                bairro.getCidade().setId(c.getInt(2));
                bairros.add(bairro);
            }
            while(c.moveToNext());
        }
        c.close();
        return bairros;
    }

    public Bairro buscarPorChavePrimaria(int id){
        Bairro bairro = new Bairro();

        Cursor cursor = bd.query("BAIRRO", Bairro.COLUNAS,
                "id="+id, null, null, null, null);

        if (cursor.moveToFirst()){
            bairro.setId(cursor.getInt(0));
            bairro.setNome(cursor.getString(1));
            bairro.getCidade().setId(cursor.getInt(2));
        }
        cursor.close();
        return bairro;
    }

}


