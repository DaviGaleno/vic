package repository;

import java.util.ArrayList;
import java.util.List;
import model.Cliente;

public class ClienteRepositorio {

    private List<Cliente> clientes = new ArrayList<>();

    public void salvar(Cliente c) {
        clientes.add(c);
    }

    public List<Cliente> listar() {
        return clientes;
    }
}


