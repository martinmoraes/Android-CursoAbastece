package br.com.appviral.cursoabastece.persistencia;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


/**
 * Created by Martin on 13/10/2016.
 */

public class DbSqlite extends SQLiteOpenHelper {
    private static final String NOME_BASE = "abastece.db";
    private static final int VERSAO_BASE = 1;

    public DbSqlite(Context context){
        super(context,NOME_BASE, null, VERSAO_BASE);
        Log.d("MEUAPP", "Fez constructor DbSqlite");
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        Log.d("MEUAPP", "Fez constructor DbSqlite - onCreate");
        String cria_tabela_abastecimentos = "CREATE TABLE abastecimentos("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT ,"
                + "qtde_litros REAL, "
                + "valor_litro REAL, "
                + "valor_total REAL, "
                + "data TEXT, "
                + "combustivel TEXT)";
        sqLiteDatabase.execSQL(cria_tabela_abastecimentos);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {    }


    public boolean inserir() {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("qtde_litros", 80);
        values.put("valor_litro", 3.84);
        values.put("valor_total", 120);
        values.put("data", "14/10/2016");
        values.put("combustivel", "Gasolina");
        Long id = db.insert("abastecimentos", null, values);
        db.close();
        return id > 0;
    }
}
