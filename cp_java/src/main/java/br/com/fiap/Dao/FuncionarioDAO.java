package br.com.fiap.Dao;

import br.com.fiap.Entity.Funcionario;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class FuncionarioDAO {
    private EntityManager em;
    private EntityManagerFactory emf;

    public FuncionarioDAO() {
        this.emf = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
        this.em = emf.createEntityManager();
    }

    public void salvar(Funcionario funcionario) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            em.persist(funcionario);
            transaction.commit();
            System.out.println("✅ Registro salvo com ID: " + funcionario.getId());

            // Debug adicional
            System.out.println("SQL executado: " + funcionario.gerarSQLInsert());
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            System.err.println("❌ Erro ao salvar: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public List<Funcionario> listarTodos() {
        return em.createQuery("SELECT f FROM Funcionario f", Funcionario.class)
                .getResultList();
    }

    public void fechar() {
        if (em != null && em.isOpen()) {
            em.close();
        }
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
        System.out.println("✅ Conexões fechadas com sucesso");
    }
}