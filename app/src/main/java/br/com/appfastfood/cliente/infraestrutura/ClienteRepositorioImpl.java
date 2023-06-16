package br.com.appfastfood.cliente.infraestrutura;

import br.com.appfastfood.cliente.dominio.modelos.Cliente;
import br.com.appfastfood.cliente.dominio.repositorios.ClienteRepositorio;
import br.com.appfastfood.cliente.infraestrutura.entidades.EntidadeCliente;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class ClienteRepositorioImpl implements ClienteRepositorio {

    private final SpringDataClienteRepository clienteRepository;

    public ClienteRepositorioImpl(SpringDataClienteRepository clienteRepository){
        this.clienteRepository = clienteRepository;
    }
    @Override
    public Optional<EntidadeCliente> buscarPorCpf(String cpf) {
        return clienteRepository.findById(UUID.randomUUID());
    }

    @Override
    public UUID cadastrar(Cliente cliente) {
        EntidadeCliente clienteDb = new EntidadeCliente(cliente.getNome(), cliente.getCpf(), cliente.getEmail());
        clienteRepository.save(clienteDb);
        return clienteDb.getId();
    }
}
