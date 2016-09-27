package br.com.appviral.cursoabastece;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Calendar;

public class AbasteceActivity extends AppCompatActivity {

    Spinner mCombustivelSpinner;
    EditText mTotalEditText, mPrecoEditText, mLitrosEditText, mDataEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abastece);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle("Abastecer");
        }



        //Vincular os componentes
        mCombustivelSpinner = (Spinner) findViewById(R.id.combustivelSpinner);
        mTotalEditText = (EditText) findViewById(R.id.totalEditText);
        mPrecoEditText = (EditText) findViewById(R.id.precoEditText);
        mLitrosEditText = (EditText) findViewById(R.id.litrosEditText);
        mDataEditText = (EditText) findViewById(R.id.dataEditText);
        inicializaComponentes();

    }

    private void inicializaComponentes(){
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.combustivel, android.R.layout.simple_spinner_dropdown_item);
        mCombustivelSpinner.setAdapter(adapter);

        String simbolo = NumberFormat.getInstance().getCurrency().getSymbol();
        mTotalEditText.setHint(simbolo);
        mPrecoEditText.setHint(simbolo);

        DateFormat dateFormat = DateFormat.getDateInstance();
        mDataEditText.setText(dateFormat.format(Calendar.getInstance().getTime()));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_abastece_toolbar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.salvar)
            Toast.makeText(this, "Clicou em Salvar.", Toast.LENGTH_SHORT).show();
        return super.onOptionsItemSelected(item);
    }
}
