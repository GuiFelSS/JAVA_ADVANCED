package br.com.fiap;

public class NovoImovel extends Imovel {

    private double precoAdicional;

    public NovoImovel(double precoAdicional) {
        this.precoAdicional = precoAdicional;
    }

    public double getPrecoAdicional() {
        return precoAdicional;
    }

    public void setPrecoAdicional(double precoAdicional) {
        this.precoAdicional = precoAdicional;
    }

    public double precoAdicional() {
        precoAdicional = (preco() * 1.1);
        return precoAdicional;
    }

    public double precoFinalAdicional() {
        return preco() + precoAdicional();
    }

    public void endereco() {
        System.out.println("Rua carvalho de Araujo, 90");
    }

    public double preco() {
        return 400000;
    }

}
