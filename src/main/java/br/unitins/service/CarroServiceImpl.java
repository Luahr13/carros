package br.unitins.service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import javax.ws.rs.NotFoundException;

import br.unitins.dto.CarroDTO;
import br.unitins.dto.CarroResponseDTO;
import br.unitins.model.Carro;
import br.unitins.repository.CarroRepository;
import br.unitins.repository.GaragemRepository;

public class CarroServiceImpl implements CarroService{

    @Inject
    CarroRepository carroRepository;

    @Inject
    GaragemRepository garagemRepository;

    @Inject
    Validator validator;

    @Override
    public List<CarroResponseDTO> getAll() {
        List<Carro> list = carroRepository.listAll();
        return list.stream().map(CarroResponseDTO::new).collect(Collectors.toList());
    }

    @Override
    public CarroResponseDTO findById(Long id) {
        Carro carro = carroRepository.findById(id);
        if(carro == null)
            throw new NotFoundException("Garagem não encontrada.");
        return new CarroResponseDTO(carro);
    }

    @Override
    @Transactional
    public CarroResponseDTO create(CarroDTO carroDTO) {
        Set<ConstraintViolation<CarroDTO>> violations = validator.validate(carroDTO);
        if (!violations.isEmpty())
            throw new ConstraintViolationException(violations);

        Carro carro = new Carro();
        carro.setModelo(carroDTO.getModelo());
        carro.setCor(carroDTO.getCor());
        carro.setGaragem(garagemRepository.findById(carroDTO.getIdGaragem()));
        carroRepository.persist(carro);

        return new CarroResponseDTO(carro);
    }

    @Override
    @Transactional
    public CarroResponseDTO update(Long id, CarroDTO carroDTO) {
        Carro carro = carroRepository.findById(id);

        carro.setModelo(carroDTO.getModelo());
        carro.setModelo(carroDTO.getCor());
        carro.setGaragem(garagemRepository.findById(carroDTO.getIdGaragem()));

        return new CarroResponseDTO(carro);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        carroRepository.deleteById(id);
    }

    @Override
    public List<CarroResponseDTO> findByNome(String nome) {
        List<Carro> list = carroRepository.findByNomeList(nome);
        return list.stream().map(CarroResponseDTO::new).collect(Collectors.toList());
    }

    @Override
    public long count() {
        return carroRepository.count();
    }
    
}
