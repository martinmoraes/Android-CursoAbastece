package br.com.appviral.cursoabastece.entidade;

/**
 * Created by Martin on 26/10/2016.
 */

public class Abastecimento {

    private String combustivel;
    private float total;
    private float preco;
    private float litros;
    private String data;


    public String getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(String combustivel) {
        this.combustivel = combustivel;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public void setTotal(String total) {
        this.total = deStringToFloat(total);
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public void setPreco(String preco) {
        this.preco = deStringToFloat(preco);
    }

    public float getLitros() {
        return litros;
    }

    public void setLitros(float litros) {
        this.litros = litros;
    }

    public void setLitros(String litros) {
        this.litros = deStringToFloat(litros);
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }


    private float deStringToFloat(String valor){
        if(valor.isEmpty())
            valor = "0";

        double num;

        try {
            num = Double.parseDouble(valor);
        } catch (NumberFormatException e) {
            num = 0;
        }
        return (float) num;
    }
}
