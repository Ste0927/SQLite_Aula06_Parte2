package br.com.stefany.filadechamados;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ChamadoDBHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "chamados.db";
    private static final int DB_VERSION = 1;

    public ChamadoDBHelper (Context context){
        super (context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(HelpDeskContract.createTableFila());
        sqLiteDatabase.execSQL(HelpDeskContract.createTableChamado());
        sqLiteDatabase.execSQL(HelpDeskContract.insertFilas());
        sqLiteDatabase.execSQL(HelpDeskContract.insertChamados());
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        db.execSQL(HelpDeskContract.ChamadoContract.DROP_TABLE);
        db.execSQL(HelpDeskContract.FilaContract.DROP_TABLE);
        onCreate(db);
    }
}
