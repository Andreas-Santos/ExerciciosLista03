package Exercicio02;

//autor: Andreas Matheus Santos - RA: 235006

public class Automovel {
    private String marca;
    private String modelo;

    public Automovel() {

    }

    public Automovel(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String imprimir() {
        return "\nMarca: " + marca +
               "\nModelo: " + modelo;
    }
}
