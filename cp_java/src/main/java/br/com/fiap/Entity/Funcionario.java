package br.com.fiap.Entity;

import javax.persistence.*;

@Entity
@Table(name = "JV_TB_FUNCIONARIO")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TIPO_FUNCIONARIO", discriminatorType = DiscriminatorType.STRING)
@SequenceGenerator(name = "funcionario", sequenceName = "SQ_JV_TB_FUNCIONARIO", allocationSize = 1)
public class Funcionario {

    @Id
    @Column(name = "ID_FUNCIONARIO")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "funcionario")
    private Integer id;

    @Column(name = "NOME_FUNCIONARIO", nullable = false, length = 100)
    private String nome;

    @Column(name = "HORAS_TRABALHADAS")
    private int horasTrabalhadas;

    @Column(name = "SALARIO_HORA")
    private double salarioPorHora;

    public Funcionario() {
    }

    public Funcionario(String nome, int horasTrabalhadas, double salarioPorHora) {
        this.nome = nome;
        this.horasTrabalhadas = horasTrabalhadas;
        this.salarioPorHora = salarioPorHora;
    }

    public double calculoSalarioMes() {
        return horasTrabalhadas * salarioPorHora;
    }

    public void infoFuncionario() {
        System.out.println("Nome do funcionario: " + nome);
        System.out.println("Salario do funcionario por horas: " + salarioPorHora);
        System.out.println("Horas trabalhadas: " + getHorasTrabalhadas()+"h");
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getHorasTrabalhadas() {
        return horasTrabalhadas;
    }

    public void setHorasTrabalhadas(int horasTrabalhadas) {
        this.horasTrabalhadas = horasTrabalhadas;
    }

    public double getSalarioPorHora() {
        return salarioPorHora;
    }

    public void setSalarioPorHora(double salarioPorHora) {
        this.salarioPorHora = salarioPorHora;
    }
}