package br.com.appfastfood.pedido.usecase.adaptadores.producers;

import br.com.appfastfood.pedido.aplicacao.adaptadores.requisicao.PedidoRequisicao;
import br.com.appfastfood.pedido.dominio.modelos.Pedido;
import br.com.appfastfood.pedido.usecase.portas.PedidoServico;

import java.util.List;

public class PedidoServicoImpl implements PedidoServico {


    @Override
    public String criar(PedidoRequisicao pedido, String status, String tempo) {

        return "a";
    }

    @Override
    public Pedido atualizar(Long id) {
        return null;
    }

    @Override
    public Pedido buscarPedidoPorId(Long id) {
        return null;
    }

    @Override
    public List<Pedido> listarTodosPedidos() {
        return null;
    }


}
