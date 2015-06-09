package daos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import domain.Localidade;
import helpers.LocalidadeDbHelper;

/**
 * Created by Cephas on 03/06/2015.
 */
public class LocalidadeDao {

    private SQLiteDatabase bd;

    public LocalidadeDao(Context contexto) {
        LocalidadeDbHelper localidadeDbHelper = new LocalidadeDbHelper(contexto);
        bd = localidadeDbHelper.getWritableDatabase();
    }

    public void inserirOuAtualizar(Localidade c) {
        ContentValues valores=new ContentValues(2);
        int idLocal = 0;
        valores.put("TIPO", c.getTipo());

        switch (c.getTipo()){
            case 0: idLocal = c.getBairro().getId();
            case 1: idLocal = c.getCidade().getId();
            case 2: idLocal = c.getEstado().getId();
            case 3: idLocal = c.getPais().getId();
        }
        valores.put("IDLOCAL", idLocal);

        if(c.getId() > 0) {
            bd.update("LOCALIDADE", valores, "id = ?",
                    new String[] { "" + c.getId()});
        }
        else {
            bd.insert("LOCALIDADE", null, valores);
        }
    }

    public void remover(Localidade c) {
        String[] id = {String.valueOf(c.getId())};
        bd.delete("LOCALIDADE", "ID=?", id);
    }

    public List<Localidade> listar(){
        List<Localidade> localidades = new ArrayList<Localidade>();
        Cursor c = bd.query("LOCALIDADE", Localidade.COLUNAS,
                null, null, null, null, "TIPO");
        if (c.moveToFirst()){
            do{
                Localidade localidade = new Localidade();

                localidade.setId(c.getInt(0));
                localidade.setTipo( c.getInt(1) );
                localidade.setIdLocal(c.getInt(2));

                localidades.add(localidade);
            }
            while(c.moveToNext());
        }
        c.close();
        return localidades;
    }

    public Localidade buscarPorChavePrimaria(int id){
        Localidade localidade = new Localidade();

        Cursor cursor = bd.query("LOCALIDADE", Localidade.COLUNAS,
                "id="+id, null, null, null, null);

        if (cursor.moveToFirst()){
            localidade.setId(cursor.getInt(0));
            localidade.setTipo(cursor.getInt(1));
            localidade.setIdLocal(cursor.getInt(2));
        }
        cursor.close();
        return localidade;
    }

}
