package br.com.fiap.model;

public class Professor extends Pessoa {
    @Override
    @SuppressWarnings("all")

    public void andar() {
        System.out.println("Professor andando");
        int x = 123;
    }
}
