package br.unitins.dto;

import java.util.HashMap;
import java.util.Map;

import br.unitins.model.Carro;

public class CarroResponseDTO {
    
    private Long id;
    private String modelo;
    private Map<String, Object> garagem;

    public CarroResponseDTO(Carro carro) {
        this.id = carro.getId();
        this.modelo = carro.getModelo();
        this.garagem = new HashMap<String, Object>();
        this.garagem.put("nome", carro.getGaragem().getNome());
        this.garagem.put("sigla", carro.getGaragem().getEndereco());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Map<String, Object> getGaragem() {
        return garagem;
    }

    public void setGaragem(Map<String, Object> garagem) {
        this.garagem = garagem;
    }
 
}
