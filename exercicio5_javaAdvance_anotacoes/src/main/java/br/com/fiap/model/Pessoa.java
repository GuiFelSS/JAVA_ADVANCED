package br.com.fiap.model;

import br.com.fiap.anotation.Coluna;
import br.com.fiap.anotation.Tabela;

@Tabela (nome = "TB_PESSOA")
public class Pessoa {
    @Coluna(nome = "NM_PESSOA", tamanho = 100, obrigatorio = true)
    public String nome;

    @Coluna(nome = "NR_IDADE", obrigatorio = true)
    public int idade;

    @Coluna(nome = "vl_altura", obrigatorio = true)
    public double altura;

    public  void andar() {
        System.out.println("Pessoa andando");
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }
}
