package br.com.fiap;


public class Main {
    public static void main(String[] args) {
        Pessoa pessoa = new Pessoa("Guilherme", 21);

        System.out.println("Nome: " + pessoa.getNome());
        System.out.println("Idade: " + pessoa.getIdade());

        pessoa.andar();

        pessoa.setIdade(22);

        System.out.println("Nome: " + pessoa.getNome());
        System.out.println("Idade: " + pessoa.getIdade());

    }
}