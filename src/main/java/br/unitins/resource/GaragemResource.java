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

import br.unitins.dto.GaragemDTO;
import br.unitins.dto.GaragemResponseDTO;
import br.unitins.service.GaragemService;

@Path("/garagens")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class GaragemResource {
    
    @Inject
    private GaragemService garagemService;

    //Insere
    @POST
    @Transactional
    public Response insert(@Valid GaragemDTO garagemDTO){
        GaragemResponseDTO garagem = garagemService.create(garagemDTO);
        return Response.status(Status.CREATED).entity(garagem).build();
    }
    
    //Lista de garagem
    @GET
    public List<GaragemResponseDTO> getAll() {
        return garagemService.getAll();
    }

    //Buscar por nome
    @GET
    @Path("/search/{nome}")
    public List<GaragemResponseDTO> searchGaragemName(@PathParam("nome") String nome){
        return garagemService.findByNome(nome);
    }

    //Busca por ID
    @GET
    @Path("/{id}")
    public GaragemResponseDTO searchCarroID(@PathParam("id") Long id){
        return garagemService.findById(id);
    }

    //Atualiza
    @PUT
    @Path("/{id}")
    @Transactional
    public Response updateGaragem(@Valid @PathParam("id") Long id, GaragemDTO garagemDTO){
        GaragemResponseDTO garagem = garagemService.update(id, garagemDTO);
        return Response.status(Status.NO_CONTENT).entity(garagem).build();
    }

    //Deletar um obj por ID
    @DELETE
    @Path("/{id}")
    @Transactional
    public Response deletarCarro(@Valid @PathParam("id") Long id){
        garagemService.delete(id);
        return Response.status(Status.NO_CONTENT).build();
    }

    @GET
    @Path("Count")
    public long count() {
        return garagemService.count();
    }

}
