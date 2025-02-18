package br.com.fiap;

public class Caminhoes extends Veiculos{

    private double capacidadeCarga;
    private double altura;
    private double largura;
    private double comprimento;

    public Caminhoes(String nomeVeiculo, double valor, String marca, String cor, String tipoCombustivel, String tipoMotor, double altura) {
        super(nomeVeiculo, valor, marca, cor, tipoCombustivel, tipoMotor);
        this.altura = altura;
        this.largura = largura;
        this.comprimento = comprimento;
    }

    public double getCapacidadeCarga() {
        return capacidadeCarga;
    }
    public void setCapacidadeCarga(double capacidadeCarga) {
        this.capacidadeCarga = capacidadeCarga;
    }
    public double getAltura() {
        return altura;
    }
    public void setAltura(double altura) {
        this.altura = altura;
    }
    public double getLargura() {
        return largura;
    }
    public void setLargura(double largura) {
        this.largura = largura;
    }
    public double getComprimento() {
        return comprimento;
    }
    public void setComprimento(double comprimento) {
        this.comprimento = comprimento;
    }
}
