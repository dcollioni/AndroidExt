package com.collioni.douglas.cadastroclientes;

import android.util.Log;

import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

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
    }

    public void atualizar(Cliente c, long id) {
    }

    public void excluir(Cliente c) {
    }

    public Cliente buscar(long id) {
        return null;
    }

    public ArrayList<Cliente> listar() {
        return null;
    }

    public long buscarId(Cliente c) {
        return 0;
    }
}
