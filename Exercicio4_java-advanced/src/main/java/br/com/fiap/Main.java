package br.com.fiap;

public class Main {
    public static void main(String[] args) {

        NovoImovel novoImovel = new NovoImovel(4000);
        VelhoImovel velhoImovel = new VelhoImovel(4000);

        novoImovel.endereco();
        System.out.println("Preço: " + novoImovel.preco());
        System.out.println("Preço Adicional: " + novoImovel.precoAdicional());
        System.out.println("Preço Final com Adicional: " + novoImovel.precoFinalAdicional());

        System.out.println("-------------------------");

        velhoImovel.endereco();
        System.out.println("Preço: " + velhoImovel.preco());
        System.out.println("Desconto: " + velhoImovel.desconto());
        System.out.println("Preço Final com Desconto: " + velhoImovel.precoFinalDesconto());

    }
}