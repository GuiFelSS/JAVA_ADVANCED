package br.com.fiap.Entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("ESTAGIARIO")
public class FunEstagiario extends Funcionario{
    private static final double SalarioFixo = 1500.0;

    public FunEstagiario() {
    }

    public FunEstagiario(String nome, int horasTrabalhadas, double salarioPorHora) {
        super(nome, horasTrabalhadas, salarioPorHora);
    }

    @Override
    public double calculoSalarioMes() {
        return SalarioFixo;
    }

    @Override
    public void infoFuncionario() {
        super.infoFuncionario(); // Chama o método da classe pai para mostrar informações básicas
        System.out.println("Cargo: Estagiário");
        System.out.println("Salário total: " + calculoSalarioMes());
    }
}
