package br.com.fiap;

public class Circulo extends Parametros {
    public Circulo(double base, double altura, double lado, double raio) {
        super(base, altura, lado, raio);
    }

    public void Metodo() {
        double areaCirculo = 3.1416 * (raio * raio);
        System.out.println("Area do Circulo: " + areaCirculo);
    }

    public void Cor() {
        System.out.println("Cor do circulo é Vermelho");
    }

}
