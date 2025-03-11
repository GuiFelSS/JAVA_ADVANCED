package br.com.fiap.dao;

import br.com.fiap.entity.Cliente;
import br.com.fiap.exception.CommitException;
import br.com.fiap.exception.IdNaoEncontradoException;

import javax.persistence.EntityManager;
import javax.swing.text.html.parser.Entity;


public class ClienteDaoImpl {

    private EntityManager em;

    public ClienteDaoImpl(EntityManager em) {
        this.em = em;
    }

    public void cadastrar(Cliente cliente) {
        em.persist(cliente);
    }

    public void atulizar(Cliente cliente) throws IdNaoEncontradoException {
        buscarPorId(cliente.getId());
        em.merge();
    }

    public void remover(Cliente cliente) throws IdNaoEncontradoException {
        Cliente cliente = buscarPorId(id);
        em.remove(cliente);
    }

    public Cliente buscarPorId(int id) throws IdNaoEncontradoException {
        Cliente cliente = em.find(Cliente.class, id);
        if (cliente == null)
            throw new IdNaoEncontradoException("Cliente não encontrado!");
        return cliente;
    }

    public void commit() throws CommitException {
        try {
            em.getTransaction().begin();
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
            throw new CommitException();
        }
    }

}
