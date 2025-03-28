package br.com.fiap.View;

import br.com.fiap.Dao.FuncionarioDAO;
import br.com.fiap.Entity.FunSenior;

public class Main {
    public static void main(String[] args) {

        /*INSTRUÇOES*/
        //1. COLOCAR AS CREDENCIAS DO BANCO DE DADOS NO ARQUIVO persistence.xmL
        //2.FAÇA CADA ETAPA DE UMA VEZ, SUGIRO FAZER COMANTAR A ETAPA REALIZADA ANTES DE PARTI PARA A PROXIMA

        FuncionarioDAO dao = new FuncionarioDAO();

        /*ETAPA 1*/
        //criando um funcionario CJ
        FunSenior Carl_Johnson = new FunSenior();
        Carl_Johnson.setNome("Carl Johnson");
        Carl_Johnson.setHorasTrabalhadas(160); //definindo horas trabalhadas
        Carl_Johnson.setSalarioPorHora(100); //define salario por hora
        dao.salvar(Carl_Johnson); //salvando no banco de dados
        Carl_Johnson.infoFuncionario(); //imprimindo informacoes do funcionario

        //grave o id gerado
        //sugiro comentar o código de cima para, para simular uma atualização de um funcionario ja registrado no banco de dados


        /*ETAPA 2*/
        //Atualizando salario do funcionario CJ
        /*
        FunSenior Carl_Johnson = new FunSenior();
        Carl_Johnson.setNome("Carl Johnson");
        Carl_Johnson.setId(41L); //id do funcionario não esqueça do "L" no final, pois é um long
        Carl_Johnson.setHorasTrabalhadas(160);
        Carl_Johnson.setSalarioPorHora(150); //atualizando salario por hora
        dao.atualizar(Carl_Johnson); //atualizando no banco de dados
        Carl_Johnson.infoFuncionario();
        dao.listarTodos();
         */


        /*ETAPA 3*/
        //deletando um funcionario
        /*
        FunSenior Carl_Johnson = new FunSenior();
        Carl_Johnson.setId(41L);
        dao.deletar(41L); //busca no banco e deleta funcionario do banco de dados atravez do id do mesmo
        dao.listarTodos();
         */

        /*fechando coneção*/
        //dao.fechar();
    }
}