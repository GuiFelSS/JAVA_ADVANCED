package br.com.fiap;

public class Parametros {
    double base;
    double altura;
    double lado;
    double raio;

    public Parametros(double base, double altura, double lado, double raio) {
        this.base = base;
        this.altura = altura;
        this.lado = lado;
        this.raio = raio;
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getLado() {
        return lado;
    }

    public void setLado(double lado) {
        this.lado = lado;
    }

    public double getRaio() {
        return raio;
    }

    public void setRaio(double raio) {
        this.raio = raio;
    }

}
