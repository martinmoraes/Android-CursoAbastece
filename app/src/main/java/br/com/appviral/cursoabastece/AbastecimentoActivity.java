package br.com.appviral.cursoabastece;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Calendar;

import br.com.appviral.cursoabastece.persistencia.DbSqlite;

public class AbastecimentoActivity extends AppCompatActivity {
    Spinner mTipoCombustivelSpinner;
    EditText mValorTotalEditText, mValorPrecoEditText, mLitrosEditText, mDataEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abastecimento);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle("Abastecer");
        }


        // Instanciando componentes
        mTipoCombustivelSpinner = (Spinner) findViewById(R.id.tipoCombustivelSpinner);
        mValorTotalEditText = (EditText) findViewById(R.id.valorTotalEditText);
        mValorPrecoEditText = (EditText) findViewById(R.id.valorPrecoEditText);
        mLitrosEditText = (EditText) findViewById(R.id.litrosEditText);
        mDataEditText = (EditText) findViewById(R.id.dataEditText);
        inicializaComponentes();



        Log.d("MEUAPP", "Vai chamar DbSqlite");
        DbSqlite dbSqlite = new DbSqlite(this);
        dbSqlite.inserir();
        Log.d("MEUAPP", "Chamou DbSqlite");

    }

    private void inicializaComponentes() {

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.combustivel, android.R.layout.simple_spinner_dropdown_item);
        mTipoCombustivelSpinner.setAdapter(adapter);

        String simbolo = NumberFormat.getInstance().getCurrency().getSymbol();
        mValorTotalEditText.setHint(simbolo);
        mValorPrecoEditText.setHint(simbolo);

        DateFormat dateFormat = DateFormat.getDateInstance();
        mDataEditText.setText(dateFormat.format(Calendar.getInstance().getTime()));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_abastecimento_toolbar, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.salvar)
            Toast.makeText(this, "Acionado o Salvar.", Toast.LENGTH_SHORT).show();
        return super.onOptionsItemSelected(item);
    }
}
