package helpers;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Cephas on 03/06/2015.
 */
public class EstadoDbHelper extends SQLiteOpenHelper{


    public static final String NOME_BANCO = "Eventos";
    public static final int VERSAO_BANCO = 1;
    public static final String ESTADO_TABLE = "CREATE TABLE ESTADO ( " +
            "ID INTEGER NOT NULL PRIMARY KEY autoincrement, " +
            "NOME TEXT, " +
            "IDPAIS INTEGER);";

    public EstadoDbHelper(Context context) {
        super(context, NOME_BANCO, null, VERSAO_BANCO);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(ESTADO_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS ESTADO");
        onCreate(sqLiteDatabase);
    }

}
