package bo.gob.ruat.testcontainer.infrastructure.adapter.secondary.repository.jpa;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Singleton;
import javax.transaction.Transactional;

import bo.gob.ruat.testcontainer.application.port.secondary.IUsuarioRepository;
import bo.gob.ruat.testcontainer.domain.entity.UsuarioEntity;
import bo.gob.ruat.testcontainer.infrastructure.adapter.secondary.model.jpa.UsuarioJPA;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class UsuarioRepositoryImpl implements IUsuarioRepository,PanacheRepository<UsuarioJPA>{


    @Override
    @Transactional
    public void creaUsuario(UsuarioEntity usuario) {
        UsuarioJPA usuarioJPA=new UsuarioJPA();
        usuarioJPA.setNombre(usuario.getPrimerNombre()+" "+usuario.getSegundoNombre());
        usuarioJPA.setApellidos(usuario.getApellidoPaterno()+" "+usuario.getApellidoMaterno());
        usuarioJPA.setEdad(usuario.getEdad());
        usuarioJPA.setCi(usuario.getCi());
        persist(usuarioJPA);
    }

    @Override
    @Transactional
    public UsuarioEntity buscaUsuarioByCi(String ci) {
        UsuarioJPA usuario = find("ci", ci).firstResult();
        UsuarioEntity resultado = new UsuarioEntity();
        resultado.setCi(usuario.getCi());
        String nombres[] = usuario.getNombre().split(" ");
        resultado.setPrimerNombre(nombres[0]);
        resultado.setSegundoNombre(nombres[1]);        
        String apellidos[] = usuario.getApellidos().split(" ");
        resultado.setApellidoPaterno(apellidos[0]);
        resultado.setApellidoMaterno(apellidos[1]);        
        
      //  resultado.setPrimerNombre(usuario.getNombre().split(" ")[0]);
      //  resultado.setPrimerNombre(usuario.getNombre().split(" ")[1]);
       // resultado.setApellidoPaterno(usuario.getApellidos().split(" ")[0]);
       // resultado.setApellidoMaterno(usuario.getApellidos().split(" ")[1]);
        resultado.setEdad(usuario.getEdad());
        return resultado;
    }


    
    
}
