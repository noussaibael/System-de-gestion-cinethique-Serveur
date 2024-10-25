package org.example.Controller;

import org.example.ejb.CDUserService;
import org.example.ejb.CDAdminService;
import org.example.entity.CD;
import jakarta.ejb.EJB;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/cds")
public class CDController {

    @EJB
    private CDUserService cdUserService;

    @EJB
    private CDAdminService cdAdminService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<CD> getAllCDs() {
        return cdAdminService.listCDs();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createCD(CD cd) {
        CD createdCD = cdAdminService.createCD(cd);
        return Response.status(Response.Status.CREATED).entity(createdCD).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateCD(@PathParam("id") Long id, CD cd) {
        cd.setId(id);
        CD updatedCD = cdAdminService.updateCD(cd);
        return Response.ok(updatedCD).build();
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteCD(@PathParam("id") Long id) {
        cdAdminService.deleteCD(id);
        return Response.noContent().build();
    }

    @POST
    @Path("/borrow/{userId}/{cdId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response borrowCD(@PathParam("userId") Long userId, @PathParam("cdId") Long cdId) {
        String message = cdUserService.borrowCD(userId, cdId);
        return Response.ok(message).build();
    }

    @POST
    @Path("/return/{userId}/{cdId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response returnCD(@PathParam("userId") Long userId, @PathParam("cdId") Long cdId) {
        String message = cdUserService.returnCD(userId, cdId);
        return Response.ok(message).build();
    }
}

