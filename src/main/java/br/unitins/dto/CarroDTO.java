package br.unitins.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class CarroDTO {
    
    @NotNull(message = "O campo não pode ser nulo.")
    private String modelo;
    
    @NotBlank(message = "O campo nome deve ser informado.")
    private String cor;
    
    @NotEmpty(message = "O campo nome deve ser informado.")
    private Long idGaragem;
    
    public String getModelo() {
        return modelo;
    }
    
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    
    public String getCor() {
        return cor;
    }
    
    public void setCor(String cor) {
        this.cor = cor;
    }

    public Long getIdGaragem() {
        return idGaragem;
    }

    public void setIdGaragem(Long idGaragem) {
        this.idGaragem = idGaragem;
    }

}
