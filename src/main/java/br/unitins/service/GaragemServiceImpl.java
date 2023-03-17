package br.unitins.service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import javax.ws.rs.NotFoundException;

import br.unitins.dto.GaragemDTO;
import br.unitins.dto.GaragemResponseDTO;
import br.unitins.model.Garagem;
import br.unitins.repository.GaragemRepository;

@ApplicationScoped
public class GaragemServiceImpl implements GaragemService{

    @Inject
    GaragemRepository garagemRepository;

    @Inject
    Validator validator;

    @Override
    public List<GaragemResponseDTO> getAll() {
        List<Garagem> list = garagemRepository.listAll();
        return list.stream().map(GaragemResponseDTO::new).collect(Collectors.toList());
    }

    @Override
    public GaragemResponseDTO findById(Long id) {
        Garagem garagem = garagemRepository.findById(id);
        if (garagem == null)
            throw new NotFoundException("Garagem não encontrada.");
        return new GaragemResponseDTO(garagem);
    }

    @Override
    @Transactional
    public GaragemResponseDTO create(GaragemDTO garagemDTO) {
        Set<ConstraintViolation<GaragemDTO>> violations = validator.validate(garagemDTO);
        if (!violations.isEmpty())
            throw new ConstraintViolationException(violations);

        Garagem entity = new Garagem();
        entity.setNome(garagemDTO.getNome());
        entity.setEndereco(garagemDTO.getEndereco());
        entity.setTelefone(garagemDTO.getTelefone());

        return new GaragemResponseDTO(entity);
    }

    @Override
    @Transactional
    public GaragemResponseDTO update(Long id, GaragemDTO garagemDTO) {
        Garagem entity = garagemRepository.findById(id);

        entity.setNome(garagemDTO.getNome());
        entity.setEndereco(garagemDTO.getEndereco());
        entity.setTelefone(garagemDTO.getTelefone());

        return new GaragemResponseDTO(entity);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        garagemRepository.deleteById(id);
    }

    @Override
    public List<GaragemResponseDTO> findByNome(String nome) {
        List<Garagem> list = garagemRepository.findByNomeList(nome);
        return list.stream().map(GaragemResponseDTO::new).collect(Collectors.toList());
    }

    @Override
    public long count() {
        return garagemRepository.count();
    }
    
}
