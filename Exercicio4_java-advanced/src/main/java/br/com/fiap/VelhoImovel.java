package br.com.fiap;

public class VelhoImovel extends Imovel {

    private double desconto;

    public VelhoImovel(double desconto) {
        this.desconto = desconto;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    public double desconto() {
        desconto = (preco() * 0.9);
        return desconto;
    }

    public double precoFinalDesconto() {
        return preco() - desconto();
    }

    public void endereco() {
        System.out.println("Rua carvalho de Araujo, 70");
    }

    public double preco() {
        return 300000;
    }


}
