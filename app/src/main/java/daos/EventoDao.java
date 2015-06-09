package daos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import domain.Evento;
import helpers.EventoDbHelper;

/**
 * Created by Cephas on 03/06/2015.
 */
public class EventoDao {

    private SQLiteDatabase bd;

    public EventoDao(Context contexto) {
        EventoDbHelper eventoDbHelper = new EventoDbHelper(contexto);
        bd = eventoDbHelper.getWritableDatabase();
    }

    public void inserirOuAtualizar(Evento c) {
        ContentValues valores = new ContentValues(12);
        valores.put("NOME",c.getNome());
        valores.put("DESCRICAO", c.getDescricao());
        valores.put("HORA", c.getHora());
        valores.put("DATAINICIO", c.getDataInicio());
        valores.put("DATAFIM", c.getDataFim());
        valores.put("TIPO", c.getTipo());
        valores.put("IDPESSOA", c.getPessoa().getId());
        valores.put("IDTEMA", c.getTema().getId());
        valores.put("IDLOCALIDADE", c.getLocalidade().getId());

        if(c.getId() > 0) {
            bd.update("EVENTO", valores, "id = ?",
                    new String[] { "" + c.getId()});
        }
        else {
            bd.insert("EVENTO", null, valores);
        }
    }

    public void remover(Evento c) {
        String[] id = {String.valueOf(c.getId())};
        bd.delete("EVENTO", "ID=?", id);
    }

    public List<Evento> listar(){
        List<Evento> eventos = new ArrayList<Evento>();
        Cursor c = bd.query("EVENTO", Evento.COLUNAS,
                null, null, null, null, "IDEVENTO");
        if (c.moveToFirst()){
            do{
                Evento evento = new Evento();
                evento.setId(c.getInt(0));
                evento.setNome(c.getString(1));
                evento.setDescricao(c.getString(2));
                evento.setHora(c.getString(3));
                evento.setDataInicio(c.getString(4));
                evento.setDataFim(c.getString(5));
                evento.setTipo(c.getInt(6));
                evento.getPessoa().setId(c.getInt(7));
                evento.getTema().setId(c.getInt(8));
                evento.getLocalidade().setId(c.getInt(9));

                eventos.add(evento);
            }
            while(c.moveToNext());
        }
        c.close();
        return eventos;
    }

    public Evento buscarPorChavePrimaria(int id){
        Evento evento = new Evento();

        Cursor cursor = bd.query("EVENTO", Evento.COLUNAS,
                "id="+id, null, null, null, null);

        if (cursor.moveToFirst()){
            evento.setId(cursor.getInt(0));
            evento.setNome(cursor.getString(1));
            evento.setDescricao(cursor.getString(2));
            evento.setHora(cursor.getString(3));
            evento.setDataInicio(cursor.getString(4));
            evento.setDataFim(cursor.getString(5));
            evento.setTipo(cursor.getInt(6));
            evento.getPessoa().setId(cursor.getInt(7));
            evento.getTema().setId(cursor.getInt(8));
            evento.getLocalidade().setId(cursor.getInt(9));
        }
        cursor.close();
        return evento;
    }

}

