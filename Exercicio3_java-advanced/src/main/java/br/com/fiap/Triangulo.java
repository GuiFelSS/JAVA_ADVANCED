package br.com.fiap;

public class Triangulo extends Parametros {

    public Triangulo(double base, double altura, double lado, double raio) {
        super(base, altura, lado, raio);
    }

    public void Metodo() {
        double areaTriangulo = (base * altura) / 2;
        System.out.println("Area do Triangulo: " + areaTriangulo);
    }

    public void Cor() {
        System.out.println("A cor do triangulo é Amarelo");
    }
}
