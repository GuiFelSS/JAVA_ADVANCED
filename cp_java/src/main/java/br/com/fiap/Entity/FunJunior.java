package br.com.fiap.Entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("JUNIOR")
public class FunJunior extends Funcionario{

    private static final double bonusJunior = 0.05; // 5% de bônus

    public FunJunior() {
    }

    public FunJunior(String nome, int horasTrabalhadas, double salarioPorHora) {
        super(nome, horasTrabalhadas, salarioPorHora);
    }

    @Override
    public double calculoSalarioMes() {
        double salarioBase = super.calculoSalarioMes(); // Calcula o salário base (horas * salarioPorHora)
        int ciclosBonus = (getHorasTrabalhadas() / 15); // Calcula quantos ciclos de 15 horas foram completados
        double totalBonus = ciclosBonus * bonusJunior; // Calcula o total de bônus
        return salarioBase + totalBonus; // Retorna o salário base + bônus
    }

    @Override
    public void infoFuncionario() {
        super.infoFuncionario(); // Chama o método da classe pai para mostrar informações básicas
        System.out.println("Cargo: Junior");
        System.out.println("Bônus por 15 horas trabalhadas: " + bonusJunior);
        System.out.println("Salário total com bônus: " + calculoSalarioMes());
    }
}
