package br.com.fiap.Dao;

import br.com.fiap.Entity.TabelaFuncionario; // Importação correta
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;

public class FuncionarioDAO {
    private EntityManager entityManager;

    public FuncionarioDAO() {
        this.entityManager = Persistence
                .createEntityManagerFactory("persistence-unit-name")
                .createEntityManager();
    }

    public void salvar(TabelaFuncionario funcionario) {
        entityManager.getTransaction().begin();
        entityManager.persist(funcionario); // Agora o persist deve funcionar
        entityManager.getTransaction().commit();
    }

    public List<TabelaFuncionario> listarTodos() {
        return entityManager.createQuery("SELECT f FROM TabelaFuncionario f", TabelaFuncionario.class)
                .getResultList();
    }

    public void fechar() {
        entityManager.close();
    }
}
