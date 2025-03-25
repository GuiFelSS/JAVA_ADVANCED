package br.com.fiap.Dao;

import br.com.fiap.Entity.Funcionario;
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

    public void salvar(Funcionario funcionario) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(funcionario);
            transaction.commit();
            System.out.println("Salvo com sucesso! ID: " + funcionario.getId());
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            System.err.println("Erro ao salvar: " + e.getMessage());
            e.printStackTrace(); // Adicione esta linha para ver o stack trace completo
        }
    }

    public List<Funcionario> listarTodos() {
        return entityManager.createQuery("SELECT f FROM TabelaFuncionario f", Funcionario.class)
                .getResultList();
    }

    public void fechar() {
        entityManager.close();
    }
}
