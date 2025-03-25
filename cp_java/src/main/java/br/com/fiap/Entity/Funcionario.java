package br.com.fiap.Entity;

import br.com.fiap.anotation.Coluna;
import br.com.fiap.anotation.Tabela;

import javax.persistence.*;
import java.lang.reflect.Field;

@Entity
@Table(name = "JV_TB_FUNCIONARIO")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TIPO_FUNCIONARIO", discriminatorType = DiscriminatorType.STRING)
@SequenceGenerator(name = "funcionario", sequenceName = "SQ_JV_TB_FUNCIONARIO", allocationSize = 1)
public class Funcionario {

    @Id
    @Column(name = "ID_FUNCIONARIO")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "funcionario")
    private Long id;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String gerarSQLInsert() {
        StringBuilder sql = new StringBuilder("INSERT INTO ");
        StringBuilder colunas = new StringBuilder();
        StringBuilder valores = new StringBuilder();

        sql.append(this.getClass().getAnnotation(Tabela.class).nome()).append(" (");

        for (Field field : this.getClass().getDeclaredFields()) {
            Coluna coluna = field.getAnnotation(Coluna.class);
            if (coluna != null && !coluna.nome().equals("ID")) { // ID é auto-incremento
                colunas.append(coluna.nome()).append(", ");
                try {
                    field.setAccessible(true);
                    Object value = field.get(this);
                    valores.append(value instanceof String ? "'" + value + "'" : value).append(", ");
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

        colunas.delete(colunas.length() - 2, colunas.length());
        valores.delete(valores.length() - 2, valores.length());

        sql.append(colunas).append(") VALUES (").append(valores).append(")");
        return sql.toString();
    }

    public String gerarSQLUpdate() {
        StringBuilder sql = new StringBuilder("UPDATE ");
        sql.append(this.getClass().getAnnotation(Tabela.class).nome()).append(" SET ");

        for (Field field : this.getClass().getDeclaredFields()) {
            Coluna coluna = field.getAnnotation(Coluna.class);
            if (coluna != null && !coluna.nome().equals("ID")) {
                try {
                    field.setAccessible(true);
                    Object value = field.get(this);
                    sql.append(coluna.nome()).append(" = ")
                            .append(value instanceof String ? "'" + value + "'" : value)
                            .append(", ");
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

        sql.delete(sql.length() - 2, sql.length());
        sql.append(" WHERE ID = ").append(this.id);
        return sql.toString();
    }

    public String gerarSQLDelete() {
        return "DELETE FROM " + this.getClass().getAnnotation(Tabela.class).nome() +
                " WHERE ID = " + this.id;
    }
}