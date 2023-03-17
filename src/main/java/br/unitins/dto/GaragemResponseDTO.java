package br.unitins.dto;

import java.util.HashMap;
import java.util.Map;

import br.unitins.model.Garagem;

public class GaragemResponseDTO {
    private Long id;
    private String nome;
    private String endereco;
    private Map<String, Object> garagem;

    public GaragemResponseDTO(Garagem garagem) {
        this.id = garagem.getId();
        this.nome = garagem.getNome();
        this.endereco = garagem.getEndereco();
        this.garagem = new HashMap<String, Object>();
        this.garagem.put(nome, garagem.getNome());
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getEndereco() {
        return endereco;
    }
    
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Map<String, Object> getGaragem() {
        return garagem;
    }

    public void setGaragem(Map<String, Object> garagem) {
        this.garagem = garagem;
    }

    
}
