package br.unitins.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class GaragemDTO {
    
    @NotBlank(message = "O campo não pode ser nulo.")
    private String nome;
    
    @NotNull(message = "O campo nome deve ser informado.")
    private String endereco;
    
    @NotNull(message = "O campo nome deve ser informado.")
    private String telefone;
    
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
    
    public String getTelefone() {
        return telefone;
    }
    
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
}
