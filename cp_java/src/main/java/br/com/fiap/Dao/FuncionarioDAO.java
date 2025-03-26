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
            System.out.println("");
            System.out.println("========================================");
            System.out.println("✅ Registro salvo com ID: " + funcionario.getId());
            System.out.println("SQL executado: " + funcionario.gerarSQLInsert());

        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            System.out.println("");
            System.out.println("========================================");
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
        System.out.println("");
        System.out.println("========================================");
        System.out.println("✅ Conexões fechadas com sucesso");
    }

    public void atualizar(Funcionario funcionario) {
        if (funcionario == null) {
            throw new IllegalArgumentException("Funcionário não pode ser nulo");
        }

        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();

            if (funcionario.getId() != null && em.find(Funcionario.class, funcionario.getId()) != null) {
                System.out.println("");
                System.out.println("========================================");
                System.out.println("SQL UPDATE: " + funcionario.gerarSQLUpdate());
                System.out.println("========================================");

                Funcionario merged = em.merge(funcionario);
                transaction.commit();
                System.out.println("");
                System.out.println("========================================");
                System.out.println("✅ Registro atualizado. ID: " + merged.getId());
            } else {
                transaction.rollback();
                System.err.println("❌ ERRO: ID " + funcionario.getId() + " não encontrado ou nulo. Use salvar() para novos registros.");
            }
        } catch (Exception e) {
            if (transaction.isActive()) transaction.rollback();
            System.err.println("❌ Erro ao atualizar: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void deletar(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("❌ ID não pode ser nulo");
        }

        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            Funcionario funcionario = em.find(Funcionario.class, id);

            if (funcionario == null) {
                transaction.rollback();
                System.err.println("❌ Registro com ID " + id + " não encontrado.");
                return;
            }

            // --- Alteração principal: Gera o SQL ANTES de remover o objeto ---
            String sqlDelete = funcionario.gerarSQLDelete(); // Captura o SQL primeiro
            System.out.println("SQL DELETE: " + sqlDelete);

            em.remove(funcionario);
            transaction.commit();
            System.out.println(" Registro deletado com ID: " + id);

        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            System.err.println("❌ Erro ao deletar: " + e.getMessage());
            e.printStackTrace();
        }
    }
}