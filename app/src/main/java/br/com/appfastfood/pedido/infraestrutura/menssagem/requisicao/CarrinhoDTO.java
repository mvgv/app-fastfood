package br.com.appfastfood.pedido.infraestrutura.menssagem.requisicao;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CarrinhoDTO {
    @JsonProperty("id")
    private String id;

    public CarrinhoDTO(String id) {
        this.id = id;
    }

    public CarrinhoDTO() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
