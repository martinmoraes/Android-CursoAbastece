package br.com.appviral.cursoabastece.persistencia;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import br.com.appviral.cursoabastece.entidade.Abastecimento;

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

    public void insere(Abastecimento abastecimento){
        ContentValues valores = new ContentValues();
        valores.put("combustivel", abastecimento.getCombustivel());
        valores.put("total", abastecimento.getTotal());
        valores.put("preco", abastecimento.getPreco());
        valores.put("litros", abastecimento.getLitros());
        valores.put("data", abastecimento.getData());

        SQLiteDatabase db = getWritableDatabase();
        db.insert("abastecimentos", null, valores);

    }




    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
