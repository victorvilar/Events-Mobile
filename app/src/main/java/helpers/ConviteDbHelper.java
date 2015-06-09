package helpers;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Cephas on 03/06/2015.
 */
public class ConviteDbHelper extends SQLiteOpenHelper{

    public static final String NOME_BANCO = "Eventos";
    public static final int VERSAO_BANCO = 1;
    public static final String CONVITE_TABLE = "CREATE TABLE CONVITE ( " +
            "ID INTEGER NOT NULL PRIMARY KEY autoincrement, " +
            "DESCRICAO TEXT, " +
            "DATAENVIO TEXT, " +
            "IDEVENTO INTEGER);";

    public ConviteDbHelper(Context context) {
        super(context, NOME_BANCO, null, VERSAO_BANCO);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CONVITE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS CONVITE");
        onCreate(sqLiteDatabase);
    }




}
