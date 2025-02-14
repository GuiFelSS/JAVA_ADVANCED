package br.com.fiap;


public class Main {
    public static void main(String[] args) {
        Produto bola = new Produto ("Bola", "Nike", 100.0, 0.3);
        Produto camiseta = new Produto ("Camiseta", "Adidas", 150.0, 0.2);
        Produto tenis = new Produto ("Tenis", "Puma", 200.0, 0.5);

        bola.setPreco(110.0);
        System.out.println("Nome: " + bola.getNome() + " Preço: " + bola.getPreco());

        camiseta.setPreco(160.0);
        System.out.println("Nome: " + camiseta.getNome() + " Preço: " + camiseta.getPreco());

        tenis.setPreco(210.0);
        System.out.println("Nome: " + tenis.getNome() + " Preço: " + tenis.getPreco());
    }
}