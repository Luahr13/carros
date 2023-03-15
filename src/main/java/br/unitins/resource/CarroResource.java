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
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import br.unitins.dto.CarroDTO;
import br.unitins.dto.CarroResponseDTO;
import br.unitins.model.Carro;
import br.unitins.repository.CarroRepository;
import br.unitins.repository.GaragemRepository;

@Path("/carros")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CarroResource {
    
    @Inject
    private CarroRepository carroRepository;
    
    @Inject
    private GaragemRepository garagemRepository;

    //Insere
    @POST
    @Transactional
    public Response insert(CarroDTO dto){
        Carro entity = new Carro();
        entity.setModelo(dto.getModelo());
        entity.setCor(dto.getCor());
        entity.setGaragem(garagemRepository.findById(dto.getIdGaragem()));

        carroRepository.persist(entity);

        return Response
            .status(Status.CREATED)
            .entity(new CarroResponseDTO(entity))
            .build();

    }

    //Lista de carros
    @GET
    public List<CarroResponseDTO> getAll() {
    
        return carroRepository.findAll()
        .stream()
        .map(carro -> new CarroResponseDTO(carro))
        .collect(Collectors.toList());
    }


    //Buscar por nome
    @GET
    @Path("/search/{modelo}")
    public List<Carro> searchCarroNAME(@PathParam("modelo") String modelo){
        return carroRepository.findByNomeList(modelo);
    }

    //Busca por ID
    @GET
    @Path("/{id}")
    public Carro searchCarroID(@PathParam("id") Long id){
        return carroRepository.findById(id);
    }

    //Atualiza
    @PUT
    @Path("/{id}")
    @Transactional
    public Response updateCarro(@PathParam("id") Long id, CarroDTO dto){
        Carro entity = carroRepository.findById(id);

        entity.setModelo(dto.getModelo());
        entity.setCor(dto.getCor());

        entity.setGaragem(garagemRepository.findById(dto.getIdGaragem()));

        return Response.status(Status.NO_CONTENT).build();
    }

    //Deletar um obj por ID
    @DELETE
    @Path("/{id}")
    @Transactional
    public Carro deletarCarro(@PathParam("id") Long id){
        Carro entity = carroRepository.findById(id);
        carroRepository.delete(entity);
        return entity;
    }

}
