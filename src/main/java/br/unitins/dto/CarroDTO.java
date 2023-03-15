package br.unitins.dto;

public class CarroDTO {
    
    private String modelo;
    private String cor;
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
