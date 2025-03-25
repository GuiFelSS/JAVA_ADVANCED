package br.com.fiap.Dao;

import br.com.fiap.Entity.TabelaFuncionario;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class FuncionarioDAO {
    private EntityManager entityManager;

    public FuncionarioDAO() {
        this.entityManager = Persistence
                .createEntityManagerFactory("CLIENTE_ORACLE")
                .createEntityManager();
    }

    public void salvar(TabelaFuncionario funcionario) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(funcionario);
            transaction.commit();
            System.out.println("[SUCESSO] Registro inserido. ID: " + funcionario.getId());
        } catch (Exception e) {
            if (transaction.isActive()) transaction.rollback();
            System.err.println("[ERRO] " + e.getMessage());
        }
    }

    public List<TabelaFuncionario> listarTodos() {
        return entityManager.createQuery("SELECT f FROM TabelaFuncionario f", TabelaFuncionario.class)
                .getResultList();
    }

    public void fechar() {
        entityManager.close();
    }
}
