package br.unitins.service;

import java.util.List;

import br.unitins.dto.GaragemDTO;
import br.unitins.dto.GaragemResponseDTO;

public interface GaragemService {

    // recursos basicos
    List<GaragemResponseDTO> getAll();

    GaragemResponseDTO findById(Long id);

    GaragemResponseDTO create(GaragemDTO garagemDTO);

    GaragemResponseDTO update(Long id, GaragemDTO garagemDTO);

    void delete(Long id);

    // recursos extras

    List<GaragemResponseDTO> findByNome(String nome);

    long count();
    
}
