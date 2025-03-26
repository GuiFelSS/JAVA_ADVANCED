package br.com.fiap.Entity;

import javax.persistence.*;

@Entity
@DiscriminatorValue("SENIOR")
public class FunSenior extends Funcionario {

    private static final double bonusSenior = 100.0;

    public FunSenior() {
    }

    public FunSenior(String nome, int horasTrabalhadas, double salarioPorHora) {
        super(nome, horasTrabalhadas, salarioPorHora);
    }

    @Override
    public double calculoSalarioMes() {
        double salarioBase = super.calculoSalarioMes();
        int ciclosBonus = (getHorasTrabalhadas() / 15);
        double totalBonus = ciclosBonus * bonusSenior;
        return salarioBase + totalBonus;
    }

    // Subscrever o método infoFuncionario para mostrar informações específicas do FunSenior
    @Override
    public void infoFuncionario() {
        super.infoFuncionario(); // Chama o método da classe pai para mostrar informações básicas
        System.out.println("Cargo: Sênior");
        System.out.println("Bônus por 15 horas trabalhadas: " + bonusSenior);
        System.out.println("Ciclos de 15 horas completados: " + (getHorasTrabalhadas() / 15));
        System.out.println("Salário total com bônus: " + calculoSalarioMes());
    }

}

