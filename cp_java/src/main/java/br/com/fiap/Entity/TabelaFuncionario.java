package br.com.fiap.Entity;

import br.com.fiap.anotation.Tabela;
import br.com.fiap.anotation.Coluna;

import javax.persistence.*;
import java.lang.reflect.Field;

@Entity
@Tabela(nome = "TAB_FUNCIONARIO")
public class TabelaFuncionario {
    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Coluna(nome = "ID")
    private Long id;

    @Coluna(nome = "NOME")
    private String nome;

    @Coluna(nome = "HORAS_TRABALHADAS")
    private int horasTrabalhadas;

    @Coluna(nome = "VALOR_POR_HORA")
    private double valorPorHora;

    public TabelaFuncionario() {
    }

    public TabelaFuncionario(String nome, int horasTrabalhadas, double valorPorHora) {
        this.nome = nome;
        this.horasTrabalhadas = horasTrabalhadas;
        this.valorPorHora = valorPorHora;
    }

    public String gerarSQLSelect() {
        StringBuilder sql = new StringBuilder("SELECT ");
        for (Field field : this.getClass().getDeclaredFields()) {
            Coluna coluna = field.getAnnotation(Coluna.class);
            if (coluna != null) {
                sql.append(coluna.nome()).append(", ");
            }
        }
        sql.delete(sql.length() - 2, sql.length()); // Remove a última vírgula
        sql.append(" FROM ").append(this.getClass().getAnnotation(Tabela.class).nome());
        return sql.toString();
    }

    // Getters e Setters
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

    public double getValorPorHora() {
        return valorPorHora;
    }

    public void setValorPorHora(double valorPorHora) {
        this.valorPorHora = valorPorHora;
    }
}
