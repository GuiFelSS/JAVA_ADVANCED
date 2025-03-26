package br.com.fiap.Entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("PLENO")
public class FunPleno extends Funcionario {

    private static final double bonusPleno = 0.10;

    public FunPleno() {
    }

    public FunPleno(String nome, int horasTrabalhadas, double salarioPorHora) {
        super(nome, horasTrabalhadas, salarioPorHora);
    }

    @Override
    public double calculoSalarioMes() {
        double salarioBase = super.calculoSalarioMes(); // Calcula o salário base (horas * salarioPorHora)
        int ciclosBonus = (getHorasTrabalhadas() / 15); // Calcula quantos ciclos de 15 horas foram completados
        double totalBonus = ciclosBonus * bonusPleno; // Calcula o total de bônus
        return salarioBase + totalBonus; // Retorna o salário base + bônus
    }

    @Override
    public void infoFuncionario() {
        super.infoFuncionario(); // Chama o método da classe pai para mostrar informações básicas
        System.out.println("Cargo: Pleno");
        System.out.println("Bônus por 15 horas trabalhadas: " + bonusPleno);
        System.out.println("Ciclos de 15 horas completados: " + (getHorasTrabalhadas() / 15));
        System.out.println("Salário total com bônus: " + calculoSalarioMes());
    }
}
