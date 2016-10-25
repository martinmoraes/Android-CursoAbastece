package br.com.appviral.cursoabastece.entidade;

import android.util.Log;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Martin on 21/10/2016.
 */

public class Abastecimento {


    public Long mId;
    public float mLitros;
    public float mPreco;
    public float mTotal;
    public String mData;
    public String mTipoCombustivel;


    public Long getmId() {
        return mId;
    }

    public void setmId(Long mId) {
        this.mId = mId;
    }

    public String getmTipoCombustivel() {
        return mTipoCombustivel;
    }

    public void setmTipoCombustivel(String mTipoCombustivel) {
        this.mTipoCombustivel = mTipoCombustivel;
    }

    public float getmLitros() {
        return mLitros;
    }

    public boolean setmLitros(String mLitros) {
        this.mLitros = deStringParaFloat(mLitros);
        if(this.mLitros == 0)
            return false;
        return true;
    }

    public void setmLitros(float mLitros) {
        this.mLitros = mLitros;
    }

    public float getmPreco() {
        return mPreco;
    }

    public void setmPreco(float mPreco) {
        this.mPreco = mPreco;
    }

    public boolean setmPreco(String mPreco) {
        this.mPreco = deStringParaFloat(mPreco);
        if(this.mPreco == 0)
            return false;
        return true;
    }

    public float getmTotal() {
        return mTotal;
    }

    public void setmTotal(float mTotal) {
        this.mTotal = mTotal;
    }

    public boolean setmTotal(String mTotal) {
        this.mTotal = deStringParaFloat(mTotal);
        if(this.mTotal == 0)
            return false;
        return true;
    }

    public String getmData() {
        return mData;
    }

    public void setmData(String mData) {
        this.mData = mData;
    }


    private float deStringParaFloat(String valor) {
        if (valor.isEmpty())
            valor = "0";

        double num;
        try {
            num = Double.parseDouble(valor);
        } catch (NumberFormatException e) {
            num = 0.00;
        }
        return (float) num ;
    }
    /*
    public String getDataParaPersistir() {
        Date data = null;
        SimpleDateFormat sdfPersiste = new SimpleDateFormat("yyyy/MM/dd");
        DateFormat dfMostra = DateFormat.getDateInstance();

        //De String para Date
        try {
            data = dfMostra.parse(mData);
        } catch (ParseException e) {
            Log.d("MEUAPP", "Em AbastecimentoDAO - dataParaPersistir(String dtOriginal) " + e.toString());
        }
        return sdfPersiste.format(data);
    }

    public void setDataDoBanco(String dtPersisitida) {
        Date data = null;
        SimpleDateFormat sdfPersiste = new SimpleDateFormat("yyyy/MM/dd");
        DateFormat sdfMostra = DateFormat.getDateInstance();

        //De String para Date
        try {
            data = sdfPersiste.parse(dtPersisitida);
        } catch (ParseException e) {
            Log.d("MEUAPP", "Em AbastecimentoDAO - dataParaMostrar(String dtPersisitida) " + e.toString());
        }

        //De Date para String
        mData = sdfMostra.format(data);
    }*/
}
