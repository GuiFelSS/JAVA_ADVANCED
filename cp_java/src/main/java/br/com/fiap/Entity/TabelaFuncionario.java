package br.com.fiap.Entity;

import br.com.fiap.anotation.Tabela;
import br.com.fiap.anotation.Coluna;

import javax.persistence.*;
import java.lang.reflect.Field;

@Entity
@Tabela(nome = "TAB_FUNCIONARIO")
@SequenceGenerator(name = "func_seq", sequenceName = "TAB_FUNCIONARIO_SEQ", allocationSize = 1)
public class TabelaFuncionario {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "func_seq")
    @Coluna(nome = "ID")
    private Long id;

    @Coluna(nome = "NOME")
    private String nome;

    @Coluna(nome = "HORAS_TRABALHADAS")
    private int horasTrabalhadas;

    @Coluna(nome = "VALOR_POR_HORA")
    private double valorPorHora;

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