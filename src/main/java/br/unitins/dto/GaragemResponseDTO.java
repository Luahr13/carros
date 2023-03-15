package br.unitins.dto;

import br.unitins.model.Garagem;

public class GaragemResponseDTO {
    private Long id;
    private String nome;
    private String endereco;

    public GaragemResponseDTO(Garagem garagem) {
        this.id = garagem.getId();
        this.nome = garagem.getNome();
        this.endereco = garagem.getEndereco();
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

}
