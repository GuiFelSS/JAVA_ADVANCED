package br.com.fiap;


public class Main {
    public static void main(String[] args) {
        Pessoa guilherme = new Pessoa("Guilherme", 21);

        System.out.println("Nome: " + guilherme.getNome());
        System.out.println("Idade: " + guilherme.getIdade());

        guilherme.andar();

        guilherme.setIdade(22);

        System.out.println("Nome: " + guilherme.getNome());
        System.out.println("Idade: " + guilherme.getIdade());

    }
}