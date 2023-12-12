package bo.gob.ruat.testcontainer.infrastructure.adapter.primary.rest;

import java.io.IOException;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import bo.gob.ruat.lib.core.domain.exception.ExcepcionLogica;
import bo.gob.ruat.testcontainer.application.port.primary.IUsuarioUseCase;


@Path("/test-container")
public class UsuarioRest {

    @Inject
    IUsuarioUseCase usuarioUseCase;
    
    @GET
	@Path("/verificar-usuario-ci")
	@Transactional(value = Transactional.TxType.REQUIRES_NEW, rollbackOn = {ExcepcionLogica.class, IOException.class,  Exception.class})
	public Response verificarUsuariCI() throws ExcepcionLogica{
        String ci = "3641546";
		String resultado = usuarioUseCase.obtieneNombreByCI(ci);

		return Response.ok(resultado).build();
	}



}
