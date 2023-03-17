package br.unitins.resource;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Valid;
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
import br.unitins.service.CarroService;

@Path("/carros")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CarroResource {
    
    @Inject
    private CarroService carroService;
    
    //Insere
    @POST
    @Transactional
    public Response insert(@Valid CarroDTO dto){
        CarroResponseDTO carro = carroService.create(dto);
        return Response.status(Status.CREATED).entity(carro).build();

    }

    //Lista de carros
    @GET
    public List<CarroResponseDTO> getAll() {
        return carroService.getAll();
    }


    //Buscar por nome
    @GET
    @Path("/search/{modelo}")
    public List<CarroResponseDTO> searchCarroNAME(@PathParam("modelo") String modelo){
        return carroService.findByNome(modelo);
    }

    //Busca por ID
    @GET
    @Path("/{id}")
    public CarroResponseDTO searchCarroID(@PathParam("id") Long id){
        return carroService.findById(id);
    }

    //Atualiza
    @PUT
    @Path("/{id}")
    @Transactional
    public Response updateCarro(@Valid @PathParam("id") Long id, CarroDTO dto){
        CarroResponseDTO carro = carroService.update(id, dto);
        return Response.status(Status.NO_CONTENT).entity(carro).build();
    }

    //Deletar um obj por ID
    @DELETE
    @Path("/{id}")
    @Transactional
    public Response deletarCarro(@Valid @PathParam("id") Long id){
        carroService.delete(id);
        return Response.status(Status.NO_CONTENT).build();
    }

    @GET
    @Path("Count")
    public long count() {
        return carroService.count();
    }

}
