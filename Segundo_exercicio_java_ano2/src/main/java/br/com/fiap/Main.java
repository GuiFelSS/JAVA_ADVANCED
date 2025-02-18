package br.com.fiap;

public class Main {
    public static void main(String[] args) {
        Gerente gerente = new Gerente("João", 4000);
        System.out.println("Salário do gerente: " + gerente.getSalario());

        Funcionario funcionario = new Funcionario("Maria", 2000);
        System.out.println("Salário do funcionário: " + funcionario.getSalario());

        Carros fusca = new Carros ("Fusca", 10000, "Volkswagen", "Azul", "Gasolina", "1.6", 2);
        Motos xj6 = new Motos ("XJ6", 30000, "Yamaha", "Branca", "Gasolina", "600" , 600);
        Caminhoes scania = new Caminhoes ("Scania", 200000, "Scania", "Vermelho", "Gasolina", "1.5",3);

        System.out.println("Carro: " + fusca.getNomeVeiculo() + " - Valor: " + fusca.getValor() + " - Marca: " + fusca.getMarca() + " - Cor: " + fusca.getCor() + " - Combustível: " + fusca.getCombustivel() + " - Motor: " + fusca.getMotor() + " - Portas: " + fusca.getPortas());
        System.out.println("Moto: " + xj6.getNomeVeiculo() + " - Valor: " + xj6.getValor() + " - Marca: " + xj6.getMarca() + " - Cor: " + xj6.getCor() + " - Cilindradas: " + xj6.getCilindradas());
        System.out.println("Caminhão: " + scania.getNomeVeiculo() + " - Valor: " + scania.getValor() + " - Marca: " + scania.getMarca() + " - Cor: " + scania.getCor() + " -  Altura: " + scania.getAltura() + " - Comprimento: " + scania.getComprimento() + " - Largura: " + scania.getLargura());
    }
}