package com.collioni.douglas.cadastroclientes;

import android.util.Log;
import android.widget.ArrayAdapter;

import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Predicate;

import java.util.ArrayList;

/**
 * Created by Douglas.Collioni on 27/03/2015.
 */
public class ClienteDao {
    private Db4oHelper db4o;

    public ClienteDao(Db4oHelper db4o) {
        this.db4o = db4o;
    }

    public void inserir(Cliente c) {
        db4o.db().store(c);
    }

    public void atualizar(Cliente c, long id) {
        Cliente cAntigo = buscar(id);

        cAntigo.setNome(c.getNome());
        cAntigo.setEmail(c.getEmail());
        cAntigo.setTelefone(c.getTelefone());
        cAntigo.setCidade(c.getCidade());

        db4o.db().store(cAntigo);
    }

    public void excluir(Cliente c) {
        db4o.db().delete(c);
    }

    public Cliente buscar(long id) {
        Cliente c = db4o.db().ext().getByID(id);
        db4o.db().ext().activate(c);
        return c;
    }

    public ArrayList<Cliente> listar() {

        ObjectSet<Cliente> clientes =
                db4o.db().query(Cliente.class);

        return new ArrayList<>(clientes);
    }

    public ArrayList<Cliente> pesquisar(final String filtro) {

        ObjectSet<Cliente> clientes =
                db4o.db().query(new Predicate<Cliente>() {
                    @Override
                    public boolean match(Cliente cliente) {
                        return cliente.getNome()
                                      .toLowerCase()
                                      .contains(filtro.toLowerCase());
                    }
                });

        return new ArrayList<>(clientes);
    }

    public long buscarId(Cliente c) {
        return db4o.db().ext().getID(c);
    }
}

















