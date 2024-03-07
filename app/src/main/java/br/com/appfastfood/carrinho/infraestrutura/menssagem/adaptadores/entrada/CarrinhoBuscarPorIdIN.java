package br.com.appfastfood.carrinho.infraestrutura.menssagem.adaptadores.entrada;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder()
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CarrinhoBuscarPorIdIN {

    private Long id;
}