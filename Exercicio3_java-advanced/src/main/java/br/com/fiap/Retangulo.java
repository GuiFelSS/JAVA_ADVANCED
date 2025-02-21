package br.com.fiap;

public class Retangulo extends Parametros{

    public Retangulo(double base, double altura, double lado, double raio) {
        super(base, altura, lado, raio);
    }

    public void Metodo() {
        double areaRetangulo = base * altura;
        System.out.println("Area do Retangulo: " + areaRetangulo);
    }

    public void Cor() {
        System.out.println("A cor do retangulo é Verde");
    }
}
