package br.com.fiap;

public class Veiculos {
    private String nomeVeiculo;
    private double valor;
    private String marca;
    private String cor;
    private String tipoCombustivel;
    private String tipoMotor;

    public Veiculos(String nomeVeiculo, double valor, String marca, String cor, String tipoCombustivel, String tipoMotor) {
        this.nomeVeiculo = nomeVeiculo;
        this.valor = valor;
        this.marca = marca;
        this.cor = cor;
        this.tipoCombustivel = tipoCombustivel;
        this.tipoMotor = tipoMotor;
    }

    public String getNomeVeiculo() {
        return("Nome do veículo: " + nomeVeiculo);
    }

    public String getValor() {
        return("Valor do veículo: " + valor);
    }

    public String getMarca() {
        return("Marca do veículo: " + marca);
    }

    public String getCor() {
        return("Cor do veículo: " + cor);
    }

    public String getMotor() {
        return("Motor: " + tipoMotor);
    }

    public String getCombustivel() {
        return "Tipo de combustível: " + tipoCombustivel;
    }
}
