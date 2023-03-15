package br.unitins.resource;


import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.unitins.dto.GaragemResponseDTO;
import br.unitins.model.Garagem;
import br.unitins.repository.GaragemRepository;

@Path("/garagens")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class GaragemResource {
    
    @Inject
    private GaragemRepository garagemRepository;

    //Insere
    @POST
    @Transactional
    public Garagem insert(Garagem garagem){
        garagemRepository.persist(garagem);
        return garagem;
    }
    
    //Lista de garagem
    @GET
    public List<GaragemResponseDTO> getAll() {
    
        return garagemRepository.findAll()
        .stream()
        .map(garagem -> new GaragemResponseDTO(garagem))
        .collect(Collectors.toList());
    }

    //Buscar por nome
    @GET
    @Path("/search/{nome}")
    public List<Garagem> searchCarroNAME(@PathParam("nome") String nome){
        return garagemRepository.findByNomeList(nome);
    }

    //Busca por ID
    @GET
    @Path("/{id}")
    public Garagem searchCarroID(@PathParam("id") Long id){
        return garagemRepository.findById(id);
    }

    //Atualiza
    @PUT
    @Path("/{id}")
    @Transactional
    public Garagem updateGaragem(@PathParam("id") Long id, Garagem garagem){
        Garagem entity = garagemRepository.findById(id);
        entity.setNome(garagem.getNome());
        entity.setEndereco(garagem.getEndereco());
        entity.setCnpj(garagem.getCnpj());
        entity.setTelefone(garagem.getTelefone());
        return entity;

    }

    //Deletar um obj por ID
    @DELETE
    @Path("/{id}")
    @Transactional
    public Garagem deletarCarro(@PathParam("id") Long id){
        Garagem entity = garagemRepository.findById(id);
        garagemRepository.delete(entity);
        return entity;
    }

}
