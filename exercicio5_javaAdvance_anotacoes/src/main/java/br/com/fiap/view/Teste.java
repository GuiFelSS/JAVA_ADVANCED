package br.com.fiap.view;

import br.com.fiap.anotation.Coluna;
import br.com.fiap.model.Pessoa;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Teste {
    public static void main(String[] args) {

        Pessoa pessoa = new Pessoa();

        String nomeClasse = pessoa.getClass().getName();
        System.out.println();
        System.out.println(nomeClasse);
        System.out.println();

        Method[] metodos = pessoa.getClass().getDeclaredMethods();

        for (Method m : metodos) {
            System.out.println(m.getName());
        }

        Field[] atributos = pessoa.getClass().getDeclaredFields();
        System.out.println();

        for (Field f : atributos) {
            System.out.println(f.getName() + " " + f.getType());

            Coluna anotacao = f.getAnnotation(Coluna.class);
            System.out.println(anotacao.nome() + " " + anotacao.tamanho() + " " + anotacao.obrigatorio());
        }


    }
}
