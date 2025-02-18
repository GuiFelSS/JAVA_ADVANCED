package br.com.fiap;

public class Motos extends Veiculos {
    private int cilindrada;

    public Motos(String nomeVeiculo, double valor, String marca, String cor, String tipoCombustivel, String tipoMotor, int cilindrada) {
        super(nomeVeiculo, valor, marca, cor, tipoCombustivel, tipoMotor);
        this.cilindrada = cilindrada;
    }

    public int getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }

    public String getCilindradas() {
        return "Cilindradas: " + cilindrada;
    }
}
