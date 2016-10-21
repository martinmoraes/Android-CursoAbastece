package br.com.appviral.cursoabastece.persistencia;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Martin on 14/10/2016.
 */

public class DbSqlite extends SQLiteOpenHelper {
    private static final String NOME_BASE = "abastece.db";
    private static final int VERSAO_BASE = 1;


    public DbSqlite (Context context){
        super(context, NOME_BASE, null, VERSAO_BASE);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String cria_tabela_abastecimentos = "CREATE TABLE abastecimentos (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "combustivel TEXT," +
                "total REAL," +
                "preco REAL," +
                "litros REAL," +
                "data TEXT)";
        sqLiteDatabase.execSQL(cria_tabela_abastecimentos);
    }

    public void insere(){
        ContentValues valores = new ContentValues();
        valores.put("combustivel", "Gasolina");
        valores.put("total", 400.00);
        valores.put("preco", 4.00);
        valores.put("litros", 100.00);
        valores.put("data", "14/10/2016");

        SQLiteDatabase db = getWritableDatabase();
        db.insert("abastecimentos", null, valores);

    }




    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
