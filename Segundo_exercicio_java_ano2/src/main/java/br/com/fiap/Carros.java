package br.com.fiap;

public class Carros extends Veiculos{
    private int quantidadePortas;


    public Carros(String nomeVeiculo, double valor, String marca, String cor, String tipoCombustivel, String tipoMotor, int quantidadePortas) {
        super(nomeVeiculo, valor, marca, cor, tipoCombustivel, tipoMotor);
        this.quantidadePortas = quantidadePortas;
    }

    public int getQuantidadePortas() {
        return quantidadePortas;
    }

    public void setQuantidadePortas(int quantidadePortas) {
        this.quantidadePortas = quantidadePortas;
    }

    public String getPortas() {
        return "Quantidade de portas: " + quantidadePortas;
    }
}
