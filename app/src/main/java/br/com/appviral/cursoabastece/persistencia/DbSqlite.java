package br.com.appviral.cursoabastece.persistencia;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import br.com.appviral.cursoabastece.entidade.Abastecimento;


/**
 * Created by Martin on 13/10/2016.
 */

public class DbSqlite extends SQLiteOpenHelper {
    private static final String NOME_BASE = "abastece.db";
    private static final int VERSAO_BASE = 1;

    public DbSqlite(Context context){
        super(context,NOME_BASE, null, VERSAO_BASE);
        context.deleteDatabase(NOME_BASE);
    }


    public void inserir(Abastecimento abastecimento){
        ContentValues valores = new ContentValues();
        valores.put("combustivel", abastecimento.getmTipoCombustivel());
        valores.put("total", abastecimento.getmTotal());
        valores.put("preco", abastecimento.getmPreco());
        valores.put("litros", abastecimento.getmLitros());
        valores.put("data", abastecimento.getmData());

        SQLiteDatabase db = getWritableDatabase();
        db.insert("abastecimentos", null, valores);
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

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {    }


}
