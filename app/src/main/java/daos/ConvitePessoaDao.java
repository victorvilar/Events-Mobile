package daos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import domain.ConvitePessoa;
import helpers.ConvitePessoaDbHelper;

/**
 * Created by Cephas on 03/06/2015.
 */

public class ConvitePessoaDao {

    private SQLiteDatabase bd;

    public ConvitePessoaDao(Context contexto) {
        ConvitePessoaDbHelper convitePessoaDbHelper = new ConvitePessoaDbHelper(contexto);
        bd = convitePessoaDbHelper.getWritableDatabase();
    }

    public void inserirOuAtualizar(ConvitePessoa c) {
        ContentValues valores=new ContentValues(6);
        valores.put("STATUS", c.getStatus());
        valores.put("JUSIFICATIVA", c.getJustificativa());
        valores.put("DATARECEBIMENTO", c.getDataRecebimento());
        valores.put("IDCONVITE", c.getConvite().getId());
        valores.put("IDPESSOA", c.getConvidado().getId());

        if(c.getId() > 0) {
            bd.update("CONVITEPESSOA", valores, "id = ?",
                    new String[] { "" + c.getId()});
        }
        else {
            bd.insert("CONVITEPESSOA", null, valores);
        }
    }

    public void remover(ConvitePessoa c) {
        String[] id = {String.valueOf(c.getId())};
        bd.delete("CONVITEPESSOA", "ID=?", id);
    }

    public List<ConvitePessoa> listar(){
        List<ConvitePessoa> convitePessoas = new ArrayList<ConvitePessoa>();
        Cursor c = bd.query("CONVITEPESSOA", ConvitePessoa.COLUNAS,
                null, null, null, null, "NOME");
        if (c.moveToFirst()){
            do{
                ConvitePessoa convitePessoa = new ConvitePessoa();
                convitePessoa.setId(c.getInt(0));
                convitePessoa.setStatus(c.getString(1));
                convitePessoa.setJustificativa(c.getString(2));
                convitePessoa.setDataRecebimento(c.getString(3));
                convitePessoa.getConvite().setId(c.getInt(4));
                convitePessoa.getConvidado().setId(c.getInt(5));

                convitePessoas.add(convitePessoa);
            }
            while(c.moveToNext());
        }
        c.close();
        return convitePessoas;
    }

    public ConvitePessoa buscarPorChavePrimaria(int id){
        ConvitePessoa convitePessoa = new ConvitePessoa();

        Cursor cursor = bd.query("CONVITEPESSOA", ConvitePessoa.COLUNAS,
                "id="+id, null, null, null, null);

        if (cursor.moveToFirst()){
            convitePessoa.setId(cursor.getInt(0));
            convitePessoa.setStatus(cursor.getString(1));
            convitePessoa.setJustificativa(cursor.getString(2));
            convitePessoa.setDataRecebimento(cursor.getString(3));
            convitePessoa.getConvite().setId(cursor.getInt(4));
            convitePessoa.getConvidado().setId(cursor.getInt(5));
        }
        cursor.close();
        return convitePessoa;
    }

}


