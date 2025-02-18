package br.com.fiap;

public class Funcionario {
    protected String nome;
    protected double salario;

    public Funcionario(String nome, double salario) {
        this.nome = nome;
        this.salario = salario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public void printNome() {
        System.out.println("nome = " + this.nome);
    }

    public void printSalario() {
        System.out.println("salario = " + this.salario);
    }


    public void comissão() {
        System.out.println("Comissão: " + this.salario * 0.1);
    }

}
