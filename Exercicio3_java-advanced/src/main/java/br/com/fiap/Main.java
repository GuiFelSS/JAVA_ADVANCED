package br.com.fiap;

public class Main {
    public static void main(String[] args) {

        Parametros parametros = new Parametros(10, 20, 30, 40);

        Retangulo retangulo = new Retangulo(parametros.getBase(), parametros.getAltura(), parametros.getLado(), parametros.getRaio());
        Quadrado quadrado = new Quadrado(parametros.getBase(), parametros.getAltura(), parametros.getLado(), parametros.getRaio());
        Triangulo triangulo = new Triangulo(parametros.getBase(), parametros.getAltura(), parametros.getLado(), parametros.getRaio());
        Circulo circulo = new Circulo(parametros.getBase(), parametros.getAltura(), parametros.getLado(), parametros.getRaio());

        retangulo.Metodo();
        retangulo.Cor();
        System.out.println(" ");
        quadrado.Metodo();
        quadrado.Cor();
        System.out.println(" ");
        triangulo.Metodo();
        triangulo.Cor();
        System.out.println(" ");
        circulo.Metodo();
        circulo.Cor();

    }
}