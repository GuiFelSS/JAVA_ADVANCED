package br.com.fiap;

public class Quadrado extends Parametros {
    public Quadrado(double base, double altura, double lado, double raio) {
        super(base, altura, lado, raio);
    }

    public void Metodo() {
        double areaQuadrado = lado * lado;
        System.out.println("Area do Quadrado: " + areaQuadrado);
    }

    public void Cor() {
        System.out.println("A cor do quadrado é Azul");
    }
}
