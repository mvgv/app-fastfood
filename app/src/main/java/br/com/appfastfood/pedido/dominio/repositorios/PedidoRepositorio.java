package br.com.appfastfood.pedido.dominio.repositorios;
import java.util.List;
import java.util.Optional;
import br.com.appfastfood.pedido.dominio.modelos.Pedido;

public interface PedidoRepositorio {
    void criar(Pedido pedido);
    void atualizar(Long id, Pedido pedido);
    Optional<List<Pedido>> listarTodosOsPedidos();
} 
