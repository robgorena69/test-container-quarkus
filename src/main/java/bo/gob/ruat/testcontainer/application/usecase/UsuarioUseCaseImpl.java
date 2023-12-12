package bo.gob.ruat.testcontainer.application.usecase;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.transaction.Transactional;

import bo.gob.ruat.testcontainer.application.port.primary.IUsuarioUseCase;
import bo.gob.ruat.testcontainer.application.port.secondary.IUsuarioRepository;
import bo.gob.ruat.testcontainer.domain.entity.UsuarioEntity;

@RequestScoped
public class UsuarioUseCaseImpl implements IUsuarioUseCase{

     @Inject
     IUsuarioRepository usuarioRepository;


    @Override
    @Transactional
    public String obtieneNombreByCI(String ci) {

        UsuarioEntity usuarioEntity = usuarioRepository.buscaUsuarioByCi(ci);
        return usuarioEntity.getPrimerNombre()+" "+usuarioEntity.getSegundoNombre() + " " + usuarioEntity.getApellidoPaterno()+ " "+usuarioEntity.getApellidoMaterno();
    }
    
}
