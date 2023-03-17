package br.unitins.service;

import java.util.List;

import br.unitins.dto.CarroDTO;
import br.unitins.dto.CarroResponseDTO;

public interface CarroService {
    // recursos basicos
    List<CarroResponseDTO> getAll();

    CarroResponseDTO findById(Long id);

    CarroResponseDTO create(CarroDTO carroDTO);

    CarroResponseDTO update(Long id, CarroDTO garagemDTO);

    void delete(Long id);

    // recursos extras

    List<CarroResponseDTO> findByNome(String nome);

    long count();
}
